package cf.towsifkafi.pixeledgeessentials.GUI;

import cf.towsifkafi.pixeledgeessentials.pixeledgeessentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class ceffects implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        Plugin plugin = pixeledgeessentials.getPlugin(pixeledgeessentials.class);
        String MPREFIX = plugin.getConfig().getString("main-prefix");
        boolean enabled = plugin.getConfig().getBoolean("effect-gui");

        if(enabled) {

            if(sender instanceof Player) {

                Player player = (Player) sender;
                Inventory vault = Bukkit.createInventory(player, 9, "PixelEffects");
                player.openInventory(vault);

                // RAGE

                ItemStack rage = new ItemStack(Material.REDSTONE, 1);
                ItemMeta rageMeta = rage.getItemMeta();
                rageMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lRAGE"));
                List<String> rageLore = new ArrayList<String>();
                rageLore.add(ChatColor.translateAlternateColorCodes('&', "&eClick to activate &c&lRAGE"));
                rageMeta.setLore(rageLore);
                rage.setItemMeta(rageMeta);

                // FURY

                ItemStack fury = new ItemStack(Material.GLOWSTONE_DUST, 1);
                ItemMeta furyMeta = fury.getItemMeta();
                furyMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lFURY"));
                List<String> furyLore = new ArrayList<String>();
                furyLore.add(ChatColor.translateAlternateColorCodes('&', "&eClick to activate &6&lFURY"));
                furyMeta.setLore(furyLore);
                fury.setItemMeta(furyMeta);

                // REGEN

                ItemStack regen = new ItemStack(Material.APPLE, 1);
                ItemMeta regenMeta = regen.getItemMeta();
                regenMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lREGEN"));
                List<String> regenLore = new ArrayList<String>();
                regenLore.add(ChatColor.translateAlternateColorCodes('&', "&eClick to activate &c&lREGEN"));
                regenMeta.setLore(regenLore);
                regen.setItemMeta(regenMeta);


                // BACK

                ItemStack back = new ItemStack(Material.ARROW, 1);
                ItemMeta backMeta = back.getItemMeta();
                backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lClose"));
                back.setItemMeta(backMeta);
                // -- * --

                ItemStack[] items = { rage, fury, regen };

                vault.setContents(items);
                vault.setItem(8, back);

            } else {

                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " &cYou can't execute that command in console"));

            }
        } else {

            if(sender instanceof Player) {
                Player p = (Player) sender;
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " &cThat command is disabled in the config"));
            } else {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', MPREFIX + " &cYou can't execute that command in console"));
            }
        }





        return true;
    }
}
