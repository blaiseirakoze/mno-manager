package biz.galaxygroup.atn.mno.models;

public class SuccessResponse {
    private String message = "action well performed";

    public SuccessResponse() {
    }

    public SuccessResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
