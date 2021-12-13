import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ProbarAplicacion {

    private Aplicacion app = new Aplicacion();
    private Utilitario util = new Utilitario();
    public String titulo = "ToolsQA";

    @Parameters({"browser"})
    @BeforeTest
    public void lanzarBrowser(String browser){
        app.iniciarBrowser(browser);
        util.imprimir("Abriendo el browser " + browser);
    }

    @Parameters({"url"})
    @Test(priority = 1)
    public void probarDemoqa(String url){
        app.irUrl(url);
        util.imprimir("Abriendo la URL "+ url);
        util.wait(5);
    }


    @AfterTest
    public void liberarBrowser(){
        app.cerrarBrowser();
        util.imprimir("Cerrando el browser");
    }

}
