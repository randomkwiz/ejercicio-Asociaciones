package validacion;

import java.util.Scanner;

public class Validaciones
{
	public int mostrarMenuPrincipalYValidarOpcion()
	{
		int opcionMenuPrincipal;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("MENU PRINCIPAL");
		
		System.out.println("1) Calcular el total de acogidos en un pais");
		System.out.println("2) Total de voluntarios");
		System.out.println("3) Centros de acogida según calificación");
		System.out.println("4) Listar los centros de acogida en guerra y pais al que pertenece");
		System.out.println("5) Informe con el total de voluntarios en cada pais");
		System.out.println("0) Salir");
		
		do
		{
			
			System.out.print("Elige una opcion: ");
			opcionMenuPrincipal = teclado.nextInt();
			
		}while(opcionMenuPrincipal < 0 || opcionMenuPrincipal > 5);
		
		return opcionMenuPrincipal;
	}
	
	public int mostrarSubMenuVoluntariosYValidarOpcion()
	{
		int opcionSubMenuVoluntarios;
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Elige la situacion del pais los centros donde estan los voluntarios.");
		
		System.out.println("1) En guerra");
		System.out.println("2) En paz");
		System.out.println("0) Volver atras");
		
		do
		{
			
			System.out.print("Elige una opcion: ");
			opcionSubMenuVoluntarios = teclado.nextInt();
			
		}while(opcionSubMenuVoluntarios < 0 || opcionSubMenuVoluntarios > 2);
		
		return opcionSubMenuVoluntarios;
	}
	
	public char calificacion()
	{
		char calificacionValidada;
		Scanner teclado = new Scanner(System.in);
		
		do
		{
			
			System.out.println("Escribe la califacicacion...");
			System.out.println("Recuerda:");
			System.out.println("O -> Optima");
			System.out.println("N -> Normal");
			System.out.println("G -> Grave");
			System.out.println("D -> Desesperada");
			
			calificacionValidada = teclado.next().charAt(0);
			
			calificacionValidada = Character.toUpperCase(calificacionValidada);
			
		}while(calificacionValidada != 'O' && calificacionValidada != 'N' && calificacionValidada != 'G' && calificacionValidada != 'D');
		
		return calificacionValidada;
	}
}
