package com.craftyn.casinoslots.command;

import org.bukkit.entity.Player;

import com.craftyn.casinoslots.CasinoSlots;
import com.craftyn.casinoslots.classes.SlotMachine;

public class CasinoSetOwner extends AnCommand {

    // Command for setting the owner of a managed slot machine
    public CasinoSetOwner(CasinoSlots plugin, String[] args, Player player) {
        super(plugin, args, player);
    }

    public Boolean process() {
        // Correct command format
        if(args.length == 3) {

            // Slot exists
            if(plugin.getSlotManager().isSlot(args[1])) {
                SlotMachine slot = plugin.getSlotManager().getSlot(args[1]);

                // Can access slot
                if(isOwner(slot)) {
                    String owner = args[2];
                    Player ownerPlayer = plugin.getServer().getPlayer(owner);
                    if (ownerPlayer != null) {
                        slot.setOwner(ownerPlayer.getName(), ownerPlayer.getUniqueId());
                        plugin.getSlotManager().saveSlot(slot);
                        sendMessage(ownerPlayer.getName() + " is now the owner of the " + args[1] + " slot machine.");
                    } else {
                        sendMessage("This player is not online.");
                    }
                }
                // No access
                else {
                    sendMessage("You do not own this slot machine.");
                }
            }

            // Slot does not exist
            else {
                sendMessage("Invalid slot machine.");
            }
        }

        // Incorrect command format
        else {
            sendMessage("Usage:");
            sendMessage("/casino setowner <slotname> <owner>");
        }
        return true;
    }

}