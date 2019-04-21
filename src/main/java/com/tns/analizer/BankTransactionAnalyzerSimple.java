package com.tns.analizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionAnalyzerSimple extends methods {

    private static final String FILE = "src/test/resources/transactions.csv";

    BufferedReader reader = null;

    public void execute() {


        try{

        mapeo(FILE);



            System.out.println("El monto de enero es" + getEnero_suma());
            if (getMonto_total() >= 0) {
                System.out.println("El monto de la cuenta es positivo: $" + getMonto_total());
            } else {
                System.out.println("El monto de la cuenta es negativo: $" + getMonto_total());

            }

            System.out.println("La categoría con más gasto es: $" + getCaeg_max_gasto() + "con" + getMaximo_gasto());



        }catch (Exception e){
            System.out.println("Error...");
            System.out.println(e.getMessage());
        }

    }

}




