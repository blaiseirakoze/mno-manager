package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MnoProductRepository extends JpaRepository<MnoProduct, String> {
    @Query(value = "SELECT COUNT(*) FROM mno_product", nativeQuery = true)
    int countMnoProduct();
}
