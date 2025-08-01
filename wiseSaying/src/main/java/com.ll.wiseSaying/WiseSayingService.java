package com.ll.wiseSaying;

import java.io.IOException;
import java.util.ArrayList;

public class WiseSayingService {
    WiseSayingRepository wsr = new WiseSayingRepository();

    public int insert(String quote, String writer) throws IOException {
        int id = getNum() + 1;


        wsr.insert(id, "{\"id\":" + id + ",\"quote\":\"" + quote + "\",\"writer\":\"" + writer + "\"}");
        wsr.updateNum(id);


        return id;
    }

    public void update(String[] data) throws IOException {
        wsr.insert(Integer.parseInt(data[0]), "{\"id\":" + data[0] + ",\"quote\":\"" + data[1] + "\",\"writer\":\"" + data[2] + "\"}");
    }

    public int getNum() throws IOException {
        try {
            return Integer.parseInt(wsr.getNum());
        } catch (Exception e) {
            wsr.updateNum(0);
            return 0;
        }
    }

    public String[][] showList() throws IOException {
        int id = getNum();
        String[][] data = new String[id][3];
        for (int i = id; i > 0; i--) {
            if(! wsr.exists(i)){continue;}
            String line = wsr.readDoc(i);
            String[] parts = line.replace("{", "").replace("}", "").replace("\"", "")
                    .replace("id:","").replace("quote:","").replace("writer:","").split(",");
            data[i-1] = parts;
        }
        return data;
    }

    public int delete(int id) throws IOException {
        if(wsr.exists(id)){
            wsr.delete(id);
            if(id==Integer.parseInt(wsr.getNum())){
                wsr.updateNum(id - 1); // 마지막 ID를 업데이트
            }
            return 1; // 성공적으로 삭제됨
        }
        return 0; // 삭제 실패, 해당 ID가 존재하지 않음
    }

    public String[] getDoc(int id) throws IOException {
        String[] data = new String[3];
        if(wsr.exists(id)){
            String line = wsr.readDoc(id);
            String[] parts = line.replace("{", "").replace("}", "").replace("\"", "")
                    .replace("id:","").replace("quote:","").replace("writer:","").split(",");
            data = parts;
        }

        return data;
    }

    public void build() throws IOException {
        int id = getNum();
        ArrayList<String> data = new ArrayList<>();
        for (int i = 1; i <= id; i++) {
            if (!wsr.exists(i)) continue;
            data. add(wsr.readDoc(i));
        }
        wsr.makeBuildFile(data);
    }
}