package com.yhmp.project.entity;

import java.io.Serializable;

public class ProjectSummary implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5388433222573129043L;

    /** 主键id */
    private Integer pk_id; 

    /** project表id，外键 */
    private Integer fk_project_id; 
    /** 评审会意见摘要 */
    private String reviewSuggestion;
    /** 项目技术总结*/
    private String technicalSummary;
    /** 经验与教训 */
    private String experience;
    /** 其他 */
    private String otherSummary;
    public Integer getPk_id() {
        return pk_id;
    }
    public void setPk_id(Integer pk_id) {
        this.pk_id = pk_id;
    }
    public Integer getFk_project_id() {
        return fk_project_id;
    }
    public void setFk_project_id(Integer fk_project_id) {
        this.fk_project_id = fk_project_id;
    }
    public String getReviewSuggestion() {
        return reviewSuggestion;
    }
    public void setReviewSuggestion(String reviewSuggestion) {
        this.reviewSuggestion = reviewSuggestion;
    }
    public String getTechnicalSummary() {
        return technicalSummary;
    }
    public void setTechnicalSummary(String technicalSummary) {
        this.technicalSummary = technicalSummary;
    }
    public String getExperience() {
        return experience;
    }
    public void setExperience(String experience) {
        this.experience = experience;
    }
    public String getOtherSummary() {
        return otherSummary;
    }
    public void setOtherSummary(String otherSummary) {
        this.otherSummary = otherSummary;
    }
    @Override
    public String toString() {
        return "ProjectSummary [pk_id=" + pk_id + ", fk_project_id=" + fk_project_id + ", reviewSuggestion="
                + reviewSuggestion + ", technicalSummary=" + technicalSummary + ", experience=" + experience
                + ", otherSummary=" + otherSummary + "]";
    }
    
}
