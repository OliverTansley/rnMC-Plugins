package org.rnm.rnmcplugins.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class Diecount_Command extends Command {

    static HashMap<String,Integer> deathRecord;

    protected Diecount_Command(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player){
            Player targetPlayer = (Player) commandSender;
            StringBuilder deathsString = new StringBuilder();
            for (Player otherPlayer : targetPlayer.getServer().getOnlinePlayers()){
                deathsString.append(otherPlayer.getName()).append(deathRecord.get(otherPlayer.getName())).append('\n');
            }
            targetPlayer.sendMessage(deathsString.toString());
        }
        return false;
    }

    public static HashMap<String, Integer> getDeathRecord() {
        return deathRecord;
    }
}
