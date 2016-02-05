package shoppinglist.services;

import javax.inject.Inject;

import shoppinglist.events.Event;
import shoppinglist.repository.ShoppingListRepository;

/**
 * This service accepts {@link Event}s, saves them in a repository
 * and notifies listeners.
 *
 * @author michaelboeckling
 */
public class EventPublisherService {

	private final ShoppingListRepository shoppingListRepository;

	@Inject
	EventPublisherService(ShoppingListRepository repo) {
	    this.shoppingListRepository = repo;
	}

	public void publish(Event evt) {
		shoppingListRepository.addEvent(evt);

		// TODO: notify listeners
	}

}
