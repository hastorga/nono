package nono;

import java.util.ArrayList;

public class main {
	

	public static void main(String[] args) {
	
		System.out.println("lectura de fichero");
		Lectura archivo = new Lectura();
		archivo.leer_ficheros();
		
		//Dimensiones Matriz
		int N = archivo.getN();
		int M = archivo.getM();
		char matriz[][] = new char[N][M];
		
		//Array List de Filas
		ArrayList<ArrayList<Integer>> filas = archivo.get_Filas();
		
		//Array List de Columnas
		ArrayList<ArrayList<Integer>> columnas = archivo.get_Columnas();
		
		int columnasResueltas[] = new int[M];
		int filasResueltas[] = new int[N];
		
		
		//LLENA MATRIZ CON CARACTERES '*' (SIN PINTAR) 
		
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				matriz[i][j]='*';
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
		
		//mostrarMatriz(N,M,matriz);
		
		
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
		
		//SE IMPRIMEN ARRAY LIST DE COLUMNAS
		
		System.out.println("\nARRAYLIST COLUMNAS: ");
		
		for(int i=0; i<columnas.size(); i++)
		{	
			System.out.print(" \n--> AL "+(i+1)+": ");
			for(int j=0; j<columnas.get(i).size() ; j++)
			{
				System.out.print(" "+ columnas.get(i).get(j)); 
			}

		}
		
		//CICLO PARA FILAS
		
		
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
		
		mostrarMatrizCompleta(N,M,matriz,columnas, filas);
	
	}
	
	public static void mostrarMatrizCompleta(int N, int M , char matriz[][], ArrayList<ArrayList<Integer>> columnas, ArrayList<ArrayList<Integer>> filas)
	{
		
		//DIMENSIONES DE MATRIZ COMPLETA
		int dimCol;
		int dimFil;
		
		int indCol = 0;
		int indFil = 0;
		
		
        //SE CALCULA DIMENSION MAXIMA PARA COLUMNAS DE MATRIZ COMPLETA
		if(M%2==0)
			dimCol = M+(M/2);
		else
			dimCol = M + ((M+1)/2);
		
		//SE CALCULA DIMENSION MAXIMA PARA FILAS DE MATRIZ COMPLETA
		if(N%2==0)
			dimFil = N+(N/2);
		else
			dimFil = N + ((N+1)/2);
		
		
		//SE INICIALIZA LA MATRIZ COMPLETA
		char matrizCompleta[][] = new char[dimFil][dimCol];
		
		
		//SE INICIALIZAN TODAS LAS POSICIONES DE LA MATRIZ CON VACIO
		for(int i=0; i<dimFil; i++)
		{	
			for(int j=0; j<dimCol; j++)
			{
				matrizCompleta[i][j] = ' ';
			}
			
		}
		
		//SE AGREGAN LOS SEGMENTOS A PINTAR PARA CADA COLUMNA
		for(int i=(dimCol-M) ; i<dimCol; i++)
		{	
			for(int j=0 ; j<columnas.get(indCol).size(); j++)
			{
				String segmento = String.valueOf(columnas.get(indCol).get(j)); 
				matrizCompleta[j][i] = segmento.charAt(0);
					
			}	
			indCol++;
		}
		
		//SE AGREGAN LOS SEGMENTOS A PINTAR PARA CADA FILA
		for(int i=(dimFil-N) ; i<dimFil; i++)
		{	
			for(int j=0 ; j<filas.get(indFil).size(); j++)
			{
				String segmento = String.valueOf(filas.get(indFil).get(j)); 
				matrizCompleta[i][j] = segmento.charAt(0);
					
			}	
			indFil++;
		}
		
		//SE AGREGAN LOS VALORES DE LA MATRIZ QUE CONTIENE EL JUEGO
		for(int i=0; i<N; i++)	
			for(int j=0; j<M; j++)
				matrizCompleta[i+(dimFil-N)][j+(dimCol-M)] = matriz[i][j];

		
		//SE IMPRIME LA MATRIZ COMPLETA
		
		System.out.println();
		
		for(int i=0; i<dimFil; i++)
		{	
			for(int j=0; j<dimCol; j++)
			{
				System.out.print(" "+matrizCompleta[i][j]);
			}
			System.out.println();
		
		}
			
	}

}
