package org.rnm.rnmcplugins.Commands;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Lobby_Command extends Command {


    public Lobby_Command() {
        super("Lobby");
    }

    @Override
    public boolean execute(@NotNull CommandSender commandSender, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player targetPlayer){
            targetPlayer.teleport(new Location(targetPlayer.getServer().getWorld("Lobby"),0.5,-23.0,0.5));
            targetPlayer.setGameMode(GameMode.ADVENTURE);
        }
        return true;
    }
}
