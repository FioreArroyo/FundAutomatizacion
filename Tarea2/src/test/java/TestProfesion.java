import org.testng.annotations.*;

public class TestProfesion {

    Profesion prof;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        Util.imprimir("**Vamos a empezar la ejecucion de la aplicacion en Persona y Profesion**");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        Util.imprimir("**Fin de la ejecucion de la aplicacion en Persona y Profesion**");
    }



    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        Util.imprimir("--Inicio de la ejecucion del escenario Profesion--");
    }

    @AfterClass(alwaysRun = true)
    public void AfterClass(){
        Util.imprimir("--Fin de la ejecucion del escenario Profesion--");
    }



    @Parameters({"profesion"})
    @Test(priority = 1, groups = {"Smoke"})
    public void crearProfesion(String profesion){
        prof = new Profesion(profesion);
        Util.imprimir("Se creo la profesion");
    }


    @Test(dependsOnMethods = {"crearProfesion"}, groups = {"Smoke"})
    public void obtenerEjerceLugar(){
        String profesion = prof.getProfesion();
        String lugarEjerce = prof.getLugarEjerce(profesion);
        Util.imprimir("La persona ejerce en una: " + lugarEjerce);
    }

}

