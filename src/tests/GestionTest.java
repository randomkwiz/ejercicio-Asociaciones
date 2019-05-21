package tests;

import gestion.Gestion;

import java.io.File;
import java.lang.reflect.Field;

public class GestionTest {
    public static void main(String[] args) {
        Gestion g = new Gestion();
        String ficheroCentroAcogida = "./Files/ficheroCentrosAcogida.txt";
        String ficheroAsociacion = "./Files/ficheroAsociaciones.txt";
        File fich1 = new File(ficheroAsociacion);
        File fich2 = new File(ficheroCentroAcogida);
/*
        System.out.println(fich1.exists());
        System.out.println(fich2.exists());

        System.out.println("Numero voluntarios en paises belicos: "+g.calcularNumeroVoluntariosEnPaisesBelicos(ficheroCentroAcogida));
        System.out.println("Numero voluntarios en paises pacificos: "+g.calcularNumeroVoluntariosEnPaisesPacificos(ficheroCentroAcogida));

        System.out.println();
        System.out.println("Calcular total acogidos por pais: (España) "+g.calcularTotalAcogidosPais("España",ficheroCentroAcogida));
        System.out.println("Calcular total acogidos por pais (España) fichero asociacion: "+g.calcularTotalAcogidosPais("España",ficheroAsociacion));

        System.out.println();
        System.out.println("Imprimir centro acogida en guerra y pais: ");
        g.imprimirCentroAcogidaEnGuerraYPais(ficheroCentroAcogida);
        System.out.println("Imprimir centro acogida por calificacion (O) :");
        g.imprimirCentroAcogidaPorCalificacion(ficheroCentroAcogida,'O');
        System.out.println("Imprimir centro acogida por calificacion (G) :");
        g.imprimirCentroAcogidaPorCalificacion(ficheroCentroAcogida,'G');
        System.out.println("Imprimir total voluntarios por pais: ");
        g.imprimirTotalVoluntariosPorPais(ficheroCentroAcogida);

*/
        g.ordenarFicheroAsociacion(ficheroCentroAcogida);




    }
}
