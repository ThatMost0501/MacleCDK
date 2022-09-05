package me.thatmost;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;


public final class maclecdk extends JavaPlugin {
    /*
    此插件代码提供者为EnRon233
    推荐发卡平台https://zoufk.com
    为商户谋福利，为买家供便利

     */
    public File file = new File(getDataFolder(), "Export.yml");
    public File used = new File(getDataFolder(), "Log.yml");
    public static YamlConfiguration filec,uselog;
    @Override
    public void onEnable() {
        ins = this;
        saveDefaultConfig();
        if (!file.exists()){
            try {
                Boolean resp = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!used.exists()){
            try {
                Boolean usedNewFile = used.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        filec = YamlConfiguration.loadConfiguration(file);
        uselog = YamlConfiguration.loadConfiguration(used);
        Bukkit.getPluginCommand("maclecdk").setExecutor(new Acommand());
        int pluginId = 16334; // <-- Replace with the id of your plugin!
        Metrics metrics = new Metrics(this, pluginId);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "My value"));
        this.getLogger().info("插件已成功运行！");
        this.getLogger().info("&a此插件代码提供者为EnRon233");
        this.getLogger().info("&a推荐发卡平台https://zoufk.com");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    private static maclecdk ins;
    public static maclecdk getIns(){
        return ins;
    }
}
