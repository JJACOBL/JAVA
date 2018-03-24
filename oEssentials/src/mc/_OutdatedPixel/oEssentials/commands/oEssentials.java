package mc._OutdatedPixel.oEssentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.netspeed.ppapi.main.PPApidocs;
import mc._OutdatedPixel.oEssentials.Main;

public class oEssentials implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("oEssentials")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(player.hasPermission("oEssentials.version")) {
					player.sendMessage(ChatColor.DARK_AQUA  + "oEssentials " + ChatColor.DARK_GRAY + "|" + ChatColor.RED + " " + Main.Plugin_Version);
					player.sendMessage(ChatColor.DARK_AQUA + "Current PP Version: " + ChatColor.RED + PPApidocs.getVersion());
					player.sendMessage(ChatColor.DARK_PURPLE + "Created by _OutdatedPixel");
					player.sendMessage(ChatColor.GREEN + "/oEssentials");
					player.sendMessage(ChatColor.GREEN + "/spectate - Vanish and TP do a player!");
					player.sendMessage(ChatColor.GREEN + "/mystats - View stats in a list.!");
					player.sendMessage(ChatColor.GREEN + "/mystatsgui - View stats in a GUI!");
				}else {
					player.sendMessage(ChatColor.RED + "You are not allowed to do this!");
				}
			}else {
				sender.sendMessage("You must be a player!");
			}
		}
		return false;
	}


}
