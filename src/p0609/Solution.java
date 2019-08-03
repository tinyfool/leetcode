package p0609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> ret = new ArrayList<>();
        HashMap<String, List<String>> contentMap = new HashMap<>();
        for (String filesString :
                paths) {
            String[] fileParts = filesString.split(" ");
            String dir = fileParts[0];
            for (int i = 1; i < fileParts.length; i++) {

                String[] split = fileParts[i].split("\\(");
                String file = split[0];
                String content = split[1].substring(0, split[1].length() - 1);
                List<String> fileList = contentMap.getOrDefault(content, new ArrayList<>());
                fileList.add(dir + "/" + file);
                contentMap.put(content, fileList);
            }
        }
        for (String content : contentMap.keySet()
        ) {
            List<String> fileList = contentMap.get(content);
            if (fileList.size() > 1)
                ret.add(contentMap.get(content));
        }
        return ret;
    }

}
