package mc._OutdatedPixel.oEssentials.commands;





import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.inventivetalent.menubuilder.inventory.InventoryMenuBuilder;
import org.inventivetalent.menubuilder.inventory.ItemListener;

import co.netspeed.ppapi.main.PPApidocs;
import net.md_5.bungee.api.ChatColor;

public class BETA implements CommandExecutor {

	
	

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("mystatsgui")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if(!(player.hasPermission("oEssentials.mystatsgui"))) {
					player.sendMessage(ChatColor.RED + "You are not allowed to do this!");
				}
				
				double playerHealth = player.getHealth();
				double playerFood = player.getFoodLevel();
				double locX1 = player.getLocation().getX();
				double locY2 = player.getLocation().getY();
				double locZ3 = player.getLocation().getZ();
				double locX = Math.round(locX1);
				double locY = Math.round(locY2);
			    double locZ = Math.round(locZ3);
				
				double amountOfWarnings = PPApidocs.getWarnings(player);
				double PlaytimeSEC = PPApidocs.getTimePlayed(player);
				double PlaytimeMIN = PlaytimeSEC / 60;
				double Playtime = PlaytimeMIN / 60;
				double blocksMined = PPApidocs.getBlocksMined(player);
				double kills = PPApidocs.getKills(player);
				double deaths = PPApidocs.getDeaths(player);
				String prestige = PPApidocs.getPrestige(player);
				double KDR = kills / deaths;
				
				String rank = PPApidocs.getRank(player);
				
				ItemStack healthItem = new ItemStack(Material.SLIME_BALL,1);
				ItemMeta meta1 = healthItem.getItemMeta();
				meta1.setDisplayName(ChatColor.RED.toString() + "Health " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + playerHealth);
				healthItem.setItemMeta(meta1);
				
				ItemStack foodItem = new ItemStack(Material.MAGMA_CREAM,1);
				ItemMeta meta2 = healthItem.getItemMeta();
				meta2.setDisplayName(ChatColor.RED.toString() + "Food " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + playerFood);
				foodItem.setItemMeta(meta2);
				
				ItemStack locationItem = new ItemStack(Material.COMPASS,1);
				ItemMeta meta3 = healthItem.getItemMeta();
				meta3.setDisplayName(ChatColor.RED.toString() + "Location " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + "X: " + locX + " Y: " + locY + " Z: " + locZ);
				locationItem.setItemMeta(meta3);
				
				ItemStack warningsItem = new ItemStack(Material.BONE,1);
				ItemMeta meta4 = healthItem.getItemMeta();
				meta4.setDisplayName(ChatColor.RED.toString() + "Warnings " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + amountOfWarnings);
				warningsItem.setItemMeta(meta4);
				
				ItemStack playtimeItem = new ItemStack(Material.WATCH,1);
				ItemMeta meta5 = healthItem.getItemMeta();
				meta5.setDisplayName(ChatColor.RED.toString() + "Playtime " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + Playtime);
				playtimeItem.setItemMeta(meta5);
				
				ItemStack blocksMinedItem = new ItemStack(Material.DIAMOND_PICKAXE,1);
				ItemMeta meta6 = healthItem.getItemMeta();
				meta6.setDisplayName(ChatColor.RED.toString() + "Blocks Mined " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + blocksMined);
				blocksMinedItem.setItemMeta(meta6);
				
				ItemStack killsItem = new ItemStack(Material.DIAMOND_SWORD,1);
				ItemMeta meta7 = healthItem.getItemMeta();
				meta7.setDisplayName(ChatColor.RED.toString() + "Kills " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + kills);
				killsItem.setItemMeta(meta7);
				
				ItemStack deathItem = new ItemStack(Material.DIAMOND_HOE,1);
				ItemMeta meta8 = healthItem.getItemMeta();
				meta8.setDisplayName(ChatColor.RED.toString() + "Deaths " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + deaths);
				deathItem.setItemMeta(meta8);
				
				ItemStack KDRItem = new ItemStack(Material.DIAMOND_AXE,1);
				ItemMeta meta9 = healthItem.getItemMeta();
				meta9.setDisplayName(ChatColor.RED.toString() + "KDR " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + Math.round(KDR));
				KDRItem.setItemMeta(meta9);
				
				ItemStack prestigeItem = new ItemStack(Material.GOLD_INGOT,1);
				ItemMeta meta10 = healthItem.getItemMeta();
				meta10.setDisplayName(ChatColor.RED.toString() + "Prestige " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + prestige);
				prestigeItem.setItemMeta(meta10);
				
				ItemStack rankItem = new ItemStack(Material.DIAMOND_BLOCK,1);
				ItemMeta meta11 = healthItem.getItemMeta();
				meta11.setDisplayName(ChatColor.RED.toString() + "Rank " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + rank);
				rankItem.setItemMeta(meta11);
			
				
				final InventoryMenuBuilder menu = new InventoryMenuBuilder(18, ChatColor.GOLD + "Statistics" + ChatColor.DARK_GRAY + " | " + ChatColor.BLUE + player.getName());
				
				menu.withTitle(ChatColor.DARK_AQUA + "Stats" + ChatColor.DARK_GRAY + " | " + ChatColor.YELLOW + player.getName());
				menu.withItem(0, new ItemStack(healthItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Health " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + playerHealth);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(1, new ItemStack(foodItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Food " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + playerFood);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(2, new ItemStack(locationItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Location " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + locX + " " + locY + " " + locZ);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(3, new ItemStack(warningsItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {

						player.sendMessage(ChatColor.RED + "Warnings " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + amountOfWarnings);
						
		            }
		        }, ClickType.LEFT).show(player);

				
				menu.withItem(4, new ItemStack(playtimeItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Playtime " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + Playtime + "hrs");
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(5, new ItemStack(blocksMinedItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Blocks Mined " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + blocksMined);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(6, new ItemStack(killsItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Kills " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + kills);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(7, new ItemStack(deathItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Deaths " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + deaths);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(8, new ItemStack(KDRItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "KDR " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + KDR);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(9, new ItemStack(prestigeItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Prestige " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + prestige);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				menu.withItem(10, new ItemStack(rankItem), new ItemListener() {
		            @Override
		            public void onInteract(Player player, ClickType action, ItemStack item) {
						player.sendMessage(ChatColor.RED + "Rank " + ChatColor.DARK_GRAY + "| " + ChatColor.GOLD + rank);
						
		            }
		        }, ClickType.LEFT).show(player);
				
				
			}else {
				sender.sendMessage("You must be a player!");
			}
		}
		return false;
	}
	

}
