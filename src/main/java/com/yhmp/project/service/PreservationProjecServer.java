package com.yhmp.project.service;

import com.yhmp.project.entity.PreservationProjectVO;

public interface PreservationProjecServer {

    <T> T selectPreservationProject (PreservationProjectVO preservationProjectVO);
}
