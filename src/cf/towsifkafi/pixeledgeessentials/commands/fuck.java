package cf.towsifkafi.pixeledgeessentials.commands;

import cf.towsifkafi.pixeledgeessentials.pixeledgeessentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class fuck implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        //da code ij here
        Plugin plugin = pixeledgeessentials.getPlugin(pixeledgeessentials.class);
        String MPREFIX = plugin.getConfig().getString("main-prefix");
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.setHealth(0);
        } else {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " You can't execute that command in console"));
        }

        return false;
    }
}
