package biz.galaxygroup.atn.mno.models;

public class MnoProductModel {
    private String atnProductId;
    private String mnoProfileId;

    public String getAtnProductId() {
        return atnProductId;
    }

    public void setAtnProductId(String atnProductId) {
        this.atnProductId = atnProductId;
    }

    public String getMnoProfileId() {
        return mnoProfileId;
    }

    public void setMnoProfileId(String mnoProfileId) {
        this.mnoProfileId = mnoProfileId;
    }

    @Override
    public String toString() {
        return "MnoProductModel{" +
                "atnProductId='" + atnProductId + '\'' +
                ", mnoProfileId='" + mnoProfileId + '\'' +
                '}';
    }
}
