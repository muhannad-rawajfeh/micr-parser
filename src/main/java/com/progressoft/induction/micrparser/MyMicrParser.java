package com.progressoft.induction.micrparser;

public class MyMicrParser implements MicrParser {

    private static final MicrInfo micrInfo = new MicrInfo();

    @Override
    public MicrInfo parse(String micr) {

        String[] micrSplitted = micr.split("<|:|=| ");

        micrInfo.setChequeNumber(micrSplitted[1]);
        micrInfo.setBankCode(micrSplitted[3]);
        micrInfo.setBranchCode(micrSplitted[4]);
        micrInfo.setAccountNumber(micrSplitted[5]);
        micrInfo.setChequeDigit(micrSplitted[7]);

        return micrInfo;
    }
}
