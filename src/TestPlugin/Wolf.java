package TestPlugin;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import TestPlugin.commands.ValueCommands;
import TestPlugin.commands.pjsucks;
import TestPlugin.Events.player.PlayerJoin;

public class Wolf extends JavaPlugin {
	@Override
	public void onEnable() {
		getLogger().info("WolfOfWallStreet has been enabled.");
		
		loadCommands();
		loadEvents();
	}

	@Override
	public void onDisable() {
		getLogger().info("WolfOfWallStreet has been disabled.");
	}
	
	public void loadCommands(){
		getCommand("PjSucks").setExecutor(new pjsucks());
		getCommand("Balance").setExecutor(new ValueCommands());
	}
	public void loadEvents(){
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerJoin(), this);
	}
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
}
