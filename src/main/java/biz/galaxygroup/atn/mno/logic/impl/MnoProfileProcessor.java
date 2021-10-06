package biz.galaxygroup.atn.mno.logic.impl;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.exceptions.HandlerNotFoundException;
import biz.galaxygroup.atn.mno.facades.MnoProfileRepository;
import biz.galaxygroup.atn.mno.facades.MnoFilterProcessor;
import biz.galaxygroup.atn.mno.models.AgentConfigModel;
import biz.galaxygroup.atn.mno.models.MnoFilterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import biz.galaxygroup.atn.mno.logic.IMnoProfileProcessor;

import java.util.List;

/**
 * @author blaise irakoze
 */
@Service
public class MnoProfileProcessor implements IMnoProfileProcessor {

    @Autowired
    private MnoProfileRepository mnoProfileRepository;

    @Autowired
    private MnoFilterProcessor filterProcessor;

    /**
     * Create MnoProfile processor
     *
     * @param mnoProfile
     * @return
     */
    @Override
    public MnoProfile createMnoProfile(MnoProfile mnoProfile) {
        try {
            return mnoProfileRepository.save(mnoProfile);
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Get all MnoProfile processor
     *
     * @return
     */
    @Override
    public List<MnoProfile> getAllMnoProfile() {
        try {
            return mnoProfileRepository.findAll();
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Edit MnoProfile processor
     *
     * @param mnoId
     * @param mnoProfile
     * @return
     */
    @Override
    public MnoProfile editMnoProfile(String mnoId, MnoProfile mnoProfile) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), mnoProfile.getName(), mnoProfile.getEmail(), mnoProfile.getTelephone(), mnoProfile.getAgentConfig(), mnoProfile.getCreationTime(), mnoProfile.getStatus()));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Enable or Disable MnoProfile processor
     *
     * @param mnoId
     * @return
     */
    @Override
    public MnoProfile enableOrDisableMnoProfile(String mnoId, String status) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), foundMnoProfile.getAgentConfig(), foundMnoProfile.getCreationTime(), status));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Get MnoProfile by id processor
     *
     * @param mnoId
     * @return
     */
    @Override
    public MnoProfile getMnoProfileById(String mnoId) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            return foundMnoProfile;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Add MnoProfile agent processor
     *
     * @param agentConfigModel
     * @return
     */
    @Override
    public MnoProfile addMnoAgentConfig(AgentConfigModel agentConfigModel) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(agentConfigModel.getMnoId()).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), agentConfigModel.getAgentConfig(), foundMnoProfile.getCreationTime(), foundMnoProfile.getStatus()));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Remove MnoProfile agent processor
     *
     * @param mnoId
     * @return
     */

//    @Override
//    public MnoProfile removeMnoAgentConfig(String mnoId) {
//        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
//        if (foundMnoProfile.getId() == null) {
//            throw new HandlerNotFoundException("MNO not found");
//        }
//        try {
//            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), "", foundMnoProfile.getCreationTime(), foundMnoProfile.getStatus()));
//        } catch (Exception e) {
//            throw new HandlerInternalServerErrorException("Error occurs");
//        }
//    }

    /**
     * Get MNO agent config by MNO id processor
     *
     * @param mnoId
     * @return
     */
    @Override
    public AgentConfigModel getMnoAgentConfigByMnoId(String mnoId) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            return new AgentConfigModel(foundMnoProfile.getId(), foundMnoProfile.getAgentConfig());
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Get MnoByFilterParams processors
     *
     * @param mnoFilterModel
     * @return
     */
    @Override
    public List<MnoProfile> getMnoByFilterParams(MnoFilterModel mnoFilterModel) {
        try {
            List<MnoProfile> foundMnoProfile = filterProcessor.filterTransfer(mnoFilterModel);
            return foundMnoProfile;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }
}
