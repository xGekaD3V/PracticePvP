package com.gekatik.Matches;

import java.util.UUID;
import com.gekatik.Gametypes.KitType;
public class Request
{
  private UUID sender;
  private UUID to;
  private KitType k;

  public Request(KitType paramKitType, UUID paramUUID1, UUID paramUUID2)
  {
    this.k = paramKitType;
    this.sender = paramUUID1;
    this.to = paramUUID2;
  }

  public KitType getK() {
    return this.k;
  }

  public void setK(KitType paramKitType) {
    this.k = paramKitType;
  }

  public UUID getSender() {
    return this.sender;
  }

  public void setSender(UUID paramUUID) {
    this.sender = paramUUID;
  }

  public UUID getTo() {
    return this.to;
  }

  public void setTo(UUID paramUUID) {
    this.to = paramUUID;
  }
}