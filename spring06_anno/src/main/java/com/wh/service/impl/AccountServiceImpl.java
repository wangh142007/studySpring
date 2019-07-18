package com.wh.service.impl;

import com.wh.dao.IAccountDao;
import com.wh.dao.impl.AccountDaoImpl;
import com.wh.service.IAccountService;

/**
 * 账户的业务层实现类
 * <bean id="accountService" class="com.wh.service.impl.AccountServiceImpl"
 *      scope = "" init-method = "" destroy_method = "">
 *      <property name = "" value = ""></property>
 * </bean>
 *
 * 对于创建对象的
 *      它们的作用就和在xml配置文件中编写一个<bean>标签实现的功能一样
 * 用于注入数据的
 *      它们的作用就和在xml配置文件中的<bean>标签中写一个<property>标签的作用一样
 * 用于改变作用范围的
 *      它们的作用就和在bean标签中使用scope属性实现的功能一样的
 * 和生命周期的
 *      它们的作用就和在bean标签中使用init-method 和destroy_method的作用一样
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
