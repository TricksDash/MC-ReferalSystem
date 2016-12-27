package rocks.tricks.main.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import rocks.tricks.main.Core;

public class FirstJoinData implements Listener {
	
	private Core plugin;
	
	public FirstJoinData(Core pl) {
		plugin = pl;
		
	}
	
	@EventHandler
	public void onFirstJoin(PlayerJoinEvent event) {
		Player player = (Player) event.getPlayer();
		
		if(!player.hasPlayedBefore()) {
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Refered", false);
			plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".ReferedCount", "0");
			plugin.saveConfig();
			
		}
	}
}

