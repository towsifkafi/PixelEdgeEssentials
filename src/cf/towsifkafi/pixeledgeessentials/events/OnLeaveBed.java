package cf.towsifkafi.pixeledgeessentials.events;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public class OnLeaveBed implements Listener {
    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event){
        event.getPlayer().kickPlayer(ChatColor.RED+ "Die Bish! You Left da BED");
    }

}
