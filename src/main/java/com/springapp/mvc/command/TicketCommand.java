package com.springapp.mvc.command;

import com.springapp.mvc.dao.TicketDao;
import com.springapp.mvc.dto.TicketDto;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class TicketCommand implements ITicketCommand {

	private TicketDao ticketDao;
	private TransactionTemplate transactionTemplate2;
	
	public void setTransactionTemplate2(TransactionTemplate transactionTemplate2) {
		this.transactionTemplate2 = transactionTemplate2;
	}
	
	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public TicketDao getTicketDao() {
		
		return ticketDao;
	}
	
	@Override
	public void execute(final TicketDto ticketDto) {
		transactionTemplate2.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				ticketDto.setAmount("1");
				ticketDao.buyTicket(ticketDto);
				
				ticketDto.setAmount("4");
				ticketDao.buyTicket(ticketDto);
			}
		});
		
	}

}
