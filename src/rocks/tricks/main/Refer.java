package rocks.tricks.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Refer implements CommandExecutor {
	
	private Core plugin;
	
	public Refer(Core pl) {
		plugin = pl;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)){
			sender.sendMessage("You are not a player");
		return false;
	}else{
		Player player = (Player) sender;
		
		player.sendMessage("test");
		
		if(args.length == 0) {
			player.sendMessage(C.red + "Incorrect usage: /refer (Name)");
		}else if(args.length == 1) {
			
			if(plugin.getConfig().get("Player-Data." + player.getUniqueId() + ".Refered").equals(true)) {
				player.sendMessage(C.red+ "You have already refered a player");
			}else{
			
			Player target = Bukkit.getPlayer(args[0]);
			
			if(target.hasPlayedBefore() == true) {

				player.sendMessage(C.gold + "Your referal fooor " + args[0] + " has been registered");
				target.sendMessage(C.gold + player.getName() + " has just refered you!");
				
				plugin.getConfig().set("Player-Data." + player.getUniqueId() + ".Refered", true);
				plugin.getConfig().set("Player-Data." + target.getUniqueId() + ".ReferedCount", + 1);
				plugin.saveConfig();
			
			}else
			
			player.sendMessage(C.red + "You cannot refer that player, they have not connected before.");
			}
		
		}else if(args.length >= 2) {
			player.sendMessage(C.red + "Incorrect usage: /refer (Name)");
			
		}else
			player.sendMessage(C.red + "Incorrect usage: /refer (Name)");
	}	
	return true;
	}
}
