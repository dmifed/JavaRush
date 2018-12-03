import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by DIMA, on 29.08.2018
 */
public class PolygonalCurve199 {
    private static class Point implements Comparable{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            if(this.x > p.x) return 1;
            else if(this.x < p.x) return -1;
            else return Integer.compare(this.y, p.y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private static List<Point> createList(){
        Scanner scanner = new Scanner(System.in);
        int countPoints = scanner.nextInt();
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < countPoints; i++){
            list.add(new Point(scanner.nextInt(), scanner.nextInt()));
        }
        scanner.close();
        return list;
    }

    public static void main(String[] args) {
        List<Point> list = createList();
        ReversePiramide<Point> pointReversePiramide = new PolygonalCurve199.ReversePiramide<>();
        for(Point p : list){
            pointReversePiramide.insert(p);
        }
        pointReversePiramide.print();



    }

    private static class ReversePiramide<T extends Comparable>{
        private List<T> list;
        private int currentSize = 0;
        public ReversePiramide(){
            list = new ArrayList<>();
        }

        public boolean insert (T point){
            list.add(point);
            goUp(currentSize);
            currentSize++;
            return true;
        }

        public T remove(){
            //System.out.println("remove " + list);
            T point = list.get(0);
            if(list.size() == 1){
                return point;
            }
            list.set(0, list.get(list.size()-1)); //last point to root
            list.remove(list.size()-1);
            goDown(0);
            return point;
        }

        private void goDown(int index){
            int smallChildIndex;
            T tmpPoint = list.get(index); //root to tmp
            while (index < list.size()/2){ //while list.index has child. If index < size/2 index at bottom level
                int leftChildIndex = 2*index + 1;
                int rightChildIndex = leftChildIndex + 1;
                // if parent has right child then compare two children to find out min of them
                if(rightChildIndex < list.size() && list.get(leftChildIndex).compareTo(list.get(rightChildIndex)) > 0){
                    smallChildIndex = rightChildIndex;
                }else {
                    smallChildIndex = leftChildIndex;
                }
                // if point < smallChild stop
                if(tmpPoint.compareTo(list.get(smallChildIndex)) < 0){
                    break;
                }

                list.set(index, list.get(smallChildIndex));
                index = smallChildIndex;
            }
            list.set(index, tmpPoint);
        }

        private void goUp(int index){
            int indexParent = (index-1)/2; //calc index of parent
            T tmpPoint = list.get(index); //save new point to tmp
            // find place to insert new point
            while (index > 0 && list.get(indexParent).compareTo(tmpPoint) > 0){ //while not at top and parent > point
                list.set(index, list.get(indexParent)); //parent to down
                index = indexParent; // change index to insert point
                indexParent = (indexParent-1) / 2; //parent of parent
            }
            list.set(index, tmpPoint);
        }

        public List<T> getArr(){
            return list;
        }

        public void print() {
            //System.out.println("test " + list);
            int size = list.size();
            for(int i = 0; i < size; i++){
                System.out.println(remove());
            }

        }
    }
}
