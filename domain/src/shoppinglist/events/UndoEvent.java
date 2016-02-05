package shoppinglist.events;

public class UndoEvent extends Event {

  private static final String EVENT_TYPE = "undo";

  public UndoEvent() {
    super(EVENT_TYPE);
  }

}
