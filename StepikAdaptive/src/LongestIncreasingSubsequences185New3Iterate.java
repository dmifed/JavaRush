import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by DIMA, on 20.09.2018
 */
public class LongestIncreasingSubsequences185New3Iterate {
    static List<Num> listOfAllNums;
    static List<Num> maxSeq;
    static long countProlong = 0;
    static long countModify = 0;


    public static void main(String[] args) {
        getList();
        listOfAllNums = trimLastsUnnecessaryElements(listOfAllNums);
        remarkIndexes();
        listOfAllNums = trimStartsUnnecessaryElements(listOfAllNums);
        remarkIndexes();
        //System.out.println("prepared list " + listOfAllNums);

        for (int i = 0; i < listOfAllNums.size(); i++){
            List<Num> currentSeq = null;
            //System.out.println("max seq " + maxSeq + " on step " + i);
            setAllElemToFalse(listOfAllNums, 0);
            if(i == 0){
                currentSeq = createSeq(0);
                maxSeq = new ArrayList<>(currentSeq);
                countModify++;
                modifySeq(currentSeq);

            }else {
                if(listOfAllNums.get(i).value < maxSeq.get(0).value){
                    currentSeq = createSeq(i);
                    if(currentSeq.size() > maxSeq.size()){
                        maxSeq = new ArrayList<>(currentSeq);
                    }
                    countModify++;
                    modifySeq(currentSeq);
                }
            }


        }
        //System.out.println("FINAL " + maxSeq);
        //System.out.println(countProlong);
        print(maxSeq);
    }
    // build seq on original seq without last elem
    private static void modifySeq(List<Num> seq){
        while (seq.size() > 1){
            Num lastElem = seq.get(seq.size()-1);
            lastElem.isAlreadyUsed = true;
            seq = seq.subList(0, seq.size()-1);
            Num firstAdded = getNextElem(seq.get(seq.size() - 1));
            if(firstAdded == null){
                continue;
            }
            int indexFirstAddedInSeq = seq.size();
            Num elemInMaxSeq = maxSeq.get(indexFirstAddedInSeq);
            if(elemInMaxSeq.value <= firstAdded.value && elemInMaxSeq.index <= firstAdded.index){
                continue;
            }
            //decide to prolong seq
            setAllElemToFalse(listOfAllNums, firstAdded.index);
            List<Num> prolongerSeq = prolongSeq(seq, firstAdded);
            if(prolongerSeq.size() > maxSeq.size()){
                maxSeq = prolongerSeq;
            }
            seq = prolongerSeq;
        }
    }

    private static List<Num> prolongSeq(List<Num> seq, Num first){
        countProlong++;
        List<Num> prolongedSeq = new ArrayList<>(seq);
        prolongedSeq.add(first);
        Num lastAdded = first;
        int startIndex = first.index + 1;
        for (int i = startIndex; i < listOfAllNums.size(); i++){

            if(listOfAllNums.get(i).value > lastAdded.value && !listOfAllNums.get(i).isAlreadyUsed){
                //if(maxSeq.size() >= prolongedSeq.size()){Num elemInSamePositionInMaxSeq = maxSeq.get(prolongedSeq.size()-1);}
                prolongedSeq.add(listOfAllNums.get(i));
                lastAdded = listOfAllNums.get(i);
            }
        }
        //System.out.println("prolonger seq " + seq);
        //System.out.println("prolonger seq " + prolongedSeq + " modify " + countModify + ", on count " + countProlong);
        return prolongedSeq;
    }
    //create initial seq
    private static List<Num> createSeq(int startIndex){
        List<Num> currentSeq = new ArrayList<>();
        currentSeq.add(listOfAllNums.get(startIndex));
        int currentSeqSize = 1;
        Num n;
        while ((n = getNextElem(currentSeq.get(currentSeqSize-1))) != null){
            currentSeq.add(n);
            currentSeqSize++;
        }
        //System.out.println("created seq " + currentSeq);
        return currentSeq;
    }
    private static Num getNextElem(Num lastAddedElem){
        //System.out.println("START FIND");
        Num nextElem = null;
        int startIndexToSearch = lastAddedElem.index;
        for(int i = startIndexToSearch+1; i < listOfAllNums.size(); i++){
            //System.out.println(listOfAllNums.get(i));
            if(lastAddedElem.value < listOfAllNums.get(i).value && !listOfAllNums.get(i).isAlreadyUsed){
                nextElem = listOfAllNums.get(i); // the first relevant elem
                // try to find more relevant elem
                for(int j = i+1; j < listOfAllNums.size(); j++){
                    // if next next elem can be taken
                    Num elemToCheckToAdd = listOfAllNums.get(j);
                    if(!elemToCheckToAdd.isAlreadyUsed && elemToCheckToAdd.value > lastAddedElem.value){
                        if(nextElem.value > elemToCheckToAdd.value){
                            nextElem = elemToCheckToAdd;
                        }else {
                            //System.out.println("RETURNED " + nextElem);
                            return nextElem;
                        }
                    }
                }
                //nextElem.isAlreadyUsed = true;
                return nextElem;
            }
        }
        return nextElem;
    }
    private static void setAllElemToFalse(List<Num> list, int startIndex){
        for (int i = startIndex; i < list.size(); i++){
            list.get(i).isAlreadyUsed = false;
        }
    }
    private static List<Num> trimStartsUnnecessaryElements(List<Num> list){
        //trim array 655432987...4 -> 2987...4
        int index = list.size()-1;
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i).value < list.get(i+1).value){
                index = i;
                break;
            }
        }
        List<Num> trimList = new ArrayList<>();
        for(int i = 0; i < list.size() - index; i++){
            trimList.add(list.get(i + index));
        }
        return trimList;
    }
    private static List<Num> trimLastsUnnecessaryElements(List<Num> list){
        //trim array ...24321 -> ...24
        int index = 0;
        for(int i = list.size()-1; i > 0; i--){
            if(list.get(i).value > list.get(i-1).value){
                index = list.get(i).index;
                break;
            }
        }
        List<Num> trimList = new ArrayList<>();
        for(int i = 0; i < index+1; i++){
            trimList.add(list.get(i));
        }
        return trimList;
    }
    private static void getList(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> intData = Stream.of(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        listOfAllNums = new ArrayList<>();
        for(int i = 0; i < intData.size(); i++){
            Num n = new Num(intData.get(i), i);
            listOfAllNums.add(n);
        }
    }
    private static class Num{
        int index;
        int value;
        boolean isAlreadyUsed;

        public Num(int value, int index) {
            this.index = index;
            this.value = value;
            isAlreadyUsed = false;
        }

        @Override
        public String toString() {
            return value + ":" + index + ":" + isAlreadyUsed;
        }
    }
    private static void remarkIndexes(){
        for(int i = 0 ; i < listOfAllNums.size(); i++){
            listOfAllNums.get(i).index = i;
        }
    }
    private static void print(List<Num> list){
        StringBuilder sb = new StringBuilder();
        for(Num n : list){
            sb.append(n.value).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
