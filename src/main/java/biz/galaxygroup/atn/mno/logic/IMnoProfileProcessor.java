package biz.galaxygroup.atn.mno.logic;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.models.AgentConfigModel;
import biz.galaxygroup.atn.mno.models.MnoFilterModel;

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
     *
     * @param mnoId
     * @return
     */
    public AgentConfigModel getMnoAgentConfigByMnoId(String mnoId);

    /**
     * Get MnoByFilterParams interface
     *
     * @param name
     * @param email
     * @param telephone
     * @param agentConfig
     * @param creationTime
     * @param status
     * @return
     */
    public List<MnoProfile> getMnoByFilterParams(MnoFilterModel mnoFilterModel);
}
