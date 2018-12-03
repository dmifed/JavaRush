import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by DIMA, on 25.07.2018
 */
public class FootballTeams1138 {
    private Map<String, Integer[]> teamsTable = new HashMap<>();
    private void fillMap(){
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        int countGames = scanner.nextInt();
        for(int i = 0; i< countGames; i++){
            String[] data = scanner.next().split(";");
            String team1 = data[0];
            int goalsByTeam1 = Integer.parseInt(data[1]);
            String team2 = data[2];
            int goalsByTeam2 = Integer.parseInt(data[3]);
            if(goalsByTeam1 > goalsByTeam2) {
                putInMap(team1, "Win");
                putInMap(team2, "Defeat");
            }else if(goalsByTeam1 < goalsByTeam2) {
                putInMap(team1, "Defeat");
                putInMap(team2, "Win");
            }else {
                putInMap(team1, "Deuce");
                putInMap(team2, "Deuce");
            }
        }
        scanner.close();
    }

    private void putInMap(String team, String resultTeam){
        if(teamsTable.containsKey(team)){
            teamsTable.put(team, setResult(resultTeam, teamsTable.get(team)));
        }else {
            Integer[] points = {0,0,0,0,0};
            teamsTable.put(team, setResult(resultTeam, points));
        }
    }

    private Integer[] setResult(String result, Integer[] points){
        //Total_games Wins Draws Defeats Total_points
        //      0       1    2      3        4
        points[0]++;
        switch (result){
            case "Win" : {
                points[1]++;
                points[4] += 3;
                break;
            }
            case "Defeat" : {
                points[3]++;
                break;
            }
            case "Deuce" : {
                points[2]++;
                points[4] += 1;
                break;
            }
        }
        return points;
    }

    private void printResult(){
        for(Map.Entry<String, Integer[]> entry : teamsTable.entrySet()){
            System.out.println(entry.getKey() + ":" + arrayToString(entry.getValue()));
        }
    }
    private String arrayToString(Integer[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arr.length-1; i++){
            sb.append(arr[i]);
            sb.append(" ");
        }
        sb.append(arr[arr.length-1]);
        return sb.toString();
    }

    public static void main(String[] args) {
        FootballTeams1138 f = new FootballTeams1138();
        f.fillMap();
        f.printResult();
    }
}
