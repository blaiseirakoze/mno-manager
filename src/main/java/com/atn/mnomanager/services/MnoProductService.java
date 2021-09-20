package com.atn.mnomanager.services;

import com.atn.mnomanager.entities.MnoProduct;
import com.atn.mnomanager.logic.IMnoProductProcessor;
import com.atn.mnomanager.models.MnoProductModel;
import com.atn.mnomanager.models.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
