package com.klawund.fin.core.domain.model;

import java.time.LocalDate;

public class Entry
{
	private final EntryId id;
	private final Money value;
	private final LocalDate date;

	public Entry(EntryId id, Money value, LocalDate date)
	{
		this.id = id;
		this.value = value;
		this.date = date;
	}

	public EntryId getId()
	{
		return id;
	}

	public Money getValue()
	{
		return value;
	}

	public LocalDate getDate()
	{
		return date;
	}
}
