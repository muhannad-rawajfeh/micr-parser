package com.progressoft.induction.micrparser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMicrParserTest {

    private static final String OMAN_MICR = "<00002019<:02=0003:00000010220474< 001";
    private static final String UAE_MICR = "<001590:013320143:<5003352420<";
    //private static final String BAHRAIN_MICR = "<000013<09=01:0001077181611<01";

    private MyMicrParser parser;

    @BeforeEach
    void setUp() {
        parser = new MyMicrParser("<|:|=| ");
    }

    @Test
    void check_oman_micr_parsing() {
        MicrInfo result = parser.parse(OMAN_MICR);
        Assertions.assertEquals("00002019", result.getChequeNumber());
        Assertions.assertEquals("02", result.getBankCode());
        Assertions.assertEquals("0003", result.getBranchCode());
        Assertions.assertEquals("00000010220474", result.getAccountNumber());
        Assertions.assertEquals("001", result.getChequeDigit());
    }

    @Test
    void check_uae_micr_parsing() {
        MicrInfo result = parser.parse(UAE_MICR);
        Assertions.assertEquals("001590", result.getChequeNumber());
        //Assertions.assertEquals("33", result.getBankCode());
        //Assertions.assertEquals("20143", result.getBranchCode());
        //Assertions.assertEquals("5003352420", result.getAccountNumber());
        //Assertions.assertNull(result.getChequeDigit());
    }
}
