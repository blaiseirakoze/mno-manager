package biz.galaxygroup.atn.mno.models;

import java.util.Date;

public class MnoFilterModel {
    private String name;
    private String email;
    private String telephone;
    private String agentConfig;
    private Date startDate;
    private Date endDate;
    private String status;

    public MnoFilterModel() {
    }

    public MnoFilterModel(String name, String email, String telephone, String agentConfig, String status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.status = status;
    }

    public MnoFilterModel(String name, String email, String telephone, String agentConfig, Date startDate, Date endDate, String status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public MnoFilterModel(String name, String email, String telephone, String agentConfig, Date startDate, String status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.startDate = startDate;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAgentConfig() {
        return agentConfig;
    }

    public void setAgentConfig(String agentConfig) {
        this.agentConfig = agentConfig;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MnoFilterModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", agentConfig='" + agentConfig + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status='" + status + '\'' +
                '}';
    }
}
