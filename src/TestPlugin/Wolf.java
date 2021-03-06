package TestPlugin;

import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.commands.Buy;
import TestPlugin.commands.Sell;
import TestPlugin.commands.ValueCommands;
import TestPlugin.commands.pjsucks;
import TestPlugin.events.player.PlayerJoin;

public class Wolf extends JavaPlugin {
	/**
	 * In the minecraft server console it returns an enabled message after the plugin has been loaded.
	 */
	@Override
	public void onEnable() {
		loadCommands();
		loadEvents();
		registerConfig();
		setup();
		getLogger().info("WolfOfWallStreet has been enabled.");
	}
	/**
	 * Saves config and gives disabled message.
	 */
	@Override
	public void onDisable() {
		getLogger().info("WolfOfWallStreet has been disabled.");
		saveConfig();
		registerConfig();
	}
	/**
	 * Loads all the commands that we add to the plugin.
	 */
	public void loadCommands(){
		getCommand("PjSucks").setExecutor(new pjsucks());
		getCommand("Balance").setExecutor(new ValueCommands());
		getCommand("Bal").setExecutor(new ValueCommands());
		getCommand("Give").setExecutor(new ValueCommands());
		getCommand("SetBalance").setExecutor(new ValueCommands());
		getCommand("SetBal").setExecutor(new ValueCommands());
		getCommand("Pay").setExecutor(new ValueCommands());
		getCommand("Sell").setExecutor(new Sell());
		getCommand("Buy").setExecutor(new Buy());
	}
	/**
	 * Registers events to listen for in game.
	 */
	public void loadEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerJoin(), this);
	}
	/**
	 * Makes and saves the config file to save command information.
	 */
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	/**
	 * Creates and saves a new config file used for the players balance/currency/
	 */
	public void setup()
	  {
	    File playersfile = new File(getDataFolder(), "playerBalance.yml");
	    if (!playersfile.exists()) {
	        try {
	            playersfile.createNewFile();
	        }
	        catch (IOException e) {
	            getLogger().severe(ChatColor.RED + "Could not create the playerBalance.yml!");
	        }
	    }
	    
	    
	    
	    
	  }
	
}
