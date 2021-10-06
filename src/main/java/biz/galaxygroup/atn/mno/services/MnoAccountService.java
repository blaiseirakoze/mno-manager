package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.entities.MnoAccount;
import biz.galaxygroup.atn.mno.logic.IMnoAccountProcessor;
import biz.galaxygroup.atn.mno.models.MnoAccountModel;
import biz.galaxygroup.atn.mno.models.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author blaise irakoze
 */
@RestController
@RequestMapping(value = "mno/account")
@CrossOrigin
public class MnoAccountService {

    @Autowired
    private IMnoAccountProcessor mnoAccountProcessor;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMnoAccount(@RequestBody MnoAccountModel mnoAccountModel) {
        return new ResponseEntity<MnoAccount>(mnoAccountProcessor.createMnoAccount(mnoAccountModel), HttpStatus.CREATED);
    }

    /**
     * Get MnoAccount by id service
     *
     * @param id
     * @return
     */
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
    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> removeMnoAccount(@PathVariable("id") String id) {
        return new ResponseEntity<SuccessResponse>(mnoAccountProcessor.removeMnoAccount(id), HttpStatus.CREATED);
    }
}
