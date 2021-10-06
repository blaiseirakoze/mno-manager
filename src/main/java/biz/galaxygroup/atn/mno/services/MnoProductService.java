package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.logic.IMnoProductProcessor;
import biz.galaxygroup.atn.mno.models.MnoProductModel;
import biz.galaxygroup.atn.mno.models.ProductFilterModel;
import biz.galaxygroup.atn.mno.models.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author blaise irakoze
 */
@RestController
@RequestMapping(value = "mno/product")
@CrossOrigin
public class MnoProductService {

    @Autowired
    private IMnoProductProcessor mnoProductProcessor;

    /**
     * Create MnoProduct service
     *
     * @param mnoProductModel
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMnoProduct(@RequestBody MnoProductModel mnoProductModel) {
        return new ResponseEntity<MnoProduct>(mnoProductProcessor.createMnoProduct(mnoProductModel), HttpStatus.CREATED);
    }

    /**
     * Get MnoProduct by MnoProductId service
     *
     * @param mnoProductId
     * @return
     */
    @RequestMapping(value = "/filter/{mnoProductId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMnoProductByIdMnoProductId(@PathVariable("mnoProductId") String mnoProductId) {
        return new ResponseEntity<MnoProduct>(mnoProductProcessor.getMnoProductByMnoProductId(mnoProductId), HttpStatus.OK);
    }

    /**
     * Remove MnoProduct service
     *
     * @param mnoProductId
     * @return
     */
    @RequestMapping(value = "/remove/{mnoProductId}", method = RequestMethod.GET)
    public ResponseEntity<?> removeMnoProduct(@PathVariable("mnoProductId") String mnoProductId) {
        return new ResponseEntity<SuccessResponse>(mnoProductProcessor.removeMnoProduct(mnoProductId), HttpStatus.CREATED);
    }

    /**
     * Get ProductByFilterParams service
     *
     * @param mnoProfile
     * @param atnProduct
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/filter/", method = RequestMethod.POST)
    public ResponseEntity<?> getProductByFilterParams(@RequestParam String mnoProfile, @RequestParam String atnProduct, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        List<MnoProduct> mnoProducts = new ArrayList<MnoProduct>();
        if (startDate.isEmpty() && endDate.isEmpty()) {
            mnoProducts = mnoProductProcessor.getProductByFilterParams(new ProductFilterModel(mnoProfile, atnProduct));
        } else if (!startDate.isEmpty() && endDate.isEmpty()) {
            Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            mnoProducts = mnoProductProcessor.getProductByFilterParams(new ProductFilterModel(mnoProfile, atnProduct, sDate));
        } else if (startDate.isEmpty() && !endDate.isEmpty()) {
            Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            mnoProducts = mnoProductProcessor.getProductByFilterParams(new ProductFilterModel(mnoProfile, atnProduct, eDate));
        } else {
            Date sDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
            Date eDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
            mnoProducts = mnoProductProcessor.getProductByFilterParams(new ProductFilterModel(mnoProfile, atnProduct, sDate, eDate));
        }
        return new ResponseEntity<List<MnoProduct>>(mnoProducts, HttpStatus.OK);
    }

}
