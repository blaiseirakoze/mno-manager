package biz.galaxygroup.atn.mno.models;

public class SuccessResponseModel {
    private String status;
    private String message = "action well performed";

    public SuccessResponseModel() {
    }

    public SuccessResponseModel(String message) {
        this.message = message;
    }

    public SuccessResponseModel(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
