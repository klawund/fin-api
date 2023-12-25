package com.klawund.fin.api.event;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class MapDomainEventBus implements DomainEventBus
{
	private final Map<Class<DomainEvent>, List<Supplier<DomainEventHandler>>> handlers;

	public MapDomainEventBus(Map<Class<DomainEvent>, List<Supplier<DomainEventHandler>>> handlers)
	{
		this.handlers = handlers;
	}

	@Override
	public void dispatch(DomainEvent event)
	{
		handlers.getOrDefault(event, Collections.emptyList())
			.forEach(handler -> handler.get().handle(event));
	}
}
