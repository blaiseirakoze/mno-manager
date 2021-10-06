package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MnoProfileRepository extends JpaRepository<MnoProfile, String> {
    @Query(value = "SELECT COUNT(*) FROM mno_profile", nativeQuery = true)
    int countMnoProfile();
}
