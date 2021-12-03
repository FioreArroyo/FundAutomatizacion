package com.company.tarea1;
import java.util.regex.Pattern;

public class Implementacion {
    private final String[] UNIDADES = {"", "un ", "dos ", "tres ", "cuatro ", "cinco ", "seis ", "siete ", "ocho ", "nueve "};
    private final String[] DECENAS = {"diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
            "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
            "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "};
    private final String[] CENTENAS = {"", "ciento ", "doscientos ", "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
            "setecientos ", "ochocientos ", "novecientos "};


    public String  Convertir(String numero) {
        String numeroEnLetras = "";
        String parte_decimal;

        //si el numero viene negativo, elimina el (-).
        numero= numero.replace("-", "");

        //si el numero viene con separador de miles (,) elimina la coma.
        String numeroSinSeparadorDeMiles = numero.replace(",", "");

        //si el numero utiliza (.) en lugar de (,) -> se reemplaza, para manejar los decimales con coma
        numero= numeroSinSeparadorDeMiles.replace(".", ",");

        // Si el numero viene sin decimales asigna un ,00
        if(numero.indexOf(",")==-1){
            numero = numero + ",00";
        }

        numero = numero.replaceAll("^0+", "");

        Resultado resultado =  Validaciones.esValido(numeroSinSeparadorDeMiles, numero);
        if (resultado.esValido){
            String Num[] = numero.split(",");

            //de da formato al numero decimal
            parte_decimal = "con "+ Num[1] + " centimos";

            //se convierte el numero a numeroEnLetras
            if (Integer.parseInt(Num[0]) > 999999) {//si es millon
                numeroEnLetras = getMillones(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 999) {//si es miles
                numeroEnLetras = getMiles(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 99) {//si es centena
                numeroEnLetras = getCentenas(Num[0]);
            } else if (Integer.parseInt(Num[0]) > 9) {//si es decena
                numeroEnLetras = getDecenas(Num[0]);
            } else {//sino unidades -> 9
                numeroEnLetras = getUnidades(Num[0]);
            }
            return (numeroEnLetras + parte_decimal).toUpperCase();
        }
        else
        {
            return resultado.mensaje;
        }
    }

    /* funciones para convertir los numeros a letras */
    private String getUnidades(String numero) {// 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        String num = numero.substring(numero.length() - 1);
        return UNIDADES[Integer.parseInt(num)];
    }

    private String getDecenas(String num) {// 99
        int n = Integer.parseInt(num);
        if (n < 10) {//para casos como -> 01 - 09
            return getUnidades(num);
        } else if (n > 19) {//para 20...99
            String u = getUnidades(num);
            if (u.equals("")) { //para 20,30,40,50,60,70,80,90
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8];
            } else {
                return DECENAS[Integer.parseInt(num.substring(0, 1)) + 8] + "y " + u;
            }
        } else {//numeros entre 11 y 19
            return DECENAS[n - 10];
        }
    }

    private String getCentenas(String num) {// 999 o 099
        if( Integer.parseInt(num)>99 ){//es centena
            if (Integer.parseInt(num) == 100) {//caso especial
                return " cien ";
            } else {
                return CENTENAS[Integer.parseInt(num.substring(0, 1))] + getDecenas(num.substring(1));
            }
        }else{//por Ej. 099
            //se quita el 0 antes de convertir a decenas
            return getDecenas(Integer.parseInt(num)+"");
        }
    }

    private String getMiles(String numero) {// 999 999
        //obtiene las centenas
        String c = numero.substring(numero.length() - 3);
        //obtiene los miles
        String m = numero.substring(0, numero.length() - 3);
        String n="";
        //se comprueba que miles tenga valor entero
        if (Integer.parseInt(m) == 1 ) {
            n = getCentenas(m);
            return  "mil " + getCentenas(c);
        }
        else if  (Integer.parseInt(m) > 1) {
            n = getCentenas(m);
            return n + "mil " + getCentenas(c);
        }
        else {
            return "" + getCentenas(c);
        }

    }


    private String getMillones(String numero) { //000 000 000
        //se obtiene los miles
        String miles = numero.substring(numero.length() - 6);
        //se obtiene los millones
        String millon = numero.substring(0, numero.length() - 6);
        String n = "";
        if(millon.length()>1){
            n = getCentenas(millon) + "millones ";
        }else{
            n = getUnidades(millon) + "millon ";
        }
        return n + getMiles(miles);
    }

}