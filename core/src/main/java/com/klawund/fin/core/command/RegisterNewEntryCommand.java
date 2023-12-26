package com.klawund.fin.core.command;

import com.klawund.fin.api.command.Command;
import com.klawund.fin.core.domain.model.EntryId;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public record RegisterNewEntryCommand(@NotEmpty String id, @NotNull BigDecimal amount, @NotNull LocalDate date) implements Command<EntryId>
{
}
