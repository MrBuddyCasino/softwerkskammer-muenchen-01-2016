package shoppinglist.commands;

import java.util.Queue;

import shoppinglist.model.ShoppingList;

public interface ExecutionEnvironment {

	ShoppingList getShoppingList();

	Queue<Command> getCommandHistory();

}
