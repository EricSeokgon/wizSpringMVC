package com.springapp.mvc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

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


}

