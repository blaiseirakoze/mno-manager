package biz.galaxygroup.atn.mno.models;

public class AgentConfigModel {
    private String mnoId;
    private String agentConfig;

    public AgentConfigModel() {
    }

    public AgentConfigModel(String mnoId, String agentConfig) {
        this.mnoId = mnoId;
        this.agentConfig = agentConfig;
    }

    public String getMnoId() {
        return mnoId;
    }

    public void setMnoId(String mnoId) {
        this.mnoId = mnoId;
    }

    public String getAgentConfig() {
        return agentConfig;
    }

    public void setAgentConfig(String agentConfig) {
        this.agentConfig = agentConfig;
    }

    @Override
    public String toString() {
        return "AgentConfigModel{" +
                "mnoId='" + mnoId + '\'' +
                ", agentConfig='" + agentConfig + '\'' +
                '}';
    }
}
