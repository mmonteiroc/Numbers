/**
 * @author mmonteiro
 * @project Pactica1
 * Creation date: 5/11/18
 */
public class pruebas {

    public static void main(String[] args) {

        int [] desglosado = desglosarNum(1234);
        for (int i = 0; i <desglosado.length ; i++) {
            System.out.println( desglosado[i]);
        }


    }

    public static int[] desglosarNum(long num){
        int[] numeros = new int[Integer.toString((int)num).length()];
        int longNum = Integer.toString((int)num).length();
        int[] numAdividir = new int[longNum];

        for (int i = longNum,j=0, x = 1; i > 0; i--,j++) {
            numAdividir[i-1] = x;
            x = x*10;
        }

        int numero = (int) num;
        for (int i = 0; i < numeros.length; i++) {

            numeros[i] =(int) num/numAdividir[i];

        }

        return numeros;

    }



}
