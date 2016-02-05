package shoppinglist.commands;

import shoppinglist.events.Event;
import shoppinglist.events.UndoEvent;

public class UndoCmd implements Command {

	private Command lastCmd;

	/**
	 *
	 * @param cmdStack
	 */
	public UndoCmd() {
	}

	/**
	 * Undoes the previous command.
	 */
	@Override
	public void execute(ExecutionEnvironment env) {
		lastCmd = env.getCommandHistory().remove();
		lastCmd.undo(env);
	}

	/**
	 * An Undo-Undo, so its really a "redo". Executes the previously popped
	 * command and pushes it back onto the stack.
	 */
	@Override
	public void undo(ExecutionEnvironment env) {

		if (lastCmd == null) {
			throw new IllegalStateException("must execute() first");
		}

		lastCmd.execute(env);
		env.getCommandHistory().add(lastCmd);
	}

	@Override
	public Event toEvent() {
		return new UndoEvent();
	}

}
