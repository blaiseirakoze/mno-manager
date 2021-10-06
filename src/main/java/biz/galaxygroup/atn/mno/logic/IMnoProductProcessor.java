package biz.galaxygroup.atn.mno.logic;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.models.MnoProductModel;
import biz.galaxygroup.atn.mno.models.ProductFilterModel;
import biz.galaxygroup.atn.mno.models.SuccessResponse;

import java.util.List;

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

    /**
     * Get ProductByFilterParams interface
     *
     * @param productFilterModel
     * @return
     */
    public List<MnoProduct> getProductByFilterParams(ProductFilterModel productFilterModel);
}
