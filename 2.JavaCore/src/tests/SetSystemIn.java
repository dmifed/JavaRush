package tests;

import java.io.*;

/**
 * Created by dima on 08.02.2017.
 */
public class SetSystemIn {
    public static void main(String[] args) throws IOException    {
        //кладем данные в строку
        StringBuilder sb = new StringBuilder();
        sb.append("Lena").append('\n');
        sb.append("Olya").append('\n');
        sb.append("Anya").append('\n');
        String data = sb.toString();

        InputStream is = new ByteArrayInputStream(data.getBytes());//Оборачиваем строку в класс ByteArrayInputStream
        System.setIn(is); //подменяем in
        readAndPrintLine(); //вызываем обычный метод, который не подозревает о наших манипуляциях
    }

    public static void readAndPrintLine() throws IOException    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while (true)        {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }
}
