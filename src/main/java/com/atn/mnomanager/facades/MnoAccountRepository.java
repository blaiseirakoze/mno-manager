package com.atn.mnomanager.facades;

import com.atn.mnomanager.entities.MnoAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnoAccountRepository extends JpaRepository<MnoAccount, String> {

}
