package org.rnm.rnmcplugins.minigames.ParkourTag;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.rnm.rnmcplugins.minigames.MinigameMetaValue;

public class parkourTag_Listener implements Listener {

    private static MinigameMetaValue metaValue = MinigameMetaValue.PARKOURTAG;

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof Player attackerPlayer){
            if(event.getEntity() instanceof Player damagedPlayer){

            }
        }
    }
}
