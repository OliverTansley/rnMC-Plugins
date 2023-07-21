package org.rnm.rnmcplugins.Parties;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.rnm.rnmcplugins.RnMC_Plugins;

import java.util.ArrayList;
import java.util.HashMap;

public class Party_Command extends Command {

    private static final HashMap<Player,Party> activeParties = new HashMap<>();

    protected Party_Command(@NotNull String name) {
        super(name);
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player targetPlayer){
            switch (strings[0].toLowerCase()) {
                case "make" -> activeParties.put(targetPlayer, new Party(targetPlayer));
                case "add" -> {
                    if (activeParties.containsKey(targetPlayer)) {
                        if (!strings[1].equals("")) {
                            activeParties.get(targetPlayer).add(targetPlayer.getServer().getPlayer(strings[1]));
                        } else {
                            targetPlayer.sendMessage("If you want to add a player please give us their name as well");
                            targetPlayer.sendMessage("Example: \\party add John");
                        }
                    }
                }
                case "leave" -> {}
            }
        }
        return true;
    }

    public static Party getPartyByLeader(Player maybeLeader){
        for(Party party : activeParties.values()){
            if(party.getPartyLeader().equals(maybeLeader)){
                return party;
            }
        }
        return null;
    }

}
