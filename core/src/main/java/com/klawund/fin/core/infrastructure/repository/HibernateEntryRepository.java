package com.klawund.fin.core.infrastructure.repository;

import com.klawund.fin.core.domain.model.Entry;
import com.klawund.fin.core.domain.repository.EntryRepository;
import com.klawund.fin.core.infrastructure.model.EntryModel;
import com.klawund.fin.core.infrastructure.model.MoneyModel;
import javax.persistence.EntityManager;

public class HibernateEntryRepository implements EntryRepository
{
	private final EntityManager entityManager;

	public HibernateEntryRepository(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public void add(Entry entry)
	{
		var model = new EntryModel(
			entry.getId().toString(),
			new MoneyModel(
				entry.getValue().getAmount()
			),
			entry.getDate()
		);

		entityManager.persist(model);
	}
}
