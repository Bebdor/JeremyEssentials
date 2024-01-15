package de.devlucas.jeremyessentials.commands.user.tpa;

import de.devlucas.jeremyessentials.JeremyEssentials;
import de.devlucas.jeremyessentials.utils.JeremyExecuter;
import de.devlucas.jeremyessentials.utils.main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@main(
        command = "tpdeny",
        permission = "essentials.tpa",
        description = "Deny a TPA request",
        isConsoleCommand = false,
        isAdminCommand = false
)

public class TpDenyCommand extends JeremyExecuter {
    @Override
    public boolean executeCommand(Player player, Command command, String[] args) {

        if (args.length == 0)
        {
            Player target = JeremyEssentials.tpa.get(player);


            if (target == null)
            {
                player.sendMessage(JeremyEssentials.pre + "You have not received any tpa requests.");
                return false;
            }

            player.sendMessage(JeremyEssentials.pre + "Successfully denied the tpa-request of §6" + target.getName() + "§7.");
            target.sendMessage(JeremyEssentials.pre + "Your tpa-request was denied.");
            JeremyEssentials.tpa.remove(player);

        }

        return false;
    }

    @Override
    public List<String> suggestTabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
