package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.models.FilterModel;

import java.text.ParseException;
import java.util.List;

public interface FilterProcessor {

    /**
     * FIlter processor interface
     *
     * @param pageNumber
     * @param pageSize
     * @param searchBy
     * @param startDate
     * @param endDate
     * @param table
     * @return
     */
    public List<Object> filterTransfer(String pageNumber, String pageSize, String searchBy, String startDate, String endDate, String table) throws ParseException;
}
