import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 08.08.2018
 */
public class RunLengthEncoding1114 {
    private static class Item{
        String letter;
        int count;

        public Item(String letter, int count) {
            this.letter = letter;
            this.count = count;
        }


    }

    private static List<Item> getList(String s){
        List<Item> list = new ArrayList<>();
        String[] letters = s.split("");
        int countLetter = 1;
        for(int i = 1; i < letters.length; i++){
            if(letters[i-1].equals(letters[i])){
                ++countLetter;
            }else {
                list.add(new Item(letters[i-1], countLetter));
                countLetter = 1;
            }
        }
        list.add(new Item(letters[letters.length-1], countLetter));
        return list;
    }

    private static void printListofItems(List<Item> list){
        StringBuilder sb = new StringBuilder();
        for(Item item : list){
            if(item.count > 1){
                sb.append(item.count).append(item.letter);
            }else {
                sb.append(item.letter);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.next();
        printListofItems(getList(line));
    }
}
