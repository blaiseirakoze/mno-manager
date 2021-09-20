package com.atn.mnomanager.facades;

import com.atn.mnomanager.entities.AtnProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtnProductRepository extends JpaRepository<AtnProduct, String> {

}
