package de.devlucas.jeremyessentials.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

import static de.devlucas.jeremyessentials.JeremyEssentials.clickCounts;

public class CookieClickEvent implements Listener
{

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (action == Action.RIGHT_CLICK_BLOCK)
        {
            if (event.getClickedBlock().getType() == Material.PLAYER_HEAD)
            {
                ItemStack item = event.getItem();

                if (item != null && item.getType() == Material.PLAYER_HEAD)
                {
                    ItemMeta itemMeta = item.getItemMeta();
                    if (itemMeta != null && itemMeta.hasDisplayName() && itemMeta.getDisplayName().equals(ChatColor.YELLOW + "Cookie"))
                    {
                        incrementClickCount(player.getUniqueId());
                        player.sendMessage(ChatColor.GREEN + "Du hast den Cookie geklickt!");
                    }
                }
            }
        }
    }

    private void incrementClickCount(UUID playerId) {
        int count = clickCounts.getOrDefault(playerId, 0);
        clickCounts.put(playerId, count + 1);
    }

}
