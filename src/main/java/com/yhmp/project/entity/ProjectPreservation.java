package com.yhmp.project.entity;

import java.io.Serializable;

/**
 * 
 * 项目归档类
 * @author Liang
 *
 */
public class ProjectPreservation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7517009062297834909L;

    /** 主键id */
    private Integer id; 

    /** project表id，外键 */
    private Integer projectId; 

    /** 项目名称 */
    private String projectName; 

    /** 项目搜集资料 */
    private String collectData; 

    /** 外业调查资料 */
    private String fieldWork; 

    /** 项目评审资料 */
    private String reviewData; 

    /** 项目搜集资料_上传文件字段 */
    private String collectDataFile; 

    /** 外业调查资料_上传文件字段 */
    private String fieldWorkFile; 

    /** 项目评审资料_上传文件字段 */
    private String reviewDataFile; 

    /** 项目成果资料 */
    private String achievementType; 

    /** 
     * 项目是否审核：
     *  0为未审核，
     *  1为已审核 
     * */
    private Integer ifAuditing; 

    /** 
     * 项目协议书：
     * 0为未具备，
     * 1未已具备 
     * */
    private Integer projectAgreement; 

    /** 协议书编号 */
    private String projectNumber; 

    /** 其他资料 */
    private String otherData; 
    
    /** 其他资料_上传字段 */
    private String otherDataFile;
    
    /** 归档日期 */
    private String preservationDate;
    
    /** 接受人 */
    private String sendee;

    /** 备注 */
    private String remarks;
    
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCollectData() {
        return collectData;
    }

    public void setCollectData(String collectData) {
        this.collectData = collectData;
    }

    public String getFieldWork() {
        return fieldWork;
    }

    public void setFieldWork(String fieldWork) {
        this.fieldWork = fieldWork;
    }

    public String getReviewData() {
        return reviewData;
    }

    public void setReviewData(String reviewData) {
        this.reviewData = reviewData;
    }

    public String getCollectDataFile() {
        return collectDataFile;
    }

    public void setCollectDataFile(String collectDataFile) {
        this.collectDataFile = collectDataFile;
    }

    public String getFieldWorkFile() {
        return fieldWorkFile;
    }

    public void setFieldWorkFile(String fieldWorkFile) {
        this.fieldWorkFile = fieldWorkFile;
    }

    public String getReviewDataFile() {
        return reviewDataFile;
    }

    public void setReviewDataFile(String reviewDataFile) {
        this.reviewDataFile = reviewDataFile;
    }

    public String getAchievementType() {
        return achievementType;
    }

    public void setAchievementType(String achievementType) {
        this.achievementType = achievementType;
    }

    public Integer getIfAuditing() {
        return ifAuditing;
    }

    public void setIfAuditing(Integer ifAuditing) {
        this.ifAuditing = ifAuditing;
    }

    public Integer getProjectAgreement() {
        return projectAgreement;
    }

    public void setProjectAgreement(Integer projectAgreement) {
        this.projectAgreement = projectAgreement;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getOtherData() {
        return otherData;
    }

    public void setOtherData(String otherData) {
        this.otherData = otherData;
    }

    public String getOtherDataFile() {
        return otherDataFile;
    }

    public void setOtherDataFile(String otherDataFile) {
        this.otherDataFile = otherDataFile;
    }

    public String getPreservationDate() {
        return preservationDate;
    }

    public void setPreservationDate(String preservationDate) {
        this.preservationDate = preservationDate;
    }

    public String getSendee() {
        return sendee;
    }

    public void setSendee(String sendee) {
        this.sendee = sendee;
    }

    @Override
    public String toString() {
        return "ProjectPreservation [id=" + id + ", projectId=" + projectId + ", projectName=" + projectName
                + ", collectData=" + collectData + ", fieldWork=" + fieldWork + ", reviewData=" + reviewData
                + ", collectDataFile=" + collectDataFile + ", fieldWorkFile=" + fieldWorkFile + ", reviewDataFile="
                + reviewDataFile + ", achievementType=" + achievementType + ", ifAuditing=" + ifAuditing
                + ", projectAgreement=" + projectAgreement + ", projectNumber=" + projectNumber + ", otherData="
                + otherData + ", otherDataFile=" + otherDataFile + ", preservationDate=" + preservationDate
                + ", sendee=" + sendee + ", remarks=" + remarks + "]";
    }


    
    
}
