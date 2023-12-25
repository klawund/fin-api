package com.klawund.fin.api.command;

public interface CommandBus
{
	<T> CommandResponse<T> dispatch(Command<T> command);
}
