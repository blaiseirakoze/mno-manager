package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnoProfileRepository extends JpaRepository<MnoProfile, String> {

}
