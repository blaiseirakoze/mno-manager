package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.entities.MnoProfile;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class MnoFilterProcessor {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<MnoProfile> filterTransfer(String name, String email, String telephone, String agentConfig, String creationTime, String status) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        format.format(mnoProfile.getCreationTime());
        MnoProfile mnoProfile = new MnoProfile(name, email, telephone, agentConfig, status);

        System.out.print("seach object mnoProfile " + mnoProfile);
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
//        2021-10-04
        if (!mnoProfile.getTelephone().equalsIgnoreCase("")) {
            query.append(" AND T.telephone = '" + mnoProfile.getTelephone() + "'");
        }
//        query.append(" ORDER BY T.creationTime desc");
        Query queryResult = entityManager.createQuery(query.toString());
        System.out.println("query ===========================> " + query);
        System.out.println("results =========================> " + queryResult);
        return queryResult.getResultList();
    }
}
