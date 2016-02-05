package shoppinglist.commands;

import shoppinglist.events.Event;

public interface Command {

  void execute(ExecutionEnvironment env);

  void undo(ExecutionEnvironment env);

  Event toEvent();

}
