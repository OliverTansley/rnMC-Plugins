package org.rnm.rnmcplugins.Parties;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;

public class Party implements Iterable<Player>{

    private final Player partyLeader;
    private final ArrayList<Player> otherPlayers;

    Party(Player leader) {
        this.partyLeader = leader;
        this.otherPlayers = new ArrayList<>();
    }

    public void add(Player newPlayer) {
        if(!otherPlayers.contains(newPlayer)){
            otherPlayers.add(newPlayer);
            partyLeader.sendMessage(newPlayer.getName() + " has been added to your party");
        }
    }

    private void removeOfflines(){
        otherPlayers.removeIf(player -> !player.isOnline());
    }

    public void teleportParty(Location targetLocation){
        for(Player player : otherPlayers){
            player.teleport(targetLocation);
        }
    }

    public void teleportParty(String worldName,String[] coordStrings){
        Location targetLocation = new Location(partyLeader.getServer().getWorld(worldName),Double.valueOf(coordStrings[0]),Double.valueOf(coordStrings[0]),Double.valueOf(coordStrings[0]));
        teleportParty(targetLocation);
    }

    public Player getPartyLeader() {
        return partyLeader;
    }

    @NotNull
    @Override
    public Iterator<Player> iterator() {
        ArrayList<Player> allPlayers = (ArrayList<Player>) otherPlayers.clone();
        otherPlayers.add(0,partyLeader);
        return allPlayers.iterator();
    }
}
