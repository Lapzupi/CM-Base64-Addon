package com.lapzupi.dev.base64.cmenusbase64addon;

import com.lapzupi.dev.configurablemenus.addons.ItemAddon;
import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTItem;
import de.tr7zw.changeme.nbtapi.NBTListCompound;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public final class Base64Addon extends ItemAddon {

    @Override
    public ItemStack getItemStack(final String id) {
        return getFromBase64(id);
    }

    @Contract(pure = true)
    @Override
    public @NotNull String getPrefix() {
        return "base64";
    }

    @Contract(pure = true)
    @Override
    public @Nullable String getPluginName() {
        return null;
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public @NotNull String getAuthor() {
        return "Lapzupi Development Team";
    }

    @Contract(pure = true)
    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    private ItemStack getFromBase64(final String base64) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        NBTItem nbti = new NBTItem(head);

        NBTCompound skull = nbti.addCompound("SkullOwner");
        skull.setString("Id", UUID.randomUUID().toString());

        NBTListCompound texture = skull.addCompound("Properties").getCompoundList("textures").addCompound();
        texture.setString("Value", base64);

        return nbti.getItem();
    }
}
