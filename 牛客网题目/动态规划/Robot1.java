import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
        // write code here
		int[][] res = new int[x][y];
        res[0][0] = 0;
        for(int i = 1 ;i<x;i++)
            {
            res[i][0] = 1;
        }
        for(int i = 1;i<y;i++){
            res[0][i] = 1;
        }
        for(int a = 1;a<x;a++){
            for(int b = 1;b<y;b++){
                res[a][b] = res[a-1][b]+res[a][b-1];
            }
        }
        
        return res[x-1][y-1];
    }
}

//·½·¨¶þ£º

import java.util.*;

public class Robot {
    public int countWays(int x, int y) {
        // write code here
        if(x<=0||y<=0) return 0;
        if(x==1||y==1) return 1;
        return countWays(x-1,y)+countWays(x,y-1);
    }
}