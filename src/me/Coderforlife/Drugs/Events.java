package me.Coderforlife.Drugs;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MainHand;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Events implements Listener {
	Logger logger = Logger.getLogger("Minecraft");
	private Main plugin;

	public Events(Main plugin) {
		setPlugin(plugin);
	}

	public Main getPlugin() {
		return this.plugin;
	}

	public void setPlugin(Main plugin) {
		this.plugin = plugin;
	}

	public boolean useDrug(PlayerInteractEvent e, Material m) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		ItemStack i = p.getInventory().getItemInMainHand();
		
        if (a == Action.RIGHT_CLICK_AIR && i.getType() == m) {
            e.setCancelled(true);
            i.setAmount(i.getAmount() - 1);
            return true;
        }
		return false;
	}
	
	public void logUsage(Player p, String msg) {
		if (this.plugin.getConfig().getBoolean("Drugs.Console.logs")) {
			this.logger.info("[SimpleDrugs] Player " + p.getName() + " " + msg);
		}
	}
	
	@EventHandler
	public void onRightClick(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if ((this.plugin.getConfig().getBoolean("Drugs.Toggle.wheat")) && (p.hasPermission("drugs.wheat"))
				&& useDrug(e, Material.WHEAT)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.sendMessage(ChatColor.GREEN + "Like that Weed?");
			
			logUsage(p, "used weed");
		}
		
		if ((this.plugin.getConfig().getBoolean("Drugs.Toggle.sugar")) && (p.hasPermission("drugs.sugar"))
				&& useDrug(e, Material.SUGAR)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.sendMessage(ChatColor.AQUA + "You just hit Cocaine!");
			
			logUsage(p, "used cocaine");
		}
		
		if ((this.plugin.getConfig().getBoolean("Drugs.Toggle.paper")) && (p.hasPermission("drugs.paper"))
				&& useDrug(e, Material.PAPER)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.addPotionEffect(
					new PotionEffect(PotionEffectType.JUMP, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1),
					true);
			p.sendMessage(ChatColor.AQUA + "You just hit Acid!");
			
			logUsage(p, "used Acid");
		}
		
		if ((this.plugin.getConfig().getBoolean("Drugs.Toggle.gunpowder")) && (p.hasPermission("drugs.gun"))
				&& useDrug(e, Material.SULPHUR)) {
			p.addPotionEffect(
					new PotionEffect(PotionEffectType.JUMP, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1),
					true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.addPotionEffect(
					new PotionEffect(PotionEffectType.SPEED, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1),
					true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.sendMessage(ChatColor.AQUA + "PowPow!!!");

			logUsage(p, "used PowPow");
		}
		
		if ((this.plugin.getConfig().getBoolean("Drugs.Toggle.bone")) && (p.hasPermission("drugs.bone"))
				&& useDrug(e, Material.BONE)) {
			p.addPotionEffect(
					new PotionEffect(PotionEffectType.JUMP, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1),
					true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.addPotionEffect(
					new PotionEffect(PotionEffectType.SPEED, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1),
					true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.sendMessage(ChatColor.AQUA + "Angel Dust!");
			
			logUsage(p, "used Angel Dust");
		}
		
		if ((this.plugin.getConfig().getBoolean("Drugs.Toggle.smoke")) && (p.hasPermission("drugs.smoke"))
				&& useDrug(e, Material.TORCH)) {
			p.addPotionEffect(
					new PotionEffect(PotionEffectType.SPEED, this.plugin.getConfig().getInt("Drugs.Effect.length"), 1),
					true);
			p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,
					this.plugin.getConfig().getInt("Drugs.Effect.length"), 1), true);
			p.sendMessage(ChatColor.GREEN + "Smoking Yeah " + ChatColor.RED + " <3");
			
			logUsage(p, "just smoked");
		}
	}
}
