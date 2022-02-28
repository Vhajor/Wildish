package me.vhajor.wildish.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ErrorHandler {

    private ErrorHandler() {
        throw new IllegalStateException("Utility Class");
    }

    public static void sendError(Player player, String source, String error) {

        player.sendMessage(ChatColor.RED + "!------======------!");
        player.sendMessage(ChatColor.RED + "An error has occurred with that command. It occurred at the " + source + ". The error that was " + error + ".");
        player.sendMessage(ChatColor.RED + "!------======------!");

    }

}
