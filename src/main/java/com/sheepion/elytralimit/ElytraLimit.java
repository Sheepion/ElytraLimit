package com.sheepion.elytralimit;

import com.sheepion.elytralimit.command.reload;
import com.sheepion.elytralimit.listener.ElytraListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class ElytraLimit extends JavaPlugin {
    public static FileConfiguration config;
    public static JavaPlugin plugin;
    private static File configFile;

    public ElytraLimit() {
        plugin = this;
    }

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        configFile = new File(plugin.getDataFolder() + "/config.yml");
        reload();
        getCommand("elytralimit").setExecutor(new reload());
        getServer().getPluginManager().registerEvents(new ElytraListener(), this);
        getLogger().info("ElytraLimit enabled!");
    }

    @Override
    public void onDisable() {
    }


    public static void reload() {
        config = YamlConfiguration.loadConfiguration(configFile);
        if (config.contains("max-elytra-speed")) {
            ElytraListener.maxElytraSpeed = config.getDouble("max-elytra-speed");
            plugin.getLogger().info("max-elytra-speed: " + ElytraListener.maxElytraSpeed);
        }
    }
}
