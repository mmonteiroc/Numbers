/**
 * @author mmonteiro
 * @project Pactica Numbers
 * Creation date: 5/11/18
 */
public class Numbers {

    public static String say(long n) {
        StringBuilder devolucion = new StringBuilder();
        long[] numeroDesglosado = desglosarNum(n);
        devolucion.append(numeros(numeroDesglosado, n));

        return devolucion.toString();
    }

    public static String numeros(long[] numeroDesglosado, long numero){
        StringBuilder devolucion = new StringBuilder();

        if (numero < 20){ // Solo si el numero es unico
            return numBasicos(numero);
        }

        if (numero<100){
            devolucion.append(decenas(numeroDesglosado[0]));
            if (numeroDesglosado[1] != 0)devolucion.append("-"+(numBasicos(numeroDesglosado[1])).toLowerCase());
        }

        if (numero >= 100 && numero <1000){ //100 to 1000  Entre cien y mill
            devolucion.append(numeros(desglosarNum(numero/100),numero/100));   // Aqui nos quedamos con las centenas en
            // adelante y hacemos recursividad solo de las centenas
            devolucion.append(" " + ceros(numeroDesglosado)); //Pedimos a la funcion ceros, que hemos de añadir (hundred, million, ........)
            if (numeroDesglosado[1] != 0){
                devolucion.append(" and "+numeros(desglosarNum(numero%100),numero%100).toLowerCase());
            }else {
                if (numeroDesglosado[2] != 0){
                    devolucion.append(" and "+ numBasicos(numero%10).toLowerCase());
                }
            }
        }
        if (numero>=1000 && numero < 1000000){//1000 to 1000000
            devolucion.append(calcularNumero(1000,numero,numeroDesglosado));
        }
        if (numero>=1000000 && numero < 1000_000_000){ //1.000.000 to 1.000.000.000
            devolucion.append(calcularNumero(1000000,numero,numeroDesglosado));
        }
        if (numero>=1_000_000_000 && numero < 1_000_000_000_000L){ // De 1 billion a 1 trillion
            devolucion.append(calcularNumero(1_000_000_000,numero,numeroDesglosado));
        }
        if (numero>=1_000_000_000_000L && numero < 1_000_000_000_000_000L){// De 1 trillion a 1 quatrillion
            devolucion.append(calcularNumero(1_000_000_000_000L,numero,numeroDesglosado));
        }
        if (numero>=1_000_000_000_000_000L && numero<1_000_000_000_000_000_000L){//1 quatrillion a 1 Quintillion
            devolucion.append(calcularNumero(1_000_000_000_000_000L,numero,numeroDesglosado));
        }
        if (numero>=1_000_000_000_000_000_000L ){//1 Quintillion to +++++++++
            devolucion.append(calcularNumero(1_000_000_000_000_000_000L, numero,numeroDesglosado));
        }
        return devolucion.toString();
    }

    //Multiplicador
    public static String calcularNumero(long divisor, long numero, long[] numDesglosado){
        StringBuilder string = new StringBuilder();
        string.append(numeros(desglosarNum(numero/divisor),numero/divisor));
        string.append(" "+ceros(numDesglosado));
        long[]y = desglosarNum(numero%divisor);
        if (y[0]!=0){
            string.append(" "+ numeros(desglosarNum(numero%divisor),numero%divisor).toLowerCase());
        }
        return string.toString();
    }

    public static String numBasicos(long n){
        //En esta funcion tenemos numeros basicos los cuales son escritos de manera unica con lo cual si el numero va del 0 al 19
        // Entraremos en esta funcion la cual nos devolvera el numero en letras
        switch ((int)n){
            case 0:     return "Zero";
            case 1:     return "One";
            case 2:     return "Two";
            case 3:     return "Three";
            case 4:     return "Four";
            case 5:     return "Five";
            case 6:     return "Six";
            case 7:     return "Seven";
            case 8:     return "Eight";
            case 9:     return "Nine";
            case 10:    return "Ten";
            case 11:    return "Eleven";
            case 12:    return "Twelve";
            case 13:    return "Thirteen";
            case 14:    return "Fourteen";
            case 15:    return "Fifteen";
            case 16:    return "Sixteen";
            case 17:    return "Seventeen";
            case 18:    return "Eighteen";
            case 19:    return "Nineteen";
            default:    return "";
        }
    }

    public static String decenas (long x){
        //ESTA FUNCION NOS DEVUELVE LOS NUMEROS 20,30,40,50,60,70,80,90 YA QUE SON UNICOS
        switch ((int)x){
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

    public static long[] desglosarNum(long num){
        //En esta funcion lo que hacemos es desglosar el numero posicion a posicion
        //Si le pasamos el numero 1234, nos devolvera lo siguiente:
        //Un array con el contenido del numero con las posiciones en orden (pos 0 = 1, pos 1 = 2, pos 2 = 3, pos 3 = 4)
        long[] numeros = new long[Long.toString(num).length()];
        int longNum = Long.toString(num).length();
        long[] numAdividir = new long[longNum];

        long x =1;
        for (int i = longNum,j=0; i > 0; i--,j++) {
            numAdividir[i-1] = x;
            x = x*10;
        }
        long numero = num;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (num/numAdividir[i]);
            num = numero%numAdividir[i];
        }
        return numeros;
    }

    public static String ceros(long[] n){
        //Funcion que dependiendo de la longitud del nº nos
        // retornara lo que le pertenezca (hundred,million......)

        int longitud =  n.length;
        switch (longitud) {
            case 3:
                return "hundred";
            case 4: case 5: case 6:
                return "thousand";
            case 7: case 8: case 9:
                return "million";
            case 10: case 11:case 12:
                return "billion";
            case 13: case 14: case 15:
                return "trillion";
            case 16:case 17: case 18:
                return "quadrillion";
            case 19: case 20: case 21:
                return "quintillion";
        }
        return "";
    }

    public static long words(String s) {
        String[] palabras = s.split(" ");
        long devolver = 0;

        if (s.startsWith("and")){
            //Aqui lo que hacemos es que si la frase que nos pasan empieza por "AND"
            // si es por recursividad, entonces quitamos la primera palabra que es "AND"
            // y continuamos con la funcion words pero con la nueva frase

            String[] palabras1 = new String[palabras.length-1];
            StringBuilder nuevaFrase = new StringBuilder();

            for (int i = 0; i < palabras1.length; i++) {
                palabras1[i] = palabras[i+1];
                nuevaFrase.append(palabras1[i]);
            }

            palabras = palabras1;
            s = nuevaFrase.toString();
        }

        if (palabras.length == 1) { //Si la frase del numero es una unica palabra entramos en esta condicion
            if (s.contains("-")) return decimals(s); //Si contiene un guion, vamos a la funcion de decimales
            if (!s.contains("-")) return basicNumbers(s);//si no contiene un guion, vamos a la funcion basic numbers
        }

        //Comprobamos el numero que es con las palabras que
        // contiene y llamamos a la funcion que le pertenece
        if (s.contains("quintillion")){
            //Multiplicador: 1_000_000_000_000_000_000L
            //cortador: 2
            return wordToNumbers(s,1_000_000_000_000_000_000L,2);

        }else if (palabras[1].contains("hundred") && s.contains("quadrillion") || s.contains("hundred quadrillion")){
            //Multiplicador: 100_000_000_000_000_000L
            // Cortador: 3
            return wordToNumbers(s,100_000_000_000_000_000L,3);

        }else if (s.contains("quadrillion")){
            //Multiplicador: 1_000_000_000_000_000L
            //cortador: 2
            return wordToNumbers(s,1_000_000_000_000_000L,2);

        }else if (palabras[1].contains("hundred") && s.contains("trillion") || s.contains("hundred trillion")){
            //Cortador: 3
            //Multiplicador: 100_000_000_000_000L
            return wordToNumbers(s,100_000_000_000_000L,3);

        }else if (s.contains("trillion")){
            //cortador: 2
            //Multiplicador: 1_000_000_000_000L
            return wordToNumbers(s,1_000_000_000_000L,2);

        }else if (palabras[1].contains("hundred") && s.contains("billion") || s.contains("hundred billion")){
            //Cortador: 3
            //Multiplicador: 100_000_000_000L
            return wordToNumbers(s,100_000_000_000L,3);

        }else if (s.contains("billion")){
            //cortador: 2
            //Multiplicador: 1_000_000_000
            return wordToNumbers(s,1_000_000_000,2);

        }else if (palabras[1].contains("hundred")&& s.contains("million") || s.contains("hundred million")){
            //Cortador: 3
            //Multiplicador: 100000000
            return wordToNumbers(s,100000000,3);

        }else if (s.contains("million")) {
            //cortador: 2
            //Multiplicador: 1000000
            return wordToNumbers(s,1000000,2);
        }else if (palabras[1].contains("hundred")&&s.contains("thousand") || s.contains("hundred thousand")){
            //Cortador: 3
            //Multiplicador: 100000
            return wordToNumbers(s,100000,3);
        }else if (s.contains("thousand")){
            //cortador: 2
            //Multiplicador: 1000
            return wordToNumbers(s,1000,2);
        }else if(s.contains("hundred")){
            return hundred(s);
        }

        return devolver;
    }

    public static long basicNumbers(String s){
        switch (s){ //Definimos numeros especiales unicos
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

    //FUNCIONES PARA DESGLOSAR Y AÑADIR NUMEROS
    //Linea 294 to 483
    public static long decimals(String s){
        long devolucion = 0;
        //Separamos el numero cortando en el guion y sumamos los dos numeros
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

    public static long wordToNumbers (String num, long multiplicador, int cortador){
        long devolver =0;
        String[] palabras = num.split(" ");

        devolver += words(palabras[0].toLowerCase());   // Añadimos el primer numero de la frase a devolver
        devolver *= multiplicador;                      // Lo multiplicamos por multiplicador
        // (Esto nos soluciona si son numeros exactos Ex: 3.000.000.000.000.000.000)
        if (palabras.length>cortador){
            devolver+=words(newNumber(palabras,cortador));
        }
        return devolver;
    }

    //Funcion para crear nuevas frases quitando los numeros iniciales
    public static String newNumber(String[] a, int x){
        StringBuilder newNum = new StringBuilder();
        for (int i = x; i < a.length; i++) {
            newNum.append(a[i]+" ");
        }
        return newNum.toString();
    }
}