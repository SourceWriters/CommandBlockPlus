package de.yellowphoenix18.commandblockplus.utils;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import de.yellowphoenix18.commandblockplus.CommandBlockPlus;
import de.yellowphoenix18.commandblockplus.config.MainConfig;
import de.yellowphoenix18.commandblockplus.listener.CommandListener;

public class PluginUtils {
	
	public static void setUp() {
		MainConfig.load();
		loadListener();
	}
	
	public static void loadListener() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new CommandListener(), CommandBlockPlus.m);
	}

}
