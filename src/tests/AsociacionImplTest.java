import clases.AsociacionImpl;

import java.util.Arrays;
public class AsociacionImplTest
{
	
	public static void main(String[] args)
	{
		AsociacionImpl porDefecto = new AsociacionImpl();
		AsociacionImpl conParametros = new AsociacionImpl("España", "Asociacion buena", 125, 25);
		AsociacionImpl deCopia = new AsociacionImpl(conParametros);
		
		System.out.println("conParametros.getPais(): " + conParametros.getPais());
		System.out.println("deCopia.getNombre(): " + deCopia.getNombre());
		System.out.println("porDefecto.getTotalAcogidos(): " + porDefecto.getTotalAcogidos());
		System.out.println("porDefecto.getNumeroVoluntarios(): " + porDefecto.getNumeroVoluntarios());
		
		System.out.println("------------------------------------------------");
		
		System.out.println("conParametros.setPais(\"Francia\")");
		
		System.out.println("ANTES -> " + conParametros.getPais());
		
		conParametros.setPais("Francia");
		
		System.out.println("DESPUES -> " + conParametros.getPais());
		
		System.out.println("------------------------------------------------");
		
		System.out.println("deCopia.setNombre(\"Asociacion no tan buena\")");
		
		System.out.println("ANTES -> " + conParametros.getNombre());
		
		conParametros.setNombre("Asociacion no tan buena");
		
		System.out.println("DESPUES -> " + conParametros.getNombre());
		
		System.out.println("------------------------------------------------");
		
		System.out.println("porDefecto.setTotalAcogidos(130)");
		
		System.out.println("ANTES -> " + porDefecto.getTotalAcogidos());
		
		porDefecto.setTotalAcogidos(130);
		
		System.out.println("DESPUES -> " + porDefecto.getTotalAcogidos());
		
		System.out.println("------------------------------------------------");
		
		System.out.println("conParametros.setNumeroVoluntarios(30)");
		
		System.out.println("ANTES -> " + conParametros.getNumeroVoluntarios());
		
		conParametros.setNumeroVoluntarios(30);
		
		System.out.println("DESPUES -> " + conParametros.getNumeroVoluntarios());
		
		System.out.println("------------------------------------------------");
		
		System.out.println("conParametros.toString(): " + conParametros.toString());
		System.out.println("deCopia.toString(): " + deCopia.toString());
		
		System.out.println("conParametros.compareTo(deCopia): "  + conParametros.compareTo(deCopia));
		
		System.out.println("conParametros.equals(deCopia): " + conParametros.equals(deCopia));
	
	}
}
