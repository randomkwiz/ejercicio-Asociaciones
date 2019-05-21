package creacionFicheros;

import java.io.*;

public class creacionFichero {

    public static void main(String[] args) {

        File carpetaFiles = null;
        File ficheroAsociacion = null;
        File ficheroCentroAcogida = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        /*Crear carpeta contenedora*/
        carpetaFiles = new File("./Files");
        if(carpetaFiles.mkdir()){
            System.out.println("Carpeta Files creada correctamente");
        }else{
            System.out.println("Problema al crear la carpeta Files o bien ya existe");
        }

        if(carpetaFiles.exists()){
            try {
                ficheroAsociacion = new File(carpetaFiles, "ficheroAsociaciones.txt");
                fw = new FileWriter(ficheroAsociacion);
                bw = new BufferedWriter(fw);

                bw.write("España,AsociacionMagica,100,15");
                bw.newLine();
                bw.write("España,AsociacionSerena,200,35");
                bw.newLine();
                bw.write("España,AsociacionHeroica,1000,150");
                bw.newLine();


                bw.close();
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            if(ficheroAsociacion.exists()){
                System.out.println("El fichero de las asociaciones se creo con exito");
            }else{
                System.out.println("Hubo un problema al crear los ficheros de las asociaciones");
            }


            try {
                ficheroCentroAcogida = new File(carpetaFiles, "ficheroCentrosAcogida.txt");
                fw = new FileWriter(ficheroCentroAcogida);
                bw = new BufferedWriter(fw);

                bw.write("España,AsociacionMagica,100,15,O,n");
                bw.newLine();
                bw.write("España,AsociacionSerena,200,35,N,n");
                bw.newLine();
                bw.write("España,AsociacionHeroica,1000,150,G,s");
                bw.newLine();


                bw.close();
                fw.close();
            }catch (IOException e){
                e.printStackTrace();
            }

            if(ficheroAsociacion.exists()){
                System.out.println("El fichero de los centros de acogida se creo con exito");
            }else{
                System.out.println("Hubo un problema al crear los ficheros de los centros de acogida");
            }



        }

    }
}
