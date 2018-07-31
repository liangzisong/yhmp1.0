package com.yhmp.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.yhmp.system.dao.UserLogsDao;
import com.yhmp.system.service.UserLogsServer;

public class UserLogsServerImpl implements UserLogsServer {

    @Autowired
    private UserLogsDao userLogsDao;
    
    @Override
    public void addUserLogs() {
        userLogsDao.addUserLogs();

    }

}
