package biz.galaxygroup.atn.mno.models;

public class MnoFilterModel {
    private String name;
    private String email;
    private String telephone;
    private String agentConfig;
    private String creationTime;
    private String status;

    public MnoFilterModel() {
    }

    public MnoFilterModel(String name, String email, String telephone, String agentConfig, String creationTime, String status) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.agentConfig = agentConfig;
        this.creationTime = creationTime;
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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
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
                ", creationTime='" + creationTime + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
