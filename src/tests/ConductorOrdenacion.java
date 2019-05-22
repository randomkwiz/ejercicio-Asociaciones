package tests;

import clases.AsociacionImpl;
import gestion.Gestion;
import interfaces.Asociacion;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

public class ConductorOrdenacion {
    public static void main(String[] args) {
        ArrayList<AsociacionImpl> array = new ArrayList<AsociacionImpl>();
        ArrayList<String> arrayString = new ArrayList<String>();
        Gestion g = new Gestion();

        array.add(new AsociacionImpl("Alemania", "AsociacionSerena", 50,150));
        array.add(new AsociacionImpl("Italia", "AsociacionHeroica", 50,150));
        array.add(new AsociacionImpl("Zimbabue", "AsociacionHeroica", 50,150));
        array.add(new AsociacionImpl("España", "AsociacionMagica", 50,150));
        array.add(new AsociacionImpl("Poniente", "AsociacionHeroica", 50,150));

        //Pasamos los objetos a string
        for(AsociacionImpl elemento:array){
            arrayString.add(elemento.toString());
        }

        //imprimimos los string
        System.out.println();
        System.out.println("Imprimimos los strings");
        for(String elemento:arrayString){
            System.out.println(elemento);
        }

        //Los convertimos a objetos otra vez

        array.clear();
        //System.out.println("Convertimos a objetos");
        for(String elemento:arrayString){
            array.add(g.toObjectAsociacionImpl(elemento));
        }

        //Imprimimos los objetos
        System.out.println();
        System.out.println("Imprimimos los objetos");
        for(AsociacionImpl elemento: array){
            System.out.println(elemento.toString());
        }

        //Se ordena

        Collections.sort(array);

        //Imprimimos los objetos ya ordenados
        System.out.println();
        System.out.println("Imprimimos los objetos ya ordenados");
        for(AsociacionImpl elemento: array){
            System.out.println(elemento.toString());
        }

        //Se convierte a string de nuevo
        arrayString.clear();
        for(AsociacionImpl elemento:array){
            arrayString.add(elemento.toString());
        }

        //imprimimos los string
        System.out.println();
        System.out.println("Imprimimos los strings de nuevo");
        for(String elemento:arrayString){
            System.out.println(elemento);
        }







        /*
        Collections.sort(array);

        for(AsociacionImpl elemento:array){
            System.out.println(elemento.toString());
        }


 */

        /*
        ArrayList<AsociacionImpl> arrayObjetos = array;

        //ArrayList<String> arrayRegistros = g.insertarRegistrosEnArrayList("./Files/ficheroCentrosAcogida.txt");
        ArrayList<String> arrayRegistros = new ArrayList<String>();

        System.out.println("MIRA AQUI");
        for(AsociacionImpl elemento:arrayObjetos){
            arrayRegistros.add(elemento.toString());
        }


        System.out.println("En cadena");
        for(String elemento:arrayRegistros){
            System.out.println(elemento);
        }

*/


       // ArrayList<AsociacionImpl> arrayObjetos = new ArrayList<AsociacionImpl>();



/*
        for(String elemento:arrayRegistros){
            arrayObjetos.add(g.toObjectAsociacionImpl(elemento));
        }

 */

/*
        System.out.println();
        System.out.println("En objetos: ");
        for(AsociacionImpl elemento:arrayObjetos){
            System.out.println(elemento.toString());
        }



        Collections.sort(arrayObjetos);
        System.out.println();
        System.out.println("En objetos despues del SORT: ");
        for(AsociacionImpl elemento:arrayObjetos){
            System.out.println(elemento.toString());
        }



        arrayRegistros.clear();

        for(AsociacionImpl elemento:arrayObjetos){
            arrayRegistros.add(elemento.toString());
        }


        System.out.println();
        System.out.println("En cadena DE VUELTA DE OBJ");
        for(String elemento:arrayRegistros){
            System.out.println(elemento);
        }

*/
    }
}
