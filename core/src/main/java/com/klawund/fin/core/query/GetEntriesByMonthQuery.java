package com.klawund.fin.core.query;

import com.klawund.fin.api.query.Query;
import java.time.Month;
import java.util.List;
import javax.validation.constraints.NotNull;

public record GetEntriesByMonthQuery(@NotNull Month month) implements Query<List<GetEntriesByMonthQueryHandler.EntryDto>>
{
}
