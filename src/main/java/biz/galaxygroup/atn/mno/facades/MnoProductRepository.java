package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnoProductRepository extends JpaRepository<MnoProduct, String> {
}
