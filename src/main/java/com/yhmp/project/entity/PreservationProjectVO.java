package com.yhmp.project.entity;

import java.io.Serializable;

public class PreservationProjectVO implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 6129904761378031227L;
    /** 项目主键 */
    private Integer pk_id;
    /** 项目名称 */
    private String declareProject;
    /** 项目编号 */
    private String declareNumber;
    /** 项目规模 */
    private String declareScale;
    /** 项目归档时间 */
    private String preservation_date;
    /** 备注 */
    private String remarks;
    /** 成果资料 */
    private String achievement_type;
    /** 合同签订情况 */
    private Integer contract;
    /** 项目负责人 */
    private String responsibilityName;
    public Integer getPk_id() {
        return pk_id;
    }
    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }
    public String getDeclareProject() {
        return declareProject;
    }
    public void setDeclareProject(String declareProject) {
        this.declareProject = declareProject;
    }
    public String getDeclareNumber() {
        return declareNumber;
    }
    public void setDeclareNumber(String declareNumber) {
        this.declareNumber = declareNumber;
    }
    public String getDeclareScale() {
        return declareScale;
    }
    public void setDeclareScale(String declareScale) {
        this.declareScale = declareScale;
    }
    public String getPreservation_date() {
        return preservation_date;
    }
    public void setPreservation_date(String preservation_date) {
        this.preservation_date = preservation_date;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getAchievement_type() {
        return achievement_type;
    }
    public void setAchievement_type(String achievement_type) {
        this.achievement_type = achievement_type;
    }
    
    public Integer getContract() {
        return contract;
    }
    public void setContract(Integer contract) {
        this.contract = contract;
    }
    public String getResponsibilityName() {
        return responsibilityName;
    }
    public void setResponsibilityName(String responsibilityName) {
        this.responsibilityName = responsibilityName;
    }
    @Override
    public String toString() {
        return "PreservationProjectVO [pk_id=" + pk_id + ", declareProject=" + declareProject + ", declareNumber="
                + declareNumber + ", declareScale=" + declareScale + ", preservation_date=" + preservation_date
                + ", remarks=" + remarks + ", achievement_type=" + achievement_type + ", contract=" + contract + "]";
    }
    
}
