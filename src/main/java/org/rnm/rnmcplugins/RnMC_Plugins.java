package org.rnm.rnmcplugins;

import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public final class RnMC_Plugins extends JavaPlugin {

    PluginManager pm = getServer().getPluginManager();

    @Override
    public void onEnable() {
        // Plugin startup logic

        /*
         *  Register event classes to plugin
         */
        Reflections listenerReflections = new Reflections("org.rnm.rnmcplugins.Events");
        Set<Class<? extends Listener>> listenerClasses = listenerReflections.getSubTypesOf(Listener.class);
        for (Class<? extends Listener> listener : listenerClasses) {
            try {
                pm.registerEvents(listener.getConstructor().newInstance(), this);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                getLogger().info("Failed to instantiate class for event: " + listener.getName());
            }
        }

        /*
         *  Register player commands to plugin
         */
        Reflections commandReflections = new Reflections("org.rnm.rnmcplugins.Commands");
        Set<Class<? extends Command>> commandClasses = commandReflections.getSubTypesOf(Command.class);
        for (Class<? extends Command> command : commandClasses) {
            try {
                getServer().getCommandMap().register(command.getName(), command.getConstructor().newInstance());
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                getLogger().info("Failed to instantiate class for command: " + command.getName());
            }
        }


        getLogger().info("\u001B[34m------------------------ \u001B[0m");
        getLogger().info("\u001B[34mrnMC Plugins initialised \u001B[0m");
        getLogger().info("\u001B[34m------------------------ \u001B[0m");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
