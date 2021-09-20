package com.atn.mnomanager.facades;

import com.atn.mnomanager.entities.MnoProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnoProductRepository extends JpaRepository<MnoProduct, String> {
}
