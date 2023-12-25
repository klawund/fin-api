package com.klawund.fin.api.event;

public interface DomainEventHandler<K extends DomainEvent>
{
	void handle(K event);

	Class<K> listenTo();
}
