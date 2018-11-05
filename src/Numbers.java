import javax.lang.model.util.ElementScanner6;

public class Numbers {

    public static String say(long n) {
        StringBuilder devolucion = new StringBuilder();
        int[] numeroDesglosado = desglosarNum(n);
        devolucion.append(numeros(numeroDesglosado, n));

        return devolucion.toString();
    }


    public static String numeros(int[] x, long n){
        StringBuilder devolucion = new StringBuilder();

        if (n < 20){ // Solo si el numero es unico
            return numBasicos(n);
        }

        if (n<100){
            devolucion.append(decenas(x[0]));
            if (x[1] != 0)devolucion.append("-"+(numBasicos(x[1])).toLowerCase());
        }

        if (n >= 100 && n <1000){ //100 to 1000
            devolucion.append(numeros(desglosarNum(n/100),n/100));
            devolucion.append(" " + ceros(x));
            if (x[1] != 0){
                devolucion.append(" and "+numeros(desglosarNum(n%100),n%100).toLowerCase());
            }else {
                if (x[2] != 0){
                    devolucion.append(" and "+ numBasicos(n%10).toLowerCase());
                }
            }
        }
        if (n>=1000 && n < 1000000){//1000 to 1000000
            devolucion.append(numeros(desglosarNum(n/1000),n/1000)); // si nos pasan 15.000 nos quedamos con la parte 15
            devolucion.append(" " + ceros(x));
            int[] y = desglosarNum(n%1000) ;
            if (y[0]!=0){
                devolucion.append(" "+numeros(desglosarNum(n%1000),n%1000).toLowerCase());
            }
        }
        if (n>=1000000 && n < 1000_000_000){ //1.000.000 to 1.000.000.000
            devolucion.append(numeros(desglosarNum(n/1000000),n/1000000));
            devolucion.append(" " + ceros(x));

            int[] y = desglosarNum(n%1000000) ;
            if (y[0]!=0){
                devolucion.append(" "+numeros(desglosarNum(n%1000000),n%1000000).toLowerCase());
            }
        }
        if (n>=1000_000_000 && n < 1000_000_000_000L){
            devolucion.append(numeros(desglosarNum(n/1000_000_000),n/1000_000_000));
            devolucion.append(" " + ceros(x));
            int[] y = desglosarNum(n%1000_000_000) ;
            if (y[0]!=0){
                devolucion.append(" "+numeros(desglosarNum(n%1000_000_000),n%1000_000_000).toLowerCase());
            }
        }
        if (n>=1000_000_000_000L && n < 1000_000_000_000_000L){
            devolucion.append(numeros(desglosarNum(n/1000_000_000_000L),n/1000_000_000_000L));
            devolucion.append(" " + ceros(x));
            int[] y = desglosarNum(n%1000_000_000_000L) ;
            if (y[0]!=0){
                devolucion.append(" "+numeros(desglosarNum(n%1000_000_000_000L),n%1000_000_000_000L).toLowerCase());
            }
        }

        return devolucion.toString();
    }

    public static String numBasicos(long n){
        //En esta funcion tenemos numeros basicos los cuales son escritos de manera unica con lo cual si el numero va del 0 al 19
        // Entraremos en esta funcion la cual nos devolvera el numero en letras
        switch ((int)n){
            case 0: return "Zero";
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default: return "";
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

    public static String ceros(int [] n){
        int longitud =  n.length;
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
            case 13:
            case 14:
            case 15:
                return "trillion";
            case 16:
            case 17:
            case 18:
                return "quadrillion";

        }
        return "";
    }



    public static long words(String s) {
        String[] palabras = s.split(" ");
        long devolver = 0;

        if (palabras.length == 1){
            if ( s.contains("-"))return decimals(s);
            if (!s.contains("-"))return basicNumbers(s);
        }


        if (s.contains("hundred")){
            devolver = hundred(s);
        }



        return devolver;
    }

    public static long basicNumbers(String s){
        switch (s){ //Numeros especiales unicos en el caso de que nos introduzcan un numero del 0 al 19
            case "zero":return(0);
            case "one":return(1);
            case "two":return(2);
            case "three":return(3);
            case "four":return(4);
            case "five":return(5);
            case "six":return(6);
            case "seven":return(7);
            case "eight":return(8);
            case "nine":return(9);
            case "ten":return(10);
            case "eleven":return(11);
            case "twelve":return(12);
            case "thirteen":return(13);
            case "fourteen":return(14);
            case "fifteen":return(15);
            case "sixteen":return(16);
            case "seventeen":return(17);
            case "eighteen":return(18);
            case "nineteen":return(19);
            case "twenty":return(20);
            case "thirty":return(30);
            case "forty":return(40);
            case "fifty":return(50);
            case "sixty":return(60);
            case "seventy":return(70);
            case "eighty":return(80);
            case "ninety":return(90);
            default:return 0;
        }


    }

    public static long decimals(String s){
        long devolucion = 0;

        String[] pal = s.split("-");
        devolucion = devolucion + basicNumbers(pal[0]);
        devolucion = devolucion + basicNumbers(pal[1]);
        return devolucion;
    }


    public static long hundred(String num){
        String[] palabras = num.split(" ");
        long devolver =0;

        //Nos soluciona los numeros basicos (100,200,300.......900)
        devolver = devolver + basicNumbers(palabras[0]);
        devolver*=100;

        //Si el numero no es exacto añadimos el resto
        if (palabras.length == 4){
            devolver+=words(palabras[3]);
        }
        return devolver;
    }


}
