import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 25.07.2018
 */
public class LCDСalculator1152 {
    private static final String[] GOR_LINES = {" ", "-", "-", " "};
    private static final String[] VERT_LINES_ALL = {"|", " ", " ", "|"};
    private static final String[] VERT_LINES_LEFT = {"|", " ", " ", " "};
    private static final String[] VERT_LINES_RIGHT = {" ", " ", " ", "|"};
    private static final String[] SPACES = {" ", " ", " ", " "};

    private static final String[][] NUM_0 = {GOR_LINES, VERT_LINES_ALL, VERT_LINES_ALL, SPACES, VERT_LINES_ALL, VERT_LINES_ALL, GOR_LINES};
    private static final String[][] NUM_1 = {SPACES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, SPACES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, SPACES};
    private static final String[][] NUM_2 = {GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, GOR_LINES, VERT_LINES_LEFT, VERT_LINES_LEFT, GOR_LINES};
    private static final String[][] NUM_3 = {GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, GOR_LINES};
    private static final String[][] NUM_4 = {SPACES, VERT_LINES_ALL, VERT_LINES_ALL, GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, SPACES};
    private static final String[][] NUM_5 = {GOR_LINES, VERT_LINES_LEFT, VERT_LINES_LEFT, GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, GOR_LINES};
    private static final String[][] NUM_6 = {GOR_LINES, VERT_LINES_LEFT, VERT_LINES_LEFT, GOR_LINES, VERT_LINES_ALL, VERT_LINES_ALL, GOR_LINES};
    private static final String[][] NUM_7 = {GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, SPACES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, SPACES};
    private static final String[][] NUM_8 = {GOR_LINES, VERT_LINES_ALL, VERT_LINES_ALL, GOR_LINES, VERT_LINES_ALL, VERT_LINES_ALL, GOR_LINES};
    private static final String[][] NUM_9 = {GOR_LINES, VERT_LINES_ALL, VERT_LINES_ALL, GOR_LINES, VERT_LINES_RIGHT, VERT_LINES_RIGHT, GOR_LINES};

    private static final String[] ELEM_BORDER = {"|"};
    private static final String[] ELEM_GAP = {" "};
    private static final String[][] VERT_BORDER = {ELEM_BORDER, ELEM_BORDER, ELEM_BORDER, ELEM_BORDER, ELEM_BORDER, ELEM_BORDER, ELEM_BORDER};
    private static final String[][] VERT_GAP = {ELEM_GAP, ELEM_GAP, ELEM_GAP, ELEM_GAP, ELEM_GAP, ELEM_GAP, ELEM_GAP};

    private List<String[][]> createListNumbers(){
        List<String[][]> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.next().split("");
        list.add(VERT_BORDER);
        for(String num : nums){
            switch (num){
                case "0" : list.add(NUM_0); break;
                case "1" : list.add(NUM_1); break;
                case "2" : list.add(NUM_2); break;
                case "3" : list.add(NUM_3); break;
                case "4" : list.add(NUM_4); break;
                case "5" : list.add(NUM_5); break;
                case "6" : list.add(NUM_6); break;
                case "7" : list.add(NUM_7); break;
                case "8" : list.add(NUM_8); break;
                case "9" : list.add(NUM_9); break;
            }
            list.add(VERT_GAP);
        }
        list.add(VERT_BORDER);
        return list;
    }

    private String[][] createView(List<String[][]> list){
        int rows = 9;
        int column = 0;
        for(String[][] num : list){
            column += num[0].length;
        }
        String[][] strings = new String[9][column];
        strings[0] = topOrBottomLines(column);
        for(int r = 1; r<8; r++){
            // get array[][] from list
            int c = 0;
            for (int elem = 0; elem< list.size(); elem++){ //for all arrays in list
                //read only r-1 row from array
                String[][] stringsInList = list.get(elem);
                for(int i = 0; i<stringsInList[r-1].length; i++){
                    strings[r][c] = stringsInList[r-1][i];
                    c++;
                }
            }
        }
        strings[8] = topOrBottomLines(column);
        return strings;
    }

    private void printTWoDimencicalArrayWithoutSpases(String[][] arr){
        for (String[] ss : arr){
            for (String s : ss){
                System.out.print(s);
            }
            System.out.println();
        }
    }


    private String[] topOrBottomLines(int column){
        String[] strings = new String[column];
        strings[0] = "x";
        for (int i = 1; i<column-1; i++){
            strings[i] = "-";
        }
        strings[column-1] = "x";
        return strings;
    }


    public static void main(String[] args) {
        LCDСalculator1152 m = new LCDСalculator1152();
        m.printTWoDimencicalArrayWithoutSpases(m.createView(m.createListNumbers()));
    }

}
