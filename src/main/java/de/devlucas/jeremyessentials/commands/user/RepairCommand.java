package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@main(
        command = "repair",
        permission = "essentials.repair",
        description = "Repair",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class RepairCommand extends JeremyExecuter {

    private HashMap<UUID, Long> lastUsed = new HashMap<>();

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        if (lastUsed.containsKey(player.getUniqueId()) &! player.hasPermission("essentials.admin"))
        {
            long timeDifference = System.currentTimeMillis() - lastUsed.get(player.getUniqueId());

            if (timeDifference < 604800000) // 1 Woche in ms
            {
                player.sendMessage(JeremyEssentials.pre + "You have to wait one week to use it again!");
                return true;
            }
        }

        ItemStack itemStack = player.getItemInHand();

        if (itemStack.getType() != Material.AIR)
        {
            itemStack.setDurability((short) 0);
            player.sendMessage(JeremyEssentials.pre + "Done.");
            lastUsed.put(player.getUniqueId(), System.currentTimeMillis());
        }
        else
        {
            player.sendMessage(JeremyEssentials.pre + "You cant repair this item");
        }
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
