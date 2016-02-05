package shoppinglist.model;

import java.util.Map;

/**
 * An item and its amount in a shopping list.
 *
 * @author michaelboeckling
 */
public class NumerableItem {

	private final ItemKey itemKey;
	private final int amount;
	private final boolean stricken;

	public NumerableItem(ItemKey item, int amount, boolean stricken) {
		this.itemKey = item;
		this.amount = amount;
		this.stricken = stricken;
	}

	public String getName() {
		return itemKey.getName();
	}

	public String getUnitKey() {
		return itemKey.getUnitKey();
	}

	public ItemKey getItemKey() {
		return itemKey;
	}

	public int getAmount() {
		return amount;
	}

	public boolean isStricken() {
		return stricken;
	}

	/**
	 * Merge these two {@link NumerableItem} instances by adding their amounts.
	 * For the general contract, look at
	 * {@link Map#merge(Object, Object, java.util.function.BiFunction)}.
	 *
	 * @param nItem
	 * @return
	 * @throws IllegalArgumentException
	 *             if the items are not of the same kind
	 */
	public NumerableItem merge(NumerableItem nItem) {

		if (!getItemKey().equals(nItem.getItemKey())) {
			throw new IllegalArgumentException(this + " is incompatible with " + nItem);
		}

		int newAmount = getAmount() + nItem.getAmount();
		if (newAmount > 0) {
			return new NumerableItem(getItemKey(), newAmount, nItem.isStricken());
		} else {
			return null;
		}
	}

	public NumerableItem strike() {
		if (isStricken()) {
			return this;
		}

		return new NumerableItem(itemKey, amount, true);
	}

	public NumerableItem unStrike() {
		if (!isStricken()) {
			return this;
		}

		return new NumerableItem(itemKey, amount, false);
	}

}
