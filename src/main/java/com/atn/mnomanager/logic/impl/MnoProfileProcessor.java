package com.atn.mnomanager.logic.impl;

import com.atn.mnomanager.exceptions.HandlerInternalServerErrorException;
import com.atn.mnomanager.exceptions.HandlerNotFoundException;
import com.atn.mnomanager.models.AgentConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.facades.MnoProfileRepository;
import com.atn.mnomanager.logic.IMnoProfileProcessor;

import java.util.List;

/**
 * @author blaise irakoze
 */
@Service
public class MnoProfileProcessor implements IMnoProfileProcessor {

    @Autowired
    private MnoProfileRepository mnoProfileRepository;

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
            throw new HandlerInternalServerErrorException("Internal server error");
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
            throw new HandlerInternalServerErrorException("Internal server error");
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
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(mnoId)) {
                throw new HandlerNotFoundException("MNO not found");
            }
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), mnoProfile.getName(), mnoProfile.getEmail(), mnoProfile.getTelephone(), mnoProfile.getAgentConfig(), mnoProfile.getCreationTime(), mnoProfile.getStatus()));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
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
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(mnoId)) {
                throw new HandlerNotFoundException("MNO not found");
            }
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), foundMnoProfile.getAgentConfig(), foundMnoProfile.getCreationTime(), status));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
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
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(mnoId)) {
                throw new HandlerNotFoundException("MNO not found");
            }
            return foundMnoProfile;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
        }
    }

    /**
     * Edit MnoProfile agent processor
     *
     * @param agentConfigModel
     * @return
     */
    @Override
    public MnoProfile addMnoAgentConfig(AgentConfigModel agentConfigModel) {
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(agentConfigModel.getMnoId()).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(agentConfigModel.getMnoId())) {
                throw new HandlerNotFoundException("MNO not found");
            }
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), agentConfigModel.getAgentConfig(), foundMnoProfile.getCreationTime(), foundMnoProfile.getStatus()));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
        }
    }

    /**
     * Get MNO agent config by MNO id interface
     *
     * @param mnoId
     * @return
     */
    @Override
    public AgentConfigModel getMnoAgentConfigByMnoId(String mnoId) {
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(mnoId)) {
                throw new HandlerNotFoundException("MNO not found");
            }
            return new AgentConfigModel(foundMnoProfile.getId(), foundMnoProfile.getAgentConfig());
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
        }
    }
}
