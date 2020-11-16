package de.b3aux.yonplei.main;

import de.b3aux.yonplei.commands.*;
import de.b3aux.yonplei.listener.*;
import de.b3aux.yonplei.methoden.FileConfig;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class Main extends JavaPlugin {

    public static String prefixConsole = "\n" +
            "                 /\\  \\         /\\  \\         /\\  \\                     /\\__\\                \n" +
            "      ___       /::\\  \\        \\:\\  \\       /::\\  \\                   /:/ _/_       ___     \n" +
            "     /|  |     /:/\\:\\  \\        \\:\\  \\     /:/\\:\\__\\                 /:/ /\\__\\     /\\__\\    \n" +
            "    |:|  |    /:/  \\:\\  \\   _____\\:\\  \\   /:/ /:/  /  ___     ___   /:/ /:/ _/_   /:/__/    \n" +
            "    |:|  |   /:/__/ \\:\\__\\ /::::::::\\__\\ /:/_/:/  /  /\\  \\   /\\__\\ /:/_/:/ /\\__\\ /::\\  \\    \n" +
            "  __|:|__|   \\:\\  \\ /:/  / \\:\\~~\\~~\\/__/ \\:\\/:/  /   \\:\\  \\ /:/  / \\:\\/:/ /:/  / \\/\\:\\  \\__ \n" +
            " /::::\\  \\    \\:\\  /:/  /   \\:\\  \\        \\::/__/     \\:\\  /:/  /   \\::/_/:/  /     \\:\\/\\__\\\n" +
            " ~~~~\\:\\  \\    \\:\\/:/  /     \\:\\  \\        \\:\\  \\      \\:\\/:/  /     \\:\\/:/  /       \\::/  /\n" +
            "      \\:\\__\\    \\::/  /       \\:\\__\\        \\:\\__\\      \\::/  /       \\::/  /        /:/  / \n" +
            "       \\/__/     \\/__/         \\/__/         \\/__/       \\/__/         \\/__/         \\/__/  \n";
    public static String prefix = "§7ꕥ §3Yonplei ";
    public static String noPerms = prefix + "§c Dazu hast du keine Berechtigung. ";
    public static String use = prefix + "§7 Bitte Tippe: §6";
    public static String playerNotOnline = prefix + "§cDer Spieler ist nicht online! ";
    public static String noPlayer = prefix + " §cDieser Befehl mus von einem Spieler ausgefuehrt werden";

    public static Main instance;
    public static Main getInstance() {
        return instance;
    }

    public static HashMap<Player, Player> msg = new HashMap<>();
    public static HashMap<Player, Player> open = new HashMap<>();
    public static HashMap<Player, Player> tpa = new HashMap<>();
    public static HashMap<String, Location> back = new HashMap<>();

    public boolean wartung = false;

    public FileConfig file = new FileConfig("Config.yml");

    @Override
    public void onEnable() {

        Bukkit.getConsoleSender().sendMessage(prefixConsole +
                " ____  _  _    __    ____  __    ____ \n" +
                "( ___)( \\( )  /__\\  (  _ \\(  )  ( ___)\n" +
                " )__)  )  (  /(__)\\  ) _ < )(__  )__) \n" +
                "(____)(_)\\_)(__)(__)(____/(____)(____)\n");

        instance = this;

        loadConfig();

        this.wartung = file.get("Wartung.Status") != null && file.getBoolean("Wartung.Status");

        PluginManager pm = this.getServer().getPluginManager();

        pm.registerEvents(new joinListener(), this);
        pm.registerEvents(new quitListener(), this);
        pm.registerEvents(new serverPingListener(), this);
        pm.registerEvents(new globalMuteListener(), this);
        pm.registerEvents(new AsyncPlayerChatListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new interactListener(), this);
        pm.registerEvents(new loginListener(), this);
        pm.registerEvents(new signListener(), this);
        pm.registerEvents(new woodBreakListener(), this);
        pm.registerEvents(new clickListener(), this);

        this.getCommand("vanish").setExecutor(new vanishCMD());
        this.getCommand("v").setExecutor(new vanishCMD());
        this.getCommand("spawn").setExecutor(new spawnCMD());
        this.getCommand("sspawn").setExecutor(new spawnCMD());
        this.getCommand("heal").setExecutor(new healCMD());
        this.getCommand("chatclear").setExecutor(new clearchatCMD());
        this.getCommand("cc").setExecutor(new clearchatCMD());
        this.getCommand("wartung").setExecutor(new wartungCMD());
        this.getCommand("wb").setExecutor(new werkbankCMD());
        this.getCommand("werkbank").setExecutor(new werkbankCMD());
        this.getCommand("tele").setExecutor(new warpCMD());
        this.getCommand("dwarp").setExecutor(new warpCMD());
        this.getCommand("swarp").setExecutor(new warpCMD());
        this.getCommand("fly").setExecutor(new flyCMD());
        this.getCommand("gm").setExecutor(new gamemodeCMD());
        this.getCommand("gamemode").setExecutor(new gamemodeCMD());
        this.getCommand("invsee").setExecutor(new invseeCMD());
        this.getCommand("ec").setExecutor(new enderchestCMD());
        this.getCommand("enderchest").setExecutor(new enderchestCMD());
        this.getCommand("msg").setExecutor(new msgCMD());
        this.getCommand("mute").setExecutor(new muteCMD());
        this.getCommand("unmute").setExecutor(new unmuteCMD());
        this.getCommand("gmute").setExecutor(new globalMuteCMD());
        this.getCommand("bye").setExecutor(new kickCMD());
        this.getCommand("slay").setExecutor(new killCMD());
        this.getCommand("kopf").setExecutor(new kopfCMD());
        this.getCommand("giveall").setExecutor(new giveallCMD());
        this.getCommand("warns").setExecutor(new warnCMD());
        this.getCommand("warnyou").setExecutor(new warnyouCMD());
        this.getCommand("unsign").setExecutor(new unsignCMD());
        this.getCommand("delwarn").setExecutor(new delwarnCMD());
        this.getCommand("break").setExecutor(new diaaxtCMD());
        this.getCommand("setlore").setExecutor(new loreCMD());
        this.getCommand("rename").setExecutor(new renameCMD());
        this.getCommand("report").setExecutor(new reportCMD());
        this.getCommand("rtp").setExecutor(new rtpCMD());
        this.getCommand("sign").setExecutor(new signCMD());
        this.getCommand("pinv").setExecutor(new pinvCMD());
        this.getCommand("pec").setExecutor(new pecCMD());
        this.getCommand("tp").setExecutor(new tpCMD());
        this.getCommand("tphere").setExecutor(new tphereCMD());
        this.getCommand("tpa").setExecutor(new tpaCMD());
        this.getCommand("tpaccept").setExecutor(new tpacceptCMD());
        this.getCommand("tpall").setExecutor(new tpallCMD());
        this.getCommand("day").setExecutor(new dayCMD());
        this.getCommand("night").setExecutor(new nightCMD());
        this.getCommand("repair").setExecutor(new repairCMD());
        this.getCommand("sun").setExecutor(new sunCMD());
        this.getCommand("trash").setExecutor(new trashCMD());
        this.getCommand("r").setExecutor(new returnCMD());
        this.getCommand("nv").setExecutor(new nightvisionCMD());
        this.getCommand("motd").setExecutor(new motdCMD());
        this.getCommand("enchant").setExecutor(new enchantCMD());
        this.getCommand("clearlag").setExecutor(new clearlagCMD());
        this.getCommand("back").setExecutor(new backCMD());



    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefixConsole +
                        " ____   ____  ___    __    ____  __    ____\n" +
                        "(  _ \\ (_  _)/ __)  /__\\  (  _ \\(  )  ( ___)\n" +
                        " )(_) ) _)(_ \\__ \\ /(__)\\  ) _ < )(__  )__) \n" +
                        "(____/ (____)(___/(__)(__)(____/(____)(____)");
    }



    public void loadConfig() {

        File SB = new File("plugins//Yonplei//ItemSign.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(SB);

        cfg.addDefault("Warns.Warns", 0);

        cfg.addDefault("messages.success", "&aDein Item wurde signiert.");
        cfg.addDefault("messages.ItemSignTrue", "&cDas Item ist bereits signiert.");
        cfg.addDefault("messages.set", "&cBitte nutze: &7/sign <Signierung>");
        cfg.addDefault("messages.noplayer", "&cDieses Command ist nur für Spieler!");
        cfg.addDefault("messages.iteminhand", "&cDu musst ein Item in der Hand haben.");
        cfg.addDefault("messages.unsign", "&aDas Item wurde unsigniert.");
        cfg.addDefault("messages.unsignown", "&cDieses Item wurde nicht von dir signiert.");
        cfg.addDefault("messages.unsignyes", "&cDieses Item ist nicht signiert.");
        cfg.addDefault("signature.lengthmsg", " &cDeine Signierung darf maximal 50 Zeichen lang sein.");
        cfg.addDefault("signature.length", "50");
        cfg.addDefault("signature.lines", "true");
        cfg.addDefault("signature.line", "---------------------------");

        cfg.addDefault("signature.user", "&7Signiert von &6%PLAYER% &7am &e%DATE%");
        cfg.addDefault("Blocked.Message.Sign", "&cDu darfst das Item nicht signieren!");
        cfg.addDefault("Blocked.Message.UnSign", "&cDu darfst das Item nicht unsignieren!");
        cfg.addDefault("Blocked.Items", Arrays.asList("GRASS", "STONE"));
        cfg.options().copyDefaults(true);

        try {
            cfg.save(SB);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
