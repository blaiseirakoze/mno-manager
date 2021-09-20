package com.atn.mnomanager.logic.impl;

import com.atn.mnomanager.entities.*;
import com.atn.mnomanager.facades.*;
import com.atn.mnomanager.logic.IMnoAccountProcessor;
import com.atn.mnomanager.logic.IMnoProductProcessor;
import com.atn.mnomanager.models.MnoAccountModel;
import com.atn.mnomanager.models.MnoProductModel;
import com.atn.mnomanager.models.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author blaise irakoze
 */
@Service
public class MnoAccountProcessor implements IMnoAccountProcessor {

    @Autowired
    private MnoAccountRepository mnoAccountRepository;

    @Autowired
    private MnoProfileRepository mnoProfileRepository;

    @Autowired
    private AccountRepository accoutRepository;

    /**
     * Create MnoAccount processor
     *
     * @param mnoAccountModel
     * @return
     */
    @Override
    public MnoAccount createMnoAccount(MnoAccountModel mnoAccountModel) {
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoAccountModel.getMnoProfileId()).get();
            Account foundAccount = accoutRepository.findById(mnoAccountModel.getAccountId()).get();
            return mnoAccountRepository.save(new MnoAccount(mnoAccountModel.getIsNormalAccount(), foundMnoProfile, foundAccount));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get MnoAccount processor
     *
     * @param id
     * @return
     */
    @Override
    public MnoAccount getAccountById(String id) {
        try {
            return mnoAccountRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Remove MnoAccount processor
     *
     * @param id
     * @return
     */
    @Override
    public SuccessResponse removeMnoAccount(String id) {
        try {
            mnoAccountRepository.deleteById(id);
            return new SuccessResponse("mno account well removed");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
