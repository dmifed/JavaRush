import java.util.Scanner;

/**
 * Created by DIMA, on 06.08.2018
 */
public class Cinema1126 {
    private class Room{
        int row;
        int column;
        int[][] seats;
        int countTikets;

        {
            Scanner scanner = new Scanner(System.in);
            row = scanner.nextInt();
            column = scanner.nextInt();
            seats = new int[row][column];
            for (int i = 0; i < row; i++){
                for (int j = 0; j < column; j++){
                    seats[i][j] = scanner.nextInt();
                }
            }
            countTikets = scanner.nextInt();
            scanner.close();
        }
    }

    private static int getRowWithCountTiketsAviadleTogether(Room r){
        int countTiketsInRow = 0;
        int[][] room = r.seats;
        for (int i = 0; i < room.length; i++){
            for (int j = 0; j< room[i].length; j++){
                if(room[i][j] == 0){
                    ++countTiketsInRow;
                    if(countTiketsInRow == r.countTikets){
                        return i+1;
                    }
                }else {
                    countTiketsInRow = 0;
                }
            }
            countTiketsInRow = 0;
        }
        return 0;
    }

    public static void main(String[] args) {
        Cinema1126 c = new Cinema1126();
        System.out.println(getRowWithCountTiketsAviadleTogether(c.new Room()));
    }
}
