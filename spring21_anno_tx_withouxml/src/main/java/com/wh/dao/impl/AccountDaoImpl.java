package com.wh.dao.impl;

import com.wh.dao.IAccountDao;
import com.wh.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl  implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Account findAccountById(Integer id) {
        List<Account> query = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
        return query.isEmpty() ? null : query.get(0);
    }

    public Account findAccountByName(String name) {
        List<Account> query = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (query.size() > 1) {
            throw new RuntimeException("结果不唯一");
        }
        if (query.size() == 0) {
            return null;
        }
        return query.get(0);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name =?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
    }
}
