package biz.galaxygroup.atn.mno.models;

import java.util.Date;

public class FilterModel {
    private String pageNumber;
    private String pageSize;
    private String searchBy;
    private Date startDate;
    private Date endDate;

    public FilterModel() {
    }

    public FilterModel(String pageNumber, String pageSize, String searchBy, Date startDate, Date endDate) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.searchBy = searchBy;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public FilterModel(String pageNumber, String pageSize, String searchBy, Date startDate) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.searchBy = searchBy;
        this.startDate = startDate;
    }

    public FilterModel(String pageNumber, String pageSize, String searchBy) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.searchBy = searchBy;
    }

    public String getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(String pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "FilterModel{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", searchBy=" + searchBy +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
