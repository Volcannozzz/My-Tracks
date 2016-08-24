import java.util.*;

//使用BFS来解决
public class Flood {
    public int floodFill(int[][] map, int n, int m) {
        // write code here
        if(m==0||map[0].length==0){
            return 0;
        }
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        Point p;
        int x,y;
        while(!queue.isEmpty()){//QUEUE中存储的是一个点的邻接点
            p = queue.poll();
            x = p.x;
            y = p.y;
           		
            if (x == n - 1 && y == m - 1){//如果得到结果，直接返回
                return map[x][y];
			}
			if (x + 1 < n&&map[x+1][y]==0){//右边的节点可以走，
				queue.add(new Point(x+1,y));//将右边节点加入队列
				map[x + 1][y] = map[x][y] + 1;//初始化右边节点。注意，我们这里判断的条件是map[x+1][y]==0，也就是说路是通的。另一层含义是如果不是0，说明走过了或者有障碍（是1）
			}
            
            			
            if (y + 1 < m&&map[x][y+1]==0){//下面的节点，这里顺序不能变，因为最早时间，肯定是从右边或者下面走，只有走不通的时候才走左边和上面
				queue.add(new Point(x,y+1));
				map[x][y + 1] = map[x][y] + 1;
			}

			if (x - 1 >= 0&&map[x-1][y]==0){//同理左边节点
				queue.add(new Point(x - 1, y));
				map[x - 1][y] = map[x][y] + 1;
			}

			if (y - 1 >= 0&&map[x][y-1]==0){//上面的节点
				queue.add(new Point(x, y - 1));
				map[x][y - 1] = map[x][y] + 1;
			}
        }
        
        return 0;
    }
}
    
     
class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
        }
    }