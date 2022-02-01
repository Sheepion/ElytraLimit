package com.sheepion.elytralimit.command;

import com.sheepion.elytralimit.ElytraLimit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("elytralimit.reload")) {
            return false;
        }
        if (args.length > 0) {
            if ("reload".equals(args[0])) {
                ElytraLimit.reload();
                return true;
            }
        }

        return false;
    }
}
