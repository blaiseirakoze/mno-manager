package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.models.AgentConfigModel;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.MnoFilterModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.logic.IMnoProfileProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author blaise irakoze
 */
@RestController
@RequestMapping(value = "api/mno")
@CrossOrigin
public class MnoProfileService {

    @Autowired
    private IMnoProfileProcessor mnoProfileProcessor;

    /**
     * Create MnoProfile service
     *
     * @param mnoProfile
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMnoProfile(@RequestBody List<MnoProfile> mnoProfile) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.createMnoProfile(mnoProfile), HttpStatus.CREATED);
    }

    /**
     * Get all MnoProfile service
     *
     * @return
     */
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<?> getAllMnoProfile() {
        return new ResponseEntity<List<MnoProfile>>(mnoProfileProcessor.getAllMnoProfile(), HttpStatus.OK);
    }

    /**
     * Edit MnoProfile service
     *
     * @param mnoId
     * @param mnoProfile
     * @return
     */
    @RequestMapping(value = "/edit/{mnoId}", method = RequestMethod.POST)
    public ResponseEntity<?> editMnoProfile(@PathVariable("mnoId") String mnoId, @RequestBody MnoProfile mnoProfile) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.editMnoProfile(mnoId, mnoProfile), HttpStatus.CREATED);
    }

    /**
     * Enable MnoProfile service
     *
     * @param mnoId
     * @return
     */
    @RequestMapping(value = "/enable/{mnoId}", method = RequestMethod.GET)
    public ResponseEntity<?> enableMnoProfile(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.enableOrDisableMnoProfile(mnoId, "enable"), HttpStatus.CREATED);
    }

    /**
     * Disable MnoProfile service
     *
     * @param mnoId
     * @return
     */
    @RequestMapping(value = "/disable/{mnoId}", method = RequestMethod.GET)
    public ResponseEntity<?> disableMnoProfile(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.enableOrDisableMnoProfile(mnoId, "disable"), HttpStatus.CREATED);
    }

    /**
     * Get MnoProfile by id service
     *
     * @param mnoId
     * @return
     */
    @RequestMapping(value = "/filter/{mnoId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMnoProfileById(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.getMnoProfileById(mnoId), HttpStatus.CREATED);
    }

    /**
     * Add MnoProfile agent service
     *
     * @param agentConfigModel
     * @return
     */
    @RequestMapping(value = "/agent/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMnoAgentConfig(@RequestBody AgentConfigModel agentConfigModel) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.addMnoAgentConfig(agentConfigModel), HttpStatus.CREATED);
    }

//    @RequestMapping(value = "/agent/remove/{mnoId}", method = RequestMethod.POST)
//    public ResponseEntity<?> removeMnoAgentConfig(@RequestBody AgentConfigModel agentConfigModel) {
//        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.addMnoAgentConfig(agentConfigModel), HttpStatus.CREATED);
//    }

    /**
     * Get MNO agent config by MNO id service
     *
     * @param mnoId
     * @return
     */
    @RequestMapping(value = "/agent/filter/{mnoId}", method = RequestMethod.GET)
    public ResponseEntity<?> getMnoAgentConfigByMnoId(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<AgentConfigModel>(mnoProfileProcessor.getMnoAgentConfigByMnoId(mnoId), HttpStatus.OK);
    }

    /**
     * Get MnoByFilterParams service
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/filter/", method = RequestMethod.GET)
    public ResponseEntity<?> getMnoByFilterParams(@RequestParam String pageNumber, @RequestParam String pageSize, @RequestParam String searchBy, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {
        return new ResponseEntity<GetResponseModel>((GetResponseModel) mnoProfileProcessor.getMnoByFilterParams(pageNumber, pageSize, searchBy, startDate, endDate), HttpStatus.OK);
    }
}
