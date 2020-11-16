package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.List;

public class unsignCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {

        File file = new File("plugins//Yonplei//ItemSign.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        Player p = (Player)sender;

        String unsign = cfg.getString("messages.unsign").replace("&", "§");
        String unsignown = cfg.getString("messages.unsignown").replace("&", "§");
        String unsignyes = cfg.getString("messages.unsignyes").replace("&", "§");
        String getIteminHand = cfg.getString("messages.iteminhand").replace("&", "§");
        String lines = cfg.getString("signature.lines").replace("&", "§");
        String blockedmsg = cfg.getString("Blocked.Message.UnSign").replace("&", "§");

        if (p.hasPermission("yonplei.signature")) {

            if (!p.getItemInHand().getItemMeta().hasLore()) {

                p.sendMessage(Main.prefix + unsignyes);
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

            if (args.length >= 0) {

                if (p.getItemInHand().getItemMeta().hasLore()) {

                    ItemStack item = p.getItemInHand();
                    ItemMeta itemMeta = item.getItemMeta();
                    List<String> lore = itemMeta.getLore();

                    if (lines.equalsIgnoreCase("true")) {

                        if (lore != null) {

                            if (lore.get(0).contains(p.getName()) || lore.get(1).contains(p.getName()) || lore.get(2).contains(p.getName()) || lore.get(3).contains(p.getName()) || lore.get(4).contains(p.getName()) || p.hasPermission("use.signature.bypass")) {

                                for (int i = 0; i < 5; i++) {

                                    lore.remove(lore.size() - 1);

                                }

                                p.sendMessage(Main.prefix + unsign);

                            } else {

                                p.sendMessage(Main.prefix + unsignown);
                            }

                        } else {

                            p.sendMessage(Main.prefix + "§7Das Item ist §cnicht §7Signiert");

                        }


                    } else if (lore.get(0).contains(p.getName()) || lore.get(1).contains(p.getName()) || lore.get(2).contains(p.getName()) || p.hasPermission("use.signature.bypass")) {

                        for (int i = 0; i < 3; i++) {

                            lore.remove(lore.size() - 1);

                        }

                        p.sendMessage(Main.prefix + unsign);

                    } else {

                        p.sendMessage(Main.prefix + unsignown);

                    }


                    itemMeta.setLore(lore);
                    item.setItemMeta(itemMeta);

                } else {

                    p.sendMessage(Main.noPerms);

                }
            }
        }

        return false;

    }
}
