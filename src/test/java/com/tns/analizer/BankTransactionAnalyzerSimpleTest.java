package com.tns.analizer;

import org.junit.Test;

public class BankTransactionAnalyzerSimpleTest {

    @Test
    public void mustReadFile(){
        BankTransactionAnalyzerSimple analizer = new BankTransactionAnalyzerSimple();
        analizer.execute();
    }
}
