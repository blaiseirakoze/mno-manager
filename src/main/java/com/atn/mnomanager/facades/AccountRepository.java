package com.atn.mnomanager.facades;

import com.atn.mnomanager.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
