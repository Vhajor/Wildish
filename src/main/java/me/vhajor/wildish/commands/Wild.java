package me.vhajor.wildish.commands;

import me.vhajor.wildish.Wildish;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

import java.util.Random;

public class Wild implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {

            System.out.println("An error has occurred with that command. It occurred at the wild command. The error that was a non-player running the command.");
            return false;

        }

        Configuration configuration = Wildish.getConfiguration();
        Random random = new Random();
        Player player = (Player) sender;
        World world = player.getWorld();
        int maxZ = configuration.getInt("max_z");
        int maxX = configuration.getInt("max_x");

        while (true) {

            int z = random.nextInt(maxZ);
            int x = random.nextInt(maxX);
            if (random.nextBoolean())
                z = -z;
            if (random.nextBoolean())
                x = -x;
            int y;

            for (y = world.getMaxHeight() - 1; y >= 0; y--)
                if (world.getBlockAt(x, y, z).getType() != Material.AIR)
                    break;

            Material material = world.getBlockAt(x, y, z).getType();

            if (material != Material.LAVA && material != Material.WATER) {

                player.teleport(new Location(world, x, y + 1D, z));

                break;
            }

        }

        return false;
    }

}
