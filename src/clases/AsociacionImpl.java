package clases;
/* ESTUDIO DE INTERFAZ
 * Propiedades basicas:
 * 			-> String pais. Consultable y Modificable
 *			-> String nombre. Consultable y Modificable
 * 			-> int totalAcogidos. Consultable y Modificable
 * 			-> int numeroVoluntarios. Consultable y Modificable
 * 
 * Propiedades derividas: No hay
 * 
 * Propiedades compartidas: No hay
 */
 
 /* INTERFAZ
  * public String getPais();
  * public String getNombre();
  * public int getTotalAcogidos();
  * public int getNumeroVoluntarios();
  * 
  * public void setPais(String pais);
  * public void setNombre(String nombre);
  * public void setTotalAcogidos(int totalAcogidos);
  * public void setNumeroVoluntarios(int numeroVoluntarios);
  */
public class AsociacionImpl implements Comparable<AsociacionImpl>
{
	private String pais;
	private String nombre;
	private int totalAcogidos;
	private int numeroVoluntarios;
	
	//Constructor por defecto
	public AsociacionImpl()
	{
		this.pais = "";
		this.nombre = "";
		this.totalAcogidos = 0;
		this.numeroVoluntarios = 0;
	}
	
	//Constructor con parametros
	public AsociacionImpl(String pais, String nombre, int totalAcogidos, int numeroVoluntarios)
	{
		this.pais = pais;
		this.nombre = nombre;
		this.totalAcogidos = totalAcogidos;
		this.numeroVoluntarios = numeroVoluntarios;
	}
	
	//Constructor de copia
	public AsociacionImpl(AsociacionImpl otra)
	{
		this.pais = otra.pais;
		this.nombre = otra.nombre;
		this.totalAcogidos = otra.totalAcogidos;
		this.numeroVoluntarios = otra.numeroVoluntarios;
	}
	
	public String getPais() { return this.pais; }
	public String getNombre() { return this.nombre; }
	public int getTotalAcogidos() { return this.totalAcogidos; }
	public int getNumeroVoluntarios() { return this.numeroVoluntarios; }

	public void setPais(String pais) { this.pais = pais; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public void setTotalAcogidos(int totalAcogidos) { this.totalAcogidos = totalAcogidos; }
	public void setNumeroVoluntarios(int numeroVoluntarios) { this.numeroVoluntarios = numeroVoluntarios; }
	
	//Critero de comparación por pais y nombre
	/*
	* Devuelve 0 si el pais y el nombre de los dos objetos son iguales
	* Devuelve
	* */
	@Override
	public int compareTo(AsociacionImpl otra)
	{
		int ret = -1;
		System.out.println("compare to en construccion");
		
		return ret;
	}
	
	//Criterio de igualdad: Son iguales si sus paises y nombres son iguales
	@Override
	public boolean equals(Object obj)
	{
		boolean ret = false;
		
		if(this == obj) ret = true;
		
		else if(obj != null && obj instanceof AsociacionImpl)
		{
			AsociacionImpl otra = (AsociacionImpl) obj;
			
			if(this.getNombre().equals(otra.getNombre()) && this.getPais().equals(otra.getPais()) )
				ret = true;
		}
		
		return ret;
	}
	
	//Representacion como cadena: Pais, nombre, totalAcogidos, numeroVoluntarios
	@Override
	public String toString()
	{
		return this.getPais() + "," + this.getNombre() + "," + this.getTotalAcogidos() + "," + this.getNumeroVoluntarios();
	}
}
