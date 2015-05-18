package com.springapp.mvc.command;


import com.springapp.mvc.dto.TicketDto;

public interface ITicketCommand {

	public void execute(TicketDto ticketDto);
	
}
