package org.rnm.rnmcplugins;


import org.bukkit.command.Command;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;
import org.rnm.rnmcplugins.Teleport.Portal.RnMC_Portal;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;


public final class RnMC_Plugins extends JavaPlugin {

    public PluginManager pm = getServer().getPluginManager();

    private static final HashMap<String,Listener> eventListeners = new HashMap<>();

    @Override
    public void onEnable() {

        try {
            registerCommands();
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            getLogger().info("Failed to register commands inside org.rnm.rnmcplugins.Commands package");
        }

        this.registerListener(new RnMC_Portal());

        getLogger().info("\u001B[34m------------------------ \u001B[0m");
        getLogger().info("\u001B[34mrnMC Plugins initialised \u001B[0m");
        getLogger().info("\u001B[34m------------------------ \u001B[0m");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Listener getListener(String className){
        return eventListeners.get(className);
    }

    private void registerListener(Listener eventListener){
        this.getServer().getPluginManager().registerEvents(eventListener,this);
        eventListeners.put(eventListener.getClass().getName(),eventListener);
    }


    private void registerCommands() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reflections commandPackageReflection = new Reflections("org.rnm.rnmcplugins.Commands");
        Set<Class<? extends Command>> commands = commandPackageReflection.getSubTypesOf(Command.class);
        for (Class<? extends Command> command : commands) {
            String commandClassName = command.getName();
            String commandName = commandClassName.split("_")[0];
            getServer().getCommandMap().register(commandName, command.getConstructor().newInstance());
        }
    }
}
