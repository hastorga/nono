package nono;

import java.util.ArrayList;

public class main {
	

	public static void main(String[] args) {
	

		//Dimensiones Matriz
		int N=5;
		int M=5;
		char matriz[][] = new char[N][M];
		
		
		//Array List de Filas
		ArrayList<ArrayList<Integer>> filas = new ArrayList<ArrayList<Integer>>();
		
		
		//SUMA DE CUADRADOS A PINTAR DE FILA
		int suma = 0 ;

		//SIMULACIONES DE FILA Y CUADRADOS A PINTAR
		char [] arrayFila = {'-' , '-' , '-' , '-' , '-'};
		int [] arraySegmentos = {3,1};
		
		//ARREGLOS DE PRUEBA (Insertar en ArrayList de Filas)
		int [] arrayF1 = {1,1,1};
		int [] arrayF2 = {1,3};
		int [] arrayF3 = {3,1};
		int [] arrayF4 = {5};
		int [] arrayF5 = {1,3};

		
		//LLENA MATRIZ
		
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				matriz[i][j]='-';
			}
		}
		
		//IMPRIME MATRIZ
		
		System.out.println("MATRIZ:");
		
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				System.out.print(" "+matriz[i][j]);
			}
			System.out.println();
			
		}
		
		//INICIALIZAN ARRAY LIST DE SEGMENTOS DE FILAS
		for(int i=0; i<N; i++)
		{	
			filas.add(new ArrayList <Integer>() );			
		}
		
		//SE LLENAN ARRAYS LIST DE SEGMENTOS DE FILAS
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<arrayF2.length ; j++)
			{
				filas.get(i).add(arrayF2[j]);
			}
		}
		
		
		//SE IMPRIMEN ARRAY LIST DE FILAS
		
		System.out.println("\nARRAY LIST: ");
		for(int i=0; i<filas.size(); i++)
		{	
			System.out.print(" \n--> AL "+(i+1)+": ");
			for(int j=0; j<filas.get(i).size() ; j++)
			{
				System.out.print(" "+ filas.get(i).get(j)); 
			}

		}
		
		//SE CALCULA LA SUMA DE CUADRADOS A PINTAR EN FILA
		for(int i=0; i<arraySegmentos.length; i++)
		{
			suma = suma + arraySegmentos[i];
		}
		
		
		//PINTAR REGLA 1 EN FILA	
		if(arraySegmentos.length==1 && arraySegmentos[0] == M)
		{
			for(int i=0; i<arrayFila.length; i++)
				arrayFila[i]='#';

		}
		
		//PINTAR REGLA 2 EN FILA
		if(suma == (M-(arraySegmentos.length-1)))
		{
			
			int indiceColumna = 0;
			
			for(int i=0; i<arraySegmentos.length; i++)
			{
				int segmento = arraySegmentos[i];
				
				for(int j=0; j<segmento; j++)
				{
					//PINTA CON '#'
					arrayFila[indiceColumna]='#';
					indiceColumna++;
				}
				
				//AGREGAR ESPACIO
				if(i<arraySegmentos.length-1)
				{
					arrayFila[indiceColumna]='-';
					indiceColumna++;
				}
				
			}
			
			//IMPRIME FILA
			System.out.print("\n\nFila pintada: \n");
			for(int i=0; i<arrayFila.length; i++)
				System.out.print(" "+arrayFila[i]);
			
		}	
	
	}

}
