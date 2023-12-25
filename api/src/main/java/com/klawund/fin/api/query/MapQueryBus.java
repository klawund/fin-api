package com.klawund.fin.api.query;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public class MapQueryBus implements QueryBus
{
	private final Map<Class<Query>, Supplier<QueryHandler>> handlers;

	public MapQueryBus(Map<Class<Query>, Supplier<QueryHandler>> handlers)
	{
		this.handlers = handlers;
	}

	@Override
	public <T> T dispatch(Query<T> query)
	{
		var handler = Optional.ofNullable(handlers.get(query.getClass()))
			.orElseThrow(IllegalStateException::new)
			.get();

		return (T) handler.handle(query);
	}
}
