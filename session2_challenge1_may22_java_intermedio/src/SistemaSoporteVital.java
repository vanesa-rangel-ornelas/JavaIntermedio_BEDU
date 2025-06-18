import java.util.concurrent.Callable;
public class SistemaSoporteVital implements Callable<String>{
    //sobreescribir el metodo que Callable trae por defecto
    @Override
    public String call(){
        return "presión y oxígeno dentro de parámetros normales.";
    }
}