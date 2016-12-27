package rocks.tricks.main;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import rocks.tricks.main.events.FirstJoinData;


public class Core extends JavaPlugin {
	
	public void onEnable() {
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	registerCommands();
	registerConfig();
	registerEvents();

	logger.info(pdfFile.getName() + "Has been enabled - Version " + pdfFile.getVersion());	
}

public void onDisable() {
	PluginDescriptionFile pdfFile = getDescription();
	Logger logger = getLogger();

	logger.info(pdfFile.getName() + "Has been disabled - Version " + pdfFile.getVersion());
}

public void registerCommands() {
	getCommand("refer").setExecutor(new Refer(this));
	}

public void registerEvents() {
	PluginManager pm = getServer().getPluginManager();
	
	pm.registerEvents(new FirstJoinData(this), this);
}

public void registerConfig() {
	getConfig().options().copyDefaults(true);
	saveDefaultConfig();
	}
}

