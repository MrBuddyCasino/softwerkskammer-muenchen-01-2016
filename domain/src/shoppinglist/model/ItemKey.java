package shoppinglist.model;

/**
 * An item in a shopping list.
 *
 * @author michaelboeckling
 */
public final class ItemKey {

	private final String name;

	private final String unitKey;

	public ItemKey(String name, String unitKey) {
		this.name = name;
		this.unitKey = unitKey;
	}

	public String getName() {
		return name;
	}

	public String getUnitKey() {
		return unitKey;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", unitKey=" + unitKey + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((unitKey == null) ? 0 : unitKey.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemKey other = (ItemKey) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (unitKey == null) {
			if (other.unitKey != null)
				return false;
		} else if (!unitKey.equals(other.unitKey))
			return false;
		return true;
	}

}
