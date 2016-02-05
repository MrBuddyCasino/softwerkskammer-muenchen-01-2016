package shoppinglist.events;

/**
 * Base class for Events. Provides default implementations of {@link #hashCode()} and
 * {@link #equals(Object)} based on {@link #eventType}.
 *
 * @author michaelboeckling
 */
public abstract class Event {

  /**
   * A string representing the type of the event.
   */
  private final String eventType;

  /**
   *
   * @param evtType
   */
  Event(String evtType) {
    this.eventType = evtType;
  }

  /**
   * Hashes based on {@link #eventType}.
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((eventType == null) ? 0 : eventType.hashCode());
    return result;
  }

  /**
   * Considers two instances equal if their {@link #eventType} is the same.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Event other = (Event) obj;
    if (eventType == null) {
      if (other.eventType != null)
        return false;
    } else if (!eventType.equals(other.eventType))
      return false;
    return true;
  }

}
