package com.progressoft.induction.micrparser;

import exceptions.MicrParserException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMicrParser implements MicrParser {

    private final String REGEX;
    private static final int NUMBER_OF_FIELDS = 5;
    private static final MicrInfo micrInfo = new MicrInfo();

    MyMicrParser(String REGEX) {
        this.REGEX = REGEX;
    }

    private Matcher micrMatcher(String micr) {
        Pattern pattern = Pattern.compile(REGEX);
        return pattern.matcher(micr);
    }

    private String[] getMicrValues(Matcher matcher) {
        String[] values = new String[5];
        if (matcher.find()) {
            for (int i = 0; i < values.length; i++) {
                values[i] = matcher.group(i + 1);
                System.out.println(values[i]); //Just To Test
            }
        }
        else {
            throw new MicrParserException("Invalid micr");
        }
        //isValidNumberOfFields();
        return values;
    }

    private void isValidNumberOfFields(int numberOfFields) {
        if (numberOfFields != NUMBER_OF_FIELDS) {
            throw new MicrParserException("Invalid No. Of Fields");
        }
    }

    @Override
    public MicrInfo parse(String micr) {

        Matcher matcher = micrMatcher(micr);
        String[] values = getMicrValues(matcher);

        String chequeNumber = values[0];
        micrInfo.setChequeNumber(chequeNumber);

        String bankCode = values[1];
        micrInfo.setBankCode(bankCode);

        String branchCode = values[2];
        micrInfo.setBranchCode(branchCode);

        String accountNumber = values[3];
        micrInfo.setAccountNumber(accountNumber);

        String chequeDigit = values[4];
        micrInfo.setChequeDigit(chequeDigit);

        return micrInfo;
    }
}
