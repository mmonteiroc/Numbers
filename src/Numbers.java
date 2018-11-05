
public class Numbers {

    public static String say(long n) {
        StringBuilder devolucion = new StringBuilder();
        int[] numeroDesglosado = desglosarNum(n);
        devolucion.append(numeros(numeroDesglosado, n));

        return devolucion.toString();
    }


    public static long words(String s) {
        return 0;
    }


    public static String numeros(int[] x, long n){
        StringBuilder devolucion = new StringBuilder();

        if (n < 20){ // Solo si el numero es unico
            return numBasicos(n);
        }

        if (n<100){
            devolucion.append(decenas(x[0]));
            if (x[1] != 0)devolucion.append("-"+(numBasicos(x[1])).toLowerCase());
        }else if (n < 1000){
            devolucion.append(numBasicos(x[0]) + " " + ceros(n));
            if (x[1] != 0){
                devolucion.append(" and "+numeros(desglosarNum(n%100),n%100).toLowerCase());
            }else {
                if (x[2] != 0){
                    devolucion.append(" and "+ numBasicos(n%10).toLowerCase());
                }
            }
        }else if(n < 10000){
            devolucion.append(numBasicos(x[0]) + " " + ceros(n));
            if (x[1]!=0){
                devolucion.append(" "+ numeros(desglosarNum(n%1000),n%1000).toLowerCase());
            }
        }else if (n < 100000){
            devolucion.append(numeros(desglosarNum(n/1000),n/1000));
            if (x[1]!=0 ) {
                devolucion.append(" " + ceros(n));
            }else {
                devolucion.append(" "+ceros(n));
            }
            if (x[2]!=0){
                devolucion.append(" "+numeros(desglosarNum(n%1000),n%1000).toLowerCase());
            }

        }else if (n < 1000000){// < 1 millon
            devolucion.append(numeros(desglosarNum(n/1000),n/1000));
            devolucion.append(" " + ceros(n));

            if (x[3] != 0){
                devolucion.append(" "+numeros(desglosarNum(n%1000),n%1000).toLowerCase());
            }else {
                if (x[4]!=0)devolucion.append(" "+numeros(desglosarNum(n%100),n%100).toLowerCase());
            }
        }else if (n <10000000){//1 millon y 10 millones
            devolucion.append(numeros(desglosarNum(n/1000000),n/1000000));
            devolucion.append(" " + ceros(n));

            if (x[1] != 0){
                devolucion.append(" "+numeros(desglosarNum(n%1000000),n%1000000).toLowerCase());
            }else {
                if (x[2]!=0){
                    devolucion.append(" "+numeros(desglosarNum(n%100000),n%100000).toLowerCase());
                }
            }
        }else if (n <100000000){//10 millones y 100 millones
            devolucion.append(numeros(desglosarNum(n/1000000),n/1000000));
            devolucion.append(" " + ceros(n));

            if (x[1] != 0){
                devolucion.append(" "+numeros(desglosarNum(n%1000000),n%1000000).toLowerCase());
            }else {
                if (x[2]!=0){
                    devolucion.append(" "+numeros(desglosarNum(n%1000000),n%1000000).toLowerCase());
                }
            }
        }else if (n < 1000000000){ // 100 millones y 1 billion
            devolucion.append(numeros(desglosarNum(n/100000000),n/100000000));
            devolucion.append(" " + ceros(n));

            if (x[1] != 0){
                devolucion.append(" "+numeros(desglosarNum(n%100000000),n%100000000).toLowerCase());
            }else {
                if (x[2]!=0){
                    devolucion.append(" "+numeros(desglosarNum(n%10000000),n%10000000).toLowerCase());
                }
            }

        }else if (n < 10000000000L){//1 billion a 10 billion
            devolucion.append(numeros(desglosarNum(n/1000000000),n/1000000000));
            devolucion.append(" " + ceros(n));

            if (x[1] != 0){
                devolucion.append(" prueba ");
                devolucion.append(numeros(desglosarNum(n%10000000),n%10000000).toLowerCase());
            }else {
                if (x[2]!=0){
                    devolucion.append(" "+numeros(desglosarNum(n%100000000),n%100000000).toLowerCase());
                }
            }
        }




        return devolucion.toString();

    }

    public static String numBasicos(long n){
        //En esta funcion tenemos numeros basicos los cuales son escritos de manera unica con lo cual si el numero va del 0 al 19
        // Entraremos en esta funcion la cual nos devolvera el numero en letras
        switch ((int)n){
            case 0:
                return "Zero";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            default:
                return "";
        }
    }

    public static String decenas (int x){
        //ESTA FUNCION NOS DEVUELVE LOS NUMEROS 20,30,40,50,60,70,80,90 YA QUE SON UNICOS
        switch (x){
            case 2:return "Twenty";
            case 3:return "Thirty";
            case 4:return "Forty";
            case 5:return "Fifty";
            case 6:return "Sixty";
            case 7:return "Seventy";
            case 8:return "Eighty";
            case 9:return "Ninety";
            default:return "imposible";
        }
    }

    //En esta funcion lo que hacemos es desglosar el numero posicion a posicion
    //Si le pasamos el numero 1234, nos devolvera lo siguiente:
    //Un array con el contenido del numero con las posiciones en orden (pos 0 = 1, pos 1 = 2, pos 2 = 3, pos 3 = 4)
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
            num = numero%numAdividir[i];

        }
        return numeros;
    }

    public static String ceros(long n){
        int longitud =  Integer.toString((int)n).length();
        switch (longitud) {
            case 3:
                return "hundred";
            case 4:
            case 5:
            case 6:
                return "thousand";
            case 7:
            case 8:
            case 9:
                return "million";
            case 10:
            case 11:
            case 12:
                return "billion";
        }
        return "";
    }

}
