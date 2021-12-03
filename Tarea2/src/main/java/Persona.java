public class Persona {

    String nombre;
    int edad;
    Profesion profe;

    public Persona(String nombre,int edad,Profesion profe){
        if(nombre!=null && edad!=0 && profe !=null ){
            this.nombre = nombre;
            this.edad=edad;
            this.profe=profe;
        }else {
            throw new IllegalArgumentException("No se pudo instanciar el objeto:Error de entrada de argumentos");
        }
    }


    public String getNombre(){
        return nombre;
    }

    public Profesion getProfesion (){
        return profe;
    }

    public boolean validarTamanoNombre (String nombre ){
        int tamano =  nombre.length();
        if (tamano>20){
            return false;
        }
        else return true;
    }

    public boolean validarEdad (int edad ){
        if (edad > 0 && edad < 150){
            return  true;
        }
        else return false;
    }


}

