package shoppinglist.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * The shopping list entity.
 *
 * @author michaelboeckling
 */
public class ShoppingList {

	private final Map<ItemKey, NumerableItem> items;

	/**
	 * Creates a new empty shopping list.
	 */
	public ShoppingList() {
		items = new HashMap<>();
	}

	/**
	 * Copy constructor - creates a shallow copy.
	 *
	 * @param other
	 */
	private ShoppingList(ShoppingList other) {
		items = new HashMap<>(other.items);
	}

	/**
	 * Adds an item to the list. If the item is already on the list, its amount
	 * is increased. If the amount is a negative number, subtracts n items of
	 * this from the list. If the number is < 1, the item is removed from the
	 * list.
	 *
	 * @param numItem
	 */
	public void addItem(NumerableItem numItem) {
		items.merge(numItem.getItemKey(), numItem, NumerableItem::merge);
	}

	public NumerableItem lookup(ItemKey key) {
		return items.get(key);
	}

	/**
	 * Replace an item. If the item was neverin the list, nothing happens.
	 *
	 * @param numItem
	 */
	public void replaceItem(NumerableItem numItem) {
		items.replace(numItem.getItemKey(), numItem);
	}

	/**
	 * Clear the list.
	 */
	public void clear() {
		items.clear();
	}

	public Collection<NumerableItem> getAllItems() {
		return items.values();
	}

	/**
	 * Creates a copy of this shopping list.
	 */
	public ShoppingList clone() {
		return new ShoppingList(this);
	}

}
