package org.rnm.rnmcplugins.Teleport.Portal;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;
import org.rnm.rnmcplugins.Parties.Party;
import org.rnm.rnmcplugins.Parties.Party_Command;

public class RnMC_Portal implements Listener {

    @EventHandler
    public void onEnter(PlayerPortalEvent event){
        Player targetPlayer = event.getPlayer();
        targetPlayer.sendMessage("Entering Portal");
        if(targetPlayer.getWorld().getName().equals("Lobby") && targetPlayer.getGameMode() == GameMode.ADVENTURE){
            event.setCancelled(true);
            Location playerLocation = targetPlayer.getLocation();

            if(playerLocation.clone().add(0,-2,0).getBlock().getState() instanceof Sign infoSign){
                String[] coordinates = infoSign.getLine(1).split(",");
                Location targetLocation = new Location(event.getPlayer().getServer().getWorld(infoSign.getLine(0)), Double.valueOf(coordinates[0]), Double.valueOf(coordinates[1]), Double.valueOf(coordinates[2]));
                Party targetParty = Party_Command.getPartyByLeader(event.getPlayer());
                if (targetParty == null) {
                    event.getPlayer().teleport(targetLocation);
                } else {
                    targetParty.teleportParty(targetLocation);
                }
            }
        }
    }
}
