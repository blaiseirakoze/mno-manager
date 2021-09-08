package com.atn.mnomanager.facades;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atn.mnomanager.entities.MnoProfile;

public interface MnoProfileRepository extends JpaRepository<MnoProfile, String> {

}
