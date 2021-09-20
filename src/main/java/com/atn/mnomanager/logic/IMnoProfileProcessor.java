package com.atn.mnomanager.logic;

import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.models.AgentConfigModel;

import java.util.List;

/**
 * @author blaise irakoze
 */
public interface IMnoProfileProcessor {

    /**
     * Create MnoProfile interface
     *
     * @param mnoProfile
     * @return
     */
    public MnoProfile createMnoProfile(MnoProfile mnoProfile);

    /**
     * Get all MnoProfile interface
     *
     * @return
     */
    public List<MnoProfile> getAllMnoProfile();

    /**
     * Edit MnoProfile interface
     *
     * @param mnoId
     * @param mnoProfile
     * @return
     */
    public MnoProfile editMnoProfile(String mnoId, MnoProfile mnoProfile);

    /**
     * Enable or Disable MnoProfile interface
     *
     * @param mnoId
     * @return
     */
    public MnoProfile enableOrDisableMnoProfile(String mnoId, String status);

    /**
     * Get MnoProfile by id interface
     *
     * @param mnoId
     * @return
     */
    public MnoProfile getMnoProfileById(String mnoId);

    /**
     * Edit MnoProfile agent interface
     *
     * @param agentConfigModel
     * @return
     */
    public MnoProfile addMnoAgentConfig(AgentConfigModel agentConfigModel);

    /**
     * Get MNO agent config by MNO id interface
     * @param mnoId
     * @return
     */
    public AgentConfigModel getMnoAgentConfigByMnoId(String mnoId);
}
