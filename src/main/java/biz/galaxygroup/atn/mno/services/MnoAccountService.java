package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.entities.MnoAccount;
import biz.galaxygroup.atn.mno.logic.IMnoAccountProcessor;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoAccountModel;
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
@RequestMapping(value = "api/mno/account")
@CrossOrigin
public class MnoAccountService {

    @Autowired
    private IMnoAccountProcessor mnoAccountProcessor;

    /**
     * Create MnoAccount service
     * @param mnoAccountModel
     * @return
     */
    @RolesAllowed({"admin"})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMnoAccount(@RequestBody List<MnoAccountModel> mnoAccountModel) {
        return new ResponseEntity<SuccessResponseModel>(mnoAccountProcessor.createMnoAccount(mnoAccountModel), HttpStatus.CREATED);
    }

    /**
     * Get MnoAccount by id service
     *
     * @param id
     * @return
     */
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/filter/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMnoAccountById(@PathVariable("id") String id) {
        return new ResponseEntity<MnoAccount>(mnoAccountProcessor.getAccountById(id), HttpStatus.OK);
    }

    /**
     * Remove MnoAccount service
     *
     * @param id
     * @return
     */
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> removeMnoAccount(@PathVariable("id") String id) {
        return new ResponseEntity<SuccessResponseModel>(mnoAccountProcessor.removeMnoAccount(id), HttpStatus.CREATED);
    }

    /**
     * Get MnoAccountsByFilterParams service
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
    public ResponseEntity<?> getMnoAccountsByFilterParams(@RequestParam String pageNumber, @RequestParam String pageSize, @RequestParam String searchBy, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        return new ResponseEntity<GetResponseModel>((GetResponseModel) mnoAccountProcessor.getMnoAccountByFilterParams(pageNumber, pageSize, searchBy, startDate, endDate), HttpStatus.OK);
    }
}
