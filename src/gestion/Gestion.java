package gestion;

import clases.AsociacionImpl;
import clases.CentroAcogidaImpl;
import utilidad.Utilidades;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Gestion {
    /*
    * INTERFAZ
    * Comentario: Dado un string, lo convierte a un objeto de la clase CentroAcogidaImpl
    * Signatura: public CentroAcogidaImpl toObject (String cadena)
    * Precondiciones:
    * Entradas: String cadena que sera el objeto hecho cadena
    * Salidas: objeto tipo CentroAcogidaImpl
    * Entrada/Salida:
    * Postcondiciones: Asociado al nombre se devolvera un objeto de clase CentroAcogidaImpl o null si hay algun error
    * */
    public CentroAcogidaImpl toObject (String cadena){
        CentroAcogidaImpl centro = null;
        String pais = cadena.split(",")[0];
        String nombre = cadena.split(",")[1];
        int totalAcogidos = Integer.parseInt(cadena.split(",")[2]);
        int numeroVoluntarios = Integer.parseInt(cadena.split(",")[3]);
        char calificacion = cadena.split(",")[4].charAt(0);
        char guerra = cadena.split(",")[5].charAt(0);

        centro = new CentroAcogidaImpl(pais, nombre, totalAcogidos, numeroVoluntarios,calificacion, guerra);

        return centro;
    }

    /*
     * INTERFAZ
     * Comentario: Dado un string, lo convierte a un objeto de la clase AsociacionImpl
     * Signatura: public AsociacionImpl toObjectAsociacionImpl (String cadena)
     * Precondiciones:
     * Entradas: String cadena que sera el objeto hecho cadena
     * Salidas: objeto tipo CentroAcogidaImpl
     * Entrada/Salida:
     * Postcondiciones: Asociado al nombre se devolvera un objeto de clase CentroAcogidaImpl o null si hay algun error
     * */
    public AsociacionImpl toObjectAsociacionImpl (String cadena){
        AsociacionImpl as = null;
        String pais = cadena.split(",")[0];
        String nombre = cadena.split(",")[1];
        int totalAcogidos = Integer.parseInt(cadena.split(",")[2]);
        int numeroVoluntarios = Integer.parseInt(cadena.split(",")[3]);


        as = new AsociacionImpl(pais, nombre, totalAcogidos, numeroVoluntarios);

        return as;
    }

    /*
     * INTERFAZ
     * Comentario: Calcula el total de acogidos de un país
     * Signatura: public int calcularTotalAcogidosPais(String pais, String ruta)
     * Precondiciones:
     * Entradas: String pais que sera el pais del que calcularemos el total de acogidos
     *           String ruta que sera la ruta del fichero donde buscaremos
     * Salidas: entero que sera el total de acogido del pais, o bien -1 si hay algun error
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre se devolvera el numero total de acogidos de un pais, o bien -1 si hay algun error
     * */
    public int calcularTotalAcogidosPais(String pais, String ruta){

        File fichero = new File(ruta);
        int totalAcogidos = -1;
        FileReader fr = null;
        BufferedReader br = null;
        String registro = null;
        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            while (br.ready()){
                registro = br.readLine();
                if(registro.split(",")[0].equals(pais)){
                    if(totalAcogidos==-1){  //para no tener en cuenta el -1
                        totalAcogidos = Integer.parseInt(registro.split(",")[2]);
                    }else{
                        totalAcogidos += Integer.parseInt(registro.split(",")[2]);
                    }
                }


            }

            br.close();
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return totalAcogidos;
    }


    /*
     * INTERFAZ
     * Comentario: Ordena un fichero por país y nombre
     * Signatura: public boolean ordenarFicheroAsociacion(String ruta)
     * Precondiciones:
     * Entradas:
     *           String ruta que sera la ruta del fichero a ordenar
     * Salidas: boolean que sera true si ha ordenado correctamente y false si ha habido algun error
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre se devolvera true si ha ordenado correctamente y false si ha habido algun error
     * */
    public boolean ordenarFicheroAsociacion(String ruta){
        File fichero = new File(ruta);
        //ArrayList<AsociacionImpl> arrayObjetos = new ArrayList<AsociacionImpl>();
        ArrayList<CentroAcogidaImpl> arrayObjetos = new ArrayList<CentroAcogidaImpl>();
        Utilidades utilidades = new Utilidades();
        boolean exito = false;

        ArrayList<String> arrayRegistros = insertarRegistrosEnArrayList(ruta);
/*
        for(String elemento:arrayRegistros){
            arrayObjetos.add(toObjectAsociacionImpl(elemento));
        }
*/
        Collections.sort(arrayRegistros);
        //utilidades.ordenarArrayList(arrayObjetos);
     /*   arrayRegistros.clear();
        for(AsociacionImpl elemento:arrayObjetos){
            arrayRegistros.add(elemento.toString());
        }
*/
/*
        Collections.sort(arrayRegistros);

 */
        fichero.delete();

        //System.out.println("Size array registros: "+arrayRegistros.size());
        insertarArrayListEnFicheroTexto(arrayRegistros,ruta);
        exito = true;
        return exito;
    }

    /*
     * INTERFAZ
     * Comentario: Mete en un arraylist los registros de un fichero de texto
     * Signatura: public ArrayList<String> insertarRegistrosEnArrayList(String ruta)
     * Precondiciones:
     * Entradas:
     *           String ruta que sera la ruta del fichero a insertar en el arraylist
     * Salidas:ArrayList<String> con los registros insertados o vacío si no hay registros
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre se devolvera ArrayList<String> con los registros insertados o vacío si no hay registros
     * */
    public ArrayList<String> insertarRegistrosEnArrayList(String ruta){

        File fichero = new File(ruta);
        FileReader fr = null;
        BufferedReader br = null;
        String registro = null;
        ArrayList<String> arrayRegistros = new ArrayList<String>();
        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            if(br.ready()){
                registro = br.readLine();
                registro = registro.substring(1,registro.length());
                arrayRegistros.add(registro);
            }
            while (br.ready()){
                registro = br.readLine();
                arrayRegistros.add(registro);
            }

            br.close();
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return arrayRegistros;
    }

    /*
     * INTERFAZ
     * Comentario: Mete en un arraylist los registros de un fichero de texto
     * Signatura: public boolean insertarArrayListEnFicheroTexto(ArrayList<String> array, String ruta)
     * Precondiciones:
     * Entradas:
     *          ArrayList<String> con los registros a insertar en el fichero
     *          String ruta que sera la ruta del fichero donde insertaremos los registros
     * Salidas: boolean que sera true si se han insertado los registros correctamente y false si no
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre se devolvera un boolean que sera true si se han insertado los registros correctamente y false si no
     * */
    public boolean insertarArrayListEnFicheroTexto(ArrayList<String> arrayRegistros, String ruta){

        File fichero = new File(ruta);
        FileWriter fw = null;
        BufferedWriter bw = null;
        String registro = null;
        boolean exito = false;
        try{
            fw = new FileWriter(fichero,true);
            bw = new BufferedWriter(fw);

            for(int i = 0; i < arrayRegistros.size(); i ++){
                bw.write(arrayRegistros.get(i));
                bw.newLine();
            }

            bw.close();
            fw.close();
            exito = true;
        }catch (IOException e){
            e.printStackTrace();
        }

        return exito;
    }

    /*
     * INTERFAZ
     * Comentario: Calcula el total de voluntarios de centros de acogida que no están en guerra.
     * Signatura: public int calcularNumeroVoluntariosEnPaisesPacificos(String ruta)
     * Precondiciones:
     * Entradas:
     *
     *          String ruta que sera la ruta del fichero donde miraremos
     * Salidas: int que sera la cantidad de voluntarios en paises pacificos (que no estan en guerra)
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre se devolvera la cantidad de voluntarios en paises que no estan en guerra o -1 si hay error
     * */
    public int calcularNumeroVoluntariosEnPaisesPacificos(String ruta){

        File fichero = new File(ruta);
        FileReader fr = null;
        BufferedReader br = null;
        String registro = null;
        int cantidad = -1;
        CentroAcogidaImpl centro = null;

        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            while (br.ready()){
                registro = br.readLine();
                centro = toObject(registro);
                if(centro.getGuerra() == 'n'){
                    if(cantidad==-1){  //para no tener en cuenta el -1
                        cantidad = centro.getNumeroVoluntarios();
                    }else{
                        cantidad += centro.getNumeroVoluntarios();
                    }
                }

            }

            br.close();
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return cantidad;
    }


    /*
     * INTERFAZ
     * Comentario: Calcula el total de voluntarios de centros de acogida que si están en guerra.
     * Signatura: public int calcularNumeroVoluntariosEnPaisesBelicos(String ruta)
     * Precondiciones:
     * Entradas:
     *
     *          String ruta que sera la ruta del fichero donde miraremos
     * Salidas: int que sera la cantidad de voluntarios en paises belicos (que si estan en guerra)
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre se devolvera la cantidad de voluntarios en paises que si estan en guerra o -1 si hay error
     * */
    public int calcularNumeroVoluntariosEnPaisesBelicos(String ruta){

        File fichero = new File(ruta);
        FileReader fr = null;
        BufferedReader br = null;
        String registro = null;
        int cantidad = -1;
        CentroAcogidaImpl centro = null;
        try{
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);

            while (br.ready()){
                registro = br.readLine();
                centro = toObject(registro);
                if(centro.getGuerra() == 's'){
                    if(cantidad==-1){  //para no tener en cuenta el -1
                        cantidad = Integer.parseInt(registro.split(",")[3]);
                    }else{
                        cantidad += Integer.parseInt(registro.split(",")[3]);
                    }
                }

            }

            br.close();
            fr.close();

        }catch (IOException e){
            e.printStackTrace();
        }

        return cantidad;
    }

    /*
     * INTERFAZ
     * Comentario: Imprima centros de acogida con una calificación elegida por el usuario
     * Signatura: public void imprimirCentroAcogidaPorCalificacion(String ruta, char calificacion)
     * Precondiciones:
     * Entradas:
     *
     *          String ruta que sera la ruta del fichero donde miraremos
     *          Char calificacion elegida por el usuario para filtrar
     * Salidas: nada porque imprimira en pantalla
     * Entrada/Salida:
     * Postcondiciones: imprime en pantalla
     * */
    public void imprimirCentroAcogidaPorCalificacion(String ruta, char calificacion){
        File fichero = new File(ruta);
        ArrayList<String> registros = insertarRegistrosEnArrayList(ruta);
        CentroAcogidaImpl centro = null;

        for(int i = 0; i < registros.size(); i ++){
            centro = toObject(registros.get(i));
            if(centro.getCalificacion() == calificacion){
                System.out.println(registros.get(i));
            }
        }

    }


    /*
     * INTERFAZ
     * Comentario: Imprime un listado de campos en guerra y el país al que pertenecen
     * Signatura: public void imprimirCentroAcogidaEnGuerraYPais(String ruta)
     * Precondiciones:
     * Entradas:
     *
     *          String ruta que sera la ruta del fichero donde miraremos
     *
     * Salidas: nada porque imprimira en pantalla
     * Entrada/Salida:
     * Postcondiciones: imprime en pantalla
     * */
    public void imprimirCentroAcogidaEnGuerraYPais(String ruta){
        File fichero = new File(ruta);
        ArrayList<String> registros = insertarRegistrosEnArrayList(ruta);
        CentroAcogidaImpl centro = null;
        for(int i = 0; i < registros.size(); i ++){
            centro = toObject(registros.get(i));
            if(centro.getGuerra() == 's'){
                System.out.println("Nombre centro acogida: "+centro.getNombre());
                System.out.println("Pais: "+centro.getPais());
            }
        }

    }

    /*
     * INTERFAZ
     * Comentario: Informe en pantalla con el total de voluntarios por país.
     * Signatura: public void imprimirTotalVoluntariosPorPais(String ruta)
     * Precondiciones:
     * Entradas:
     *
     *          String ruta que sera la ruta del fichero donde miraremos
     *
     * Salidas: nada porque imprimira en pantalla
     * Entrada/Salida:
     * Postcondiciones: imprime en pantalla
     * */
    public void imprimirTotalVoluntariosPorPais(String ruta){
        File fichero = new File(ruta);
        ArrayList<String> paises = new ArrayList<String>();
        ArrayList<String> registros = insertarRegistrosEnArrayList(ruta);
        int totalVoluntarios = 0;
        AsociacionImpl asociacion = null;

        for(int i = 0; i < registros.size(); i ++){

            if(!isEncontradoElementoEnArrayList(registros.get(i).split(",")[0], registros)){
                //guarda en el arraylist paises todos los paises sin repetirlos
                paises.add(registros.get(i).split(",")[0]);
            }
        }

        for(int i = 0; i < paises.size(); i ++){
            for(int j=0;  j < registros.size(); j ++ ){

                if(registros.get(j).split(",")[0].equals(paises.get(i)));
                totalVoluntarios += Integer.parseInt(registros.get(j).split(",")[3]);
            }
            System.out.println("Pais: "+paises.get(i));
            System.out.println("Total voluntarios: "+totalVoluntarios);
            totalVoluntarios= 0;

        }





    }

    /*
     * INTERFAZ
     * Comentario: Te dice si un elementro String ya está en un arraylist
     * Signatura: public boolean isEncontradoElementoEnArrayList(String elemento, ArrayList<String> arraylist)
     * Precondiciones:
     * Entradas:
     *
     *          String elemento que sera el elemento a buscar
     *          ArrayList<String> que sera el arraylist donde buscaremos
     * Salidas: boolean que sera true en caso de que dicho elemento ya se encontrase en el arraylist, y false si no
     * Entrada/Salida:
     * Postcondiciones: asociado al nombre devuelve un boolean que sera true en caso de que dicho elemento ya se encontrase en el arraylist, y false si no
     * */
    public boolean isEncontradoElementoEnArrayList(String elemento, ArrayList<String> arraylist){
        boolean encontrado = false;

        for(int i = 0 ; i < arraylist.size(); i++){
            if(arraylist.get(i).equals(elemento)){
                encontrado = true;
            }
        }

        return encontrado;
    }

}
