package com.klawund.fin.core.infrastructure.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EntryModel
{
	@Id
	@Column(nullable = false, unique = true)
	private String id;

	@Embedded
	private MoneyModel money;

	private LocalDate date;

	public EntryModel()
	{
	}

	public EntryModel(String id, MoneyModel money, LocalDate date)
	{
		this.id = id;
		this.money = money;
		this.date = date;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public MoneyModel getMoney()
	{
		return money;
	}

	public void setMoney(MoneyModel money)
	{
		this.money = money;
	}

	public LocalDate getDate()
	{
		return date;
	}

	public void setDate(LocalDate date)
	{
		this.date = date;
	}
}
