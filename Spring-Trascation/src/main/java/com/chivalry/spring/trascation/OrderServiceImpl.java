package com.chivalry.spring.trascation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author Mr.zxb
 * @date 2020-08-16 20:18:20
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insert(String id) {

    }
}
