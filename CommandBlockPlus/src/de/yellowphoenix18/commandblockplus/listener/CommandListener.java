package de.yellowphoenix18.commandblockplus.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import de.yellowphoenix18.commandblockplus.config.MainConfig;

public class CommandListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void on(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String command = e.getMessage().toLowerCase();
		if(!p.hasPermission("commandblockplus.bypass")) {
			boolean blocked = false;
			for(String cmd : MainConfig.blocked_commands) {
				if(cmd.startsWith("s[")) {
					cmd = cmd.substring(2, cmd.length());
					if(command.startsWith(cmd)) {
						blocked = true;
						break;
					}
				} else if(command.equalsIgnoreCase(cmd)) {
					blocked = true;
					break;
				}
			}
			if(blocked == true) {
				e.setCancelled(true);
				p.sendMessage(MainConfig.prefix + MainConfig.blocked_command);
			}
		}
	}

}
