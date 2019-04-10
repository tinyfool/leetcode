package example.SlidingWindow;

public class Example1 {

    public int longestKStringOfx(String s,int k,char x) {

        int ans = 0;
        int Nx = 0;

        for(int i = 0;i<k-1;i++) {
            char c = s.charAt(i);
            if (c==x)
                Nx++;
        }
        for(int i = 0;i<s.length()-k;i++) {
            int right = i+k-1;
            char c = s.charAt(right);
            if (c==x)
                Nx++;
            if(i-1>=0) {
                char cf = s.charAt(i-1);
                if(cf==x)
                    Nx--;
            }
            if(Nx>ans)
                ans=Nx;
        }
        return ans;
    }

    public static void main(String[] args) {

        int k=3;
        String s = "abaaaccsddaa";
        char x = 'a';
        Example1 example1 = new Example1();
        System.out.println(example1.longestKStringOfx(s,k,x));

        s = "abcdeaaadfewfsaaadassaaaaaddddaass";
        k = 5;
        x = 'a';
        System.out.println(example1.longestKStringOfx(s,k,x));
    }
}
