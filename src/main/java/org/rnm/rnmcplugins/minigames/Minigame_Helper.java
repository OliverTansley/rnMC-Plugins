package org.rnm.rnmcplugins.minigames;

import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;
import org.rnm.rnmcplugins.Parties.Party;
import org.rnm.rnmcplugins.RnMC_Plugins;

public class Minigame_Helper {

    private final String miniGameMetaTag = "CURRENT_MINIGAME";

    public String getMiniGameMetaTag() {
        return miniGameMetaTag;
    }

    public void setPlayerMinigame(Player targetPlayer, MinigameMetaValue miniGame){
        targetPlayer.setMetadata(miniGameMetaTag,miniGame);
    }

    public void setPartyMinigame(Party targetParty,MinigameMetaValue miniGame){
        for(Player player : targetParty){
            player.setMetadata(miniGameMetaTag,miniGame);
        }
    }


}
