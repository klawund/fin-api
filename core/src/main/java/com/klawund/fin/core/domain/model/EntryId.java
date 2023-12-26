package com.klawund.fin.core.domain.model;

import java.util.UUID;

public class EntryId
{
	private final String id;

	public EntryId(String id)
	{
		this.id = id;
	}

	public EntryId()
	{
		this(UUID.randomUUID().toString());
	}

	public String getId()
	{
		return id;
	}

	@Override
	public String toString()
	{
		return id;
	}
}
