package shoppinglist.repository;

import shoppinglist.events.Event;

public interface ShoppingListRepository {

	void addEvent(Event evt);

}
