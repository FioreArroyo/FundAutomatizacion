public class Aplicacion {
    private String url;
    private String browser;


    private Selenium selenium = new Selenium(url, browser);
    private  int time = 5;

    public void iniciarBrowser(String browser){
        selenium.abrirBrowser(browser);
    }

    public void irUrl(String url){
        selenium.abrirUrl(url);
        Utilitario.wait(time);
    }

    public void cerrarBrowser(){
        selenium.cerrarBrowser();
    }


}
