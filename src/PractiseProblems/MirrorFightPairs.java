package PractiseProblems;

import java.util.Scanner;

public class MirrorFightPairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String S = sc.next();

        long[] freq = new long[26];

        for (char c : S.toCharArray()) {
            freq[c - 'a']++;
        }

        long pairs = 0;

        for (int i = 0; i < 26; i++) {
            int mirror = 25 - i;
            if (i < mirror) {
                pairs += freq[i] * freq[mirror];
            }
        }

        System.out.println(pairs);
        sc.close();
    }
}
