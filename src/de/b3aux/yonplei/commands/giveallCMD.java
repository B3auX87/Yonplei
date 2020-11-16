package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveallCMD implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = ((Player) sender);

        if(p.hasPermission("yonplei.giveall")){

            if(args.length == 0){

                ItemStack itemStack = p.getInventory().getItemInHand();

                if(itemStack.getType() != Material.AIR){

                    p.getInventory().setItemInHand(null);

                    Bukkit.getOnlinePlayers().forEach(players -> {

                        if (players != sender) {

                            players.getInventory().addItem(itemStack);

                            if (itemStack.getItemMeta().getDisplayName() != null) {

                                players.sendMessage(Main.prefix + "§7Alle haben ein Item §e" + itemStack.getItemMeta().getDisplayName() + " §7bekommen.");

                            } else {

                                players.sendMessage(Main.prefix + "§7Alle haben ein Item §e" + itemStack.getType() + " §7bekommen.");

                            }

                        }

                    });

                }else{

                    p.sendMessage(Main.prefix + "§cDu musst ein Item in der Hand halten.");

                }

            }

        }else{

            p.sendMessage(Main.noPerms);

        }

        return false;
    }
}
