package com.gekatik.Party;

import java.util.ArrayList;
import java.util.UUID;

public class Team
{
  private UUID leader;
  private ArrayList<UUID> members = new ArrayList();
  private boolean inGame = false;

  public UUID getLeader() {
    return this.leader;
  }

  public ArrayList<UUID> getMembers() {
    return this.members;
  }

  public boolean isInGame() {
    return this.inGame;
  }

  public Team(UUID paramUUID) {
    this.leader = paramUUID;
  }

  public void setInGame(boolean paramBoolean) {
    this.inGame = paramBoolean;
  }

  public void addMember(UUID paramUUID) {
    this.members.add(paramUUID);
  }

  public void removeMember(UUID paramUUID) {
    this.members.remove(paramUUID);
  }
}