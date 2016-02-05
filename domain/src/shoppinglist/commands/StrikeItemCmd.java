package shoppinglist.commands;

import shoppinglist.events.Event;
import shoppinglist.events.ItemStrickenEvent;
import shoppinglist.model.ItemKey;
import shoppinglist.model.NumerableItem;

public class StrikeItemCmd implements Command {

	private final ItemKey key;

	public StrikeItemCmd(String name, String unitKey) {
		key = new ItemKey(name, unitKey);
	}

	@Override
	public void execute(ExecutionEnvironment env) {
		NumerableItem item = env.getShoppingList().lookup(key);
		env.getShoppingList().replaceItem(item.strike());
	}

	@Override
	public void undo(ExecutionEnvironment env) {
		NumerableItem item = env.getShoppingList().lookup(key);
		env.getShoppingList().replaceItem(item.unStrike());
	}

	@Override
	public Event toEvent() {
		return new ItemStrickenEvent(key);
	}

}
