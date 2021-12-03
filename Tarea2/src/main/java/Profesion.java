public class Profesion {
    String profesion;
    String lugarEjerce;

    public Profesion(String profesion){
        if(profesion!=null ){
            this.profesion=profesion;
        }else {
            throw new IllegalArgumentException("No se pudo instanciar el objeto:Error de entrada de argumentos");
        }
    }


    public String getLugarEjerce(String profesion) {
        profesion = profesion.toLowerCase();

        switch (profesion) {

            case "estudiante":
                lugarEjerce="Instituto";
                break;
            case "profesor":
                lugarEjerce="Academia";
                break;
            case "abogado":
                lugarEjerce="Corte";
                break;
            case "doctor":
                lugarEjerce="Hospital";
                break;
            case "agricultor":
                lugarEjerce="Campo";
                break;
            case "piloto":
                lugarEjerce="Aeropuerto";
                break;

            default:
                profesion = null;
                //lugarEjerce=null;
                lugarEjerce="La profesion no existe";
                break;
        }
        return lugarEjerce;
    }




    public String getProfesion() {

        return profesion;
    }

}
