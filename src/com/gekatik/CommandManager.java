package com.gekatik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import com.gekatik.Subcommands.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager
  implements CommandExecutor
{
  private ArrayList<Subcommand> commands = new ArrayList();

  public CommandManager(PracticePvP paramPracticePvP) {
    paramPracticePvP.getCommand("party").setExecutor(this);
  }

  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString)
  {
    if (!(paramCommandSender instanceof Player))
    {
      paramCommandSender.sendMessage(ChatColor.RED + "You are not a player!");

      return true;
    }

    Player localPlayer = (Player)paramCommandSender;

    if (paramCommand.getName().equalsIgnoreCase("party"))
    {
      if (paramArrayOfString.length == 0)
      {
          Iterator<Subcommand> localObject1;
        for (localObject1 = this.commands.iterator(); ((Iterator)localObject1).hasNext(); ) { Subcommand localObject2 = (Subcommand)((Iterator)localObject1).next();

          localPlayer.sendMessage(PracticePvP.prefix + " " + ChatColor.GREEN + ((Subcommand)localObject2).getName());
        }

        return true;
      }

      Object localObject1 = get(paramArrayOfString[0]);

      if (localObject1 == null)
      {
        localPlayer.sendMessage(PracticePvP.prefix + ChatColor.RED + paramArrayOfString[0] + " is not a Runnable Command!");

        return true;
      }

      Object localObject2 = new ArrayList();

      ((ArrayList)localObject2).addAll(Arrays.asList(paramArrayOfString));

      ((ArrayList)localObject2).remove(localObject2);

      paramArrayOfString = (String[])((ArrayList)localObject2).toArray(new String[((ArrayList)localObject2).size()]);
      try
      {
        ((Subcommand)localObject1).onCommand(localPlayer, paramArrayOfString);
      }
      catch (Exception localException)
      {
        localPlayer.sendMessage(PracticePvP.prefix + ChatColor.YELLOW + "An error has occurred while running this command! " + localException.getCause());

        localException.printStackTrace();
      }

    }

    return true;
  }

  private String aliases(Subcommand paramSubcommand)
  {
    String str1 = "";

    for (String str2 : paramSubcommand.getAliases())
    {
      str1 = str1 + str2 + " | ";
    }

    return str1.substring(0, str1.lastIndexOf("| "));
  }

  private Subcommand get(String paramString)
  {
    for (Subcommand localSubcommand : this.commands)
    {
      if (localSubcommand.getName().equalsIgnoreCase(paramString)) return localSubcommand;

      for (String str : localSubcommand.getAliases()) if (paramString.equalsIgnoreCase(str)) return localSubcommand;

    }

    return null;
  }
}