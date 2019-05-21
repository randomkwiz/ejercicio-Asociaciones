/* ANALISIS
 * Se desea realizar un programa para una organización humanitaria, que podrá consultar distintos datos acerca de los centros de acogida que esta organización tiene.
 * 
 * El programa tendrá un menú con las siguientes opciones:
 * 		-> Calcular el total de acogidos en un pais
 * 		-> Un submenu para ver el total de voluntarios, dentro dos opciones, los que están en guerra y los que no.
 * 		-> Mostrar los centros de acogida según una calificación elegida por el usuario (Optima, Normal, Grave, Desesperada)
 * 		-> Mostrar un listado de los centros de acogida en guerra y el pais al que pertenecen.
 * 		-> Mostrar un informe con el total de voluntarios por pais
 * 
 * Entrada:
 * 		-> Una opcion para el menu principal
 * 		-> Una opcion para el submenu del total de voluntarios
 * 		-> Un pais para la opcion 1 del menu principal (total de acogidos de un pais)
 * 		-> Una calificacion para la opcion 3 del menu principal (mostrar centros de acogida segun una calificacion dada)
 * 
 * Salida:
 * 		-> Distintos mensajes de ayuda al usuario y eco de los datos
 * 		-> Un menu principal con estas opciones:
 * 			1) Calcular el total de acogidos en un pais
 * 			2) Total de voluntarios
 * 			3) Centros de acogida según calificación
 * 			4) Listar los centros de acogida en guerra y pais al que pertenece
 * 			5) Informe con el total de voluntarios en cada pais
 * 			0) Salir
 * 
 * 		-> Un submenu para la opcion 2 del menu principal (total de voluntarios)
 * 			1) En guerra
 * 			2) En paz
 * 			0) Volver atras
 * 
 * Restricciones:
 * 		-> La opcion para el menu principal debe ser un numero entre 0 y 5 (0 para salir)
 * 		-> La opcion del submenu de total de voluntarios debe ser un numero entre 0 y 2 (0 para salir)
 * 		-> La calificacion debe ser:
 * 				* O para Optima
 * 				* N para Normal
 * 				* G para Grave
 * 				* D para Desesperada
 * 
 */ 
 
/* PSEUDOCODIGO GENERALIZADO (nivel 0)
 * Inicio
 * 	Mostrar menu principal y validar opcion
 * 	Mientras (opcion != salir)
 * 		Segun(opcion)
 * 			case 1:
 * 				Calcular total de acogidos en un pais
 * 			case 2:
 * 				Total de voluntarios
 * 			case 3:
 * 				Mostrar los centros de acogida según una calificación
 * 			case 4:
 * 				Listar los centros de acogida en guerra y pais al que pertenecen *
 * 			case 5:
 * 				Informe con el total de voluntarios por pais
 * 		FinSegun
 * 		Mostrar menu principal y validar opcion
 * 	FinMientras
 * 
 * Fin
 */
 /* PSEUDOCODIGO modulos
  * 
  * - total de voluntarios (opcion 2 del menu)
  * Inicio
  * 	Mostar submenuVoluntarios y validar opcionSubMenuVoluntarios
  * 	Mientras (opcionSubMenuVoluntarios != volver atras)
  * 		Segun(opcionSubMenuVoluntarios)
  * 			case 1:
  * 				Total de voluntarios en centros de acogida con pais en guerra *
  * 			case 2:
  * 				Total de voluntarios en centros de acogida con pais que no estan en guerra *
  * 		FinSegun
  * 		Mostrar submenuVoluntarios y validar opcionSubMenuVoluntarios *
  * 	FinMientras
  * Fin
  */
package main;
import gestion.Gestion;

import java.util.Scanner;
import  validacion.*;

public class mainsito
{
	public static void main(String[] args)
	{
		int opcion, opcionSubMenuVoluntarios, totalVoluntariosPais;
		char calificacion;
		String pais;
		String rutaFichero = "./Files/ficheroCentrosAcogida.txt"; 
		
		Validaciones validaciones = new Validaciones();
		Gestion gestion = new Gestion();
		Scanner teclado = new Scanner(System.in);
		
			//Mostrar menu principal y validar opcion
			opcion = validaciones.mostrarMenuPrincipalYValidarOpcion();
			
			while(opcion != 0)
			{
				switch(opcion)
				{
					case 1:
						//Calcular total de acogidos en un pais
						System.out.print("Escribe el nombre del pais: ");
						pais = teclado.next();
						
						totalVoluntariosPais = gestion.calcularTotalAcogidosPais(pais, rutaFichero);
						
						if(totalVoluntariosPais >= 0)
							System.out.println("En " + pais + " hay " + totalVoluntariosPais + " voluntarios.");
						else
							System.out.println("En este pais no hay ninguna asociacion registrada");
						
						break;
						
					case 2:
						//Total de voluntarios
						
						//Mostrar submenuVoluntarios y validar opcionSubMenuVoluntarios
						opcionSubMenuVoluntarios = validaciones.mostrarSubMenuVoluntariosYValidarOpcion();
						
						while(opcionSubMenuVoluntarios != 0)
						{
							switch(opcionSubMenuVoluntarios)
							{
								case 1:
									//Total de voluntarios en centros de acogida con pais en guerra *
									System.out.println("Total de voluntarios en centros de acogida con pais en guerra: \n"+gestion.calcularNumeroVoluntariosEnPaisesBelicos(rutaFichero));

									
									break;
									
								case 2:
									//Total de voluntarios en centros de acogida con pais que no estan en guerra *
									System.out.println("Total de voluntarios en centros de acogida con paises que no estan en guerra \n"+gestion.calcularNumeroVoluntariosEnPaisesPacificos(rutaFichero));
									gestion.calcularNumeroVoluntariosEnPaisesPacificos(rutaFichero);
									
									break;
							}
							
							//Mostrar submenuVoluntarios y validar opcionSubMenuVoluntarios
							opcionSubMenuVoluntarios = validaciones.mostrarSubMenuVoluntariosYValidarOpcion();
						}

						
						break;
						
					case 3:
						//Mostrar los centros de acogida según una calificación
						calificacion = validaciones.calificacion();
						
						gestion.imprimirCentroAcogidaPorCalificacion(rutaFichero, calificacion);
						
						break;
						
					case 4:
						//Listar los centros de acogida en guerra y pais al que pertenecen *
						
						gestion.imprimirCentroAcogidaEnGuerraYPais(rutaFichero);
						
						break;
						
					case 5:
						//Informe con el total de voluntarios por pais *
						gestion.imprimirTotalVoluntariosPorPais(rutaFichero);
						
						break;
				}
				
				//Mostrar menu principal y validar opcion
				opcion = validaciones.mostrarMenuPrincipalYValidarOpcion();
			}
	}
}
