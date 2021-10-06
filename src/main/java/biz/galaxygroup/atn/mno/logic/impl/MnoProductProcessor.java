package biz.galaxygroup.atn.mno.logic.impl;

import biz.galaxygroup.atn.mno.entities.AtnProduct;
import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.exceptions.HandlerNotFoundException;
import biz.galaxygroup.atn.mno.facades.AtnProductRepository;
import biz.galaxygroup.atn.mno.facades.MnoProductRepository;
import biz.galaxygroup.atn.mno.facades.MnoProfileRepository;
import biz.galaxygroup.atn.mno.facades.FilterProcessor;
import biz.galaxygroup.atn.mno.models.FilterModel;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoProductModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;
import biz.galaxygroup.atn.mno.logic.IMnoProductProcessor;
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
public class MnoProductProcessor implements IMnoProductProcessor {

    @Autowired
    private MnoProductRepository mnoProductRepository;

    @Autowired
    private MnoProfileRepository mnoProfileRepository;

    @Autowired
    private AtnProductRepository atnProductRepository;

    @Autowired
    private FilterProcessor filterProcessor;

    /**
     * Create MnoProduct processor
     *
     * @param mnoProductModel
     * @return
     */
    @Override
    public SuccessResponseModel createMnoProduct(List<MnoProductModel> mnoProductModel) {
        List<MnoProfile> foundMnoProfileList = new ArrayList<>();
        List<AtnProduct> foundAtnProductList = new ArrayList<>();
        int i = 0;
        MnoProfile foundMnoProfile = new MnoProfile();
        AtnProduct foundAtnProduct = new AtnProduct();
        for (MnoProductModel mnoProduct : mnoProductModel) {
            foundMnoProfile = mnoProfileRepository.findById(mnoProduct.getMnoProfileId()).orElse(new MnoProfile());
            if (foundMnoProfile.getId() == null) {
                throw new HandlerNotFoundException("MNO with" + mnoProduct.getMnoProfileId() + " not found");
            } else {
                foundMnoProfileList.add(foundMnoProfile);
            }
            foundAtnProduct = atnProductRepository.findById(mnoProduct.getAtnProductId()).orElse(new AtnProduct());
            if (foundAtnProduct.getId() == null) {
                throw new HandlerNotFoundException("Atn product with" + mnoProduct.getAtnProductId() + " not found");
            } else {
                foundAtnProductList.add(foundAtnProduct);
            }
        }
        try {
            for (MnoProductModel mnoProduct : mnoProductModel) {
                mnoProductRepository.save(new MnoProduct(foundMnoProfileList.get(i), foundAtnProductList.get(i)));
                i++;
            }
            return new SuccessResponseModel(HttpStatus.CREATED.toString(), "Mno product successfully created");
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
    public SuccessResponseModel removeMnoProduct(String id) {
        MnoProduct foundMnoProduct = mnoProductRepository.findById(id).orElse(new MnoProduct());
        if (foundMnoProduct.getId() == null) {
            throw new HandlerNotFoundException("Mno product not found");
        }
        try {
            mnoProductRepository.deleteById(id);
            return new SuccessResponseModel(HttpStatus.NO_CONTENT.toString(), "Mno product successfully removed");
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    /**
     * Get ProductByFilterParams processor
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public GetResponseModel getProductByFilterParams(String pageNumber, String pageSize, String searchBy, String startDate, String endDate) {
        try {
            FilterModel filterModel = new FilterModel();
            if (startDate.isEmpty() && endDate.isEmpty()) {
                filterModel = new FilterModel(pageNumber, pageSize, searchBy);
            } else if (!startDate.isEmpty() && endDate.isEmpty()) {
                Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                filterModel = new FilterModel(pageNumber, pageSize, searchBy, sDate);
            } else if (startDate.isEmpty() && !endDate.isEmpty()) {
                Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
                filterModel = new FilterModel(pageNumber, pageSize, searchBy, eDate);
            } else {
                Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
                Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
                filterModel = new FilterModel(pageNumber, pageSize, searchBy, eDate, sDate);
            }
            List<Object> list = filterProcessor.filterTransfer(filterModel, "MnoProduct");
            GetResponseModel getResponseModel = new GetResponseModel(list.size(), Integer.valueOf(pageNumber), list);
            return getResponseModel;
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }
}
