import java.util.Scanner;

/**
 * Created by DIMA, on 22.08.2018
 */
public class UnitsOfMeasurement161 {
    private static double convertSourceToMillimeters(double num, String sourceUnits){
        switch (sourceUnits){
            case "mile" : return num * 1000*1609;
            case "yard" : return num * 914.4;
            case "foot" : return num * 304.8;
            case "inch" : return num * 25.4;
            case "km" : return num * 1000 * 1000;
            case "m" : return num * 1000;
            case "cm" : return num * 10;
            default : return num;
        }
    }

    private static double converMillimetersToTarget(double millmeters, String targetUnits){
        switch (targetUnits){
            case "mile" : return millmeters / (1000d * 1609d);
            case "yard" : return millmeters / 914.4;
            case "foot" : return millmeters / 304.8;
            case "inch" : return millmeters / 25.4;
            case "km" : return millmeters / (1000d * 1000d);
            case "m" : return millmeters / 1000d;
            case "cm" : return millmeters / 10d;
            default : return millmeters;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        double num = Double.parseDouble(data[0]);
        String source = data[1];
        String target = data[3];
        scanner.close();
        double millimeters = convertSourceToMillimeters(num, source);
        double converted = converMillimetersToTarget(millimeters, target);
        System.out.printf("%.2e" , converted);
    }
}
