package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnoAccountRepository extends JpaRepository<MnoAccount, String> {

}
