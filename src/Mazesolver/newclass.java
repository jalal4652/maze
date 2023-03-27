package Mazesolver;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
public class newclass extends JFrame{
    int maze[][]={{1,1,1,1,1,1,1,1,1,1,1,1,1},
                  {1,0,1,0,1,0,1,0,0,0,0,0,1},
                  {1,0,1,0,0,0,1,0,1,1,1,0,1},
                  {1,0,0,1,0,0,0,0,1,1,1,0,1},
                  {1,0,1,0,1,1,1,0,1,0,0,0,1},
                  {1,0,1,0,1,0,0,0,1,1,1,0,1},
                  {1,0,1,0,1,1,1,0,1,0,1,0,1},
                  {1,0,0,0,0,0,0,0,0,0,1,9,1},
                  {1,1,1,1,1,1,1,1,1,1,1,1,1}
                 };
    List<Integer>path=new ArrayList<>();
     public newclass(){
         setTitle("mazesolver");
         setSize(1080,720);//this is size of our window
         setLocation(50,50);// this location of our window
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// this by default close operation
        DepthFirstSearch.searchpath(maze,1,1,path);//this is our algorithm
       System.out.print(path);
     }
    // Override
    public void paint(Graphics g) {
        g.translate(50, 50);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.yellow;// goves  yellow color to value one
                        break;
                    case 9:
                        color = Color.red;// gives red color to our destination
                        break;
                    default:
                        color = Color.white;// defalut gives white
                        break;
                }
                g.setColor(color);//it setting color
                g.fillRect(50 * j, 50 * i, 50, 50);// giving shape of each indx
                g.setColor(Color.black);// it gives border color to seprate indx
                g.drawRect(50 * j, 50 * i, 50, 50);//  gives border shape
            }
        }
        for (int i = 0; i < path.size(); i += 2) {
            int pathx = path.get(i);
            int pathy = path.get(i + 1);
            System.out.println("xpath=:" + pathx);// it will print x path
            System.out.println("ypath=:" + pathy);// it will print y path
            g.setColor(Color.GREEN);// gives color to our possible path
            g.fillRect(50 * pathx, 50 * pathy, 40, 40);// shape to our path
        }
    }
    public static void main(String []args){
        newclass view=new newclass();
        view.setVisible(true);
    }
}
