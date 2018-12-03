import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by DIMA, on 24.07.2018
 */
public class MultiplicationTable134 {
    private class ListPair{
        List<Integer> left, top;
        Scanner scanner = new Scanner(System.in);
        private void getLists(){
            left = IntStream.rangeClosed(scanner.nextInt(), scanner.nextInt()).sorted().boxed().collect(Collectors.toList());
            top = IntStream.rangeClosed(scanner.nextInt(), scanner.nextInt()).sorted().boxed().collect(Collectors.toList());
            scanner.close();
        }
        ListPair() {            getLists();        }
    }

    private List<List<Integer>> calcMultiplicationTable(List<Integer> left, List<Integer> top){
        List<List<Integer>> multyTable = new ArrayList<>();
        for(int row : left){
            List<Integer> numderInRow = new ArrayList<>();
            for (int col : top){
               numderInRow.add(col*row);
            }
            multyTable.add(numderInRow);
        }
        return multyTable;

    }

    private List<String> convertListToString(List<Integer> integerList){
        List<String> stringList = new ArrayList<>();
        for(int a : integerList){
            stringList.add(String.valueOf(a));
        }
        return stringList;

    }
    private void printMultyTable(List<Integer> left, List<Integer> top, List<List<Integer>> table){
        // convert all to string;
        List<String> leftStr = convertListToString(left);
        List<String> topStr = convertListToString(top);
        List<List<String>> tableStr = new ArrayList<>();
        for(List<Integer> list : table){
            List<String> stringList = convertListToString(list);
            tableStr.add(stringList);
        }
        //adding left and top
        topStr.add(0, "");
        for(int i = 0; i<tableStr.size(); i++){
            tableStr.get(i).add(0, leftStr.get(i));
        }
        tableStr.add(0, topStr);

        //print
        for(List<String> list : tableStr){
            System.out.println(list.stream().collect(Collectors.joining("\t")));
        }

    }

    public static void main(String[] args) {
        MultiplicationTable134 m = new MultiplicationTable134();
        ListPair listPair = m.new ListPair();
        m.printMultyTable(listPair.left, listPair.top, m.calcMultiplicationTable(listPair.left, listPair.top));


    }
}
