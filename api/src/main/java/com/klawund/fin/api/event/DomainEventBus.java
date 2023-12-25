package com.klawund.fin.api.event;

public interface DomainEventBus
{
	void dispatch(DomainEvent event);
}
