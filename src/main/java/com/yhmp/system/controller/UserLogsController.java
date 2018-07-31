package com.yhmp.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yhmp.system.entity.UserLogs;
import com.yhmp.system.service.UserLogsServer;

@Controller
public class UserLogsController {

    
    @RequestMapping("/userLog")
    public void logs(UserLogs userLogs) {
        System.out.println("UserLogsController.logs()");
        System.out.println(userLogs.getUserId());
        System.out.println(userLogs.getUserName());
    }
}
