package biz.galaxygroup.atn.mno.services;

import biz.galaxygroup.atn.mno.models.AgentConfigModel;
import biz.galaxygroup.atn.mno.models.GetResponseModel;
import biz.galaxygroup.atn.mno.models.SuccessResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import biz.galaxygroup.atn.mno.logic.IMnoProfileProcessor;

import javax.annotation.security.RolesAllowed;
import java.text.ParseException;
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
    @RolesAllowed({"admin"})
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> createMnoProfile(@RequestBody List<MnoProfile> mnoProfile) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.createMnoProfile(mnoProfile), HttpStatus.CREATED);
    }

    /**
     * Get all MnoProfile service
     * client-admin, client-reseller
     *
     * @return
     */
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/all", method = RequestMethod.GET)
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
    @RolesAllowed({"admin"})
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
    @RolesAllowed({"admin"})
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
    @RolesAllowed({"admin"})
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
    @RolesAllowed({"admin"})
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
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/agent/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMnoAgentConfig(@RequestBody AgentConfigModel agentConfigModel) {
        return new ResponseEntity<SuccessResponseModel>(mnoProfileProcessor.addMnoAgentConfig(agentConfigModel), HttpStatus.CREATED);
    }

    /**
     * Remove MnoProfile agent service
     *
     * @param mnoId
     * @return
     */
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/agent/remove/{mnoId}", method = RequestMethod.POST)
    public ResponseEntity<?> removeMnoAgentConfig(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.removeMnoAgentConfig(mnoId), HttpStatus.CREATED);
    }

    /**
     * Get MNO agent config by MNO id service
     *
     * @param mnoId
     * @return
     */
    @RolesAllowed({"admin"})
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
    @RolesAllowed({"admin"})
    @RequestMapping(value = "/filter", method = RequestMethod.GET)
    public ResponseEntity<?> getMnoByFilterParams(
            @RequestParam(required = false) String pageNumber,
            @RequestParam(required = false) String pageSize,
            @RequestParam(required = false) String searchBy,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate) throws ParseException {
        return new ResponseEntity<GetResponseModel>((GetResponseModel) mnoProfileProcessor.getMnoByFilterParams(pageNumber, pageSize, searchBy, startDate, endDate), HttpStatus.OK);
    }
}
