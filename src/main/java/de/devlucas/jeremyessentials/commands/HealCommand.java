package de.devlucas.jeremyessentials.commands;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
@main(command = "heal", description = "A command that allows the Player to heal himself or other players", permission = "essentials.heal", isConsoleCommand = false)
public class HealCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {
        player.setHealth(20);
        player.setFoodLevel(20);
        player.sendMessage(JeremyEssentials.pre + "You have been healed!");

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
