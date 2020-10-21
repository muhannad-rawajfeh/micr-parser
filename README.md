What is MICR?
- MICR stands for Magnetic Ink Character Recognition.
- MICR is a process by which documents are printed using magnetic ink/toner and special fonts to create machine-readable information for quick processing of paper-based payments. 
- The line of numbers and characters that make up the MICR line is printed in the the bottom edge of a check.

![micr](https://user-images.githubusercontent.com/70616946/96759235-6bf8c680-13e0-11eb-97f6-4b6d336add4c.png)


What you need to do is to be able to read the micr and extract the check fields from it.

the following cheque has this micr: ``<00002019<:02=0003:00000010220474< 001``

![micr](https://user-images.githubusercontent.com/70616946/96759289-803cc380-13e0-11eb-9ac9-dc5a56e99dbb.jpg)


you need to extract:
- cheque number: 00002019
- bank code: 02
- branch code: 0003
- account number: 00000010220474
- cheque digits: 001

you will save these fields in MicrInfo object after parsing it.

```java
class MicrInfo {

    private String chequeNumber;
    private String bankCode;
    private String branchCode;
    private String accountNumber;
    private String chequeDigit;
}
```

Implement the following interface:
```java
public interface MicrParser {

    MicrInfo parse(String micr);

}
```

--------------------
and for the following uae micr : ``<001590:013320143:<5003352420<``

you need to extract:
- cheque number: 001590
- bank code: 33
- branch code: 20143
- account number: 5003352420
- cheque digits: null

and for the following Bahrain micr: ``<000013<09=01:0001077181611<01``

you need to extract:
- cheque number: 000013
- bank code: 09
- branch code: 01
- account number: 0001077181611
- cheque digits: null

--------------------
Notes: you need to write this task using TDD techniques

[TDD](https://www.freecodecamp.org/news/test-driven-development-what-it-is-and-what-it-is-not-41fa6bca02a2/)


[Matcher](http://tutorials.jenkov.com/java-regex/matcher.html)
