package biz.galaxygroup.atn.mno.models;

import java.util.Date;

public class ProductFilterModel {
    private String mnoProfile;
    private String atnProduct;
    private Date creationTime;

    public ProductFilterModel() {
    }

    public ProductFilterModel(String mnoProfile, String atnProduct) {
        this.mnoProfile = mnoProfile;
        this.atnProduct = atnProduct;
    }

    public ProductFilterModel(String mnoProfile, String atnProduct, Date creationTime) {
        this.mnoProfile = mnoProfile;
        this.atnProduct = atnProduct;
        this.creationTime = creationTime;
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

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "ProductFilterModel{" +
                "mnoProfile='" + mnoProfile + '\'' +
                ", atnProduct='" + atnProduct + '\'' +
                ", creationTime=" + creationTime +
                '}';
    }
}
