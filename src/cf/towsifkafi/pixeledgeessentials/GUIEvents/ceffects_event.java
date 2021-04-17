package cf.towsifkafi.pixeledgeessentials.GUIEvents;

import cf.towsifkafi.pixeledgeessentials.effects.fury;
import cf.towsifkafi.pixeledgeessentials.effects.regen;
import org.bukkit.Material;
import cf.towsifkafi.pixeledgeessentials.effects.rage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static org.bukkit.Material.REDSTONE;

public class ceffects_event implements Listener {
    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getClickedInventory().getTitle().equalsIgnoreCase("PixelEffects")) {

            switch (e.getCurrentItem().getType()) {
                case REDSTONE:
                    player.performCommand("rage");
                    break;
                case GLOWSTONE_DUST:
                    player.performCommand("fury");
                    break;
                case APPLE:
                    player.performCommand("regen");
                    break;
            }
            e.setCancelled(true);
        }

    }

}
