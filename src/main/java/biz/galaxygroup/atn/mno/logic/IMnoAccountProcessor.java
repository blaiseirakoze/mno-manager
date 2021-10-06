package biz.galaxygroup.atn.mno.logic;

import biz.galaxygroup.atn.mno.entities.MnoAccount;
import biz.galaxygroup.atn.mno.models.MnoAccountModel;
import biz.galaxygroup.atn.mno.models.SuccessResponse;

public interface IMnoAccountProcessor {

    /**
     * Create accoumt interface
     *
     * @param mnoAccountModel
     * @return
     */
    public MnoAccount createMnoAccount(MnoAccountModel mnoAccountModel);

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
    public SuccessResponse removeMnoAccount(String id);
}
