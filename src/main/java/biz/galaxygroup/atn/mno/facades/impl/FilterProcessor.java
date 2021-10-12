package biz.galaxygroup.atn.mno.facades.impl;
import biz.galaxygroup.atn.mno.models.FilterModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class FilterProcessor implements biz.galaxygroup.atn.mno.facades.FilterProcessor {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Object> filterTransfer(FilterModel filterModel, String table) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder stringBuilder = new StringBuilder("Select T from " + table + " T where T.id is not null ");
        String[] searchParams = filterModel.getSearchBy().split(",");
        if (filterModel.getStartDate() != null) {
            stringBuilder.append(" AND T.creationTime <= '" + format.format(filterModel.getStartDate()) + "'");
        }
        if (filterModel.getEndDate() != null) {
            stringBuilder.append(" AND T.creationTime >= '" + format.format(filterModel.getEndDate()) + "'");
        }
        for (String param : searchParams) {
            stringBuilder.append(" AND T.searchBy LIKE '%" + param + "%'");
        }
        stringBuilder.append(" ORDER BY T.creationTime desc");
        Query query = entityManager.createQuery(stringBuilder.toString());
        if (filterModel.getPageNumber() != null) {
            query.setFirstResult((Integer.valueOf(filterModel.getPageNumber()) - 1) * Integer.valueOf(filterModel.getPageSize()));
        }
        if (filterModel.getPageSize() != null) {
            query.setMaxResults(Integer.valueOf(filterModel.getPageSize()));
        }
        return query.getResultList();
    }
}
