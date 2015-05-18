package com.springapp.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.springapp.mvc.dto.TicketDto;

/**
 * Project: wizSpringMVC
 * FileName: TicketDao
 * Date: 2015-05-17
 * Time: 오전 4:59
 * Author: hadeslee
 * Note:
 * To change this template use File | Settings | File Templates.
 */
public class TicketDao {

    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public TicketDao() {
        System.out.println(template);
    }

    public void buyTicket(final TicketDto dto) {
        System.out.println("buyTicket()");
        System.out.println("dto.getConsumerId() : " + dto.getConsumerId());
        System.out.println("dto.getAmount() : " + dto.getAmount());

        template.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                String query = "insert into card (consumerId, amount) values (?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, dto.getConsumerId());
                pstmt.setString(2, dto.getAmount());

                return pstmt;
            }
        });

        template.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                String query = "insert into ticket (consumerId, countnum) values (?, ?)";
                PreparedStatement pstmt = con.prepareStatement(query);
                pstmt.setString(1, dto.getConsumerId());
                pstmt.setString(2, dto.getAmount());

                return pstmt;
            }
        });
    }


}
