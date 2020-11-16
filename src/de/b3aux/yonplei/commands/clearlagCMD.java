package de.b3aux.yonplei.commands;

import de.b3aux.yonplei.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class clearlagCMD implements CommandExecutor {

    private int task;
    private int seconds = 5;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("clearlag")) {

            if (p.hasPermission("yonplei.clearlag")) {

                if (args.length == 0) {

                    this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

                        @Override
                        public void run() {

                            Bukkit.broadcastMessage(Main.prefix + " §3Clearlag §7 in: §5" + seconds + "§7 sekunden.");

                            seconds--;

                            if (seconds == 0) {

                                Bukkit.getScheduler().cancelTask(task);
                                seconds = 5;

                                if (!p.getWorld().getName().equalsIgnoreCase("citybuild")) {

                                    for (Player all : Bukkit.getOnlinePlayers()) {

                                        for (Entity entity : Bukkit.getWorld(p.getWorld().getName()).getEntities()) {

                                            if (entity instanceof Item || entity instanceof Monster || entity instanceof Animals) {

                                                entity.remove();

                                            }
                                        }

                                        all.sendMessage(Main.prefix + "§7Alle am boden liegende §6Items§7, §6Monster §7und §6Tiere §7wurden entfernt.");
                                        all.playSound(all.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10F, 10F);

                                    }
                                }
                            }

                        }
                    }, 0, 20);

                } else {

                    p.sendMessage(Main.noPerms);

                }

            } else {

             p.sendMessage(Main.prefix + "§7Bitte Tippe: §6/clearlag");

            }
        }
        return false;
    }
}
