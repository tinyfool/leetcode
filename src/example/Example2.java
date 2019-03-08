package example;

public class Example2 {

    public int longestKStringOfx(String s,int k,char x) {

        int ans = 0;
        int Nx = 0;

        for(int right = 0;right<s.length()-k;right++) {
            char c = s.charAt(right);
            if (c==x)
                Nx++;
            int left = right-k;
            if(left>=0) {
                char cf = s.charAt(left);
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
