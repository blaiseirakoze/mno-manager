package biz.galaxygroup.atn.mno.models;

import java.util.List;

public class GetResponseModel {
    private int totalItems;
    private int currentPage;
    private Object data;

    public GetResponseModel() {
    }

    public GetResponseModel(int totalItems, int currentPage, Object data) {
        this.totalItems = totalItems;
        this.currentPage = currentPage;
        this.data = data;
    }

    public GetResponseModel(int totalItems, Object data) {
        this.totalItems = totalItems;
        this.data = data;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
