package string;

import java.util.ArrayList;
import java.util.List;

public class StringMatcher {

    public List<Integer> matchDirectOrPalindromic(String str, String target) {
        int[][][] dp = new int[str.length()+1][target.length()+2][2];

        for(int i = 1; i <= target.length(); i++ ) {
            dp[0][i][0] = 0;
            dp[0][i][1] = 0;
        }

        for(int i = 0; i <= str.length(); i++ ) {
            dp[i][0][0] = 1;
            dp[i][target.length()+1][1] = 1;
        }

        List<Integer> indexes = new ArrayList<>();
        for(int i = 1; i < str.length()+1; i++ ) {
            char c = str.charAt(i-1);
            for(int j = 1; j <= target.length(); j++ ) {
                char cRef = target.charAt(j-1);
                if( c == cRef ) {
                    if( dp[i-1][j-1][0] == 1 ) {
                        dp[i][j][0] = 1;
                    }
                    if( dp[i-1][j+1][1] == 1 ) {
                        dp[i][j][1] = 1;
                    }
                }
            }

            if( dp[i][target.length()][0] == 1 ) {
                indexes.add(i-target.length());
            }
            if( dp[i][1][1] == 1 ) {
                indexes.add(i-target.length());
            }
        }

        return indexes;
    }
}
