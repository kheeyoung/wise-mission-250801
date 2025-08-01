package com.ll.wiseSaying;

import java.io.*;
import java.util.ArrayList;

public class WiseSayingRepository {
    private String url = "db/wiseSaying";

    public String getNum() throws IOException {

        File file = new File(url + "/lastId.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        return line;

    }

    public void updateNum(int num) throws IOException {
        File file = new File(url + "/lastId.txt");
        File parentDir = file.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();  // 폴더 자동 생성
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(num + "");

        bufferedWriter.close();
    }

    public void insert(int id, String data) throws IOException {
        FileWriter fileWriter = new FileWriter(url + "/"+id+".json");
        fileWriter.write(data);

        fileWriter.close();
    }

    public String readDoc(int i) throws IOException{
        File file = new File(url + "/"+i+".json");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        bufferedReader.close();
        fileReader.close();
        return line;
    }

    public boolean exists(int id) {
        File file = new File(url + "/" + id + ".json");
        return file.exists();
    }

    public void delete(int id) {
        File file = new File(url + "/" + id + ".json");
        file.delete();
    }


    public void makeBuildFile(ArrayList<String> data) throws IOException {
        FileWriter fileWriter = new FileWriter(url + "/data.json");
        fileWriter.write(String.valueOf(data));

        fileWriter.close();
    }
}