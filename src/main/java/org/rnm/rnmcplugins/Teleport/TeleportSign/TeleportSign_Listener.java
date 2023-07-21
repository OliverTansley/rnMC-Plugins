package org.rnm.rnmcplugins.Teleport.TeleportSign;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.rnm.rnmcplugins.Parties.Party;
import org.rnm.rnmcplugins.Parties.Party_Command;

public class TeleportSign_Listener implements Listener {

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.ADVENTURE) {
            event.setCancelled(true);
            if (event.getClickedBlock().getState() instanceof Sign clickedSign) {
                Location clickedSignLocation = clickedSign.getLocation();
                event.getPlayer().getServer().getLogger().info(clickedSignLocation.clone().add(0.0, -4.0, 0.0).getBlock().toString());
                if (clickedSignLocation.clone().add(0.0, -4.0, 0.0).getBlock().getState() instanceof Sign infoSign) {
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
}
