package com.atn.mnomanager.logic;

import com.atn.mnomanager.entities.MnoProfile;

import java.util.List;

/**
 * @author blaise irakoze
 */
public interface IMnoProfileProcessor {

    /**
     * Create MnoProfile interface
     *
     * @param mnoProfile
     * @return
     */
    public MnoProfile createMnoProfile(MnoProfile mnoProfile);

    /**
     * Get all MnoProfile interface
     *
     * @return
     */
    public List<MnoProfile> getAllMnoProfile();

    /**
     * Edit MnoProfile interface
     *
     * @param mnoId
     * @param mnoProfile
     * @return
     */
    public MnoProfile editMnoProfile(String mnoId, MnoProfile mnoProfile);

    /**
     * Enable or Disable MnoProfile interface
     *
     * @param mnoId
     * @return
     */
    public MnoProfile enableOrDisableMnoProfile(String mnoId, String status);

    /**
     * Get MnoProfile by id interface
     *
     * @param mnoId
     * @return
     */
    public MnoProfile getMnoProfileById(String mnoId);
}
