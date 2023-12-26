package com.klawund.fin.core.infrastructure.model;

import java.math.BigDecimal;
import javax.persistence.Embeddable;

@Embeddable
public class MoneyModel
{
	private BigDecimal amount;

	public MoneyModel()
	{
	}

	public MoneyModel(BigDecimal amount)
	{
		this.amount = amount;
	}

	public BigDecimal getAmount()
	{
		return amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
}
