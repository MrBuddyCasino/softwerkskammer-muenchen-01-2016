package shoppinglist.commands;

import shoppinglist.events.Event;
import shoppinglist.events.ItemAddedEvent;
import shoppinglist.model.ItemKey;
import shoppinglist.model.NumerableItem;

/**
 * Adds an item to the shopping list.
 *
 * @author michaelboeckling
 */
public class AddItemCmd implements Command {

  private final ItemKey key;
  private final int amount;

  public AddItemCmd(String name, int amount, String unitKey) {
    this.key = new ItemKey(name, unitKey);
    this.amount = amount;
  }

  @Override
  public void execute(ExecutionEnvironment env) {
    env.getShoppingList().addItem(new NumerableItem(key, amount, false));
  }

  @Override
  public void undo(ExecutionEnvironment env) {
    env.getShoppingList().addItem(new NumerableItem(key, amount * -1, false));
  }

  @Override
  public Event toEvent() {
    return new ItemAddedEvent(key, amount);
  }

}
