package de.devlucas.jeremyessentials.commands.user;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@de.devlucas.jeremyessentials.utils.Command(
        command = "Head",
        permission = "essentials.head",
        description = "Gives a player-head to the player",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class HeadCommand extends JeremyExecuter
{
    @Override @Deprecated public boolean executeCommand(@NotNull Player player, Command command, String @NotNull [] args)
    {

        Player target = Bukkit.getPlayer(args[0]);

        target = (target == null ? (Player) Bukkit.getOfflinePlayer(args[0]) : target);

        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);
        SkullMeta skull = (SkullMeta) item.getItemMeta();
        skull.setOwner(String.valueOf(target));
        skull.setDisplayName(target + "'s Head");
        player.sendMessage(JeremyEssentials.pre + "Successfully gave you the head of " + target.getName() + ".");

        return false;
    }

    @Override public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args)
    {
        return null;
    }
}
