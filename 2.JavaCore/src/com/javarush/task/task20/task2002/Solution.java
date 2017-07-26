package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String fileName = "X:\\Programming\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\test.txt";
            File your_file_name = File.createTempFile(fileName, null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User u1 = new User();
            u1.setCountry(User.Country.RUSSIA);
            u1.setMale(true);
            u1.setBirthDate(new Date(1000));
            u1.setLastName("last1");
            u1.setFirstName("first");
            User u2 = new User();
            u2.setCountry(User.Country.OTHER);
            u2.setMale(false);
            u2.setBirthDate(new Date(10000));
            User u3 = new User();
            javaRush.users.add(u1);
            javaRush.users.add(u2);
            javaRush.users.add(u3);

            List<User> lst = new ArrayList<>();
            lst.add(u1);
            lst.add(u2);
            lst.add(u3);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if (loadedObject.equals(javaRush)){
                System.out.println("OK");
            }else {
                for (int i = 0; i<javaRush.users.size(); i++){

                    User u = loadedObject.users.get(i);
                    System.out.println("LOADED FirstName " + u.getFirstName() + "   SAVED: " + lst.get(i).getFirstName());
                    //System.out.println(u.getFirstName().equals(lst.get(i).getFirstName()));
                    System.out.println("LOADED LastName " + u.getLastName() + "   SAVED: " + lst.get(i).getLastName());
                    //System.out.println(u.getLastName().equals(lst.get(i).getLastName()));
                    System.out.println("LOADED BirthDate " + u.getBirthDate() + "   SAVED: " + lst.get(i).getBirthDate());
                    System.out.println(u.getBirthDate().equals(lst.get(i).getBirthDate()));
                    System.out.println("LOADED isMale " + u.isMale() + "   SAVED: " + lst.get(i).isMale());
                    //System.out.println(u.isMale() == lst.get(i).isMale());
                    System.out.println("LOADED Country " + u.getCountry().getDisplayedName() + "   SAVED: " + lst.get(i).getCountry().getDisplayedName());
                    //System.out.println(u.getCountry()== lst.get(i).getCountry());
                    System.out.println(u.equals(lst.get(i)));
                    System.out.println();
                }
                System.out.println(javaRush.users.equals(loadedObject.users));
            }
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method " + e);
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isUserPresent = users != null ? "yes" : "no";
            printWriter.println(isUserPresent);
            if (users != null){
                printWriter.println(users.size());
                for (int i = 0; i<users.size(); i++){
                    User user = users.get(i);

                    String isUserFirstName = user.getFirstName() !=null ? "yes" : "no";
                    printWriter.println(isUserFirstName);
                    if (user.getFirstName() != null){                        printWriter.println(user.getFirstName());                    }

                    String isUserLastName = user.getLastName() !=null ? "yes" : "no";
                    printWriter.println(isUserLastName);
                    if (user.getLastName() != null){                        printWriter.println(user.getLastName());                    }

                    String isUserBirthDayPresent = user.getBirthDate() != null ? "yes" : "no";
                    printWriter.println(isUserBirthDayPresent);
                    if (user.getBirthDate() != null){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                        printWriter.println(simpleDateFormat.format(user.getBirthDate()));
                    }
                    printWriter.println(user.isMale());

                    String isUserCountryPresent = user.getCountry() !=null ? "yes" : "no";
                    printWriter.println(isUserCountryPresent);
                    if (user.getCountry() != null){
                        printWriter.println(user.getCountry().getDisplayedName());
                    }

                }
            }
            printWriter.flush();
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //System.out.println("starting load");
            //implement this method - реализуйте этот метод
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String isUserPresent = bufferedReader.readLine();
            if (isUserPresent.equals("yes")){
                int usersLenght = Integer.parseInt(bufferedReader.readLine());
                for (int i = 0; i<usersLenght; i++){
                    User user = new User();
                    String isfirstNamePresent = bufferedReader.readLine();
                    if(isfirstNamePresent.equals("yes")){
                        String firstName = bufferedReader.readLine();
                        user.setFirstName(firstName);
                    }
                    String islastNamePresent = bufferedReader.readLine();
                    if(islastNamePresent.equals("yes")){
                        String lastName = bufferedReader.readLine();
                        user.setLastName(lastName);
                    }

                    String isUserBirthDayPresent = bufferedReader.readLine();
                    if (isUserBirthDayPresent.equals("yes")){
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                        Date date = simpleDateFormat.parse(bufferedReader.readLine());
                        //Date date = new Date(Integer.parseInt(bufferedReader.readLine()));
                        user.setBirthDate(date);
                    }
                    boolean isMale = Boolean.parseBoolean(bufferedReader.readLine());
                    user.setMale(isMale);
                    String isUserCountryPresent = bufferedReader.readLine();
                    if(isUserCountryPresent.equals("yes")){
                        String countryString = bufferedReader.readLine();
                        if (countryString.equals("Ukraine")){
                            user.setCountry(User.Country.UKRAINE);
                        }else if(countryString.equals("Russia")){
                            user.setCountry(User.Country.RUSSIA);
                        }else {
                            user.setCountry(User.Country.OTHER);
                        }
                    }
                    users.add(user);
                    //System.out.println("add user " + i);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;


            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}