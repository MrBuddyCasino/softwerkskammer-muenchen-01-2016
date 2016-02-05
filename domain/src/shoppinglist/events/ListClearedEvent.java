package shoppinglist.events;

public class ListClearedEvent extends Event {

  private static final String EVENT_TYPE = "list-cleared";

  public ListClearedEvent() {
    super(EVENT_TYPE);
  }

}
