package shoppinglist.events;

import shoppinglist.model.ItemKey;

public class ItemStrickenEvent extends Event {

  private static final String EVENT_TYPE = "item-stricken";

  private final ItemKey key;

  public ItemStrickenEvent(ItemKey key) {
    super(EVENT_TYPE);
    this.key = key;
  }

  public ItemKey getKey() {
    return key;
  }

}
