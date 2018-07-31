package com.yhmp.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yhmp.project.dao.PreservationProjecDao;
import com.yhmp.project.entity.PorjectDeclare;
import com.yhmp.project.entity.PreservationProjectVO;
import com.yhmp.project.service.PreservationProjecServer;
@Service
public class PreservationProjecServerImpl implements PreservationProjecServer {

    @Autowired
    private PreservationProjecDao allPreservationProjecDao;
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T selectPreservationProject(PreservationProjectVO preservationProjectVO) {
        //informationDAO.selectProjectInformation();
        System.out.println("porjectDeclare="+preservationProjectVO);
        List<PreservationProjectVO> list = allPreservationProjecDao.selectPreservationProject(preservationProjectVO);
        System.out.println("===============");
        System.out.println("list.size()="+list.size());
        list.forEach(i -> System.out.println(i));
        switch (list.size()) {
        //单个项目信息
//        case 1:
//            System.out.println("查询出一条");
//            System.out.println("list.get(0)="+list.get(0));
//            return (T) list.get(0);
        //多个项目信息
        default:
            System.out.println("查询出多条");
            return (T) list;
        }
    }

}
