package biz.galaxygroup.atn.mno.logic.impl;

import biz.galaxygroup.atn.mno.entities.*;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.exceptions.HandlerNotFoundException;
import biz.galaxygroup.atn.mno.facades.AccountRepository;
import biz.galaxygroup.atn.mno.facades.MnoAccountRepository;
import biz.galaxygroup.atn.mno.facades.MnoProfileRepository;
import biz.galaxygroup.atn.mno.facades.FilterProcessor;
import biz.galaxygroup.atn.mno.models.*;
import biz.galaxygroup.atn.mno.logic.IMnoAccountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Autowired
    private FilterProcessor filterProcessor;

    /**
     * Create MnoAccount processor
     *
     * @param mnoAccountModel
     * @return
     */
    @Override
    public SuccessResponseModel createMnoAccount(List<MnoAccountModel> mnoAccountModel) {
        List<MnoProfile> foundMnoProfileList = new ArrayList<>();
        List<Account> foundAccountList = new ArrayList<>();
        int i = 0;
        MnoProfile foundMnoProfile = new MnoProfile();
        Account foundAccount = new Account();
        for (MnoAccountModel mnoAccount : mnoAccountModel) {
            foundMnoProfile = mnoProfileRepository.findById(mnoAccount.getMnoProfileId()).orElse(new MnoProfile());
            if (foundMnoProfile.getId() == null) {
                throw new HandlerNotFoundException("MNO with " + mnoAccount.getMnoProfileId() + " not found");
            } else {
                foundMnoProfileList.add(foundMnoProfile);
            }
            foundAccount = accountRepository.findById(mnoAccount.getAccountId()).orElse(new Account());
            if (foundAccount.getId() == null) {
                throw new HandlerNotFoundException("Account with " + mnoAccount.getAccountId() + " not found");
            } else {
                foundAccountList.add(foundAccount);
            }
        }
        try {

            for (MnoAccountModel mnoAccount : mnoAccountModel) {
                mnoAccountRepository.save(new MnoAccount(mnoAccount.getIsNormalAccount(), foundMnoProfileList.get(i), foundAccountList.get(i)));
                i++;
            }
            return new SuccessResponseModel(HttpStatus.CREATED.toString(), "Mno account successfully created");
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
    public SuccessResponseModel removeMnoAccount(String id) {
        MnoAccount foundMnoAccount = mnoAccountRepository.findById(id).orElse(new MnoAccount());
        if (foundMnoAccount.getId() == null) {
            throw new HandlerNotFoundException("MnoAccount not found");
        }
        try {
            mnoAccountRepository.deleteById(id);
            return new SuccessResponseModel(HttpStatus.NO_CONTENT.toString(), "Mno account successfully removed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Get MnoAccountByFilterParams processor
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public GetResponseModel getMnoAccountByFilterParams(String pageNumber, String pageSize, String searchBy, String startDate, String endDate) {
        try {
            List<Object> list = filterProcessor.filterTransfer(pageNumber, pageSize, searchBy, startDate, endDate, "MnoAccount");
            GetResponseModel getResponseModel;
            if (pageNumber == null) {
                getResponseModel = new GetResponseModel(list.size(), list);
            } else {
                getResponseModel = new GetResponseModel(list.size(), Integer.valueOf(pageNumber), list);
            }
            return getResponseModel;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }
}
