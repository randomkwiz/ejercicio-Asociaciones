/*
* Nombre: CentroAcogidaImpl
* Clase padre: interfaces.Asociacion
* Propiedades:
*       Adicionales:
*              -Calificacion caracter, consultable y modificable (O optima, N normal, G grave, D desesperada)
*              -Guerra caracter (s/n), consultable y modificable
*
* Restricciones: totalAcogidos estara entre 10 y 300
*                   calificacion es un caracter O, N, G o D
*                   guerra es s o n
*
* Representacion como cadena:
* Los del padre y los suyos propios
*
* Constructor: un unico constructor con parametros
*
* Metodos interface:
*   public char getCalificacion();
    public void setCalificacion(char calificacion) ;
    public char getGuerra() ;
    public void setGuerra(char guerra);
    public int getTotalAcogidos() ;
    public void setTotalAcogidos(int totalAcogidos);
* */
package interfaces;
public interface CentroAcogida {
    public char getCalificacion();
    public void setCalificacion(char calificacion) ;
    public char getGuerra() ;
    public void setGuerra(char guerra);
    public int getTotalAcogidos() ;
    public void setTotalAcogidos(int totalAcogidos);

}
