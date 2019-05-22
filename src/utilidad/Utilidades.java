package utilidad;

import clases.AsociacionImpl;

import java.util.ArrayList;

public class Utilidades {
    /*
     * INTERFAZ
     * Comentario: Ordena un ArrayList
     * Signatura: public ArrayList ordenarArrayList(ArrayList arraylist)
     * Precondiciones:
     * Entradas:
     *
     * Salidas:
     * Entrada/Salida: Arraylist que será ordenado
     * Postcondiciones: asociado al nombre se devolvera el arraylist ordenado
     * */
    public ArrayList<AsociacionImpl> ordenarArrayList(ArrayList<AsociacionImpl> arraylist){
        int n = arraylist.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arraylist.get(j).compareTo(arraylist.get(j+1)) > 0 )
                {
                    // swap arr[j+1] and arr[i]
                    AsociacionImpl temp = arraylist.get(j);
                    arraylist.set(j,arraylist.get(j+1));
                    arraylist.set(j+1, temp);
                }

        return arraylist;
    }


}
