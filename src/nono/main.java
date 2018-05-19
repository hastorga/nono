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
		
		//Array List de Columnas
		ArrayList<ArrayList<Integer>> columnas = new ArrayList<ArrayList<Integer>>();
		
		
		//ARREGLOS DE PRUEBA (Insertar en ArrayList de Filas o columnas)
		int [] arrayF1 = {1,1,1};
		int [] arrayF2 = {1,3};
		int [] arrayF3 = {3,1};
		int [] arrayF4 = {5};
		int [] arrayF5 = {1,1,1};

		
		//LLENA MATRIZ CON CARACTERES '-' (SIN PINTAR) 
		
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				matriz[i][j]='-';
			}
		}
		
		//IMPRIME MATRIZ
		
		System.out.println("MATRIZ VACIA:");
		
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				System.out.print(" "+matriz[i][j]);
			}
			System.out.println();
			
		}
		
		//SE INICIALIZAN ARRAYS LIST DE SEGMENTOS DE FILAS Y COLUMNAS
		for(int i=0; i<N; i++)
		{	
			filas.add(new ArrayList <Integer>() );	
			columnas.add(new ArrayList <Integer>() );	
		}
		
		
		//SE LLENAN ARRAYS LIST DE SEGMENTOS DE FILAS
		//(Debiese ser dinamico y leido desde archivo de texto)
		
		/*
	
		for(int j=0; j<arrayF1.length ; j++)
			filas.get(0).add(arrayF1[j]);
		for(int j=0; j<arrayF2.length ; j++)
			filas.get(1).add(arrayF2[j]);
		for(int j=0; j<arrayF3.length ; j++)
			filas.get(2).add(arrayF3[j]);
		for(int j=0; j<arrayF4.length ; j++)
			filas.get(3).add(arrayF4[j]);
		for(int j=0; j<arrayF5.length ; j++)
			filas.get(4).add(arrayF5[j]);
		*/
		
		for(int j=0; j<arrayF1.length ; j++)
			columnas.get(0).add(arrayF1[j]);
		for(int j=0; j<arrayF2.length ; j++)
			columnas.get(1).add(arrayF2[j]);
		for(int j=0; j<arrayF3.length ; j++)
			columnas.get(2).add(arrayF3[j]);
		for(int j=0; j<arrayF4.length ; j++)
			columnas.get(3).add(arrayF4[j]);
		for(int j=0; j<arrayF5.length ; j++)
			columnas.get(4).add(arrayF5[j]);
			
		
	
		//SE IMPRIMEN ARRAY LIST DE FILAS
		
		System.out.println("\nARRAY LIST FILAS: ");
		for(int i=0; i<filas.size(); i++)
		{	
			System.out.print(" \n--> AL "+(i+1)+": ");
			for(int j=0; j<filas.get(i).size() ; j++)
			{
				System.out.print(" "+ filas.get(i).get(j)); 
			}

		}
		
		System.out.println("\nARRAY LIST COLUMNAS: ");
		for(int i=0; i<columnas.size(); i++)
		{	
			System.out.print(" \n--> AL "+(i+1)+": ");
			for(int j=0; j<columnas.get(i).size() ; j++)
			{
				System.out.print(" "+ columnas.get(i).get(j)); 
			}

		}
		
		
		//CICLO PARA FILAS
		
		/*
		for(int x=0 ; x<filas.size() ; x++)
		{
			int suma = 0;
			
			//SUMA DE CUADRADOS A PINTAR EN FILA
			for(int i=0; i<filas.get(x).size(); i++)
			{
				suma = suma + filas.get(x).get(i);
			}
			
			//PINTAR REGLA 1 EN FILA	
			if(filas.get(x).size()==1 && filas.get(x).get(0) == M)
			{
				for(int i=0; i<filas.get(x).size(); i++)
				{
					matriz[x][i] = '#';
				}
					
			}
			
			//PINTAR REGLA 2 EN FILA
			if(suma == (M-(filas.get(x).size()-1)))
			{
				
				int indiceColumna = 0;
				
				for(int i=0; i<filas.get(x).size(); i++)
				{
					int segmento = filas.get(x).get(i);
					
					for(int j=0; j<segmento; j++)
					{
						//PINTA CON '#'
						matriz[x][indiceColumna]='#';
						indiceColumna++;
					}
					
					//AGREGAR ESPACIO
					if(i<filas.get(x).size()-1)
					{
						matriz[x][indiceColumna]='-';
						indiceColumna++;
					}
					
				}
				
				
			}
			
		}
		*/
		
		//CICLO PARA COLUMNAS
		
		for(int x=0 ; x<columnas.size() ; x++)
		{
			int suma = 0;
			
			//SUMA DE CUADRADOS A PINTAR EN COLUMNA
			for(int i=0; i<columnas.get(x).size(); i++)
			{
				suma = suma + columnas.get(x).get(i);
			}
			
			//PINTAR REGLA 1 EN COLUMNA	
			if(columnas.get(x).size()==1 && columnas.get(x).get(0) == N)
			{
				for(int i=0; i<columnas.get(x).size(); i++)
				{
					matriz[i][x] = '#';
				}
					
			}
			
			//PINTAR REGLA 2 EN COLUMNA
			if(suma == (N-(columnas.get(x).size()-1)))
			{
				
				int indiceFila = 0;
				
				for(int i=0; i<columnas.get(x).size(); i++)
				{
					int segmento = columnas.get(x).get(i);
					
					for(int j=0; j<segmento; j++)
					{
						//PINTA CON '#'
						matriz[indiceFila][x]='#';
						indiceFila++;
					}
					
					//AGREGAR ESPACIO
					if(i<columnas.get(x).size()-1)
					{
						matriz[indiceFila][x]='-';
						indiceFila++;
					}
					
				}
				
				
			}
			
		}
	
		//IMPRIME MATRIZ
		
		System.out.println("\n\nMATRIZ PINTADA:");
		
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				System.out.print(" "+matriz[i][j]);
			}
			System.out.println();
			
		}
	
	}

}
