package biz.galaxygroup.atn.mno.logic;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.models.AgentConfigModel;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoFilterModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;

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
    public SuccessResponseModel createMnoProfile(List<MnoProfile> mnoProfile);

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
    public SuccessResponseModel editMnoProfile(String mnoId, MnoProfile mnoProfile);

    /**
     * Enable or Disable MnoProfile interface
     *
     * @param mnoId
     * @return
     */
    public SuccessResponseModel enableOrDisableMnoProfile(String mnoId, String status);

    /**
     * Get MnoProfile by id interface
     *
     * @param mnoId
     * @return
     */
    public MnoProfile getMnoProfileById(String mnoId);

    /**
     * Add MnoProfile agent interface
     *
     * @param agentConfigModel
     * @return
     */
    public SuccessResponseModel addMnoAgentConfig(AgentConfigModel agentConfigModel);

    /**
     * Remove MnoProfile agent interface
     *
     * @param mnoId
     * @return
     */
    public MnoProfile removeMnoAgentConfig(String mnoId);

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
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     */
    public GetResponseModel getMnoByFilterParams(String pageNumber, String pageSize, String searchBy, String startDate, String endDate);
}
