/**
 * Created by DIMA, on 13.08.2018
 */
public class FromPythonToJavaCode159 {
    private static String convertString(String python){
        String[] parts = python.split("_");
        StringBuilder sb = new StringBuilder();
        for (String s : parts){
            sb.append(titleCase(s));
        }
        return sb.toString();
    }


    private static String titleCase(String s){
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(convertString(new java.util.Scanner(System.in).next()));
    }
}
