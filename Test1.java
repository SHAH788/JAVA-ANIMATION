import javax.swing.*;
import java.awt.*;

 final public class Test1 {

    JFrame frame;
    DrawPanel drawPanel;

    private int A = 9;
    private int B = 5;

    boolean up = false;
    boolean down = true;
    
    public static void main(String[] args) {
        new Test1().go();
    }
    private DrawPanel DrawPanel;

    private void go() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawPanel = new DrawPanel();

        frame.getContentPane().add(BorderLayout.CENTER, DrawPanel);

        frame.setVisible(true);
          frame.setResizable(false);
        frame.setSize(200, 200);
        frame.setLocation(175, 55);
        moveA();
    }

    class DrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.BLUE);
            g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
            g.setColor(Color.RED);
            g.fillRect(9, 6, this.getWidth()-12, this.getHeight()-12);
            g.setColor(Color.white);
            g.fillRect(A, B, 6, 6);
        }
    }

    private void moveA() {
        while(true){
        
            if(B >= 260){
                up = true;
                down = false;
            }
            if(B <= 7){
                up = false;
                down = true;
            }
            if(up){
                B--;
            }
            if(down){
                B++;
            }
            try{
                Thread.sleep(10);
            } catch (Exception exc){}
            frame.repaint();
        }
    }
}