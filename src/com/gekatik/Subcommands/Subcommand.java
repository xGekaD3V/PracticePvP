package com.gekatik.Subcommands;


import org.bukkit.entity.Player;

public abstract class Subcommand
{
  public abstract void onCommand(Player paramPlayer, String[] paramArrayOfString);

  public abstract String getName();

  public abstract String getInfo();

  public abstract String[] getAliases();
}