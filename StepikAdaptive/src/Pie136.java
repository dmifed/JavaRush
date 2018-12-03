import java.util.Scanner;

/**
 * Created by DIMA, on 23.07.2018
 */
public class Pie136 {
    private class Students{
        private int csStudents, biologStudents;
        public Students(int csStudents, int biologStudents) {
            this.csStudents = csStudents;
            this.biologStudents = biologStudents;
        }
    }

    private Students getSudents(){
        Scanner scanner = new Scanner(System.in);
        Students s = new Students(scanner.nextInt(), scanner.nextInt());
        scanner.close();
        return s;
    }

    private int findNOD(Students s){
        int csStudents = s.csStudents;
        int biologStudents = s.biologStudents;
        if (csStudents==biologStudents) return csStudents;
        int r = 1;
        while (true){
            r = biologStudents%csStudents;
            if(r != 0){
                biologStudents = csStudents;
                csStudents = r;
            }else {
                return csStudents;
            }

        }
    }
    private int findNOK(Students s){
        int nod = findNOD(s);
        return s.csStudents*s.biologStudents/nod;
    }

    public static void main(String[] args) {
        Pie136 p = new Pie136();
        System.out.println(p.findNOK(p.getSudents()));
    }
}
