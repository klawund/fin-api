package com.klawund.fin.api.query;

public interface QueryBus
{
	<T> T dispatch(Query<T> query);
}
