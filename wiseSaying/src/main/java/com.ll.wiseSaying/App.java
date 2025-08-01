package main.java.com.ll.wiseSaying;

import main.java.com.ll.wiseSaying.WiseSayingController;
import main.java.com.ll.wiseSaying.WiseSayingRepository;
import main.java.com.ll.wiseSaying.WiseSayingService;

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
            switch (commend) {
                case "종료":
                    return;

                case "목록":
                    phaseController.showList();
                    break;

                case "등록":
                    phaseController.insert();
                    break;

                case "수정":
                    phaseController.update();
                    break;

                case "삭제":
                    phaseController.delete();
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