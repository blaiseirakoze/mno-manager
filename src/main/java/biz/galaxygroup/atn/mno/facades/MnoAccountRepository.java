package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MnoAccountRepository extends JpaRepository<MnoAccount, String> {
    @Query(value = "SELECT COUNT(*) FROM mno_account", nativeQuery = true)
    int countMnoAccount();
}
