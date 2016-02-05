package shoppinglist.repository;

import java.util.ArrayList;
import java.util.List;

import shoppinglist.events.Event;

public class InMemoryShoppingListRepository implements ShoppingListRepository {

	private List<Event> events = new ArrayList<>();

	public void addEvent(Event evt) {
		events.add(evt);
	}

}
