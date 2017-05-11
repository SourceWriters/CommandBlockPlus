package de.yellowphoenix18.commandblockplus.config;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainConfig {
	
	public static File f = new File("plugins/CommandBlockPlus", "config.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(f);
	
	public static String prefix = "&8[&cCommandBlock&4Plus&8] &7";
	public static String blocked_command = "&7This command is &cblocked&7!";
	
	public static List<String> blocked_commands = new ArrayList<String>();
	
	public static void load() {
		blocked_commands.add("s[/plugins");
		blocked_commands.add("s[/pl");
		blocked_commands.add("s[/?");
		
		blocked_commands = setObject("CommandBlockPlus.Blocked-Commands", blocked_commands);
		prefix = fixColorCodes(setObject("CommandBlockPlus.Messages.Prefix", prefix));
		blocked_command = fixColorCodes(setObject("CommandBlockPlus.Messages.Blocked-Command", blocked_command));
	}
	
	public static String fixColorCodes(String code) {
		code = code.replace("&", "§");
		return code;
	}
	
	public static List<String> setObject(String path, List<String> obj) {
		if(cfg.contains(path)) {
			return cfg.getStringList(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}	
	
	public static String setObject(String path, String obj) {
		if(cfg.contains(path)) {
			return cfg.getString(path);
		} else {
			cfg.set(path, obj);
			save();
			return obj;
		}
	}
	
	public static void save() {
		try {
			cfg.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
