package com.database.bpo.pojo.vo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * project
 * @author
 */
@Data
@Mapper
public class ProjectInList implements Serializable {
    public Integer projectId;

    public String userEmployerName;

    public String equipmentName;

    public String projectType;

    public Integer projectAdminId;

    public String projectName;

    public String skillsRequirement;

    public String projectRequirement;

    public String projectPeriod;

    public String projectBudget;

    public String projectStatus;

    public String connectTel;

    public String connectName;

    public static final long serialVersionUID = 1L;
}
