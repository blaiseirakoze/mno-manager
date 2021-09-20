package com.atn.mnomanager.logic.impl;

import com.atn.mnomanager.entities.*;
import com.atn.mnomanager.exceptions.HandlerInternalServerErrorException;
import com.atn.mnomanager.exceptions.HandlerNotFoundException;
import com.atn.mnomanager.facades.*;
import com.atn.mnomanager.logic.IMnoAccountProcessor;
import com.atn.mnomanager.models.MnoAccountModel;
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
    private AccountRepository accountRepository;

    /**
     * Create MnoAccount processor
     *
     * @param mnoAccountModel
     * @return
     */
    @Override
    public MnoAccount createMnoAccount(MnoAccountModel mnoAccountModel) {
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoAccountModel.getMnoProfileId()).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(mnoAccountModel.getMnoProfileId())) {
                throw new HandlerNotFoundException("MNO not found");
            }
            Account foundAccount = accountRepository.findById(mnoAccountModel.getAccountId()).orElse(new Account());
            if (!foundAccount.getId().equals(mnoAccountModel.getAccountId())) {
                throw new HandlerNotFoundException("Account not found");
            }
            return mnoAccountRepository.save(new MnoAccount(mnoAccountModel.getIsNormalAccount(), foundMnoProfile, foundAccount));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
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
            MnoAccount foundMnoAccount = mnoAccountRepository.findById(id).orElse(new MnoAccount());
            if (!foundMnoAccount.getId().equals(id)) {
                throw new HandlerNotFoundException("MnoAccount not found");
            }
            return foundMnoAccount;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
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
            MnoAccount foundMnoAccount = mnoAccountRepository.findById(id).orElse(new MnoAccount());
            if (!foundMnoAccount.getId().equals(id)) {
                throw new HandlerNotFoundException("MnoAccount not found");
            }
            mnoAccountRepository.deleteById(id);
            return new SuccessResponse("mno account well removed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
        }
    }
}
