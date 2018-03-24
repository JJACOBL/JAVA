package mc._OutdatedPixel.oEssentials.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import co.netspeed.ppapi.main.PPApidocs;
import net.md_5.bungee.api.ChatColor;

public class mystats implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("mystats")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(!(player.hasPermission("oEssentials.mystats"))) {
					player.sendMessage(ChatColor.RED + "You are not allowed to do this!");
				}
				
				//LIVE VARIABLES
				double playerHealth = player.getHealth();
				double playerFood = player.getFoodLevel();
				double locX = player.getLocation().getX();
				double locY = player.getLocation().getY();
				double locZ = player.getLocation().getZ();
				double amountOfWarnings = PPApidocs.getWarnings(player);
				double Playtime = PPApidocs.getTimePlayed(player);
				double blocksMined = PPApidocs.getBlocksMined(player);
				double kills = PPApidocs.getKills(player);
				double deaths = PPApidocs.getDeaths(player);
				String prestige = PPApidocs.getPrestige(player);
				double KDR = kills / deaths;
				String rank = PPApidocs.getRank(player);
				
				
				
				
				player.sendMessage(ChatColor.DARK_AQUA + "Statistics " + ChatColor.DARK_GRAY + "| " + ChatColor.YELLOW + player.getName());
				player.sendMessage(ChatColor.DARK_AQUA + "Health: " + ChatColor.GREEN + playerHealth);
				player.sendMessage(ChatColor.DARK_AQUA + "Food: " + ChatColor.GREEN + playerFood);
				player.sendMessage(ChatColor.DARK_AQUA + "Location: " + ChatColor.GREEN + locX + " " + locY + " " + locZ);
				player.sendMessage(ChatColor.DARK_AQUA + "Warnings: " + ChatColor.GREEN + amountOfWarnings);
				player.sendMessage(ChatColor.DARK_AQUA + "Playtime (Seconds): " + ChatColor.GREEN + Playtime);
				player.sendMessage(ChatColor.DARK_AQUA + "Blocks Mined: " + ChatColor.GREEN + blocksMined);
				player.sendMessage(ChatColor.DARK_AQUA + "Kills: " + ChatColor.GREEN + kills);
				player.sendMessage(ChatColor.DARK_AQUA + "Deaths: " + ChatColor.GREEN + deaths);
				player.sendMessage(ChatColor.DARK_AQUA + "KDR: " + ChatColor.GREEN + KDR);
				player.sendMessage(ChatColor.DARK_AQUA + "Prestige: " + ChatColor.GREEN + prestige);
				player.sendMessage(ChatColor.DARK_AQUA + "Rank: " + ChatColor.GREEN + rank);
			}else {
				sender.sendMessage("You must be a player!");
			}
		}
		return false;
	}
	

}
