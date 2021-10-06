package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.AtnProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtnProductRepository extends JpaRepository<AtnProduct, String> {

}
