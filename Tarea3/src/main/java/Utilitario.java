public class Utilitario {

    public static void wait(int time){
        time= time*1000;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void imprimir (String mensaje){
        System.out.println(mensaje);
    }
}
