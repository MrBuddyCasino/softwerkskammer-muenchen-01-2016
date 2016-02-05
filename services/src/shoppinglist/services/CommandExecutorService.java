package shoppinglist.services;

import java.util.Queue;
import java.util.Stack;

import javax.inject.Inject;

import com.google.common.collect.EvictingQueue;

import shoppinglist.commands.Command;
import shoppinglist.commands.ExecutionEnvironment;
import shoppinglist.commands.UndoCmd;
import shoppinglist.model.ShoppingList;

/**
 * Executes commands, handling un-do's and event publishing.
 *
 * @author michaelboeckling
 */
public class CommandExecutorService implements ExecutionEnvironment {

  /** to support re-do */
  private final Stack<Command> undoStack = new Stack<Command>();

  /** a bounded fifo queue */
  private final Queue<Command> commandHistory = EvictingQueue.create(10);

  private final ShoppingList shoppingList = new ShoppingList();

  private final EventPublisherService eventPublisher;

  @Inject
  CommandExecutorService(EventPublisherService eventPublisher) {
      this.eventPublisher = eventPublisher;
  }

  /**
   *
   * @param cmd
   */
  public void execute(Command cmd) {
    cmd.execute(this);

    if (!(cmd instanceof UndoCmd)) {
      commandHistory.add(cmd);
    }

    eventPublisher.publish(cmd.toEvent());
  }

  @Override
  public ShoppingList getShoppingList() {
    return shoppingList;
  }

  @Override
  public Queue<Command> getCommandHistory() {
    return commandHistory;
  }

}
