package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.*;

/*
Читаем и пишем в файл: Human
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String fileName = "X:\\Programming\\IdeaProjects\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2001\\test.txt";
            File your_file_name = File.createTempFile(fileName, null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            System.out.println(somePerson.name);
            System.out.println(somePerson.assets.size());
            for(int i = 0; i < somePerson.assets.size(); i++){
                System.out.println(somePerson.assets.get(i).getName() + " " + somePerson.assets.get(i).getPrice());
            }
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if(ivanov.equals(somePerson)) System.out.println("OK");
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method" + e);
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;
            // если нейм не равно нул, то вернуть
            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;

        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //System.out.println("save start");
            PrintWriter printWriter = new PrintWriter(outputStream);
            String isAssetPresent = assets != null ? "yes" : "no";
            printWriter.println(isAssetPresent);
            if (assets != null){
                printWriter.println(assets.size());
                for(int i = 0; i<assets.size(); i++){
                    printWriter.println(assets.get(i).getName());
                    printWriter.println(String.valueOf(assets.get(i).getPrice()));
                }
            }
            printWriter.println(name);
            printWriter.flush();
            //System.out.println("saving " + name);
            //System.out.println("save end");
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            //System.out.println("load start");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String isAssetPresent = bufferedReader.readLine();
            if (isAssetPresent.equals("yes")){
                assets = new ArrayList<>();
                int sizeAssets = Integer.parseInt(bufferedReader.readLine());
                for (int i = 0; i<sizeAssets; i++){
                    String nameAsset = bufferedReader.readLine();
                    double priceAsset = Double.parseDouble(bufferedReader.readLine());
                    Asset asset = new Asset(nameAsset);
                    asset.setPrice(priceAsset);
                    assets.add(asset);
                }
            }
            name = bufferedReader.readLine();
        }
    }
}