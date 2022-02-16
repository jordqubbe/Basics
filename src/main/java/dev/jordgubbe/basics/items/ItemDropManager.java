package dev.jordgubbe.basics.items;

import dev.jordgubbe.basics.lib.Item;
import dev.jordgubbe.basics.utils.Colorize;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ItemDropManager {

    public static ItemStack fancyRose;

    public static void init() {
        createFancyRose();
    }

    public static void createFancyRose() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add(Colorize.format("&7Be sure to give it to someone!"));
        fancyRose = Item.createItem(Colorize.format("&6Fancy Rose"), Material.POPPY, 1, lore);
    }


}
