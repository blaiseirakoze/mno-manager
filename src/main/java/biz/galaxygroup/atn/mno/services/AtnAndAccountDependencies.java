package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.entities.Account;
import biz.galaxygroup.atn.mno.entities.AtnProduct;
import biz.galaxygroup.atn.mno.exceptions.HandlerInternalServerErrorException;
import biz.galaxygroup.atn.mno.facades.AccountRepository;
import biz.galaxygroup.atn.mno.facades.AtnProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("api")
public class AtnAndAccountDependencies {

    @Autowired
    private AtnProductRepository atnProductRepository;
    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(value = "/atn", method = RequestMethod.POST)
    public ResponseEntity<?> createAtn(@RequestBody AtnProduct atnProduct) {
        try {
            return new ResponseEntity<AtnProduct>(atnProductRepository.save(atnProduct), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    @RequestMapping(value = "/atn", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAtn() {
        try {
            return new ResponseEntity<List<AtnProduct>>(atnProductRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<?> createAccount(@RequestBody Account account) throws Exception {
        try {
            return new ResponseEntity<Account>(accountRepository.save(account), HttpStatus.CREATED);
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResponseEntity<?> getAllAccounts() {
        try {
            return new ResponseEntity<List<Account>>(accountRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            throw new HandlerInternalServerErrorException("Error occurs");
        }
    }
}
