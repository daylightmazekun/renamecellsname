package bean;

import java.util.HashMap;

public class Cells {
    //ecxel path
    private String path;
    //替换元素
    private HashMap<String, String> hashMap;


    public HashMap<String, String> getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
