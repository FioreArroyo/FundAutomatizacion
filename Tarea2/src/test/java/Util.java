import org.testng.Reporter;

public class Util {
    public static void imprimir(String mensaje){
        System.out.println(mensaje);
        Reporter.log(mensaje);
    }
}
