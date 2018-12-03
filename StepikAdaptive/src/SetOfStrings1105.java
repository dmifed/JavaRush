
import java.util.Scanner;

/**
 * Created by DIMA, on 19.11.2018
 */
public class SetOfStrings1105 {
    private int startSizeArr = 8;
    private int sizeArr = startSizeArr;
    private String[] setOfStrings = new String[sizeArr];
    private double maxFilling = 0.75;
    private int numberElements = 0;

    private int calcHash(String s, int sizeArr){
        //System.out.println(s + " " + sizeArr);
        return s.chars().map(i -> (i*i)%sizeArr).reduce((i1, i2) -> i1 + i2).orElse(0) % sizeArr;
    }

    private boolean needIncreaseArray(){
        return maxFilling <= (double) numberElements / (double) setOfStrings.length;
    }

    private boolean addingStringToArr(String s){
        if(!needIncreaseArray()){
            // adding string
            return addString(s, setOfStrings);
        }else {
            //System.out.println("increace at " + s + " numberElems = " + numberElements);
            // increase arr
            // adding from all to new array all elements
            copyToNewArray(setOfStrings);
            // adding string
            return addString(s, setOfStrings);
        }
    }

    private boolean remove(String s){
        int index = calcHash(s, setOfStrings.length);
        if(setOfStrings[index] == null) return false;
        if(setOfStrings[index].equals(s)){
            setOfStrings[index] = null;
            --numberElements;
            return true;
        }else {
            int numberAttempt = 1;
            while (numberAttempt <= setOfStrings.length){
                index = (index + numberAttempt) % setOfStrings.length;
                if(setOfStrings[index] == null) return false;
                if (setOfStrings[index].equals(s)) {
                    setOfStrings[index] = null;
                    return true;
                }
                ++numberAttempt;
            }
        }
        return false;
    }

    private boolean find(String s){
        int index = calcHash(s, setOfStrings.length);
        if(setOfStrings[index] == null) return false;
        if(setOfStrings[index].equals(s)){
            return true;
        }else {
            int numberAttempt = 1;
            while (numberAttempt <= setOfStrings.length){
                index = (index + numberAttempt) % setOfStrings.length;
                if(setOfStrings[index] == null) return false;
                if (setOfStrings[index].equals(s)) {
                    return true;
                }
                ++numberAttempt;
            }
        }
        return false;
    }

    private void copyToNewArray(String[] source){
        String[] newArray = new String[source.length * 2];
        numberElements = 0;
        for(String s : source){
            if(s != null){
                addString(s, newArray);
            }

        }
        setOfStrings = newArray;
    }

    private boolean addString(String s, String[] arr){
        int index  = calcHash(s, arr.length);
        if(arr[index] == null){
            arr[index] = s;
            ++numberElements;
        }else {
            boolean isAdding = false;
            int numberAttempt = 1;
            while (!isAdding) {
                if(arr[index].equals(s)) return false;
                index = (index + numberAttempt) % arr.length;
                if (arr[index] == null) {
                    arr[index] = s;
                    isAdding = true;
                    ++numberElements;
                }
                ++numberAttempt;
            }
        }
        return true;
    }

    private String[] parseCommand(String line){
        String[] arr = new String[2];
        String command = line.substring(0, 1);
        String str = line.substring(2);
        arr[0] = command;
        arr[1] = str;
        return arr;
    }

    public static void main(String[] args) {
        SetOfStrings1105 setOfStrings1105 = new SetOfStrings1105();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean result = false;
            String[] data = setOfStrings1105.parseCommand(scanner.nextLine());
            String command = data[0];
            switch (command){
                case "+" :
                    result = setOfStrings1105.addingStringToArr(data[1]);
                    break;
                case "-" :
                    result = setOfStrings1105.remove(data[1]);
                    break;
                case "?" :
                    result = setOfStrings1105.find(data[1]);
                    break;
            }
            System.out.println(result ? "OK" : "FAIL");
        }
    }
}
