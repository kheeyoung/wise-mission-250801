package com.ll.wiseSaying;


import java.io.BufferedReader;
import java.io.IOException;

public class App {
    static BufferedReader br= new BufferedReader(new java.io.InputStreamReader(System.in));
    private WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    private WiseSayingService wiseSayingService = new WiseSayingService();
    private WiseSayingController phaseController = new WiseSayingController();

    public void run() throws IOException {
        System.out.println("== 명언 앱 ==");
        while (true) {
            String commend = phaseController.getCommend();
            switch (commend.substring(0,2)) {
                case "종료":
                    return;

                case "목록":
                    if(commend.length() == 2) {
                        phaseController.showList();
                        break;
                    } phaseController.search(commend);

                    break;

                case "등록":
                    phaseController.insert();
                    break;

                case "수정":
                    phaseController.update(commend);
                    break;

                case "삭제":
                    phaseController.delete(commend);
                    break;

                case "빌드":
                    phaseController.bulid();
                    break;


                default:
                    System.out.println("알 수 없는 명령입니다. 다시 시도하세요.");
            }
        }
    }
}