/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1p;

import java.util.Scanner;

/**
 *
 * @author Darlin
 */
public class Parcial1P {
    private static final int MATERIAL =0;
    private static final int CANTIDAD =1;
    private static final int PRECIOU =2;
    private static final int PESO =3;
    
    
  
    private static String[][]  comisiones= new String[4][10];
    
    public static void cargarInformacion(int fila){
        Scanner t= new Scanner(System.in);
        System.out.println("Ingrese nombre del material");
        comisiones[fila][MATERIAL]= t.nextLine();
        System.out.println("Ingresa cantidad del material");
        comisiones[fila][CANTIDAD]=t.nextLine();
        System.out.println("Ingresa precio por unidad del material");
        comisiones[fila][PRECIOU]=t.nextLine();
        System.out.println("Ingresa el peso del material ");
        comisiones[fila][PESO]=t.nextLine();
        
    }
    //primer paso: multiplicar el valor de la unidad por el no. de unidades
    public static void paso1(String[][] comisiones){
        int multi = 0;
        String aux, aux2;
        int a,b,i;
        for (i = 0; i < 4; i++) {
            aux=comisiones[i][1];
            aux2=comisiones[i][2];
            a=Integer.parseInt(aux);
            b=Integer.parseInt(aux2);
            multi=a*b;
            comisiones[i][4]=Integer.toString(multi);
        }
    }
    //smultiplicar el valor de cada unidad por el coeficiente de gastos al valor(0.232 omite el paso 2 y 3)
    public static void paso4(String[][] comisiones){
        double multi=0.0;
        String aux;
        int a, i;
        for (i = 0; i < 4; i++) {
            aux=comisiones[i][2];
            a=Integer.parseInt(aux);
            multi=a*Double.valueOf(0.232); //paso 2 y 3 coeficiente de gasto
            comisiones[i][5]=Double.toString(multi);
        }
    }
    //peso de cada unidad por el no. de unidades
    public static void paso5(String[][] comisiones){
        int multi=0;
        String aux, aux2;
        int a,b,i;
        for (i = 0; i < 4; i++) {
            aux=comisiones[i][1];
            aux2=comisiones[i][3];
            a=Integer.parseInt(aux);
            b=Integer.parseInt(aux2);
            multi=a*b;
            comisiones[i][6]=Integer.toString(multi);
        }
    }
    //multiplicar peso de la unidad por el coeficiente del gasto al valor
    public static void paso8(String[][] comisiones){
        double multi=0.0;
        String aux;
        int a, i;
        for (i = 0; i < 4; i++) {
            aux=comisiones[i][3];
            a=Integer.parseInt(aux);
            multi=a*Double.valueOf(0.75); //paso 7: coeficiente de gasto al peso 
            comisiones[i][7]=Double.toString(multi);
        }
    }
    public static void imprimirDecorado(String[][] ma) {
        for (int x = 0; x < ma.length; x++) {
            System.out.print("|");
            for (int y = 0; y < ma[x].length; y++) {
                System.out.print(ma[x][y]);
                if (y != ma[x].length - 1) {
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
    }
    //calcular costo por unidad 
    //suma horizontal entre valor según factura, los gastos al valor, y los gastos al peso de cada unidad
    private static void CostoUnidad(String[][] comisiones){
        double sumaCosto=0.0, a,b,c;
        String aux, aux2, aux3;
        int i;
        for (i = 0; i < 4; i++) {
            aux=comisiones[i][2];
            aux2=comisiones[i][5];
            aux3=comisiones[i][7];
            a= Double.parseDouble(aux);
            b=Double.parseDouble(aux2);
            c=Double.parseDouble(aux3);
            sumaCosto=b+a+c;
            comisiones[i][8]=Double.toString(sumaCosto);
        }
    }
    private static void CostoTotal(String[][] comisiones){
        double multi=0.0,a,b;
        String aux, aux2;
        int i;
        for (i = 0; i < 4; i++) {
            aux=comisiones[i][1];
            aux2=comisiones[i][8];
            a=Double.parseDouble(aux);
            b=Double.parseDouble(aux2);
            multi=a*b;
            comisiones[i][9]=Double.toString(multi);
        }
    }
    private static void SumaCostoTotal(String[][] comisiones){
        double suma=0.0;
        for (int i=0;  i<comisiones.length; i++){
            //for (int j = 0; j < comisiones.length; j++) {
                suma+=Double.parseDouble(comisiones[i][9]);
            //}  
        }
        System.out.println("La suma total es: "+ suma);
    }
    private static void registro(){      
        for (int i = 0; i < comisiones.length; i++) { 
            cargarInformacion(i); 
        }  
    }
    private static void matrizResultante(){
        for (int i = 0;  i<comisiones.length; i++) {
            System.out.println(comisiones[i][0]);
            System.out.print("\t");
            System.out.println("No. de unidades: "+comisiones[i][1]);
            System.out.print("\t");
            System.out.println("Valor segun factura: "+comisiones[i][2]);
            System.out.print("\t");
            System.out.println("Gasto al valor: "+comisiones[i][5]);
            System.out.print("\t");
            System.out.println("Gasto al peso: "+comisiones[i][7]);
            System.out.print("\t");
            System.out.println("Costo por unidad: "+comisiones[i][8]);System.out.print("\t");
            System.out.println("Costo total: "+comisiones[i][9]);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        registro();
        paso1(comisiones);
        paso4(comisiones);
        paso5(comisiones);
        paso8(comisiones);
        CostoUnidad(comisiones);
        CostoTotal(comisiones);
        imprimirDecorado(comisiones);        
        SumaCostoTotal(comisiones);
        System.out.println("---------------------------FACTURA------------------------------------------");
        matrizResultante();
    }
    
}
