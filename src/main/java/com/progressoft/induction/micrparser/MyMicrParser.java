package com.progressoft.induction.micrparser;

public class MyMicrParser implements MicrParser {

    private final String regex;
    private static final MicrInfo micrInfo = new MicrInfo();

    MyMicrParser(String regex) {
        this.regex = regex;
    }

    @Override
    public MicrInfo parse(String micr) {

        String[] micrSplitted = micr.split(regex);

        String chequeNumber = micrSplitted[1];
        micrInfo.setChequeNumber(chequeNumber);

        String bankCode = micrSplitted[3];
        micrInfo.setBankCode(bankCode);

        String branchCode = micrSplitted[4];
        micrInfo.setBranchCode(branchCode);

        String accountNumber = micrSplitted[5];
        micrInfo.setAccountNumber(accountNumber);

        String chequeDigit = micrSplitted[7];
        micrInfo.setChequeDigit(chequeDigit);

        return micrInfo;
    }
}
