package com.atn.mnomanager.logic.impl;

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
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
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
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).get();
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), mnoProfile.getName(), mnoProfile.getEmail(), mnoProfile.getTelephone(), mnoProfile.getAgentConfig(), mnoProfile.getCreationTime(), mnoProfile.getStatus()));
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).get();
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), foundMnoProfile.getAgentConfig(), foundMnoProfile.getCreationTime(), status));
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            return mnoProfileRepository.findById(mnoId).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
