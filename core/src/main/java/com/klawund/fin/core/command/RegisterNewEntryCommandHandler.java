package com.klawund.fin.core.command;

import com.klawund.fin.api.command.CommandHandler;
import com.klawund.fin.api.command.CommandResponse;
import com.klawund.fin.core.domain.model.Entry;
import com.klawund.fin.core.domain.model.EntryId;
import com.klawund.fin.core.domain.model.Money;
import com.klawund.fin.core.domain.repository.EntryRepository;

public class RegisterNewEntryCommandHandler implements CommandHandler<EntryId, RegisterNewEntryCommand>
{
	private final EntryRepository entries;

	public RegisterNewEntryCommandHandler(EntryRepository entries)
	{
		this.entries = entries;
	}

	@Override
	public CommandResponse<EntryId> handle(RegisterNewEntryCommand command)
	{
		// todo implement command bean validation through middleware layer (not implemented)

		var id = new EntryId(command.id());

		var entry = new Entry(
			id,
			new Money(command.amount()),
			command.date()
		);

		entries.add(entry);

		return new CommandResponse<>(id);
	}

	@Override
	public Class<RegisterNewEntryCommand> listenTo()
	{
		return RegisterNewEntryCommand.class;
	}
}
