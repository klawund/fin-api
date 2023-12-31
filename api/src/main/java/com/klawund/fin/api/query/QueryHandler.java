package com.klawund.fin.api.query;

public interface QueryHandler<V, K extends Query<V>>
{
	V handle(K query);

	Class<K> listenTo();
}
