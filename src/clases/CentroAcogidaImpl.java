package clases;
import interfaces.CentroAcogida;

/*
* Nombre: CentroAcogidaImpl
* Clase padre: interfaces.Asociacion
* Propiedades:
*       Adicionales:
*              -Calificacion caracter, consultable y modificable (O optima, N normal, G grave, D desesperada)
*              -Guerra caracter (s/n), consultable y modificable
*       Redefinidas:
*              -totalAcogidos consultable y modificable, entre 10 y 300
*
* Restricciones: totalAcogidos estara entre 10 y 300
*                   calificacion es un caracter O, N, G o D
*                   guerra es s o n
*
* Representacion como cadena:
* Los del padre y los suyos propios
*
* Constructor: un unico constructor con parametros
* */
public class CentroAcogidaImpl extends AsociacionImpl implements CentroAcogida {

    private char calificacion;
    private char guerra;


    /*Constructor: un unico constructor con parametros*/
    public CentroAcogidaImpl(String pais, String nombre, int totalAcogidos, int numeroVoluntarios,char calificacion, char guerra) {
        super(pais, nombre, totalAcogidos, numeroVoluntarios);
        this.calificacion = calificacion;
        this.guerra = guerra;
    }

    /*setters y getters*/
    public char getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(char calificacion) {
        this.calificacion = calificacion;
    }

    public char getGuerra() {
        return guerra;
    }

    public void setGuerra(char guerra) {
        this.guerra = guerra;
    }

   /* @Override
    public int getTotalAcogidos() {
        return totalAcogidos;
    }

    @Override
    public void setTotalAcogidos(int totalAcogidos) {
        this.totalAcogidos = totalAcogidos;
    }
*/
    @Override
    public String toString() {
        return  super.toString()+"\n" +
                + calificacion +
                ", " + guerra
                ;
    }
}
