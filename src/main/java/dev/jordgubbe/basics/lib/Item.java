package dev.jordgubbe.basics.lib;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public interface Item {

    /**
     * @param name - Name of the new item
     * @param mat - Material of the new item (Don't use skulls with textures here)
     * @param amount - Amount of the new item
     * @param lore - Lore (if any) of the new item
     * @return - The newly created ItemStack
     */

    default ItemStack createItem(String name, Material mat, int amount, ArrayList<String> lore) {
        ItemStack item = new ItemStack(mat, amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        return item;
    }

    /**
     * Creates a Skull ItemStack that can get a texture from minecraft-heads.com
     * @param name - name of the skull item
     * @param lore - lore (if any) of said skull item
     * @param url - Provide a URL in the form of a Mojang texture : http://textures.minecraft.net/texture/[whatever the value is]
     * @return - The newly created Skull ItemStack
     */

   default ItemStack createSkull(String name, ArrayList<String> lore, String url) {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        return SkullCreator.itemWithUrl(item, url);
    }

}
