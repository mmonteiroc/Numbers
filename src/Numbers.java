/**
 * @author Miguel Monteiro Claveri
 * @email miguelmonteiroclaveri@gmail.com
 * @project Pactica Numbers
 * Creation date: 5/11/18
 */
public class Numbers {

    /**
     * @param numero Numero que recive
     * @return String que devuelve
     * <p>
     * Methods los cuales llama este method
     * @see #desglosarNum(long)
     * @see #numeros(long[], long)
     */
    public static String say(long numero) {
        StringBuilder devolucion = new StringBuilder();
        long[] numeroDesglosado = desglosarNum(numero);
        devolucion.append(numeros(numeroDesglosado, numero));

        return devolucion.toString();
    }

    /**
     * Esta funcion recibe dos parametros y lo que hace es transformarte
     * ese numero que le pasas a la funcion a numero escrito (100 --> one hundred)
     *
     * @param numeroDesglosado Numero que le pasamos desglosado
     * @param numero           Numero que le pasamos para trabajar
     * @return String con el numero que hemos pasado a letras
     * <p>
     * Methods a los cualles llama este method
     * @see #numBasicos(long)
     * @see #decenas(long)
     * @see #numeros(long[], long)
     * @see #desglosarNum(long)
     * @see #terminaciones(long[])
     * @see #obtenerDivisor(long)
     * @see #calcularNumero(long, long, long[])
     */
    public static String numeros(long[] numeroDesglosado, long numero) {
        StringBuilder devolucion = new StringBuilder();
        long divisor = 0;
        if (numero < 20) { // Solo si el numero es unico
            return numBasicos(numero);
        }
        if (numero < 100) {
            devolucion.append(decenas(numeroDesglosado[0]));
            if (numeroDesglosado[1] != 0) devolucion.append("-" + (numBasicos(numeroDesglosado[1])).toLowerCase());
        }
        if (numero >= 100 && numero < 1000) { //100 to 1000  Entre cien y mill
            devolucion.append(numeros(desglosarNum(numero / 100), numero / 100));   // Aqui nos quedamos con las centenas en
            // adelante y hacemos recursividad solo de las centenas
            devolucion.append(" " + terminaciones(numeroDesglosado)); //Pedimos a la funcion terminaciones, que hemos de añadir (hundred, million, ........)
            if (numeroDesglosado[1] != 0) {
                devolucion.append(" and " + numeros(desglosarNum(numero % 100), numero % 100).toLowerCase());
            } else {
                if (numeroDesglosado[2] != 0) {
                    devolucion.append(" and " + numBasicos(numero % 10).toLowerCase());
                }
            }
        }
        if (numero >= 1000) {
            divisor = obtenerDivisor(numero);
            devolucion.append(calcularNumero(divisor, numero, numeroDesglosado));
        }
        return devolucion.toString();
    }

    /**
     * Le pasamos el numero con el que estamos trabajando y nos retorna
     * el divisor que hemos de usar.
     *
     * @param numero numero que le pasamos
     * @return divisor que nos retorna
     */
    public static long obtenerDivisor(long numero) {
        long divisor = 0;
        if (numero >= 1000 && numero < 1_000_000) divisor = 1000; //1000 to 1000000
        if (numero >= 1000000 && numero < 1000_000_000) divisor = 1000000;//1.000.000 to 1.000.000.000
        if (numero >= 1_000_000_000 && numero < 1_000_000_000_000L) divisor = 1_000_000_000;// De 1 billion a 1 trillion
        if (numero >= 1_000_000_000_000L && numero < 1_000_000_000_000_000L)
            divisor = 1_000_000_000_000L; // De 1 trillion a 1 quatrillion
        if (numero >= 1_000_000_000_000_000L && numero < 1_000_000_000_000_000_000L)
            divisor = 1_000_000_000_000_000L; //1 quatrillion a 1 Quintillion
        if (numero >= 1_000_000_000_000_000_000L) divisor = 1_000_000_000_000_000_000L;//1 Quintillion to +++++++++
        return divisor;
    }

    /**
     * En este metodo recibimos un numero (normal y desglosado) y un divisor
     * Llamamos a la funcion numeros pasandole un numero desglosado
     * de (el numero normal / divisor) y un numero normal de (el numero normal / divisor)
     * despues añadimos la terminacion la cual le pertenece a ese numero
     * Si lo que nos queda de numero no es 0 volvemos a hacer recursividad
     * a numeros pero con el residuo de numero original / divisor
     *
     * @param divisor       numero por el cual hemos de dividir (multiplos de 10: 1000, 1.000.000..........)
     * @param numero        numero el cual queremos trabajar
     * @param numDesglosado numero desglosado del numero el cual queremos trabajar
     * @return nos retorna un string con el numero que nosotros le hemos pasado a letras
     * <p>
     * Methods a los cualles llama este method
     * @see #desglosarNum(long)
     * @see #terminaciones(long[])
     * @see #numeros(long[], long)
     */
    public static String calcularNumero(long divisor, long numero, long[] numDesglosado) {
        StringBuilder string = new StringBuilder();
        string.append(numeros(desglosarNum(numero / divisor), numero / divisor));
        string.append(" " + terminaciones(numDesglosado));
        long[] y = desglosarNum(numero % divisor);
        if (y[0] != 0) {
            string.append(" " + numeros(desglosarNum(numero % divisor), numero % divisor).toLowerCase());
        }
        return string.toString();
    }

    /**
     * En esta funcion tenemos numeros basicos los cuales son escritos de manera unica con lo cual si el numero va del 0 al 19
     * entraremos en esta funcion la cual nos devolvera el numero en letras
     *
     * @param numero Numero el cual nosotros le pasamos
     * @return String que nos retorna con el numero que le pertenece
     */
    public static String numBasicos(long numero) {
        switch ((int) numero) {
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

    /**
     * ESTA FUNCION NOS DEVUELVE LOS NUMEROS
     * 20,30,40,50,60,70,80,90 YA QUE SON UNICOS
     *
     * @param decena nos pasan el numero de esa decena
     * @return Nos retorna un String con lo que le pertenece
     */
    public static String decenas(long decena) {
        switch ((int) decena) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
            default:
                return "imposible";
        }
    }

    /**
     * En esta funcion lo que hacemos es desglosar el numero posicion a posicion
     *
     * @param numero Le pasamos un long con el numero que queremos desglosar
     * @return nos retorna un array de long con el numero desglosado
     */
    public static long[] desglosarNum(long numero) {
        char[] numeros = Long.toString(numero).toCharArray();
        StringBuilder st = new StringBuilder();
        long[] devolver = new long[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            st.append(numeros[i] + "-");
        }
        String[] arrString = st.toString().split("-");
        for (int i = 0; i < arrString.length; i++) {
            devolver[i] = Long.parseLong(arrString[i]);
        }
        return devolver;
    }

    /**
     * @param numeroArray Recibimos el numero original splited en un array
     * @return nos devuelve que le pertenece a ese numero("hundred","thousand"....)
     */
    public static String terminaciones(long[] numeroArray) {
        int longitud = numeroArray.length;
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

            case 19:
            case 20:
            case 21:
                return "quintillion";
        }
        return "";
    }

    /**
     * @param fraseNumeros Es el numero en letras el cual le pasamos
     * @returnnos devuelve el numero que le hemos pasado en numeros convencionales
     * <p>
     * Methods a los cualles llama este method
     * @see #decimals(String)
     * @see #basicNumbers(String)
     * @see #wordToNumbers(String, long, int)
     * @see #hundred(String)
     */
    public static long words(String fraseNumeros) {
        String[] palabras = fraseNumeros.split(" ");
        long devolver = 0;

        if (fraseNumeros.startsWith("and")) {
            //Aqui lo que hacemos es que si la frase que nos pasan empieza por "AND"
            // si es por recursividad, entonces quitamos la primera palabra que es "AND"
            // y continuamos con la funcion words pero con la nueva frase
            String[] palabras1 = new String[palabras.length - 1];
            StringBuilder nuevaFrase = new StringBuilder();
            for (int i = 0; i < palabras1.length; i++) {
                palabras1[i] = palabras[i + 1];
                nuevaFrase.append(palabras1[i]);
            }
            palabras = palabras1;
            fraseNumeros = nuevaFrase.toString();
        }

        if (palabras.length == 1) { //Si la frase del numero es una unica palabra entramos en esta condicion
            if (fraseNumeros.contains("-"))
                return decimals(fraseNumeros); //Si contiene un guion, vamos a la funcion de decimales
            if (!fraseNumeros.contains("-"))
                return basicNumbers(fraseNumeros);//si no contiene un guion, vamos a la funcion basic numbers
        }

        //Comprobamos el numero que es con las palabras que
        // contiene y llamamos a la funcion que le pertenece
        if (fraseNumeros.contains("quintillion")) {
            return wordToNumbers(fraseNumeros, 1_000_000_000_000_000_000L, 2);
        } else if (palabras[1].contains("hundred") && fraseNumeros.contains("quadrillion") || fraseNumeros.contains("hundred quadrillion")) {
            return wordToNumbers(fraseNumeros, 100_000_000_000_000_000L, 3);
        } else if (fraseNumeros.contains("quadrillion")) {
            return wordToNumbers(fraseNumeros, 1_000_000_000_000_000L, 2);
        } else if (palabras[1].contains("hundred") && fraseNumeros.contains("trillion") || fraseNumeros.contains("hundred trillion")) {
            return wordToNumbers(fraseNumeros, 100_000_000_000_000L, 3);
        } else if (fraseNumeros.contains("trillion")) {
            return wordToNumbers(fraseNumeros, 1_000_000_000_000L, 2);
        } else if (palabras[1].contains("hundred") && fraseNumeros.contains("billion") || fraseNumeros.contains("hundred billion")) {
            return wordToNumbers(fraseNumeros, 100_000_000_000L, 3);
        } else if (fraseNumeros.contains("billion")) {
            return wordToNumbers(fraseNumeros, 1_000_000_000, 2);
        } else if (palabras[1].contains("hundred") && fraseNumeros.contains("million") || fraseNumeros.contains("hundred million")) {
            return wordToNumbers(fraseNumeros, 100000000, 3);
        } else if (fraseNumeros.contains("million")) {
            return wordToNumbers(fraseNumeros, 1000000, 2);
        } else if (palabras[1].contains("hundred") && fraseNumeros.contains("thousand") || fraseNumeros.contains("hundred thousand")) {
            return wordToNumbers(fraseNumeros, 100000, 3);
        } else if (fraseNumeros.contains("thousand")) {
            return wordToNumbers(fraseNumeros, 1000, 2);
        } else if (fraseNumeros.contains("hundred")) {
            return hundred(fraseNumeros);
        }

        return devolver;
    }

    /**
     * Definimos numeros especiales unicos
     *
     * @param fraseNum Es el numero en letras el cual le pasamos
     * @return nos devuelve el numero que le hemos pasado en numeros convencionales
     */
    public static long basicNumbers(String fraseNum) {
        switch (fraseNum) {
            case "zero":
                return (0);
            case "one":
                return (1);
            case "two":
                return (2);
            case "three":
                return (3);
            case "four":
                return (4);
            case "five":
                return (5);
            case "six":
                return (6);
            case "seven":
                return (7);
            case "eight":
                return (8);
            case "nine":
                return (9);
            case "ten":
                return (10);
            case "eleven":
                return (11);
            case "twelve":
                return (12);
            case "thirteen":
                return (13);
            case "fourteen":
                return (14);
            case "fifteen":
                return (15);
            case "sixteen":
                return (16);
            case "seventeen":
                return (17);
            case "eighteen":
                return (18);
            case "nineteen":
                return (19);
            case "twenty":
                return (20);
            case "thirty":
                return (30);
            case "forty":
                return (40);
            case "fifty":
                return (50);
            case "sixty":
                return (60);
            case "seventy":
                return (70);
            case "eighty":
                return (80);
            case "ninety":
                return (90);
            default:
                return 0;
        }
    }

    /**
     * Este method, nos sirve para numero de 20 a 99
     *
     * @param numeroFrase Es el numero en letras el cual le pasamos
     * @return nos devuelve el numero que le hemos pasado en numeros convencionales
     * <p>
     * Methods a los cualles llama este method
     * @see #basicNumbers(String)
     */
    public static long decimals(String numeroFrase) {
        long devolucion = 0;
        String[] pal = numeroFrase.split("-");//Separamos el numero cortando en el guion y sumamos los dos numeros
        devolucion = devolucion + basicNumbers(pal[0]);
        devolucion = devolucion + basicNumbers(pal[1]);
        return devolucion;
    }

    /**
     * Este method nos sirve para numeros de 100 a 999
     *
     * @param num numero en letras el cual le pasamos
     * @return nos devuelve el numero que le hemos pasado en numeros convencionales
     * <p>
     * Methods a los cualles llama este method
     * @see #words(String)
     * @see #basicNumbers(String)
     */
    public static long hundred(String num) {
        String[] palabras = num.split(" ");
        long devolver = 0;

        devolver = devolver + basicNumbers(palabras[0]);//Nos soluciona los numeros basicos (100,200,300.......900)
        devolver *= 100;
        if (palabras.length == 4) {//Si el numero no es exacto añadimos el resto
            devolver += words(palabras[3]);
        }
        return devolver;
    }

    /**
     * Este method solo funciona en numeros mayores a 1000
     *
     * @param num           Es la frase que contiene el numero
     * @param multiplicador Dependiendo de si es mil, diez mil o cien mill..... recibira un multiplicador (1000,10.000,100.000)
     * @param cortador      Define en que punto de la frase hemos de cortar para llamar a newNumber
     * @return Nos devuelve el numero que le hemos pasado en letras en numeros convencionales
     * <p>
     * Methods a los cualles llama este method
     * @see #newNumber(String[], int)
     * @see #words(String)
     */
    public static long wordToNumbers(String num, long multiplicador, int cortador) {
        long devolver = 0;
        String[] palabras = num.split(" ");

        devolver += words(palabras[0].toLowerCase());   // Añadimos el primer numero de la frase a devolver
        devolver *= multiplicador;                      // Lo multiplicamos por multiplicador
        if (palabras.length > cortador) {
            devolver += words(newNumber(palabras, cortador));
        }
        return devolver;
    }

    /**
     * Funcion la cual nos devuelve una frase con un numero quitando las X palabras del principio
     * con esta funcion acortamos el numero
     *
     * @param arrayNumeros Sera el array de palabras que le pasamos
     * @param cortador     Sera el numero de palabras que ha de cortar por delante
     * @return Nos devuelve una frase con el nuevo numero
     */
    public static String newNumber(String[] arrayNumeros, int cortador) {
        StringBuilder newNum = new StringBuilder();
        for (int i = cortador; i < arrayNumeros.length; i++) {
            newNum.append(arrayNumeros[i] + " ");
        }
        return newNum.toString();
    }
}