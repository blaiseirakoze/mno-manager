package biz.galaxygroup.atn.mno.models;

import java.util.Date;

public class ProductFilterModel {
    private String mnoProfile;
    private String atnProduct;
    private Date startDate;
    private Date endDate;

    public ProductFilterModel() {
    }

    public ProductFilterModel(String mnoProfile, String atnProduct) {
        this.mnoProfile = mnoProfile;
        this.atnProduct = atnProduct;
    }

    public ProductFilterModel(String mnoProfile, String atnProduct, Date startDate) {
        this.mnoProfile = mnoProfile;
        this.atnProduct = atnProduct;
        this.startDate = startDate;
    }

    public ProductFilterModel(String mnoProfile, String atnProduct, Date startDate, Date endDate) {
        this.mnoProfile = mnoProfile;
        this.atnProduct = atnProduct;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getMnoProfile() {
        return mnoProfile;
    }

    public void setMnoProfile(String mnoProfile) {
        this.mnoProfile = mnoProfile;
    }

    public String getAtnProduct() {
        return atnProduct;
    }

    public void setAtnProduct(String atnProduct) {
        this.atnProduct = atnProduct;
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
        return "ProductFilterModel{" +
                "mnoProfile='" + mnoProfile + '\'' +
                ", atnProduct='" + atnProduct + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
