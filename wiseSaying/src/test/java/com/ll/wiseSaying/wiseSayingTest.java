package com.ll.wiseSaying;

public class wiseSayingTest {
    public static void main(String[] args) {
        System.out.println("WiseSayingTest 실행 중...");

        WiseSayingService service = new WiseSayingService();

        // 예시: 명언 추가
        try {
            int id = service.insert("삶은 짧고 예술은 길다.", "히포크라테스");
            System.out.println("명언이 추가되었습니다. ID: " + id);
            service.showList(1);
            System.out.println("명언 조회 완료.");
            service.update(new String[]{"1", "삶은 짧고 예술은 길다. (수정됨)", "히포크라테스 (수정됨)"});
            System.out.println("명언이 수정되었습니다. ID: 1");
            service.delete(id);
            System.out.println("명언이 삭제되었습니다. ID: " + id);
            service.build();
            System.out.println("명언 데이터가 빌드되었습니다.");


        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("WiseSayingTest 종료.");
    }
}
