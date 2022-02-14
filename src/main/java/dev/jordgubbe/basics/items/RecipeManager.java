package dev.jordgubbe.basics.items;

import dev.jordgubbe.basics.lib.Item;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

public class RecipeManager {

    public static void init() {
        Bukkit.addRecipe(teleportBowRecipe());
        Bukkit.addRecipe(tripleShotBowRecipe());
    }

    private static ShapedRecipe teleportBowRecipe() {
        ShapedRecipe teleportBowRecipe = Item.addRecipe(ItemManager.teleportBow, "teleport", " ES", "EDS", " ES");
        teleportBowRecipe.setIngredient('E', Material.ENDER_EYE);
        teleportBowRecipe.setIngredient('S', Material.STRING);
        teleportBowRecipe.setIngredient('D', Material.DIAMOND);
        return teleportBowRecipe;
    }

    private static ShapedRecipe tripleShotBowRecipe() {
        ShapedRecipe tripleShotBowRecipe = Item.addRecipe(ItemManager.tripleShotBow, "triple", " BS", "BDS", " BS");
        tripleShotBowRecipe.setIngredient('B', Material.BONE);
        tripleShotBowRecipe.setIngredient('S', Material.STRING);
        tripleShotBowRecipe.setIngredient('D', Material.DIAMOND);
        return tripleShotBowRecipe;
    }

}
