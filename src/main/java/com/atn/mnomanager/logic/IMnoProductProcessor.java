package com.atn.mnomanager.logic;

import com.atn.mnomanager.entities.MnoProduct;
import com.atn.mnomanager.models.MnoProductModel;
import com.atn.mnomanager.models.SuccessResponse;

public interface IMnoProductProcessor {

    /**
     * Create MnoProduct interface
     *
     * @param mnoProductModel
     * @return
     */
    public MnoProduct createMnoProduct(MnoProductModel mnoProductModel);

    /**
     * Get MnoProduct by MnoProductId interface
     *
     * @param mnoProductId
     * @return
     */
    public MnoProduct getMnoProductByMnoProductId(String mnoProductId);

    /**
     * Remove MnoProduct interface
     *
     * @param mnoProductId
     * @return
     */
    public SuccessResponse removeMnoProduct(String mnoProductId);
}
