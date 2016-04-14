import java.io.IOException;

import Statistics.Statistics;
/**
*Nombre del Programa: Integration Of the t Function Using Simpson Rule
*@author Mario Andres Ochoa Camacho
*@version 1.0
*Fecha: 13/04/2016
*Descripcion: Calcula la Integral de la funcion t usando la Regla de Simpson

*Import: java.io.IOException
*Paquete: Statistics
*Clase: Main
*Metodos: main,BeginCalc

*Instrucciones de Uso:
*Solo es ecesario ejecutar el programa y se calculan los vlaores, si se desean calcualr otros es necesario modificar el programa
*/
public class Main {
/**
 * Clase Princial
 * @param args
 * @throws IOException 
 */
  public static void main(String[] args){
			
	  System.out.println("Para x=0 a 1.1    y con dof = 9,  el valor de p = " + BeginCalc(0, 1.1,9,10));
	  System.out.println("Para x=0 a 1.1812 y con dof = 10, el valor de p = " + BeginCalc(0, 1.1812,10,10));
	  System.out.println("Para x=0 a 2.750  y con dof = 30, el valor de p = " + BeginCalc(0, 2.750 ,30,10));	
  }
  
  /**
   * Realiza la iteracion para encontrar el valor
   * @param x0 Valor inicial de x
   * @param x1 Valor final de x
   * @param dof Grados de libertad
   * @param numSeg Numero de Segmentos
   * @return Resultado
   */
  private static double BeginCalc(double x0, double x1, int dof, int numSeg){
	  double result=0;
	  double error = 0.00001;
	  double actualValue = 0;
	  double actualError = 0;
	  
	  do{
		  result =  Statistics.CalcSimpson(x0, x1, numSeg, dof);
		  actualError = Math.abs(result-actualValue);
		  actualValue = result;
		  numSeg = numSeg*2;
	  }while(actualError > error);
	  
	  return result;
  }
}