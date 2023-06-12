package com.maximum.worldtravel;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.framework.qual.DefaultQualifier;

@DefaultQualifier(NonNull.class)
public final class Main extends JavaPlugin implements Listener {
  private static Main instance;

  @Override
  public void onEnable() {
    Main.instance = this;

    this.getServer().getPluginManager().registerEvents(new GameListener(), this);
    
    getCommand("worldtravel").setExecutor(new WorldTravelCommand());

    getServer().getScheduler().runTask(this, () -> {
      
    });
  }

    

  @Override
	public void onDisable() {
		
	}

  public static Main getInstance() { return instance; }
}
