package floorspaceOfTheRoom121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by DIMA on 06.07.2018.
 */
public class CountSquare {
    public static void main(String[] args) {
        double a, b, c, square;
        String figure;
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            figure = bufferedReader.readLine();
            switch (figure){
                case "triangle" :
                    a = Double.parseDouble(bufferedReader.readLine());
                    b = Double.parseDouble(bufferedReader.readLine());
                    c = Double.parseDouble(bufferedReader.readLine());
                    square = calcSquare(a, b, c);
                    break;
                case "rectangle" :
                    a = Double.parseDouble(bufferedReader.readLine());
                    b = Double.parseDouble(bufferedReader.readLine());
                    square = calcSquare(a, b);
                    break;
                case "circle" :
                    a = Double.parseDouble(bufferedReader.readLine());
                    square = calcSquare(a);
                    break;
                default : square = 0;
            }
            System.out.println(square);


        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    static double calcSquare (double a, double b, double c){
        double p = (a + b + c)/2; //semiperimetr
        double triangleSquare = Math.sqrt(p * (p - a ) * (p - b) * (p - c));
        return triangleSquare;
    }
    static double calcSquare (double a, double b){
        double squareSquare = a*b;
        return squareSquare;
    }
    static double calcSquare (double r){
        double circleSquare = 3.14 * r * r;
        return circleSquare;
    }

}
