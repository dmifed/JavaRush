package zipStream;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by DIMA on 26.02.2018.
 */
public class ZipStream01 {
    public static void main(String[] args) throws Exception{
        // создаем архив
        FileOutputStream zipFile = new FileOutputStream("E:\\test31Level\\zipTest\\archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него ZipEntry – «архивный объект»
        zip.putNextEntry(new ZipEntry("docInArhive.txt"));

        //копируем файл «doc.txt» в архив под именем «docInArhive.txt»
        File file = new File("E:\\test31Level\\zipTest\\doc.txt");
        Files.copy(file.toPath(), zip);

        // закрываем архив
        zip.close();
    }
}
