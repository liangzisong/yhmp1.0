package com.yhmp.project.entity;

import java.io.Serializable;
import java.util.Arrays;
/**
 * 项目计划实体类
 * @author liang
 *
 */
public class ProjectPlan implements Serializable {

	private static final long serialVersionUID = -6849897108068531382L;
	private Integer pk_id;
	/** 外键id */
	private Integer fk_project_id;
	/**	项目名称	*/
	private String declareProject;
	/**	负责人姓名	*/
	private String responsibilityName;
	/** 项目阶段计划 */
	private String periodicPlan;
	/** 各阶段 */
	private Integer projectPlan;
	/** 计划进度 */
	private Integer planSchedule;
	/** 计划内容 */
	private String projectContent;
	/** 完成时间 */
	private String finishTime;
	/** 项目成员 */
	private String personLiable;
	/** 调整工期 */
	private String timeAdjustment;
	
	
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
	public String getDeclareProject() {
		return declareProject;
	}
	public void setDeclareProject(String declareProject) {
		this.declareProject = declareProject;
	}
	public String getResponsibilityName() {
		return responsibilityName;
	}
	public void setResponsibilityName(String responsibilityName) {
		this.responsibilityName = responsibilityName;
	}
	public String getPeriodicPlan() {
		return periodicPlan;
	}
	public void setPeriodicPlan(String periodicPlan) {
		this.periodicPlan = periodicPlan;
	}
	
	public Integer getProjectPlan() {
		return projectPlan;
	}
	public void setProjectPlan(Integer projectPlan) {
		this.projectPlan = projectPlan;
	}
	public Integer getPlanSchedule() {
		return planSchedule;
	}
	public void setPlanSchedule(Integer planSchedule) {
		this.planSchedule = planSchedule;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getPersonLiable() {
		return personLiable;
	}
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	
	public String getTimeAdjustment() {
		return timeAdjustment;
	}
	public void setTimeAdjustment(String timeAdjustment) {
		this.timeAdjustment = timeAdjustment;
	}
    @Override
    public String toString() {
        return "ProjectPlan [pk_id=" + pk_id + ", fk_project_id=" + fk_project_id + ", declareProject=" + declareProject
                + ", responsibilityName=" + responsibilityName + ", periodicPlan=" + periodicPlan + ", projectPlan="
                + projectPlan + ", planSchedule=" + planSchedule + ", projectContent=" + projectContent
                + ", finishTime=" + finishTime + ", personLiable=" + personLiable + ", timeAdjustment=" + timeAdjustment
                + "]";
    }
	
	
}
