package de.yellowphoenix18.commandblockplus;

import org.bukkit.plugin.java.JavaPlugin;

import de.yellowphoenix18.commandblockplus.utils.PluginUtils;

public class CommandBlockPlus extends JavaPlugin {
	
	public static CommandBlockPlus m;
	
	public void onEnable() {
		m = this;
		PluginUtils.setUp();
	}
	
	public void onDisable() {
		
	}

}
