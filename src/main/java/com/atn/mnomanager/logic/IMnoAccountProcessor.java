package com.atn.mnomanager.logic;

import com.atn.mnomanager.entities.MnoAccount;
import com.atn.mnomanager.models.MnoAccountModel;
import com.atn.mnomanager.models.SuccessResponse;

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
