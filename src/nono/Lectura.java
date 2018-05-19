package nono;
import java.io.*;
import java.util.ArrayList;

public class Lectura {
	 	private ArrayList<ArrayList<Integer>> filas = new ArrayList<ArrayList<Integer>>();
		
		private ArrayList<ArrayList<Integer>> columnas = new ArrayList<ArrayList<Integer>>();
		
	public void leer_fichero() {
		File archivo = null;
	    FileReader fr = null;
	    BufferedReader br = null;
	  //Array List de Filas
	   
	    try {
	       // Apertura del fichero y creacion de BufferedReader para poder
	       // hacer una lectura comoda (disponer del metodo readLine()).
	       archivo = new File ("columnas.txt");
	       fr = new FileReader (archivo);
	       br = new BufferedReader(fr);
	
	     
			
	       // Lectura del fichero
	       String linea;
	   
	       while((linea=br.readLine())!=null)
	       {
	    	   //Se crea un array por cada linea
	    	   ArrayList<Integer> array = new ArrayList<Integer>();
	    	   String splittedString[] = linea.split(",");
	    	   for (int j=0; j<splittedString.length; j++)
	    	   {
	    		  //por cada linea se obtienen chars que se agregan al array.
	 	    	  int valor = Integer.parseInt(splittedString[j]);
	 	    	  array.add(valor);
	    	   }
	    	   columnas.add(array);
	    	   System.out.println("--NUEVA LINEA");
	    	
	       }
	       
	    }
	    catch(Exception e){
	       e.printStackTrace();
	    }finally{
	       // En el finally cerramos el fichero, para asegurarnos
	       // que se cierra tanto si todo va bien como si salta 
	       // una excepcion.
	       try{                    
	          if( null != fr ){   
	             fr.close();     
	          }                  
	       }catch (Exception e2){ 
	          e2.printStackTrace();
	       }
	    }
	    System.out.println("vector columnas");
	    
	    for(int k = 0; k < columnas.size() ;k++)
	    {
	    	System.out.println(columnas.get(k));
	    }
	    
	}
	public ArrayList<ArrayList<Integer>> get_Columnas () {
		return  columnas;
	}
	public ArrayList<ArrayList<Integer>> get_filas () {
		return  filas;
	}
	
}

