package mc._OutdatedPixel.oEssentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Spectate implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("spectate")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("oEssentials.spectate")) {

					if(args.length < 1) {
						player.sendMessage(ChatColor.RED + "Invalid Syntax! Use: /spectate <player>");
					}else if(args.length == 1) {
						Player target = Bukkit.getPlayerExact(args[0]);
						
						if(target == null) {
							player.sendMessage(ChatColor.RED + "Could not find player!");
						}else {
							Location targetLoc = target.getLocation();
							player.teleport(targetLoc);
							player.performCommand("vanish");
							player.sendMessage(ChatColor.DARK_GREEN + "Now spectating " + ChatColor.DARK_AQUA + target.getName());
						}
					}else if(args.length > 1) {
						player.sendMessage(ChatColor.RED + "Invalid Syntax! Use: /spectate <player>");
					}
				}
			}
		}
		return false;
	}
}






				



