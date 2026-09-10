package util;

@lombok.ToString
public class MyUtil {
    public MyUtil() {
    }

    public static String trim( String str ) {
        return str.trim().replaceAll( "\n|\t", "" )
                .replaceAll( "\\s+", " " );
    }

    public static boolean validar( String str ) {
        //Predicate<String> SEGURO_PERMISIVO = str -> str != null && !str.isEmpty();
        java.util.function.Predicate<String> estrategia = val -> val != null && !val.isBlank() && !val.isEmpty();
        return estrategia.test( str );
    }

    public static int toInt( String str, int valDefecto ) {

        int myInt = -1;

        try {
            myInt = Integer.valueOf( str );
        } catch( NumberFormatException e ) {
            myInt = valDefecto;
        }

        return myInt;
    }
}
