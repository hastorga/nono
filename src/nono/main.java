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
		boolean auxFilasResueltas[] = new boolean[N];	
		boolean auxColumnasResueltas[] = new boolean[N];
		
		//Contadores
		int iteracion = 0;
		int cont = 0;
		
		//Tipo: "fila" || "columna"
		String tipo;
		
		boolean sinAvance = false;

		//Se inicializa la matriz con el caracter ' ' (Posici�n disponible)
		for(int i=0; i<N; i++)
		{	
			for(int j=0; j<M; j++)
			{
				matriz[i][j] = ' ';
			}
			
		}
	
		//CICLO DE REVISION
		while( sinAvance==false)
		{
			
			/*
			System.out.println("\n************************************************************************");
		    System.out.println("\n\t(WHILE: "+ cont + ") - Juego terminado?: " + nonoResuelto(filasResueltas,columnasResueltas));
		    System.out.println("\n************************************************************************");
			
			System.out.println("\n\tSE COPIAN ARRAYS");
		
			*/
			
			auxFilasResueltas = filasResueltas.clone();
		    auxColumnasResueltas = columnasResueltas.clone();
			
			
			/**--------------------------------CICLO DE FILAS--------------------------------*/
			
			tipo = "fila";
			
			for(int x=0 ; x<filas.size() ; x++)
			{
				int suma = 0;
				int indice = x;
				
				int posPrimerPintado = -1;
				int posUltimoPintado = M;
				
				boolean disponiblesInicio = false;
				boolean disponiblesFinal = false;
				
				int segmento = filas.get(x).get(0);
				
				//Suma de segmentos a pintar en la fila
				for(int i=0; i<filas.get(x).size(); i++)
				{
					suma = suma + filas.get(x).get(i);
				}

				//Encuentra la primera posici�n pintada
				for(int i=0; i<M; i++)
				{
					if( matriz[x][i] == '#')
					{
						posPrimerPintado = i;
						break;
					}	
				}
				
				//Encuentra la ultima posici�n pintada
				for(int i=M-1; i>=0; i--)
				{
					if( matriz[x][i] == '#')
					{
						posUltimoPintado = i;
						break;
					}	
				}
				
				//Determina si existen posiciones disponibles antes de la primera posici�n pintada
				for(int i=0; i<posPrimerPintado; i++)
				{
					if( matriz[x][i] == ' ')
						disponiblesInicio=true;
	
				}
						
				//Determina si existen posiciones disponibles despues de la ultima posici�n pintada
				for(int i=M-1; i>posUltimoPintado; i--)
				{
					if( matriz[x][i] == ' ')
						disponiblesFinal=true;
	
				}
				
				//Se analiza la fila 'x' en caso de no estar resuelta
				if(filasResueltas[x]==false)
				{
					
					//Se analiza la fila en caso de tener un solo segmento a pintar
					if(filas.get(x).size()==1)
					{
						
						/**PINTAR REGLA 1 EN FILA*/
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
						
						/**PINTAR REGLA 6 EN FILA*/
						if(filas.get(x).get(0) == 0 && filasResueltas[x]==false)
						{
							for(int i=0; i<M; i++)
							{
								matriz[x][i] = '-';
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,6);
							
						}
						
						/**PINTAR REGLA 3 EN FILA*/
						if(filasResueltas[x]==false)
						{
							//Caso en que la primera posici�n de la fila est� pintada
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
							
							//Caso en que la ultima posici�n de la fila est� pintada
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
						
						/**PINTAR REGLA 5 EN FILA*/
						if(filas.get(x).get(0) == M-1 && filasResueltas[x]==false)
						{
							//Caso en que la primera posici�n de la fila est� 'no disponible'
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
							
							//Caso en que la ultima posici�n de la fila est� 'no disponible'
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
						
						
						/**PINTAR REGLA 9 EN FILA*/
						if(posPrimerPintado > -1)
						{
							if(disponiblesInicio == false && filasResueltas[x] == false)
							{
								//Se pinta el segmento completo a partir de la primera posici�n pintada
								for(int i=posPrimerPintado; i< posPrimerPintado + segmento; i++)
								{
									matriz[x][i] = '#';
								}
								
								//Se actualizan las posiciones (posteriores al segmento) de 'disponibles' a 'no disponibles' 
								for(int i=posPrimerPintado+segmento; i<M; i++)
								{	
									if( matriz[x][i] == ' ' )
										matriz[x][i] = '-';	
	
								}	
								
								filasResueltas[x]=true;
								iteracion++;
								mostrarMatriz(N,M,matriz,iteracion,indice,tipo,9);
							}
						}
						
						
						/**PINTAR REGLA 10 EN FILA*/
						if(posUltimoPintado < M)
						{
							if(disponiblesFinal == false && filasResueltas[x] == false)
							{
								//Se pinta el segmento completo a partir de la ultima posicion pintada 
								for(int i=posUltimoPintado; i > posUltimoPintado - segmento; i--)
								{
									matriz[x][i] = '#';
								}
								
								//Se actualizan las posiciones (anteriores al segmento) de 'disponibles' a 'no disponibles' 
								for(int i=posUltimoPintado - segmento; i >= 0; i--)
								{	
									if( matriz[x][i] == ' ' )
										matriz[x][i] = '-';	
	
								}	
								
								filasResueltas[x]=true;
								iteracion++;
								mostrarMatriz(N,M,matriz,iteracion,indice,tipo,10);
							}
						}
					

					}
					
					
					/**PINTAR REGLA 2 EN FILA*/
					if(suma == (M-(filas.get(x).size()-1)) && filasResueltas[x]==false)
					{
						
						int indiceFila = 0;
						
						//Se pintan todos los segmentos de la fila
						for(int i=0; i<filas.get(x).size(); i++)
						{

							segmento = filas.get(x).get(i);
							
							//Se pinta un segmento completo
							for(int j=0; j<segmento; j++)
							{
								matriz[x][indiceFila]='#';
								indiceFila++;
							}
							
							//Se agrega un espacio entre segmentos (posici�n 'no disponible')
							if(i<filas.get(x).size()-1)
							{
								matriz[x][indiceFila]='-';
								indiceFila++;
							}
							
						}
						filasResueltas[x]=true;
						iteracion++;
						mostrarMatriz(N,M,matriz,iteracion,indice,tipo,2);
						
					}
					

					
					/**PINTAR REGLA 4 EN FILA*/
					if(filas.get(x).size()==2 && filasResueltas[x]==false)
					{
						
						if( matriz[x][0] == '#' && matriz[x][M-1] == '#' )
						{
							int primerSegmento = filas.get(x).get(0);
							int segundoSegmento = filas.get(x).get(1);
							
							//Se pinta el primer segmento al inicio
							for(int i=0; i< primerSegmento; i++)
							{
								matriz[x][i] = '#';
							}
							
							//Se pinta el segundo segmento al final
							for(int i= M-1; i >= M-segundoSegmento; i--)
							{
								matriz[x][i] = '#';
							}
							
							//Se agregan espacios (posiciones 'no disponibles' entre ambos segmentos
							for(int i= primerSegmento; i < M-segundoSegmento; i++)
							{
								matriz[x][i] = '-';
							}
							
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,4);
						}
						
					}
					

					
					//MARCAR FILA COMO RESUELTA SI LA CANTIDAD DE POSICIONES PINTADAS ES
					//IGUAL A LA CANTIDAD DE POSICIONES A PINTAR
					
					
					if(filasResueltas[x]==false)
					{
						
						boolean posicionesVacias = false;
						int sumaPintadosEnFila = 0;
						
						for(int i=0; i< M; i++)
						{
							//Determina si existen posiciones disponibles
							if( matriz[x][i] == ' ')
								posicionesVacias = true;
								
							//Suma la cantidad de posiciones pintadas
							if( matriz[x][i] == '#')
								sumaPintadosEnFila++;
						}
						
						
						/**PINTAR REGLA 8 EN FILA*/
						if(posicionesVacias == false )
						{
							filasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,8);
							
						}
						
						/**PINTAR REGLA 7 EN FILA*/
						
						//Determina si la suma de las posiciones pintadas en la fila es
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
		
			
			/**--------------------------------CICLO DE COLUMNAS--------------------------------*/
			
			tipo = "columna";
			
			for(int x=0 ; x<columnas.size() ; x++)
			{
				int suma = 0;
				int indice = x;
				
				int posPrimerPintado = -1;
				int posUltimoPintado = N;
				
				boolean disponiblesInicio = false;
				boolean disponiblesFinal = false;
				
				int segmento = columnas.get(x).get(0);
				
				//Suma de segmentos a pintar en la fila
				for(int i=0; i<columnas.get(x).size(); i++)
				{
					suma = suma + columnas.get(x).get(i);
				}

				//Encuentra la primera posici�n pintada
				for(int i=0; i<N ; i++)
				{
					if( matriz[i][x] == '#')
					{
						posPrimerPintado = i;
						break;
					}	
				}
				
				//Encuentra la ultima posici�n pintada
				for(int i=N-1; i>=0; i--)
				{
					if( matriz[i][x] == '#')
					{
						posUltimoPintado = i;
						break;
					}	
				}
				
				//Determina si existen posiciones disponibles antes de la primera posici�n pintada
				for(int i=0; i<posPrimerPintado; i++)
				{
					if( matriz[i][x] == ' ')
						disponiblesInicio=true;
	
				}
						
				//Determina si existen posiciones disponibles despues de la ultima posici�n pintada
				for(int i=N-1; i>posUltimoPintado; i--)
				{
					if( matriz[i][x] == ' ')
						disponiblesFinal=true;
	
				}
				 
				//Se analiza la columna 'x' en caso de no estar resuelta
				if(columnasResueltas[x]==false)
				{
					//Se analiza la columna en caso de tener un solo segmento a pintae
					if(columnas.get(x).size()==1)
					{
						/**PINTAR REGLA 1 EN COLUMNA*/	
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
						
						/**PINTAR REGLA 6 EN COLUMNA*/	
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
						
						/**PINTAR REGLA 3 EN COLUMNA*/	
						if(columnasResueltas[x]==false)
						{
							//Caso en que la primera posici�n de la columna est� pintada
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
							
							//Caso en que la ultima posici�n de la columna est� pintada
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
						
						/**PINTAR REGLA 5 EN COLUMNA*/	
						if(columnas.get(x).get(0) == N-1 && columnasResueltas[x]==false)
						{
							//Caso en que la primera posici�n de la columna est� 'no disponible'
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
							
							//Caso en que la ultima posici�n de la columna est� 'no disponible'
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
						
						/**PINTAR REGLA 9 EN COLUMNA*/	
						if(posPrimerPintado > -1)
						{
							if(disponiblesInicio == false && columnasResueltas[x] == false)
							{
								//Se pinta el segmento completo a partir de la primera posici�n pintada
								for(int i=posPrimerPintado; i< posPrimerPintado + segmento; i++)
								{
									matriz[i][x] = '#';
								}
								
								//Se actualizan las posiciones (posteriores al segmento) de 'disponibles' a 'no disponibles' 
								for(int i=posPrimerPintado+segmento; i<N; i++)
								{	
									if( matriz[i][x] == ' ' )
										matriz[i][x] = '-';	
	
								}	
								
								columnasResueltas[x]=true;
								iteracion++;
								mostrarMatriz(N,M,matriz,iteracion,indice,tipo,9);
							}
						}
						
						/**PINTAR REGLA 10 EN COLUMNA*/
						if(posUltimoPintado < N)
						{
							if(disponiblesFinal == false && columnasResueltas[x] == false)
							{
								//Se pinta el segmento completo a partir de la ultima posicion pintada 
								for(int i=posUltimoPintado; i > posUltimoPintado - segmento; i--)
								{
									matriz[i][x] = '#';
								}
								
								//Se actualizan las posiciones (anteriores al segmento) de 'disponibles' a 'no disponibles' 
								for(int i=posUltimoPintado - segmento; i >= 0; i--)
								{	
									if( matriz[i][x] == ' ' )
										matriz[i][x] = '-';	
	
								}	
								
								columnasResueltas[x]=true;
								iteracion++;
								mostrarMatriz(N,M,matriz,iteracion,indice,tipo,10);
							}
						}
						
							
					}
					
					
					
					/**PINTAR REGLA 2 EN COLUMNA*/	
					if(suma == (N-(columnas.get(x).size()-1)) && columnasResueltas[x]==false)
					{
						
						int indiceColumna = 0;
						
						//Se pintan todos los segmentos de la columna
						for(int i=0; i<columnas.get(x).size(); i++)
						{
							segmento = columnas.get(x).get(i);
							
							//Se pinta un segmento completo
							for(int j=0; j<segmento; j++)
							{
								matriz[indiceColumna][x]='#';
								indiceColumna++;
							}
							
							//Se agrega un espacio entre segmentos (posici�n 'no disponible')
							if(i<columnas.get(x).size()-1)
							{
								matriz[indiceColumna][x]='-';
								indiceColumna++;
							}
							
						}
						columnasResueltas[x]=true;
						iteracion++;
						mostrarMatriz(N,M,matriz,iteracion,indice,tipo,2); 
											
					}
					
					/**PINTAR REGLA 4 EN COLUMNA*/	
					if(columnas.get(x).size()==2 && columnasResueltas[x]==false)
					{
						
						if( matriz[0][x] == '#' && matriz[N-1][x] == '#' )
						{
							int primerSegmento = columnas.get(x).get(0);
							int segundoSegmento = columnas.get(x).get(1);
							
							//Se pinta el primer segmento al inicio
							for(int i=0; i< primerSegmento; i++)
							{
								matriz[i][x] = '#';
							}
							
							//Se pinta el segundo segmento al final
							for(int i= N-1; i >= N-segundoSegmento; i--)
							{
								matriz[i][x] = '#';
							}
							
							//Se agregan espacios (posiciones 'no disponibles' entre ambos segmentos
							for(int i= primerSegmento; i < N-segundoSegmento; i++)
							{
								matriz[i][x] = '-';
							}
							
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,4);
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
						
						
						/**PINTAR REGLA 8 EN COLUMNA*/	
						if(posicionesVacias == false)
						{
							columnasResueltas[x]=true;
							iteracion++;
							mostrarMatriz(N,M,matriz,iteracion,indice,tipo,8);
							
						}

						
						/**PINTAR REGLA 7 EN COLUMNA*/	
						
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

					
				}
				
			}//Fin - For de columnas
			
			
		    
		    sinAvance = sinAvance(filasResueltas, columnasResueltas, auxFilasResueltas, auxColumnasResueltas);
		    
		    //System.out.println("\n\t\t[sinAvance while] : " + sinAvance);
		    //System.out.println("\n\t\t[nonoResuelto while] : " + nonoResuelto);
			
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
			System.out.println("\n(Columna " + (indice+1) + " - Regla: "+ regla + ")");
		
		if(fila.equals(tipo))
			System.out.println("\n(Fila " + (indice+1) + " - Regla: "+ regla + ")");
		
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
	
	public static void mostrarResueltas(boolean[] filasResueltas, boolean[] columnasResueltas)
	{

		for(int i=0 ; i<filasResueltas.length ; i++)
			System.out.println("\n(Fila: "+ (i+1) + " -> " + filasResueltas[i]+")");
		
		for(int i=0 ; i<columnasResueltas.length ; i++)
			System.out.println("\n(Columna: "+ (i+1) + " -> " + columnasResueltas[i]+")");
		
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
	
	public static boolean sinAvance(boolean[] filasResueltas, boolean[] columnasResueltas, boolean[] auxFilasResueltas, boolean[] auxColumnasResueltas)
	{
		boolean filasIguales = true;
		boolean columnasIguales = true;

		/*
		System.out.println("\t-----------AVANCE -----------------");
		
		
		for (int i=0; i<auxFilasResueltas.length; i++)
		{
			System.out.println("\tFILAS:    AUXILIAR[" +i+"]: "+auxFilasResueltas[i]+" <--->  FILAS["+i+"]: " + filasResueltas[i]);
		}
		
		System.out.println("\n");

		for (int i=0; i<auxColumnasResueltas.length; i++)
		{
			System.out.println("\tCOLUMNAS:    AUXILIAR[" +i+"]: "+auxColumnasResueltas[i]+" <--->  FILAS["+i+"]: " + columnasResueltas[i]);
		}
		*/
		
		//Se comprueba si hay cambios de los arrays con respecto a la revision anterior
		for(int i=0; i<filasResueltas.length; i++)
		{
			if(filasResueltas[i] != auxFilasResueltas[i])
				filasIguales = false;
		}
		for(int i=0; i<columnasResueltas.length; i++)
		{
			if(columnasResueltas[i] != auxColumnasResueltas[i])
				columnasIguales = false;
		}

		
		//Se determina si se puede avanzar a una siguiente revision de filas y columnas
		if( filasIguales && columnasIguales)
		{
			System.out.println("\n\t\t[SIN Avance para la siguiente revision]");
			//System.out.println("\t-----------FIN AVANCE -----------------");
			return true;
		}
		else
		{
			System.out.println("\n\t\t[HAY Avance para la siguiente revision]");
			//System.out.println("\t-----------FIN AVANCE -----------------");
			return false;
		}
			
	}
	

}
