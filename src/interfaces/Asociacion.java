package interfaces;/* ESTUDIO DE INTERFAZ
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
public interface Asociacion
{
	public String getPais();
	public String getNombre();
	public int getTotalAcogidos();
	public int getNumeroVoluntarios();

	public void setPais(String pais);
	public void setNombre(String nombre);
	public void setTotalAcogidos(int totalAcogidos);
	public void setNumeroVoluntarios(int numeroVoluntarios);
}
