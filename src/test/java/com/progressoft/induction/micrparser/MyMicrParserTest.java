package com.progressoft.induction.micrparser;

import exceptions.MicrParserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMicrParserTest {

    private static final String OMAN_MICR = "<00002019<:02=0003:00000010220474< 001";
    private static final String UAE_MICR = "<001590:013320143:<5003352420<";
    private static final String BAHRAIN_MICR = "<000013<09=01:0001077181611<01";

    private static final String OMAN_REGEX = "^<(\\d{8})<:(\\d{2})=(\\d{4}):(\\d{14})< (\\d+)?";
    private static final String UAE_REGEX = "^<(\\d{6}):\\d\\d(\\d{2})(\\d{5}):<(\\d{10})<(\\d+)?";
    private static final String BAHRAIN_REGEX = "^<(\\d{6})<(\\d{2})=(\\d{2}):(\\d{13})<\\d\\d(\\d+)?";

    private MicrParser parser;

    @BeforeEach
    void setUp() {
    }

    @Test
    void omanMicrWhileChequeDigitIsNotNull_parseTest() {

        parser = new MyMicrParser(OMAN_REGEX);
        MicrInfo result = parser.parse(OMAN_MICR);

        Assertions.assertEquals("00002019", result.getChequeNumber());
        Assertions.assertEquals("02", result.getBankCode());
        Assertions.assertEquals("0003", result.getBranchCode());
        Assertions.assertEquals("00000010220474", result.getAccountNumber());
        Assertions.assertEquals("001", result.getChequeDigit());
    }

    @Test
    void uaeMicrWhileChequeDigitIsNull_parseTest() {

        parser = new MyMicrParser(UAE_REGEX);
        MicrInfo result = parser.parse(UAE_MICR);

        Assertions.assertEquals("001590", result.getChequeNumber());
        Assertions.assertEquals("33", result.getBankCode());
        Assertions.assertEquals("20143", result.getBranchCode());
        Assertions.assertEquals("5003352420", result.getAccountNumber());
        Assertions.assertNull(result.getChequeDigit());
    }

    @Test
    void bahrainMicrWhileChequeDigitIsNull_parseTest() {

        parser = new MyMicrParser(BAHRAIN_REGEX);
        MicrInfo result = parser.parse(BAHRAIN_MICR);

        Assertions.assertEquals("000013", result.getChequeNumber());
        Assertions.assertEquals("09", result.getBankCode());
        Assertions.assertEquals("01", result.getBranchCode());
        Assertions.assertEquals("0001077181611", result.getAccountNumber());
        Assertions.assertNull(result.getChequeDigit());
    }

    @Test
    void givenInvalidMicr_whenParse_thenShouldThrowException() {

        parser = new MyMicrParser(OMAN_REGEX);

        Assertions.assertThrows(MicrParserException.class,
                () -> parser.parse("<00002019<:02=0003:"));
    }
}
