package mc._OutdatedPixel.oEssentials;

import org.bukkit.plugin.java.JavaPlugin;

import mc._OutdatedPixel.oEssentials.commands.*;

public class Main extends JavaPlugin {
	
	public static final String Plugin_Version = "0.3.2";
	//TODO: 0.2.1: Fixed ChatColor bugs for /mystats
	//TODO: 0.2.2: Added "Rank" to the /mystats
	//TODO: 0.3: Made /mystats into a GUi
	//TODO: 0.3.1 Added everything else in
	//TODO: 0.3.2 Fixed GUI Text, Changed PT to hours
	
	public void onEnable() {
		getServer().getLogger().info("oEssentials enabled");
	
		getCommand("oEssentials").setExecutor(new oEssentials());
		getCommand("spectate").setExecutor(new Spectate());
		getCommand("mystats").setExecutor(new mystats());
		getCommand("mystatsgui").setExecutor(new BETA());
	}
	
	public void onDisable() {
		getServer().getLogger().info("oEssentials disabled.");
	}

}
