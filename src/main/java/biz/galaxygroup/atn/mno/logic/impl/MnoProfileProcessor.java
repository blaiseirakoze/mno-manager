package biz.galaxygroup.atn.mno.logic.impl;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.exceptions.HandlerNotFoundException;
import biz.galaxygroup.atn.mno.facades.FilterProcessor;
import biz.galaxygroup.atn.mno.facades.MnoProfileRepository;
import biz.galaxygroup.atn.mno.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    private FilterProcessor filterProcessor;

    @Autowired
    private biz.galaxygroup.atn.mno.facades.impl.FilterProcessor filterProcessor2;

    /**
     * Create MnoProfile processor
     *
     * @param mnoProfile
     * @return
     */
    @Override
    public SuccessResponseModel createMnoProfile(List<MnoProfile> mnoProfile) {
        try {
            for (MnoProfile mnoPro : mnoProfile) {
                mnoProfileRepository.save(mnoPro);
            }
            return new SuccessResponseModel(HttpStatus.CREATED.toString(), "Mno profile successfully created");
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
    public SuccessResponseModel editMnoProfile(String mnoId, MnoProfile mnoProfile) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), mnoProfile.getName(), mnoProfile.getEmail(), mnoProfile.getTelephone(), mnoProfile.getAgentConfig(), mnoProfile.getCreationTime(), mnoProfile.getStatus()));
            return new SuccessResponseModel(HttpStatus.CREATED.toString(), "Mno profile successfully updated");
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
    public SuccessResponseModel enableOrDisableMnoProfile(String mnoId, String status) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), foundMnoProfile.getAgentConfig(), foundMnoProfile.getCreationTime(), status));
            return new SuccessResponseModel(HttpStatus.CREATED.toString(), "Mno profile successfully status changed");
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
    public SuccessResponseModel addMnoAgentConfig(AgentConfigModel agentConfigModel) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(agentConfigModel.getMnoId()).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), agentConfigModel.getAgentConfig(), foundMnoProfile.getCreationTime(), foundMnoProfile.getStatus()));
            return new SuccessResponseModel(HttpStatus.CREATED.toString(), "Mno agent successfully added");
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
    @Override
    public MnoProfile removeMnoAgentConfig(String mnoId) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoId).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        try {
            return mnoProfileRepository.save(new MnoProfile(foundMnoProfile.getId(), foundMnoProfile.getName(), foundMnoProfile.getEmail(), foundMnoProfile.getTelephone(), "", foundMnoProfile.getCreationTime(), foundMnoProfile.getStatus()));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

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
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public GetResponseModel getMnoByFilterParams(String pageNumber, String pageSize, String searchBy, String startDate, String endDate) {
        try {
            List<Object> list = filterProcessor.filterTransfer(pageNumber, pageSize, searchBy, startDate, endDate, "MnoProfile");
            GetResponseModel getResponseModel;
            int totalItems = mnoProfileRepository.countMnoProfile();
            if (pageNumber == null) {
                getResponseModel = new GetResponseModel(totalItems, list);
            } else {
                getResponseModel = new GetResponseModel(totalItems, Integer.valueOf(pageNumber), list);
            }
            return getResponseModel;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }
}
