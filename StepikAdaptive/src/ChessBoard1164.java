
import java.util.Scanner;

/**
 * Created by DIMA, on 23.07.2018
 */
public class ChessBoard1164 {
    private TwoCoordinates getCoordinates(){
        Scanner scanner = new Scanner(System.in);
        TwoCoordinates t = new TwoCoordinates(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
        scanner.close();
        return t;
    }

    private String canHit(TwoCoordinates t){
        String hit = "NO";
        if(t.x1 == t.x2 || t.y1 == t.y2) hit = "YES"; //only by lines
        int distByX = Math.abs(t.x1 - t.x2);
        int distByY = Math.abs(t.y1 - t.y2);
        if(distByX == distByY) hit = "YES"; //only by diags
        return hit;
    }

    private class TwoCoordinates{
        private int x1, y1, x2, y2;
        TwoCoordinates(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }

    public static void main(String[] args) {
        ChessBoard1164 c = new ChessBoard1164();
        System.out.println(c.canHit(c.getCoordinates()));
    }


}
