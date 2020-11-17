package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class enchantCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (sender instanceof ConsoleCommandSender) {

            System.out.println("Dieser Command ist nur für Spieler.");
            return true;

        }

        if (p.hasPermission("yonplei.enchant"))  {

            if (args.length <= 1) {

                p.sendMessage(Main.use + "/enchant name level");

            } else if (args.length == 2) {

                try {

                    ItemStack itemStack = p.getItemInHand();
                    int elvl = Integer.parseInt(args[1]);
                    String ename = args[0];

                    if (ename.equalsIgnoreCase("sharpness")) {

                        itemStack.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, elvl);

                    } else if (ename.equalsIgnoreCase("knockback")) {

                        itemStack.addUnsafeEnchantment(Enchantment.KNOCKBACK, elvl);

                    } else if (ename.equalsIgnoreCase("respiration")) {

                        itemStack.addUnsafeEnchantment(Enchantment.OXYGEN, elvl);

                    } else if (ename.equalsIgnoreCase("water")) {

                        itemStack.addUnsafeEnchantment(Enchantment.WATER_WORKER, elvl);

                    } else if (ename.equalsIgnoreCase("silktouch")) {

                        itemStack.addUnsafeEnchantment(Enchantment.SILK_TOUCH, elvl);

                    } else if (ename.equalsIgnoreCase("thorns")) {

                        itemStack.addUnsafeEnchantment(Enchantment.THORNS, elvl);

                    } else if (ename.equalsIgnoreCase("frost")) {

                        itemStack.addUnsafeEnchantment(Enchantment.FROST_WALKER, elvl);

                    } else if (ename.equalsIgnoreCase("blastprotection")) {

                        itemStack.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, elvl);

                    } else if (ename.equalsIgnoreCase("fireprotection")) {

                        itemStack.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, elvl);

                    } else if (ename.equalsIgnoreCase("fallprotection")) {

                        itemStack.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, elvl);

                    } else if (ename.equalsIgnoreCase("projectileprotection")) {

                        itemStack.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, elvl);

                    } else if (ename.equalsIgnoreCase("fireaspect")) {

                        itemStack.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, elvl);

                    } else if (ename.equalsIgnoreCase("arrowfire")) {

                        itemStack.addUnsafeEnchantment(Enchantment.ARROW_FIRE, elvl);

                    } else if (ename.equalsIgnoreCase("arrowdamage")) {

                        itemStack.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, elvl);

                    } else if (ename.equalsIgnoreCase("arrowknockback")) {

                        itemStack.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, elvl);

                    } else if (ename.equalsIgnoreCase("unbreaking")) {

                        itemStack.addUnsafeEnchantment(Enchantment.DURABILITY, elvl);

                    } else if (ename.equalsIgnoreCase("looting")) {

                        itemStack.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, elvl);

                    } else if (ename.equalsIgnoreCase("repair")) {

                        itemStack.addUnsafeEnchantment(Enchantment.MENDING, elvl);

                    } else if (ename.equalsIgnoreCase("protection")) {

                        itemStack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, elvl);

                    } else if (ename.equalsIgnoreCase("loyality")) {

                        itemStack.addUnsafeEnchantment(Enchantment.LOYALTY, elvl);

                    } else if (ename.equalsIgnoreCase("infinity")) {

                        itemStack.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, elvl);

                    } else if (ename.equalsIgnoreCase("efficiency")) {

                        itemStack.addUnsafeEnchantment(Enchantment.DIG_SPEED, elvl);


                    }else {

                        p.sendMessage(Main.prefix + "§cUnbekanntes Enchantment.");
                        return true;

                    }

                    p.sendMessage(Main.prefix + "§7Du hast dein Item mit §3" + ename + "§7 lvl §3" + elvl + " §7aufgewertet.");

                } catch (NumberFormatException e) {

                    p.sendMessage(Main.use + "/enchant name level");

                }

            } else {

                p.sendMessage(Main.use + "/enchant name level");

            }

        } else {

            p.sendMessage(Main.noPerms);

        }

        return true;
    }
}
