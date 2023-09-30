package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

import static de.devlucas.jeremyessentials.JeremyEssentials.clickCounts;

@main(command = "cookie", permission = "", description = "Is a command that allows the player to display the cookies", isConsoleCommand = false)
public class CookieClickerCommand extends JeremyExecuter {

    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {
        if (command.getName().equalsIgnoreCase("cookie")) {

            int clickCount = clickCounts.getOrDefault(player.getUniqueId(), 0);
            player.sendMessage(ChatColor.YELLOW + "Du hast den Cookie bereits " + clickCount + " mal geklickt!");
            return true;
        }
        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
