package com.atn.mnomanager.facades;

import com.atn.mnomanager.entities.MnoProfile;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class FilterProcessor {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<MnoProfile> filterTransfer(MnoProfile mnoProfile) {
        System.out.print("seach object");
        StringBuilder query = new StringBuilder("Select T from MnoProfile T where T.id is not null ");

        if (!mnoProfile.getName().equalsIgnoreCase("")) {
            query.append(" AND T.name = '" + mnoProfile.getName() + "'");
        }
        if (!mnoProfile.getStatus().equalsIgnoreCase("")) {
            query.append(" AND T.status = '" + mnoProfile.getStatus() + "'");
        }
        if (!mnoProfile.getAgentConfig().equalsIgnoreCase("")) {
            query.append(" AND T.agentConfig = '" + mnoProfile.getAgentConfig() + "'");
        }
        if (!mnoProfile.getEmail().equalsIgnoreCase("")) {
            query.append(" AND T.email = '" + mnoProfile.getEmail() + "'");
        }
//        if (!mnoProfile.getCreationTime().toString().equals("")) {
//            query.append(" AND T.creationTime > '" + mnoProfile.getCreationTime() + "'");
//        }
        if (!mnoProfile.getTelephone().equalsIgnoreCase("")) {
            query.append(" AND T.telephone = '" + mnoProfile.getTelephone() + "'");
        }
//        query.append(" ORDER BY T.creationTime desc");
        Query queryResult = entityManager.createQuery(query.toString());
        System.out.println("query ===========================> "+ query);
        System.out.println("results =========================> "+ queryResult);
        return queryResult.getResultList();
    }
}
