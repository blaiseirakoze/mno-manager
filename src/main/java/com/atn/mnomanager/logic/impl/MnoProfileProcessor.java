package com.atn.mnomanager.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atn.mnomanager.entities.MnoProfile;
import com.atn.mnomanager.facades.MnoProfileRepository;
import com.atn.mnomanager.logic.IMnoProfileProcessor;

/**
 * 
 * @author blaise irakoze
 *
 */
@Service
public class MnoProfileProcessor implements IMnoProfileProcessor {

	@Autowired
	private MnoProfileRepository mnoProfileRepository;

	@Override
	public MnoProfile createMnoProfile(MnoProfile mnoProfile) {
		try {
			return mnoProfileRepository.save(mnoProfile);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
