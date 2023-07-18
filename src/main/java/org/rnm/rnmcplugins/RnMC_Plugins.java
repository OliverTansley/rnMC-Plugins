package org.rnm.rnmcplugins;

import org.bukkit.plugin.java.JavaPlugin;

public final class RnMC_Plugins extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("YourPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
