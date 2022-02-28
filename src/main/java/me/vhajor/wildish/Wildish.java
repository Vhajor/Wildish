package me.vhajor.wildish;

import me.vhajor.wildish.commands.Wild;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Wildish extends JavaPlugin {

    private static Configuration configuration;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        configuration = getConfig();

        PluginCommand wildCommand = Bukkit.getPluginCommand("wild");
        assert wildCommand != null;
        wildCommand.setExecutor(new Wild());

    }

    public static Configuration getConfiguration() {
        return configuration;
    }
    
}
