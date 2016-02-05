package shoppinglist.events;

import shoppinglist.model.ItemKey;

public class ItemAddedEvent extends Event {

  private static final String EVENT_TYPE = "item-added";

  private final ItemKey key;
  private final int amount;

  public ItemAddedEvent(ItemKey key, int amount) {
    super(EVENT_TYPE);

    this.key = key;
    this.amount = amount;
  }

  public ItemKey getKey() {
    return key;
  }

  public int getAmount() {
    return amount;
  }

}
