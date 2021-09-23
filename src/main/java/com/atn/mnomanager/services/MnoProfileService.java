package com.atn.mnomanager.services;

import com.atn.mnomanager.models.AgentConfigModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.logic.IMnoProfileProcessor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author blaise irakoze
 */
@RestController
@RequestMapping(value = "mno")
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
    public ResponseEntity<?> createMnoProfile(@RequestBody MnoProfile mnoProfile) {
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.createMnoProfile(mnoProfile), HttpStatus.CREATED);
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
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.editMnoProfile(mnoId, mnoProfile), HttpStatus.CREATED);
    }

    /**
     * Enable MnoProfile service
     *
     * @param mnoId
     * @return
     */
    @RequestMapping(value = "/enable/{mnoId}", method = RequestMethod.GET)
    public ResponseEntity<?> enableMnoProfile(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.enableOrDisableMnoProfile(mnoId, "enable"), HttpStatus.CREATED);
    }

    /**
     * Disable MnoProfile service
     *
     * @param mnoId
     * @return
     */
    @RequestMapping(value = "/disable/{mnoId}", method = RequestMethod.GET)
    public ResponseEntity<?> disableMnoProfile(@PathVariable("mnoId") String mnoId) {
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.enableOrDisableMnoProfile(mnoId, "disable"), HttpStatus.CREATED);
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
     * Edit MnoProfile agent service
     *
     * @param agentConfigModel
     * @return
     */
    @RequestMapping(value = "/agent/add", method = RequestMethod.POST)
    public ResponseEntity<?> addMnoAgentConfig(@RequestBody AgentConfigModel agentConfigModel) {
        return new ResponseEntity<MnoProfile>(mnoProfileProcessor.addMnoAgentConfig(agentConfigModel), HttpStatus.CREATED);
    }

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
     * @param name
     * @param status
     * @param agentConfig
     * @param email
     * @param creationTime
     * @param telephone
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "/filter/", method = RequestMethod.POST)
    public ResponseEntity<?> getMnoByFilterParams(@RequestParam String name, @RequestParam String status, @RequestParam String agentConfig, @RequestParam String email, @RequestParam String creationTime, @RequestParam String telephone) throws ParseException {
//        Date creationDate = new SimpleDateFormat("yyyy-MM-dd").parse(creationTime);
        return new ResponseEntity<List<MnoProfile>>(mnoProfileProcessor.getMnoByFilterParams(new MnoProfile(name, email, telephone, agentConfig, status)), HttpStatus.OK);
    }

}
