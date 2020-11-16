package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class signCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

        File file = new File("plugins//Yonplei//ItemSign.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Player p = (Player)sender;

        String signset = cfg.getString("messages.set").replace("&", "§");
        String getIteminHand = cfg.getString("messages.iteminhand").replace("&", "§");
        String timeStamp = (new SimpleDateFormat("dd.MM.yyyy")).format(Calendar.getInstance().getTime());
        String lines = cfg.getString("signature.lines").replace("&", "§");
        String liness = cfg.getString("signature.line").replace("&", "§");
        String ItemSignTrue = cfg.getString("messages.ItemSignTrue").replace("&", "§");
        String sign = cfg.getString("signature.user").replace("&", "§");
        String blockedmsg = cfg.getString("Blocked.Message.Sign").replace("&", "§");

        sign = sign.replace("%PLAYER%", p.getName());
        sign = sign.replace("%DISPLAYNAME%", p.getDisplayName());
        sign = sign.replace("%DATE%", timeStamp);

        if (p.hasPermission("yonplei.signature")) {

            if (args.length == 0) {

                p.sendMessage(Main.prefix + signset);
                return true;

            }

            if (p.getInventory().getItemInHand().getType().equals(Material.AIR)) {

                sender.sendMessage(Main.prefix + getIteminHand);
                return true;
            }

            for (String items : cfg.getStringList("Blocked.Items")) {

                if (p.getInventory().getItemInHand().getType() == Material.matchMaterial(items)) {

                    sender.sendMessage(Main.prefix + blockedmsg);
                    return true;

                }
            }

            if (p.getInventory().getItemInHand().getAmount() > 1) {

                sender.sendMessage(Main.prefix + "§cDu darfst nur ein Item gleichzeitig signieren.");
                return true;
            }

            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < args.length; i++) {

                if (i == args.length - 1) {

                    builder.append(args[i]);

                } else {

                    builder.append(args[i]).append(" ");

                }
            }

            String msg = ChatColor.translateAlternateColorCodes('&', builder.toString());
            String success = cfg.getString("messages.success").replace("&", "§");

            ItemStack item = p.getItemInHand();
            ItemMeta meta = item.getItemMeta();

            List<String> lore = meta.getLore();

            if (lore == null) {

                lore = new ArrayList<String>();

            } else {

                p.sendMessage(Main.prefix + ItemSignTrue);
                return true;

            }

            lore.add("");
            lore.add(msg);

            if (lines.equalsIgnoreCase("true")) {

                lore.add(liness);
                lore.add(sign);
                lore.add(liness);

            } else {

                lore.add(sign);

            }

            meta.setLore(lore);
            item.setItemMeta(meta);

            p.sendMessage(Main.prefix + success);

        } else {

            p.sendMessage(Main.noPerms);
        }

        return false;
    }
}
