package shoppinglist.services;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;

import shoppinglist.MockitoRule;
import shoppinglist.commands.AddItemCmd;
import shoppinglist.commands.Command;

/**
 * Unit tests for {@link ShoppingListService}.
 *
 * @author michaelboeckling
 */
public class ShoppingListServiceTest {

  @Rule
  public final MockitoRule mocks = MockitoRule.forTest(this);

  @Mock
  private EventPublisherService eventPublisher;

  private CommandExecutorService commandExecutor;

  @Before
  public void setup() {
    commandExecutor = new CommandExecutorService(eventPublisher);
  }

  @Test
  public void command_execution_should_create_corresponding_event() {
    Command cmd = new AddItemCmd("Audio Technica ATH-M50x", 1, "piece");
    commandExecutor.execute(cmd);

    verify(eventPublisher).publish(eq(cmd.toEvent()));
  }

}
