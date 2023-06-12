package com.maximum.worldtravel;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;



public class WorldTravelCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(!(sender instanceof Player)) {
            return false;
        }    
		
		Player player = (Player) sender;

        if(!player.isOp()) {
            player.sendMessage(ChatColor.RED + "Only Operators can use this command!");
            return false;
        }

        String worldName = args[0];
        
        File[] serverSubfiles = Bukkit.getWorldContainer().listFiles();

        File worldFolder = null;

        for(File file : serverSubfiles) {
            if(file.getName().equals(worldName) && file.isDirectory()) {
                worldFolder = file;
                break;
            }
        }

        if(worldFolder == null) {
            player.sendMessage(ChatColor.RED + "World folder does not exist!");
            return false;
        }

        File[] worldSubfiles = worldFolder.listFiles();

        boolean isWorldFolder = false;

        for(File file : worldSubfiles) {
            if(file.getName().equals("level.dat")) {
                isWorldFolder = true;
                break;
            }
        }

        if(!isWorldFolder) {
            player.sendMessage(ChatColor.RED + "Specified name is of a non-world folder!");
            return false;
        }

        World world = Bukkit.createWorld(new WorldCreator(worldName));
        player.teleport(world.getSpawnLocation());

        return true;

	}
}
