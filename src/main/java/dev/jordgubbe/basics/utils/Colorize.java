package dev.jordgubbe.basics.utils;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Colorize {

    /**
     *
     * I DO NOT OWN THIS
     * THIS IS TAKEN (AND EDITED) FROM KODY SIMPSONS SIMP-API
     * https://github.com/Cortex-MC/SimpAPI
     *
     */

    @Deprecated
    public static final String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
    private static final Pattern HEX_PATTERN = Pattern.compile("(&#[0-9a-fA-F]{6})");

    public static String translate(String text) {
        Matcher matcher = HEX_PATTERN.matcher(text);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            String hex = matcher.group(1).substring(1);
            matcher.appendReplacement(sb, "" + ChatColor.of(hex));
        }
        matcher.appendTail(sb);
        String hexColored = sb.toString();
        return ChatColor.translateAlternateColorCodes('&', hexColored);
    }

    public static TextComponent translateToTextComponent(String text) {
        String colored = translate(text);
        TextComponent base = new TextComponent();
        BaseComponent[] converted = TextComponent.fromLegacyText(colored);
        for (BaseComponent comp : converted) {
            base.addExtra(comp);
        }
        return base;
    }

    public static String format(String string) {
        return Colorize.translate(string);
    }

    public static String stripColor(String string) {
        return org.bukkit.ChatColor.stripColor(string);
    }

}
