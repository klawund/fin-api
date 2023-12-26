package com.klawund.fin.core.query;

import com.klawund.fin.api.query.QueryHandler;
import com.klawund.fin.core.infrastructure.model.EntryModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;

public class GetEntriesByMonthQueryHandler implements QueryHandler<List<GetEntriesByMonthQueryHandler.EntryDto>, GetEntriesByMonthQuery>
{
	private final EntityManager entityManager;

	public GetEntriesByMonthQueryHandler(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public List<EntryDto> handle(GetEntriesByMonthQuery query)
	{
		var cb = entityManager.getCriteriaBuilder();
		var criteria = cb.createQuery(EntryModel.class);
		var root = criteria.from(EntryModel.class);

		var monthPredicate = cb.equal(cb.function("month", Integer.class, root.get("date")), query.month().getValue());
		criteria.where(monthPredicate);

		var result = entityManager.createQuery(criteria).getResultList();

		return result.stream()
			.map(entry -> new EntryDto(
					entry.getId(),
					entry.getMoney().getAmount(),
					entry.getDate()
				)
			)
			.collect(Collectors.toList());
	}

	@Override
	public Class<GetEntriesByMonthQuery> listenTo()
	{
		return GetEntriesByMonthQuery.class;
	}

	public record EntryDto(String id, BigDecimal amount, LocalDate date)
	{
	}
}
