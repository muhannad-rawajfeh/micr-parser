package com.progressoft.induction.micrparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMicrParserTest {

    private static final String MICR = "<00002019<:02=0003:00000010220474< 001";
    private MyMicrParser parser;

    @BeforeEach
    void setUp() {
        parser = new MyMicrParser();
    }

    @Test
    void check_chequeNumber() {
        MicrInfo result = parser.parse(MICR);
        Assertions.assertEquals("00002019", result.getChequeNumber());
    }

    @Test
    void check_bankCode() {
        MicrInfo result = parser.parse(MICR);
        Assertions.assertEquals("02", result.getBankCode());
    }

    @Test
    void check_branchCode() {
        MicrInfo result = parser.parse(MICR);
        Assertions.assertEquals("0003", result.getBranchCode());
    }

    @Test
    void check_accountNumber() {
        MicrInfo result = parser.parse(MICR);
        Assertions.assertEquals("00000010220474", result.getAccountNumber());
    }

    @Test
    void check_chequeDigit() {
        MicrInfo result = parser.parse(MICR);
        Assertions.assertEquals("001", result.getChequeDigit());
    }
}
