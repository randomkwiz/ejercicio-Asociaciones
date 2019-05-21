package interfaces;

/*
 * Nombre: interfaces.CentroAcogida
 * Clase padre: interfaces.Asociacion
 * Propiedades:
 *       Adicionales:
 *              -Calificacion caracter, consultable y modificable (O optima, N normal, G grave, D desesperada)
 *              -Guerra caracter (s/n), consultable y modificable
 *       Redefinidas:
 *              -totalAcogidos consultable y modificable, entre 10 y 300
 * Restricciones: totalAcogidos estara entre 10 y 300
 *
 * Representacion como cadena:
 *
 * Los del padre y los suyos propios
 *
 * Constructor: un unico constructor con parametros
 * */
public interface CentroAcogida {
    public char getCalificacion();

    public void setCalificacion(char calificacion) ;
    public char getGuerra() ;

    public void setGuerra(char guerra);
    public int getTotalAcogidos() ;


    public void setTotalAcogidos(int totalAcogidos);

}
