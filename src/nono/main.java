package nono;

import java.util.ArrayList;

public class main {
	

	public static void main(String[] args) {
	
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
		
		//Arrays de columnas y filas resueltas
		boolean columnasResueltas[] = new boolean[M];
		boolean filasResueltas[] = new boolean[N];
		
		int iteracion = 0;
		int cont = 0;
		String tipo;
		
		
		//Se inicializa la matriz con el caracter ' ' (Posici�n vacia)
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				matriz[i][j] = ' ';
			}
			
		}
		
		/*
		 * 
		 * CICLO ITERATIVO A IMPLEMENTAR PRONTO:
		 * 
		 * El ciclo acaba cuando todas las filas y columnas est�n resueltas (Juego terminado)
		 * o cuando no se puede avanzar a una siguiente iteracion (Falta de reglas para llegar a la solucion).
		 * 
		 * 
		 * De esta manera se evita entrar en un loop infinito buscando la solucion.
		 * 
		
		while( !nonoResuelto(filasResueltas,columnasResueltas) || sinAvance(rellenar parametros) )
		{
			int auxFilasResueltas[] = filasResueltas.clone();
			int auxColumnasResueltas[] = columnasResueltas.clone();
			
			//CICLO DE FILAS
			//CICLO DE COLUMNAS
		}
		
		*/
		
	
		//!nonoResuelto(filasResueltas,columnasResueltas) ||
		while( cont < 4)
		{
			
			
			System.out.println("\n**********************************");
			System.out.println("\nJuego terminado?: " + nonoResuelto(filasResueltas,columnasResueltas));
			
			System.out.println("\n**********************************");
			System.out.println("\n\t(WHILE: "+ cont + ")");
			System.out.println("\n**********************************");
			
			//CICLO PARA FILAS
			
			tipo = "fila";
			
			for(int x=0 ; x<filas.size() ; x++)
			{
				int suma = 0;
				int indice = x;
				
				
				if(filasResueltas[x]==false)
				{
					//SUMA DE CUADRADOS A PINTAR EN FILA
					for(int i=0; i<filas.get(x).size(); i++)
					{
						suma = suma + filas.get(x).get(i);
					}
						
					if(filas.get(x).size()==1)
					{
						//PINTAR REGLA 1 EN FILA
						if(filas.get(x).get(0) == M)
						{
							for(int i=0; i<filas.get(x).get(0); i++)
							{
								matriz[x][i] = '#';
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,1);
							
						}
						
						//PINTAR REGLA 6 EN FILA
						if(filas.get(x).get(0) == 0)
						{
							for(int i=0; i<M; i++)
							{
								matriz[x][i] = '-';
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,6);
							
						}
							
							
					}
					
					
					//PINTAR REGLA 2 EN FILA
					if(suma == (M-(filas.get(x).size()-1)) && filasResueltas[x]==false)
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
						filasResueltas[x]=true;
						iteracion++;
						mostrarMatriz(N,M,matriz,iteracion,indice,tipo,2);
						
					}
					
					//PINTAR REGLA 3 EN FILA	
					if(filas.get(x).size()==1 && filasResueltas[x]==false)
					{

						int segmento = filas.get(x).get(0);
						
						if( matriz[x][0] == '#')
						{
							for(int i=0; i<segmento; i++)
							{
								matriz[x][i] = '#';
							}
							
							for(int i=segmento; i< M; i++)
							{
								matriz[x][i] = '-';
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,3);
						}
						
						if( matriz[x][M-1] == '#')
						{
							for(int i=0; i< M-segmento; i++)
							{
								matriz[x][i] = '-';
							}
							
							for(int i=M-segmento; i< M; i++)
							{
								matriz[x][i] = '#';
							}
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,3);
						}
						
							
					}
					
					//PINTAR REGLA 4 EN FILA
					if(filas.get(x).size()==2 && filasResueltas[x]==false)
					{
						
						if( matriz[x][0] == '#' && matriz[x][M-1] == '#' )
						{
							int primerSegmento = filas.get(x).get(0);
							int segundoSegmento = filas.get(x).get(1);
							
							for(int i=0; i< primerSegmento; i++)
							{
								matriz[x][i] = '#';
							}
							
							for(int i= M-1; i >= M-segundoSegmento; i--)
							{
								matriz[x][i] = '#';
							}
							
							for(int i= primerSegmento; i < M-segundoSegmento; i++)
							{
								matriz[x][i] = '-';
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,4);
							System.out.println("\n(Regla 4 - Fila: "+ (x+1) + ")");
						}
						
					}
					
					//PINTAR REGLA 5 EN FILA
					if(filas.get(x).size()==1 && filas.get(x).get(0) == M-1 && filasResueltas[x]==false)
					{
						if( matriz[x][0] == '-')
						{
							for(int i=1; i< M; i++)
							{
								matriz[x][i] = '#';
							}
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,5);
						}
						
						if( matriz[x][M-1] == '-')
						{
							for(int i=0; i< M-1; i++)
							{
								matriz[x][i] = '#';
							}
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,5);
						}
								
					}
					
					//MARCAR FILA COMO RESUELTA SI LA CANTIDAD DE POSICIONES PINTADAS ES
					//IGUAL A LA CANTIDAD DE POSICIONES A PINTAR
					
					
					if(filasResueltas[x]==false)
					{
						
						boolean posicionesVacias = false;
						int sumaPintadosEnFila = 0;
						int vacias = 0;
						
						for(int i=0; i< M; i++)
						{
							//Determina si existen posiciones disponibles
							if( matriz[x][i] == ' ')
							{
								posicionesVacias = true;
								vacias++;
							}
								
							
							//Suma la cantidad de posiciones pintadas
							if( matriz[x][i] == '#')
								sumaPintadosEnFila++;
						}
						
						//PINTAR REGLA 8 EN FILA
						
						if(posicionesVacias == false )
						{
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,8);
							
						}
						
						//PINTAR REGLA 7 EN FILA
						
						//Determina si la suma de las posiciones pintadas en la columna es
						//igual a la suma de posiciones a pintar
						if(sumaPintadosEnFila == suma && filasResueltas[x]==false)
						{
							//Las posiciones 'disponibles' se actualizan a 'no disponibles'
							for(int i=0; i< M; i++)
							{
								if( matriz[x][i] == ' ' )
									matriz[x][i] = '-';	
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,7);
						}
	
						


						
					}
					
				
				}
			
			}//Fin - For de Filas
		
			
			//CICLO PARA COLUMNAS
			
			tipo = "columna";
			
			for(int x=0 ; x<columnas.size() ; x++)
			{
				int suma = 0;
				int indice = x;
				 
				
				if(columnasResueltas[x]==false)
				{
					//SUMA DE CUADRADOS A PINTAR EN COLUMNA
					for(int i=0; i<columnas.get(x).size(); i++)
					{
						suma = suma + columnas.get(x).get(i);
					}
					
					if(columnas.get(x).size()==1)
					{
						//PINTAR REGLA 1 EN COLUMNA	
						if(columnas.get(x).get(0) == N)
						{
							for(int i=0; i<columnas.get(x).get(0); i++)
							{
								matriz[i][x] = '#';
							}
							
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,1);
									
						}
						
						//PINTAR REGLA 6 EN COLUMNA	
						if(columnas.get(x).get(0) == 0)
						{
							for(int i=0; i<N; i++)
							{
								matriz[i][x] = '-';
							}
							
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,6);								
						}
						
							
					}
					
					
					
					//PINTAR REGLA 2 EN COLUMNA
					if(suma == (N-(columnas.get(x).size()-1)) && columnasResueltas[x]==false)
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
						columnasResueltas[x]=true;
						iteracion++;
						mostrarMatriz(N,M,matriz,iteracion,indice,tipo,2); 
											
					}
					
					//PINTAR REGLA 3 EN COLUMNA	
					if(columnas.get(x).size()==1 && columnasResueltas[x]==false)
					{

						int segmento = columnas.get(x).get(0);
						
						if( matriz[0][x] == '#')
						{
							for(int i=0; i<segmento; i++)
							{
								matriz[i][x] = '#';
							}
							
							for(int i=segmento; i< N; i++)
							{
								matriz[i][x] = '-';
							}
							
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,3);
						}
						
						if( matriz[N-1][x] == '#')
						{
							for(int i=0; i< N-segmento; i++)
							{
								matriz[i][x] = '-';
							}
							
							for(int i=N-segmento; i<N; i++)
							{
								matriz[i][x] = '#';
							}
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,3);
						}
						
							
					}
					
					//PINTAR REGLA 4 EN COLUMNA
					if(columnas.get(x).size()==2 && columnasResueltas[x]==false)
					{
						
						if( matriz[0][x] == '#' && matriz[N-1][x] == '#' )
						{
							int primerSegmento = columnas.get(x).get(0);
							int segundoSegmento = columnas.get(x).get(1);
							
							for(int i=0; i< primerSegmento; i++)
							{
								matriz[i][x] = '#';
							}
							
							for(int i= N-1; i >= N-segundoSegmento; i--)
							{
								matriz[i][x] = '#';
							}
							
							for(int i= primerSegmento; i < N-segundoSegmento; i++)
							{
								matriz[i][x] = '-';
							}
							
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,4);
						}
						
					}
					
					
					
					//PINTAR REGLA 5 EN COLUMNA
					if(columnas.get(x).size()==1 && columnas.get(x).get(0) == N-1 && columnasResueltas[x]==false)
					{
						
						if( matriz[0][x] == '-')
						{
							for(int i=1; i< N; i++)
							{
								matriz[i][x] = '#';
							}
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,5);
						}
						

						if( matriz[N-1][x] == '-')
						{
							for(int i=0; i< N-1; i++)
							{
								matriz[i][x] = '#';
							}
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,5);
						}
								
					}
					
					//MARCAR COLUMNA COMO RESUELTA SI LA CANTIDAD DE POSICIONES PINTADAS ES
					//IGUAL A LA CANTIDAD DE POSICIONES A PINTAR
					
					
					if(columnasResueltas[x]==false)
					{
						
						boolean posicionesVacias = false;
						int sumaPintadosEnColumna = 0;
						
						for(int i=0; i< N; i++)
						{
							//Determina si existen posiciones disponibles
							if( matriz[i][x] == ' ')
								posicionesVacias = true;
							
							//Suma la cantidad de posiciones pintadas
							if( matriz[i][x] == '#')
								sumaPintadosEnColumna++;
						}
						
						//PINTAR REGLA 8 EN COLUMNA
						
						if(posicionesVacias == false)
						{
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,8);
							
						}

						
						//PINTAR REGLA 7 EN COLUMNA
						
						//Determina si la suma de las posiciones pintadas en la columna es
						//igual a la suma de posiciones a pintar
						if(sumaPintadosEnColumna == suma && columnasResueltas[x]==false)
						{
							//Las posiciones 'disponibles' se actualizan a 'no disponibles'
							for(int i=0; i< N; i++)
							{
								if( matriz[i][x] == ' ' )
									matriz[i][x] = '-';	
							}
							
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,7);
						}
						
					}

					
				}//Fin - For de columnas
				
			}
			
			cont++;

					

		}//Fin - While
        
		
		
		
		
		
		System.out.print("\n\n***************************************");
		System.out.print("\n             NONOGRAMA                 \n");

		
		if(nonoResuelto(filasResueltas, columnasResueltas))
			System.out.println("\n\tJUEGO TERMINADO :)");
		else
			System.out.println("\n\tJUEGO INCOMPLETO :(");
		
		System.out.print("\n***************************************\n");
		
		mostrarMatrizCompleta(N,M,matriz,columnas,filas);
		
		System.out.print("\n\n***************************************");
		System.out.print("\n         FILAS Y COLUMNAS              \n");
		System.out.print("\n***************************************\n");
		
		mostrarResueltas(filasResueltas, columnasResueltas);
		
		
		
	}
	
	
	

	
	
	public static void mostrarMatriz(int N, int M , char matriz[][], int iteracion, int indice, String tipo,  int regla )
	{
		String columna = "columna";
		String fila = "fila";
		
		System.out.print("\n-----------------------------------");
		System.out.print("\n\tIteracion: "+ iteracion + "\n\n");
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				System.out.print(" "+matriz[i][j]);
			}
			System.out.println();
			
		}
		
	
		if(columna.equals(tipo))
			System.out.println("\n(Regla " + regla + " - Columna: "+ (indice+1) + ")");
		
		if(fila.equals(tipo))
			System.out.println("\n(Regla " + regla + " - Fila: "+ (indice+1) + ")");
		
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
		
		System.out.println("");
		
		for(int i=0; i<dimFil; i++)
		{	
			for(int j=0; j<dimCol; j++)
			{
				System.out.print(" "+matrizCompleta[i][j]);
			}
			System.out.println();
		
		}
			
	}
	
	public static boolean nonoResuelto(boolean[] filasResueltas, boolean[] columnasResueltas)
	{

		for(int i=0; i<columnasResueltas.length; i++)
		{
			if(columnasResueltas[i]==false)
				return false;
		}
		
		for(int i=0; i<filasResueltas.length; i++)
		{
			if(filasResueltas[i]==false)
				return false;
		}
		
		return true;

	}
	
	public static void mostrarResueltas(boolean[] filasResueltas, boolean[] columnasResueltas)
	{

		for(int i=0 ; i<filasResueltas.length ; i++)
			System.out.println("\n(Fila: "+ (i+1) + " -> " + filasResueltas[i]+")");
		
		for(int i=0 ; i<columnasResueltas.length ; i++)
			System.out.println("\n(Columna: "+ (i+1) + " -> " + columnasResueltas[i]+")");
		
	}
	
	public static boolean sinAvance(int[] filasResueltas, int[] columnasResueltas, int[] auxColResueltas, int[] auxFilResueltas)
	{
		boolean filasIguales = true;
		boolean columnasIguales = true;

		for(int i=0; i<columnasResueltas.length; i++)
		{
			if(columnasResueltas[i] != auxColResueltas[i])
				columnasIguales = false;
		}
		
		for(int i=0; i<filasResueltas.length; i++)
		{
			if(filasResueltas[i] != auxFilResueltas[i])
				filasIguales = false;
		}
		
		//NO HAY AVANCE
		if( filasIguales && columnasIguales)
			return true;
		else
			return false;
	}
	

	


}
