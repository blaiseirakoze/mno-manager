package com.atn.mnomanager.logic.impl;

import com.atn.mnomanager.entities.AtnProduct;
import com.atn.mnomanager.entities.MnoProduct;
import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.facades.AtnProductRepository;
import com.atn.mnomanager.facades.MnoProductRepository;
import com.atn.mnomanager.facades.MnoProfileRepository;
import com.atn.mnomanager.logic.IMnoProductProcessor;
import com.atn.mnomanager.models.MnoProductModel;
import com.atn.mnomanager.models.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author blaise irakoze
 */
@Service
public class MnoProductProcessor implements IMnoProductProcessor {

    @Autowired
    private MnoProductRepository mnoProductRepository;

    @Autowired
    private MnoProfileRepository mnoProfileRepository;

    @Autowired
    private AtnProductRepository atnProductRepository;

    /**
     * Create MnoProduct processor
     *
     * @param mnoProductModel
     * @return
     */
    @Override
    public MnoProduct createMnoProduct(MnoProductModel mnoProductModel) {
        try {
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoProductModel.getMnoProfileId()).get();
            AtnProduct foundAtnProduct = atnProductRepository.findById(mnoProductModel.getAtnProductId()).get();
            return mnoProductRepository.save(new MnoProduct(foundMnoProfile, foundAtnProduct));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get MnoProduct by mnoProductId processor
     *
     * @param mnoProductId
     * @return
     */
    @Override
    public MnoProduct getMnoProductByMnoProductId(String mnoProductId) {
        try {
            return mnoProductRepository.findById(mnoProductId).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Remove MnoProduct processor
     * @param id
     * @return
     */
    @Override
    public SuccessResponse removeMnoProduct(String id) {
        try {
            mnoProductRepository.deleteById(id);
            return new SuccessResponse("mno product well deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
