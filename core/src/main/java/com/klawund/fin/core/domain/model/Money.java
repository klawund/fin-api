package com.klawund.fin.core.domain.model;

import java.math.BigDecimal;

public class Money
{
	private final BigDecimal amount;

	public Money(BigDecimal amount)
	{
		this.amount = amount;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}
}
