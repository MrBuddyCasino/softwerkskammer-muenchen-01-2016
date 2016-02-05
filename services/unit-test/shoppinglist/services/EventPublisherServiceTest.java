package shoppinglist.services;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import shoppinglist.MockitoRule;
import shoppinglist.events.Event;
import shoppinglist.events.ItemAddedEvent;
import shoppinglist.model.ItemKey;
import shoppinglist.repository.ShoppingListRepository;

/**
 * Unit tests for {@link EventPublisherService}.
 *
 * @author michaelboeckling
 */
public class EventPublisherServiceTest {

  @Rule
  public final MockitoRule mocks = MockitoRule.forTest(this);

  @Mock
  private ShoppingListRepository shoppingListRepository;

  private EventPublisherService eventPublisherService;

  @Before
  public void setup() {
    eventPublisherService = new EventPublisherService(shoppingListRepository);
  }

  @Test
  public void published_event_is_added_to_repository() {
    Event evt = new ItemAddedEvent(new ItemKey("Audio Technica ATH-M50x", "piece"), 1);
    eventPublisherService.publish(evt);

    verify(shoppingListRepository).addEvent(evt);
  }

}
