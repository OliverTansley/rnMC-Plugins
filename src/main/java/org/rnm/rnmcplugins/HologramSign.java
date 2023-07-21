package org.rnm.rnmcplugins;


import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

import java.util.ArrayList;

public class HologramSign {

    ArmorStand signStand;

    public HologramSign(ArrayList<String> textLines, Location location){
        signStand = location.getWorld().spawn(location,ArmorStand.class);
        signStand.setVisible(false);
        signStand.setCanMove(false);
        signStand.setCollidable(false);
        signStand.setInvisible(true);
        signStand.setCustomName(textLines.toString());
    }

}
