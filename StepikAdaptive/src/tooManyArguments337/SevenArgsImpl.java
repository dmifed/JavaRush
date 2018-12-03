package tooManyArguments337;

/**
 * Created by DIMA, on 06.08.2018
 */
public class SevenArgsImpl {
    static SevenArgs sevenArgs = (a,b,c,d,e,f,g) -> (a+b+c+d+e+f+g).toUpperCase();

    public static void main(String[] args) {
        System.out.println(sevenArgs.changeCase("a", "b", "c", "d", "e", "f", "g"));
    }

}
