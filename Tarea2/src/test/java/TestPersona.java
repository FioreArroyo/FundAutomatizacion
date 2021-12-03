import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestPersona {
    Persona persona;
    Profesion prof;
    SoftAssert soft = new SoftAssert();

    @Parameters({"nombre","edad", "profesion"})
    @Test(priority = 1, groups = {"Smoke"})
    //@Test(priority = 1)
    public void crearPersona(String nombre, int edad, String profesion){
        prof = new Profesion(profesion);
        persona = new Persona(nombre, edad, prof);
    }

    @Test(priority = 2, groups = {"Smoke"})
    public void obtenerNombre(){
        String nombrePersona = persona.getNombre();
        Util.imprimir("El nombre es de la persona es: " + nombrePersona);
    }

    @Test(priority = 3, groups = {"Smoke"})
    public void obtenerProfesion(){
        String profesion = prof.getProfesion();
        Util.imprimir("La profesion de la persona es: " + profesion);
    }



    @Test(priority = 4, groups = {"Other"})
    public void validarEdad(){
        Util.imprimir("Vamos a validar la Edad");
        Assert.assertTrue(persona.validarEdad(persona.edad), "La persona no tiene una edad valida ");
        Util.imprimir("VP Pass: La edad es valida");
    }

    @Test(priority = 5, groups = {"Other"})
    public void validarNombre(){
        Util.imprimir("Vamos a validar si el nombre es correcto");
        soft.assertTrue(persona.validarTamanoNombre(persona.nombre), "El nombre no debe superar los 20 caracteres");
        Util.imprimir("VP Pass: El nombre es valido");
        soft.assertAll();
    }

}

