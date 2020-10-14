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
        int index = 0;
        while (matcher.find()) {
            values[index] = matcher.group(index + 1);
            System.out.println(values[index]); //Just To Test
            index++;
        }
        //isValidNumberOfFields(index);
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

    public static void main(String[] args) {
        MicrParser parser = new MyMicrParser("^<(\\d{8})<:(\\d{2})=(\\d{4}):(\\d{14})< (\\d+)?");
        parser.parse("<00002019<:02=0003:00000010220474< 001");
    }
}
