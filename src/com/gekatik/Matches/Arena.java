package com.gekatik.Matches;


import java.util.ArrayList;
import java.util.UUID;
import com.gekatik.Gametypes.KitType;
import org.bukkit.Location;

public class Arena
{
  private Location loc1;
  private Location loc2;
  private int id;
  private ArrayList<UUID> players = new ArrayList();
  private boolean inUse = false;
  private KitType t;

  public Arena(int paramInt, Location paramLocation1, Location paramLocation2, KitType paramKitType)
  {
    this.id = paramInt;
    this.loc1 = paramLocation1;
    this.loc2 = paramLocation2;
    this.t = paramKitType;
  }
  public void setLoc1(Location paramLocation) {
    this.loc1 = paramLocation;
  }
  public void setLoc2(Location paramLocation) { this.loc2 = paramLocation; }

  public Location getLoc1() {
    return this.loc1;
  }

  public Location getLoc2() {
    return this.loc2;
  }

  public int getId() {
    return this.id;
  }

  public ArrayList<UUID> getPlayers() {
    return this.players;
  }

  public boolean isInUse() {
    return this.inUse;
  }

  public void setInUse(boolean paramBoolean) {
    this.inUse = paramBoolean;
  }

  public KitType getKitType() {
    return this.t;
  }
}