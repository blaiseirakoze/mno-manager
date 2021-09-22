package com.atn.mnomanager.logic.impl;

import com.atn.mnomanager.entities.AtnProduct;
import com.atn.mnomanager.entities.MnoProduct;
import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.exceptions.HandlerInternalServerErrorException;
import com.atn.mnomanager.exceptions.HandlerNotFoundException;
import com.atn.mnomanager.facades.AtnProductRepository;
import com.atn.mnomanager.facades.MnoProductRepository;
import com.atn.mnomanager.facades.MnoProfileRepository;
import com.atn.mnomanager.logic.IMnoProductProcessor;
import com.atn.mnomanager.models.MnoProductModel;
import com.atn.mnomanager.models.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoProductModel.getMnoProfileId()).orElse(new MnoProfile());
            if (!foundMnoProfile.getId().equals(mnoProductModel.getMnoProfileId())) {
                throw new HandlerNotFoundException("MNO not found");
            }
            AtnProduct foundAtnProduct = atnProductRepository.findById(mnoProductModel.getAtnProductId()).orElse(new AtnProduct());
            if (!foundAtnProduct.getId().equals(mnoProductModel.getAtnProductId())) {
                throw new HandlerNotFoundException("Atn product not found");
            }
            return mnoProductRepository.save(new MnoProduct(foundMnoProfile, foundAtnProduct));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
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
            MnoProduct foundMnoProduct = mnoProductRepository.findById(mnoProductId).orElse(new MnoProduct());
            if (!foundMnoProduct.getId().equals(mnoProductId)) {
                throw new HandlerNotFoundException("Mno product not found");
            }
            return foundMnoProduct;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
        }
    }

    /**
     * Remove MnoProduct processor
     *
     * @param id
     * @return
     */
    @Override
    public SuccessResponse removeMnoProduct(String id) {
        try {
            MnoProduct foundMnoProduct = mnoProductRepository.findById(id).orElse(new MnoProduct());
            if (!foundMnoProduct.getId().equals(id)) {
                throw new HandlerNotFoundException("Mno product not found");
            }
            mnoProductRepository.deleteById(id);
            return new SuccessResponse("mno product well removed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Internal server error");
        }
    }

}
