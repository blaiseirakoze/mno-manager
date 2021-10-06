package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

}
