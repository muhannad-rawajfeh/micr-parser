package com.progressoft.induction.micrparser;

public class MicrInfo {

    private String chequeNumber;
    private String bankCode;
    private String branchCode;
    private String accountNumber;
    private String chequeDigit;

    public String getChequeNumber() {
        return chequeNumber;
    }

    public void setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getChequeDigit() {
        return chequeDigit;
    }

    public void setChequeDigit(String chequeDigit) {
        this.chequeDigit = chequeDigit;
    }

    public void setAll(String chequeNumber, String bankCode, String branchCode,
                       String accountNumber, String chequeDigit) {
        this.chequeNumber = chequeNumber;
        this.bankCode = bankCode;
        this.branchCode = branchCode;
        this.accountNumber = accountNumber;
        this.chequeDigit = chequeDigit;
    }
}
