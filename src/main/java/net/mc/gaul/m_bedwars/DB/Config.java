package net.mc.gaul.m_bedwars.DB;

import net.mc.gaul.m_bedwars.M_BedWars;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class Config {

    private File ConfigFile;
    private org.bukkit.configuration.file.YamlConfiguration YamlConfiguration;
    private String configdir;
    private String configname;
    private File file;
    Plugin plugin;

    public Config(String configdir, String configname) {
        this.configdir = configdir;
        this.configname = configname;
        this.plugin = M_BedWars.getPlugin();

        if (configdir.isEmpty()) {
            this.file = new File(plugin.getDataFolder().toString());
        } else {
            this.file = new File(plugin.getDataFolder().toString(), configdir);
        }
        this.ConfigFile = new File(file, configname + ".yml");
        this.YamlConfiguration = YamlConfiguration.loadConfiguration(ConfigFile);
    }

    public void PlayerConfigSettings() throws IOException {
//        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(ConfigFile);
        YamlConfiguration.set("options.language", "eng");
        YamlConfiguration.save(ConfigFile);
    }

    public static void createNewFile(String configdir, String configname){
        File file;
        file = new File(configdir, configname + ".yml");
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs(); // 부모 디렉토리 생성
        }
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (Exception e) {
                Bukkit.getLogger().warning("생성 중 에랴 발생: " + e.getMessage());
            }
        }
    }

    public void setupConfig(){
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!this.ConfigFile.exists()) {
            try {
                if (configdir.isEmpty()) {
//                    FileWriter writer = new FileWriter(ConfigFile);
//                    writer.close();
                    this.plugin.saveResource(configname + ".yml", false);
                } else {
                    this.plugin.saveResource(configdir + "/" + configname + ".yml", false);
                }
            } catch (Exception ex) {
                this.plugin.getLogger().warning("Unable to create" + configname + ".yml file. Using default profile selection.");
                return;
            }
        }
        YamlConfiguration = new YamlConfiguration();
        try {
            YamlConfiguration.load(this.ConfigFile);
        } catch (InvalidConfigurationException | IOException var3) {
            var3.printStackTrace();
        }
    }

    public YamlConfiguration getConfig()  {
        if (!ConfigFile.exists()) {
            Bukkit.getLogger().warning("구성 파일을 찾을 수 없습니다: " + ConfigFile.getPath());
            return null;
        }
        return this.YamlConfiguration;
    }

    public YamlConfiguration getConfig(String configdir, String configname){
        this.file = new File(configdir);
        this.ConfigFile = new File(file, configname + ".yml");
        this.YamlConfiguration = YamlConfiguration.loadConfiguration(ConfigFile);
        return this.YamlConfiguration;
    }

    public File getFile(){
        return this.file;
    }

    public void saveConfig() {
        try {
            this.YamlConfiguration.save(this.ConfigFile);
        } catch (IOException var2) {
            this.plugin.getLogger().warning("Could not save config to " + this.ConfigFile.getName());
        }
    }

    public void reloadConfig() {
        YamlConfiguration newConfig = new YamlConfiguration();
        try {
            newConfig.load(this.ConfigFile);
            this.YamlConfiguration = newConfig;
        } catch (IOException | InvalidConfigurationException var3) {
            this.plugin.getLogger().warning("Could not load config from " + this.ConfigFile.getName());
        }
    }
}
