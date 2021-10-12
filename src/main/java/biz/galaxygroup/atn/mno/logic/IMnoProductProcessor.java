package biz.galaxygroup.atn.mno.logic;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoProductModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;

import java.util.List;

public interface IMnoProductProcessor {

    /**
     * Create MnoProduct interface
     *
     * @param mnoProductModel
     * @return
     */
    public SuccessResponseModel createMnoProduct(List<MnoProductModel> mnoProductModel);

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
    public SuccessResponseModel removeMnoProduct(String mnoProductId);

    /**
     * Get ProductByFilterParams interface
     *
     * @param
     * @return
     */
    public GetResponseModel getProductByFilterParams(String pageNumber, String pageSize, String searchBy, String startDate, String endDate);
}
