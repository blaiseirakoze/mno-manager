package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.logic.IMnoProductProcessor;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoProductModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
import java.util.List;

/**
 * @author blaise irakoze
 */
@RestController
@RequestMapping(value = "api/mno/product")
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
    @RolesAllowed({"admin"})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMnoProduct(@RequestBody List<MnoProductModel> mnoProductModel) {
        return new ResponseEntity<SuccessResponseModel>(mnoProductProcessor.createMnoProduct(mnoProductModel), HttpStatus.CREATED);
    }

    /**
     * Get MnoProduct by MnoProductId service
     *
     * @param mnoProductId
     * @return
     */
    @RolesAllowed({"admin"})
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
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/remove/{mnoProductId}", method = RequestMethod.GET)
    public ResponseEntity<?> removeMnoProduct(@PathVariable("mnoProductId") String mnoProductId) {
        return new ResponseEntity<SuccessResponseModel>(mnoProductProcessor.removeMnoProduct(mnoProductId), HttpStatus.CREATED);
    }

    /**
     * Get ProductByFilterParams service
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/filter/", method = RequestMethod.GET)
    public ResponseEntity<?> getProductByFilterParams(
            @RequestParam(required = false) String pageNumber,
            @RequestParam(required = false) String pageSize,
            @RequestParam(required = false) String searchBy,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) throws ParseException {
        return new ResponseEntity<GetResponseModel>((GetResponseModel) mnoProductProcessor.getProductByFilterParams(pageNumber, pageSize, searchBy, startDate, endDate), HttpStatus.OK);
    }

}
