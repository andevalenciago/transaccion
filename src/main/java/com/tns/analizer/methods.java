package com.tns.analizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class methods {

   private BufferedReader reader = null;
   private String[] lineas;

   Map retorno;
   Map<String, Integer> montos_cat =  new HashMap<>();
   private int monto_total;
    Date fecha;
   private int enero_suma;
   private int maximo_gasto;
   private String caeg_max_gasto;


public  Map mapeo(String Ruta)
{
    try {
        reader = new BufferedReader(new FileReader(Ruta) );  //le entrego el archivo a leer al br creado.
        String LineaActual = reader.readLine();
        SimpleDateFormat formato_fecha = new SimpleDateFormat("dd-MM-yyyy");

        while(LineaActual!=null)
        {

            lineas = LineaActual.split(",");

            setMonto_total(getMonto_total() + Integer.parseInt(lineas[1]));


// suma enero


           fecha = formato_fecha.parse(lineas[0]);

           if(fecha.after(formato_fecha.parse("31-12-2017")) && fecha.before(formato_fecha.parse("01-02-2018")))
           {
               setEnero_suma(getEnero_suma()+ Integer.parseInt(lineas[1]));

           }

//hallar categoría con mayor gasto

            if(montos_cat.get(lineas[2])==null)
            {
                montos_cat.put(lineas[2].toString(), Integer.parseInt(lineas[1]));
            }else if (montos_cat.get(lineas[2]) < 0) {



                    setMaximo_gasto(montos_cat.get(lineas[2]) + Integer.parseInt(lineas[1]));
                    setCaeg_max_gasto(lineas[2]);


                }




            LineaActual = reader.readLine();


        }











        return retorno;

    } catch (IOException | ParseException e) {
        e.printStackTrace();
        return null;
    }

}

    public int obtenerMes(Date dateinicio, Date datefin)
    {



return getEnero_suma();
    }

    public int getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(int monto_total) {
        this.monto_total = monto_total;
    }

    public int getEnero_suma() {
        return enero_suma;
    }

    public void setEnero_suma(int enero_suma) {
        this.enero_suma = enero_suma;
    }

    public int getMaximo_gasto() {
        return maximo_gasto;
    }

    public void setMaximo_gasto(int maximo_gasto) {
        this.maximo_gasto = maximo_gasto;
    }

    public String getCaeg_max_gasto() {
        return caeg_max_gasto;
    }

    public void setCaeg_max_gasto(String caeg_max_gasto) {
        this.caeg_max_gasto = caeg_max_gasto;
    }
}
