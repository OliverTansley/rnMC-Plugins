package org.rnm.rnmcplugins.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.rnm.rnmcplugins.Commands.Diecount_Command;

public class DieCount_Event implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        Player deadPlayer = event.getEntity();
        if (Diecount_Command.getDeathRecord().containsKey(deadPlayer.getName())){
            Diecount_Command.getDeathRecord().put(deadPlayer.getName(),Diecount_Command.getDeathRecord().get(deadPlayer.getName()) +1);
        }else {
            Diecount_Command.getDeathRecord().put(deadPlayer.getName(),1);
        }
    }
}
