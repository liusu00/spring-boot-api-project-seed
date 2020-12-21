package com.company.project.model;

import javax.persistence.*;

@Table(name = "clc_registration_project_rel")
public class RegistrationProjectRel {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 就诊项目
     */
    @Column(name = "project_id")
    private String projectId;

    /**
     * 预约挂号id
     */
    @Column(name = "registration_id")
    private String registrationId;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取就诊项目
     *
     * @return project_id - 就诊项目
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * 设置就诊项目
     *
     * @param projectId 就诊项目
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取预约挂号id
     *
     * @return registration_id - 预约挂号id
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * 设置预约挂号id
     *
     * @param registrationId 预约挂号id
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }
}