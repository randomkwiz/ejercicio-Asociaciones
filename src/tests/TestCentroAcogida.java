package tests;

import clases.AsociacionImpl;
import clases.CentroAcogidaImpl;



public class TestCentroAcogida {
    public static void main(String[] args) {
        CentroAcogidaImpl ca = new CentroAcogidaImpl("Nuestra Españita","AE",5000,890,'O','n');
        CentroAcogidaImpl ca2 = new CentroAcogidaImpl("Nuestra Españita","AE",5000,890,'O','n');

        /*Compare to */
        System.out.println(ca.compareTo(ca2));

        System.out.println(ca.getCalificacion());
        System.out.println(ca.getGuerra());
        System.out.println(ca.getTotalAcogidos());
        System.out.println(ca.toString());
        System.out.println(ca.getNombre());
        System.out.println(ca.getPais());
        System.out.println(ca.getNumeroVoluntarios());
        ca.setTotalAcogidos(700);
        System.out.println(ca.getTotalAcogidos());




    }
}
