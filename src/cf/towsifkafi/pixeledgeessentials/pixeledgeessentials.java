package cf.towsifkafi.pixeledgeessentials;

import cf.towsifkafi.pixeledgeessentials.GUI.ceffects;
import cf.towsifkafi.pixeledgeessentials.GUIEvents.ceffects_event;
import cf.towsifkafi.pixeledgeessentials.commands.fuck;
import cf.towsifkafi.pixeledgeessentials.effects.fury;
import cf.towsifkafi.pixeledgeessentials.effects.rage;
import cf.towsifkafi.pixeledgeessentials.effects.regen;
import cf.towsifkafi.pixeledgeessentials.events.OnLeaveBed;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class pixeledgeessentials extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        String MPREFIX = getConfig().getString("main-prefix");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',MPREFIX + " &aPixelEdge Essentials Started!"));
        //getLogger().info(ChatColor.GREEN + "PixelEdge Essentials Started!");
        getServer().getPluginManager().registerEvents(new OnLeaveBed(), this);
        getServer().getPluginManager().registerEvents(new ceffects_event(), this);
        getCommand("fuck").setExecutor(new fuck());
        getCommand("rage").setExecutor(new rage());
        getCommand("fury").setExecutor(new fury());
        getCommand("regen").setExecutor(new regen());
        getCommand("ceffects").setExecutor(new ceffects());
    }

    @Override
    public void onDisable() {
        String MPREFIX = getConfig().getString("main-prefix");
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " &cServer er putki marse tai plugin off hoise!"));
        //getLogger().info("Server er putki marse tai plugin off hoise!");
    }

}
