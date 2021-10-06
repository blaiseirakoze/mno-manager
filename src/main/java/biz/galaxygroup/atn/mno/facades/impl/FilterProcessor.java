package biz.galaxygroup.atn.mno.facades.impl;

import biz.galaxygroup.atn.mno.models.FilterModel;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @author blaise irakoze
 */
@Component
public class FilterProcessor implements biz.galaxygroup.atn.mno.facades.FilterProcessor {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Filter processor
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @param table
     * @return
     * @throws ParseException
     */
    @Transactional
    @Override
    public List<Object> filterTransfer(String pageNumber, String pageSize, String searchBy, String startDate, String endDate, String table) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        StringBuilder stringBuilder = new StringBuilder("Select T from " + table + " T where T.id is not null ");
        if (startDate != null) {
            stringBuilder.append(" AND T.creationTime > '" + format.format(new SimpleDateFormat("yyyy-MM-dd").parse(startDate)) + "'");
        }
        if (endDate != null) {
            stringBuilder.append(" AND T.creationTime < '" + format.format(new SimpleDateFormat("yyyy-MM-dd").parse(endDate)) + "'");
        }
        if (searchBy != null) {
            String[] searchParams = searchBy.split(",");
            for (String param : searchParams) {
                stringBuilder.append(" AND T.searchBy LIKE '%" + param + "%'");
            }
        }
        stringBuilder.append(" ORDER BY T.creationTime desc");
        Query query = entityManager.createQuery(stringBuilder.toString());
        if (pageNumber != null && pageSize != null) {
            query.setFirstResult((Integer.valueOf(pageNumber) - 1) * Integer.valueOf(pageSize));
        }
        if (pageSize != null) {
            query.setMaxResults(Integer.valueOf(pageSize));
        }
        return query.getResultList();
    }

    /**
     * Add or remove a day to date
     *
     * @param oldDate
     * @param days
     * @return
     */
    public String addRemoveDayToDate(String oldDate, int days) {
        //Specifying date format that matches the given date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            //Setting the date to the given date
            c.setTime(sdf.parse(oldDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, days);
        //Date after adding the days to the given date
        String newDate = sdf.format(c.getTime());
        return newDate;
    }
}
