import java.util.Scanner;

/**
 * Created by DIMA, on 12.11.2018
 */
public class SwimmingPool117 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int distanceToLongEdgeX = scanner.nextInt();
        int distanceToShortEdgeY = scanner.nextInt();
        scanner.close();
        int lengthOfLongEdge = N >= M ? N : M;
        int lengthOfShortEdge = N <= M ? N : M;

        int minDistanceToLongEdge = distanceToLongEdgeX <= (lengthOfShortEdge - distanceToLongEdgeX) ? distanceToLongEdgeX : lengthOfShortEdge - distanceToLongEdgeX;
        int minDistanceToShortEdge = distanceToShortEdgeY <= (lengthOfLongEdge - distanceToShortEdgeY) ? distanceToShortEdgeY : lengthOfLongEdge - distanceToShortEdgeY;

        int minDistance = minDistanceToLongEdge <= minDistanceToShortEdge ? minDistanceToLongEdge : minDistanceToShortEdge;
        System.out.println(minDistance);

    }


}
