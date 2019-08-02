package p0535;

import java.util.HashMap;
//Runtime: 2 ms, faster than 90.29% of Java online submissions for Encode and Decode TinyURL.
//Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Encode and Decode TinyURL.
public class Codec {

    int i = 0;
    HashMap<String,String> map = new HashMap();
    HashMap<String,String> rmap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        if(map.containsKey(longUrl))
            return map.get(longUrl);

        i++;
        String newUrl = String.valueOf(i);
        map.put(longUrl,newUrl);
        rmap.put(newUrl,longUrl);
        return newUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return rmap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));