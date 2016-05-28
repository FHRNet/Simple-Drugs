package me.Coderforlife.Drugs;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	Logger logger = Logger.getLogger("Minecraft");
	final String perm = ChatColor.RED + "You don't have the right permission";

	public void onEnable() {
		getCommand("drugs").setExecutor(new KillerCommands(this));
		getServer().getPluginManager().registerEvents(new Events(this), this);
		getConfig().options().header("Simple Drugs Config.");
		loadConfiguration();
	}

	public void loadConfiguration() {
		String wheat = "Drugs.Toggle.wheat";
		String sugar = "Drugs.Toggle.sugar";
		String paper = "Drugs.Toggle.paper";
		String gunp = "Drugs.Toggle.gunpowder";
		String bone = "Drugs.Toggle.bone";
		String effect = "Drugs.Effect.length";
		String console = "Drugs.Console.logs";
		/*
		 * String remove = "Drugs.Effect.Clear"; String sound =
		 * "Drugs.Effect.Sound";
		 */
		getConfig().addDefault(wheat, true);
		getConfig().addDefault(sugar, true);
		getConfig().addDefault(paper, true);
		getConfig().addDefault(gunp, true);
		getConfig().addDefault(bone, true);
		getConfig().addDefault(effect, 5220);
		getConfig().addDefault(console, true);
		/*
		 * getConfig().addDefault(remove, true); getConfig().addDefault(sound,
		 * true)
		 */
		getConfig().options().copyDefaults(true);
		saveConfig();
	}

	public boolean onCommand(CommandSender sender, Command command, String Commandlabel, String[] args) {
		if (command.getName().equalsIgnoreCase("drugs")) {
			if (args[0].equalsIgnoreCase("reload")) {
				try {
					if (sender.hasPermission("drugs.reload")) {
						sender.sendMessage(ChatColor.GREEN + "Reloading config...");
						reloadConfig();
						sender.sendMessage(ChatColor.GREEN + "Reloaded Config");
					} else {
						sender.sendMessage(perm);
					}
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "Error: " + ChatColor.WHITE + "Config failed to load.");
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public void onDisable() {
	}
}
