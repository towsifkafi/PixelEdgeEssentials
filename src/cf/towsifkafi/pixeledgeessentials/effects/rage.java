package cf.towsifkafi.pixeledgeessentials.effects;

import cf.towsifkafi.pixeledgeessentials.commands.CooldownManager;
import cf.towsifkafi.pixeledgeessentials.pixeledgeessentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.TimeUnit;

public class rage implements CommandExecutor {

    private final CooldownManager rageCooldownManager = new CooldownManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Plugin plugin = pixeledgeessentials.getPlugin(pixeledgeessentials.class);
        String MPREFIX = plugin.getConfig().getString("main-prefix");
        String EPREFIX = plugin.getConfig().getString("pixeleffect-prefix");
        boolean enabled = plugin.getConfig().getBoolean("rage");
        if(enabled) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("pixel.rage")) {
                    if(args.length == 0) {
                        long timeLeft = System.currentTimeMillis() - rageCooldownManager.getCooldown(p.getUniqueId());
                        if(TimeUnit.MILLISECONDS.toSeconds(timeLeft) >= CooldownManager.DEFAULT_COOLDOWN){
                            ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 900, 2));
                            ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 900, 2));
                            ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 900, 0));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &cRage &a has been used!"));
                            rageCooldownManager.setCooldown(p.getUniqueId(), System.currentTimeMillis());
                        }else{
                            Long timeleft = CooldownManager.DEFAULT_COOLDOWN - TimeUnit.MILLISECONDS.toSeconds(timeLeft);
                            p.sendMessage(ChatColor.RED +" "+ timeleft.toString() + " seconds before you can use rage again.");
                        }
                    } else {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if(target instanceof Player) {
                            long timeLeft = System.currentTimeMillis() - rageCooldownManager.getCooldown(p.getUniqueId());
                            if(TimeUnit.MILLISECONDS.toSeconds(timeLeft) >= CooldownManager.DEFAULT_COOLDOWN){
                                target.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 900, 2));
                                target.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 900, 2));
                                target.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 900, 0));
                                target.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &aYou have been &cRaged&a by &b" + p.getDisplayName()));
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &aYou have &cRaged&a &b" + target.getDisplayName()));
                                rageCooldownManager.setCooldown(p.getUniqueId(), System.currentTimeMillis());
                            }else{
                                Long timeleft = CooldownManager.DEFAULT_COOLDOWN - TimeUnit.MILLISECONDS.toSeconds(timeLeft);
                                p.sendMessage(ChatColor.RED +" "+ timeleft.toString() + " seconds before you can use rage again.");
                            }
                        } else {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &aPlease provide a valid player"));
                        }
                    }

                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &cYou don't have permission to execute that command"));
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " You can't execute that command in console"));
            }
        } else {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &cThat effect is disabled in the config"));
            } else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " You can't execute that command in console"));
            }
        }
        return false;
    }
}
