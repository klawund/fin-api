package com.klawund.fin.api.command;

public interface CommandHandler<V, K extends Command<V>>
{
	CommandResponse<V> handle(K command);

	Class<K> listenTo();
}
