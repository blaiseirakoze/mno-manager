package com.atn.mnomanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.logic.IMnoProfileProcessor;

/**
 * 
 * @author blaise irakoze
 *
 */
@RestController
@RequestMapping("mno-prifile")
@CrossOrigin
public class MnoProfileService {

	@Autowired
	private IMnoProfileProcessor mnoProfileProcessor;

	/**
	 * 
	 * @param mnoProfile
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> fundTransfer(@RequestBody MnoProfile mnoProfile) {
		return new ResponseEntity<MnoProfile>(mnoProfileProcessor.createMnoProfile(mnoProfile), HttpStatus.CREATED);
	}
}
