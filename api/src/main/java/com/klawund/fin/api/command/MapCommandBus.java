package com.klawund.fin.api.command;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MapCommandBus implements CommandBus
{
	private final Map<Class<Command>, Supplier<CommandHandler>> handlers;

	public MapCommandBus(Map<Class<Command>, Supplier<CommandHandler>> handlers)
	{
		this.handlers = handlers;
	}

	@Override
	public <T> CommandResponse<T> dispatch(Command<T> command)
	{
		var handler = Optional.ofNullable(handlers.get(command.getClass()))
			.orElseThrow(IllegalStateException::new)
			.get();

		return handler.handle(command);
	}
}
