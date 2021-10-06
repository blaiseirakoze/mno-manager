package biz.galaxygroup.atn.mno.logic.impl;

import biz.galaxygroup.atn.mno.entities.AtnProduct;
import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.exceptions.HandlerNotFoundException;
import biz.galaxygroup.atn.mno.facades.AtnProductRepository;
import biz.galaxygroup.atn.mno.facades.MnoProductRepository;
import biz.galaxygroup.atn.mno.facades.MnoProfileRepository;
import biz.galaxygroup.atn.mno.facades.ProductFilterProcessor;
import biz.galaxygroup.atn.mno.models.MnoProductModel;
import biz.galaxygroup.atn.mno.models.ProductFilterModel;
import biz.galaxygroup.atn.mno.models.SuccessResponse;
import biz.galaxygroup.atn.mno.logic.IMnoProductProcessor;
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

    @Autowired
    private ProductFilterProcessor filterProcessor;

    /**
     * Create MnoProduct processor
     *
     * @param mnoProductModel
     * @return
     */
    @Override
    public MnoProduct createMnoProduct(MnoProductModel mnoProductModel) {
        MnoProfile foundMnoProfile = mnoProfileRepository.findById(mnoProductModel.getMnoProfileId()).orElse(new MnoProfile());
        if (foundMnoProfile.getId() == null) {
            throw new HandlerNotFoundException("MNO not found");
        }
        AtnProduct foundAtnProduct = atnProductRepository.findById(mnoProductModel.getAtnProductId()).orElse(new AtnProduct());
        if (foundAtnProduct.getId() == null) {
            throw new HandlerNotFoundException("Atn product not found");
        }
        try {
            return mnoProductRepository.save(new MnoProduct(foundMnoProfile, foundAtnProduct));
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
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
        MnoProduct foundMnoProduct = mnoProductRepository.findById(mnoProductId).orElse(new MnoProduct());
        if (foundMnoProduct.getId() == null) {
            throw new HandlerNotFoundException("Mno product not found");
        }
        try {
            return foundMnoProduct;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
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
        MnoProduct foundMnoProduct = mnoProductRepository.findById(id).orElse(new MnoProduct());
        if (foundMnoProduct.getId() == null) {
            throw new HandlerNotFoundException("Mno product not found");
        }
        try {
            mnoProductRepository.deleteById(id);
            return new SuccessResponse("mno product well removed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Get ProductByFilterParams processor
     *
     * @param productFilterModel
     * @return
     */
    @Override
    public List<MnoProduct> getProductByFilterParams(ProductFilterModel productFilterModel) {
        try {
            List<MnoProduct> foundMnoProduct = filterProcessor.filterTransfer(productFilterModel);
            return foundMnoProduct;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

}
