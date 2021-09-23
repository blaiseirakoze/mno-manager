package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoProduct;
import biz.galaxygroup.atn.mno.models.ProductFilterModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class ProductFilterProcessor {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<MnoProduct> filterTransfer(ProductFilterModel productFilterModel) {
        System.out.println("product reqqqqqqqqqqqqqqqqqqqqqqqqqqq "+ productFilterModel);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        format.format(productFilterModel.getCreationTime());
        StringBuilder query = new StringBuilder("Select T from MnoProduct T where T.id is not null ");

        if (!productFilterModel.getMnoProfile().equalsIgnoreCase("")) {
            query.append(" AND T.mnoProfile = '" + productFilterModel.getMnoProfile() + "'");
        }
        if (!productFilterModel.getAtnProduct().equalsIgnoreCase("")) {
            query.append(" AND T.atnProduct = '" + productFilterModel.getAtnProduct() + "'");
        }
        if (!productFilterModel.getCreationTime().toString().equals("")) {
            query.append(" AND T.creationTime > '" + format.format(productFilterModel.getCreationTime()) + "'");
        }
        query.append(" ORDER BY T.creationTime desc");
        Query queryResult = entityManager.createQuery(query.toString());
        System.out.println("query ===========================> " + query);
        System.out.println("results =========================> " + queryResult);
        return queryResult.getResultList();
    }
}
