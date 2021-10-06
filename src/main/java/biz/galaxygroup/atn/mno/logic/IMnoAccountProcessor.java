package biz.galaxygroup.atn.mno.logic;

import biz.galaxygroup.atn.mno.entities.MnoAccount;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoAccountModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;

import java.util.List;

public interface IMnoAccountProcessor {

    /**
     * Create accoumt interface
     *
     * @param mnoAccountModel
     * @return
     */
    public SuccessResponseModel createMnoAccount(List<MnoAccountModel> mnoAccountModel);

    /**
     * Get MnaAccount by id interface
     *
     * @param id
     * @return
     */
    public MnoAccount getAccountById(String id);

    /**
     * Remove MnoAccount interface
     *
     * @param id
     * @return
     */
    public SuccessResponseModel removeMnoAccount(String id);

    /**
     * Get MnoAccountByFilterParams interface
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     */
    public GetResponseModel getMnoAccountByFilterParams(String pageNumber, String pageSize, String searchBy, String startDate, String endDate);
}
