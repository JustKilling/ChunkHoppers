package me.justkilling.chunkhoppers.Commands;

import me.justkilling.chunkhoppers.Items.ChunkHopper;
import me.justkilling.chunkhoppers.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.justkilling.chunkhoppers.Items.ChunkHopper.hopperLocations;

public class ChunkHopperGive implements CommandExecutor {
public static Player player;


    Main plugin;

    public ChunkHopperGive(Main plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("chunkhopper").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {



        player = (Player) sender;

        if(sender instanceof Player){
            if(args.length == 0){
            player.sendMessage(ChatColor.RED + "Please use the correct format!\n/chunkhopper give\n/chunkhopper showlocations");
            }else if(args[0].equalsIgnoreCase("give")){
                player.getInventory().addItem(ChunkHopper.ChunkHopper());
                player.sendMessage(ChatColor.GREEN + "There you go!");
            }else if(args[0].equalsIgnoreCase("showlocations")){
                Bukkit.broadcastMessage("Current chunkhoppers are placed on: ");
                for(Location hopperlocations: hopperLocations){
                    sender.sendMessage(hopperlocations.getBlockX() + " "+ hopperlocations.getBlockY() + " "+ hopperlocations.getBlockZ());


                }
            } else{
                sender.sendMessage("wrong command bitch");
            }
        }else{
            sender.sendMessage(ChatColor.RED + "Only players may execute this command!");
        }






        return true;

    }
}
