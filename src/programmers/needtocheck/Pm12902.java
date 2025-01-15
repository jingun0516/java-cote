package programmers.needtocheck;

public class Pm12902 {
    static long[] tile = new long[5001];

    public static long solution(int n) {
        int mod=1000000007;

        tile[0]=1;
        tile[2]=3;

        for(int i=4; i<=n; i+=2){
            tile[i] = tile[i-2] * 3;
            for(int j=i-4; j>=0; j-=2){
                tile[i] += tile[j] * 2;
            }
            tile[i] = tile[i] % mod;
        };

        return tile[n];
    }

    public static void main(String[] args) {
        int n = 8;

        System.out.println(solution(n));
    }
}
