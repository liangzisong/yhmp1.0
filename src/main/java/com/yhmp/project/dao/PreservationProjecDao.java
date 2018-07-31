package com.yhmp.project.dao;

import java.util.List;

import com.yhmp.project.entity.PreservationProjectVO;

public interface PreservationProjecDao {

    List<PreservationProjectVO> selectPreservationProject (PreservationProjectVO preservationProjectVO);
}
