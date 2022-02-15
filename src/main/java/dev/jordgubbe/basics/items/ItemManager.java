package dev.jordgubbe.basics.items;

import dev.jordgubbe.basics.lib.Item;
import dev.jordgubbe.basics.utils.Colorize;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack tripleShotBow;
    public static ItemStack teleportBow;

    public static void init() {
        createTripleShotBowItem();
        createTeleportBowItem();
    }

    public static void createTripleShotBowItem() {
        ArrayList<String> lore = new ArrayList<>();
        lore.add("yes");
        tripleShotBow = Item.createItem(Colorize.format("&6Triple Shot Bow"), Material.BOW, 1, lore);
        Item.addEnchant(tripleShotBow, Enchantment.DURABILITY, 10);
    }

    public static void createTeleportBowItem() {
        List<String> lore = new ArrayList<>();
        lore.add(Colorize.format("&6Item Ability: Ender Warp &e&lSNEAK + LEFT-CLICK"));
        lore.add(ChatColor.GRAY + "Use the item's ability to launch an Ender Pearl");
        lore.add(ChatColor.GRAY + "just like you're throwing one");
        teleportBow = Item.createItem(Colorize.format("&6Teleport Bow"), Material.BOW, 1, lore);
    }
}
