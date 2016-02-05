package shoppinglist.commands;

import shoppinglist.events.Event;
import shoppinglist.events.ListClearedEvent;
import shoppinglist.model.NumerableItem;
import shoppinglist.model.ShoppingList;

public class ClearListCmd implements Command {

	private ShoppingList backup;

	public ClearListCmd() {
	}

	@Override
	public void execute(ExecutionEnvironment env) {
		backup = env.getShoppingList();
		env.getShoppingList().clear();
	}

	@Override
	public void undo(ExecutionEnvironment env) {
		for (NumerableItem item : backup.getAllItems()) {
			env.getShoppingList().addItem(item);
		}
	}

	@Override
	public Event toEvent() {
		return new ListClearedEvent();
	}

}
