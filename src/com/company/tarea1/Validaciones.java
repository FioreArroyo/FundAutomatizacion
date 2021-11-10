package com.company.tarea1;

import java.util.regex.Pattern;

public class Validaciones {
    public static Resultado esValido(String monto, String montoFormato) {
        Resultado r = new Resultado();
        if (!esNumero(monto)){
            r.esValido = false;
            r.mensaje = "El monto debe ser numérico. Utilice una coma para separar los miles";
        }
        else  if (!esMtoPositivo(monto)){
            r.esValido = false;
            r.mensaje = "El monto debe ser mayor a 0";
        }
        else  if (!maximoMtoPermitido(monto)){
            r.esValido = false;
            r.mensaje = "El monto debe ser menor a 999,999,999.99";
        }
        else  if (!esFormatoValido(montoFormato)){
            r.esValido = false;
            r.mensaje = "Solamente se permiten 2 decimales";
        }
        else {
            r.esValido = true;
            r.mensaje = null;
        }

        return  r;
    }

    public static boolean esFormatoValido(String str)
    {

        if (Pattern.matches("\\d{1,9},\\d{1,2}", str)) {
            return  true;
        }
        else {
            return  false;
        }
    }


    private static boolean esNumero(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private static boolean esMtoPositivo(String str)
    {
        try
        {
            double mto = Double.parseDouble(str);
            if (mto > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }


    private static boolean maximoMtoPermitido(String str)
    {
        try
        {
            double mto = Double.parseDouble(str);
            if (mto > 999999999.99){
                return false;
            }
            else{
                return true;
            }
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
    }
}

