package biz.galaxygroup.atn.mno.logic.impl;

import biz.galaxygroup.atn.mno.entities.Account;
import biz.galaxygroup.atn.mno.entities.MnoAccount;
import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.exceptions.HandlerNotFoundException;
import biz.galaxygroup.atn.mno.facades.AccountRepository;
import biz.galaxygroup.atn.mno.facades.MnoAccountRepository;
import biz.galaxygroup.atn.mno.facades.MnoProfileRepository;
import biz.galaxygroup.atn.mno.models.MnoAccountModel;
import biz.galaxygroup.atn.mno.models.SuccessResponse;
import biz.galaxygroup.atn.mno.logic.IMnoAccountProcessor;
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
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoAccountModel.getMnoProfileId()).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        Account foundAccount = accountRepository.findById(mnoAccountModel.getAccountId()).orElse(new Account());
        if (foundAccount.getId() == null) {
            throw new HandlerNotFoundException("Account not found");
        }
        try {
            return mnoAccountRepository.save(new MnoAccount(mnoAccountModel.getIsNormalAccount(), foundMnoProfile, foundAccount));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
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
        MnoAccount foundMnoAccount = mnoAccountRepository.findById(id).orElse(new MnoAccount());
        if (foundMnoAccount.getId() == null) {
            throw new HandlerNotFoundException("MnoAccount not found");
        }
        try {
            return foundMnoAccount;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
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
        MnoAccount foundMnoAccount = mnoAccountRepository.findById(id).orElse(new MnoAccount());
        if (foundMnoAccount.getId() == null) {
            throw new HandlerNotFoundException("MnoAccount not found");
        }
        try {
            mnoAccountRepository.deleteById(id);
            return new SuccessResponse("mno account well removed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }
}
