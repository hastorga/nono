package nono;
import java.io.*;
import java.util.ArrayList;

public class Lectura {
	
 	private ArrayList<ArrayList<Integer>> filas = new ArrayList<ArrayList<Integer>>();
	
	private ArrayList<ArrayList<Integer>> columnas = new ArrayList<ArrayList<Integer>>();
	
	private int N,M;
	
	public void leer_ficheros ()
	{
		leer_columnas_filas ();
		
	}	
	
	public void leer_columnas_filas() {
			
			File archivo = null;
		    FileReader fr = null;
		    BufferedReader br = null;
		    //Array List de Filas
		   
		    try {
		       // Apertura del fichero y creacion de BufferedReader para poder
		       // hacer una lectura comoda (disponer del metodo readLine()).
		       archivo = new File ("vectores.txt");
		       fr = new FileReader (archivo);
		       br = new BufferedReader(fr);
		
		       //Se lee la primera linea que contiene al M
		     M = Integer.parseInt(br.readLine());
				
		       // Lectura del fichero
		       String linea;
		       int countline = 0;
		       while((linea=br.readLine())!=null && countline < M)
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
		    	   countline++;
		    	
		       }
		       
		       N= Integer.parseInt(br.readLine());
		       countline= 0;
		       
		       while((linea=br.readLine())!=null && countline < N)
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
		    	   filas.add(array);
		    	   countline++;
		    	
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
		    System.out.println("Vector columnas");
		    
		    for(int k = 0; k < columnas.size() ;k++)
		    {
		    	System.out.println(columnas.get(k));
		    }
		    
		    System.out.println("Vector filas");
		    
		    for(int k = 0; k < filas.size() ;k++)
		    {
		    	System.out.println(filas.get(k));
		    }
		    
		}
	
	
	public ArrayList<ArrayList<Integer>> get_Columnas () {
		return  columnas;
	}
	
	public ArrayList<ArrayList<Integer>> get_Filas () {
		return  filas;
	}
	
}

