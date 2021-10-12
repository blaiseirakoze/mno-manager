package biz.galaxygroup.atn.mno.facades;

import biz.galaxygroup.atn.mno.models.FilterModel;

import java.util.List;

public interface FilterProcessor {

    /**
     * FIlter processor interface
     *
     * @param filterModel
     * @param table
     * @return
     */
    public List<Object> filterTransfer(FilterModel filterModel, String table);
}
