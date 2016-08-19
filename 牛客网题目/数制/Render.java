import java.util.*;

public class Render {
    public int[] renderPixel(int[] screen, int x, int y) {
        // write code here
        
        for(int i = x;i<y+1;i++)
            {
            int location = i/8;
            int count = i%8;
            
            screen[location] = screen[location]|(1<<count);
        }
        
        return screen;
    }
}