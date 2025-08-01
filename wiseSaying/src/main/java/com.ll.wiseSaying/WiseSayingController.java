package com.ll.wiseSaying;



import java.io.BufferedReader;
import java.io.IOException;

public class WiseSayingController {
    static BufferedReader br= new BufferedReader(new java.io.InputStreamReader(System.in));
    WiseSayingService wss = new WiseSayingService();
    public void insert() throws IOException {
        System.out.print("명언 : ");
        String quote=br.readLine();
        System.out.print("작가 : ");
        String writer=br.readLine();
        int id =wss.insert(quote, writer);
        System.out.println(id+"번 명언이 등록되었습니다.");
    }

    public String getCommend() throws IOException {
        System.out.print("명령) ");
        return  br.readLine();
    }

    public void showList() throws IOException {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        String[][] data =wss.showList();
        for (String[] line : data) {
            if(line[0] == null) continue; // null 체크
            System.out.println(line[0]+" / " + line[1] + " / " + line[2]);
        }
    }

    public int getId(String commend) {
        try {
            return Integer.parseInt(commend.split("\\?id=")[1]);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형식이 아닙니다. 수정?id=숫자 형식으로 입력해주세요.");
        } catch (Exception e) {
            System.out.println("명령어 형식이 잘못되었습니다. 수정?id=숫자 형식으로 입력해주세요.");

        }
        return -1;
    }

    public void delete(String commend) throws IOException {

        int id=getId(commend);
        if(id == -1) return; // 잘못된 ID 처리
        int result = wss.delete(id);
        if(result==0){
            System.out.println(id+"번 명언은 존재하지 않습니다.");
        }else{
            System.out.println(id+"번 명언이 삭제되었습니다.");
        }
    }

    public void update(String commend) throws IOException {
        int id=getId(commend);
        if(id == -1) return; // 잘못된 ID 처리
            String[] doc = wss.getDoc(id);

            if(doc[0] == null){
                System.out.println(id+"번 명언은 존재하지 않습니다.");
                return;
            }

            System.out.println("명언(기존) : "+ doc[1]);
            doc[1]= br.readLine();
            System.out.println("작가(기존) : "+ doc[2]);
            doc[2]= br.readLine();

            wss.update(doc);

    }

    public void bulid() throws IOException {
        wss.build();
    }

    public void search(String commend) throws IOException {
        String key = getKey(commend);
        if (key == "") return; // 잘못된 ID 처리


    }
    public String getKey(String commend) {
        try {
            return commend.split("\\?keywordType=author&keyword=")[1];
        } catch (Exception e) {
            System.out.println("명령어 형식이 잘못되었습니다. 목록?keywordType=author&keyword=키워드 형식으로 입력해주세요.");

        }
        return "";
    }
}