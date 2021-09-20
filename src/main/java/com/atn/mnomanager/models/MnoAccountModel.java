package com.atn.mnomanager.models;

public class MnoAccountModel {
    private String mnoProfileId;
    private String accountId;
    private int isNormalAccount;

    public String getMnoProfileId() {
        return mnoProfileId;
    }

    public void setMnoProfileId(String mnoProfileId) {
        this.mnoProfileId = mnoProfileId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getIsNormalAccount() {
        return isNormalAccount;
    }

    public void setIsNormalAccount(int isNormalAccount) {
        this.isNormalAccount = isNormalAccount;
    }
}
