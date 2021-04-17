package cf.towsifkafi.pixeledgeessentials.effects;

import cf.towsifkafi.pixeledgeessentials.commands.CooldownManager;
import cf.towsifkafi.pixeledgeessentials.pixeledgeessentials;
import com.connorlinfoot.actionbarapi.ActionBarAPI;
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

public class regen implements CommandExecutor {

    private final CooldownManager regenCooldownManager = new CooldownManager();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Plugin plugin = pixeledgeessentials.getPlugin(pixeledgeessentials.class);
        String MPREFIX = plugin.getConfig().getString("main-prefix");
        String EPREFIX = plugin.getConfig().getString("pixeleffect-prefix");
        boolean enabled = plugin.getConfig().getBoolean("regen");
        if(enabled) {
            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("pixel.regen")) {
                    long timeLeft = System.currentTimeMillis() - regenCooldownManager.getCooldown(p.getUniqueId());
                    if(TimeUnit.MILLISECONDS.toSeconds(timeLeft) >= CooldownManager.DEFAULT_COOLDOWN){
                        ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600, 3));
                        ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 600, 3));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', EPREFIX + " &dRegen &ahas been used!"));
                        ActionBarAPI.sendActionBar(p,ChatColor.translateAlternateColorCodes('&', "&d&lREGEN &a&lActivated"), 600);
                        regenCooldownManager.setCooldown(p.getUniqueId(), System.currentTimeMillis());
                    }else{
                        Long timeleft = CooldownManager.DEFAULT_COOLDOWN - TimeUnit.MILLISECONDS.toSeconds(timeLeft);
                        p.sendMessage(ChatColor.RED + " "+ timeleft.toString() + " seconds before you can use regen command again.");
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
