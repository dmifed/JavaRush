package tests;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Properties.*;
/**
 * Created by dima on 17.03.2017.
 */
public class PropertiesTest {


    public static void main(String[] args) throws Exception{
        Properties p = new Properties();
        String fileNAme = "X:\\Programming\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2003\\test.txt";
        p.setProperty("A", "1");
        p.list(new PrintStream(fileNAme));

    }
}
