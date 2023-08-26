import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//        Пример _ ППППППППППППППППППППППППППППППППППП  /третья часть закончена, правильно до конца третьей части, отсюда:
//        третья часть https://www.youtube.com/watch?v=UEjMMnBGmgw

public class Task1_3_10_3 extends JPanel implements ActionListener {

    public static JFrame jFrame;
    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static int speed = 10;

    Snake_clean_copy_3 s = new Snake_clean_copy_3(5, 6, 5, 5);
    Timer timer = new Timer(1000/speed, this);

    public Task1_3_10_3() {
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint (Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0,0, WIDTH*SCALE,HEIGHT*SCALE);

        for (int x = 0; x < WIDTH*SCALE; x+=SCALE) {
            g.setColor(Color.white);
            g.drawLine(x,0, x, HEIGHT*SCALE);
        }
        for (int y = 0; y < HEIGHT*SCALE; y+=SCALE) {
            g.setColor(Color.white);
            g.drawLine(0, y,WIDTH*SCALE, y);
        }

        for (int l = 0; l < s.length; l++) {
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*SCALE+1, s.sY[l]*SCALE+1, SCALE-1, SCALE-1);
        }
    }

    public static void main(String[] args) {
        System.out.println("""
                Задание:\s
                3. Доработайте змейку, что б при врезании в стену(край поля) - игра оканчивалась

                Решение:\s""");

        jFrame = new JFrame("Title");
        jFrame.setSize(WIDTH*SCALE+17,HEIGHT*SCALE+40);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setLocationRelativeTo(null);

        jFrame.add(new Task1_3_10_3());

        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        s.move();
        repaint();
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed (KeyEvent event) {
            int key = event.getKeyCode();

            if ((key == KeyEvent.VK_UP) && (s.direction != 2)) s.direction = 0;
            if ((key == KeyEvent.VK_DOWN) && (s.direction != 0)) s.direction = 2;
            if ((key == KeyEvent.VK_RIGHT) && (s.direction != 3)) s.direction = 1;
            if ((key == KeyEvent.VK_LEFT) && (s.direction != 1)) s.direction = 3;
        }
    }
}

/*public */class Snake_clean_copy_3 {

    public int length = 2;
    public int direction = 2;

    public int sX[] = new int[300];
    public int sY[] = new int[300];

    public Snake_clean_copy_3(int x1, int y1, int x2, int y2) {
        sX[0] = x1;
        sX[1] = x2;
        sY[0] = y1;
        sY[1] = y2;
    }

    public void move() {

        for (int l = length; l > 0; l--) {
            sX[l] = sX[l-1];
            sY[l] = sY[l-1];
        }

        //up
        if (direction == 0) sY[0]--;
        //down
        if (direction == 2) sY[0]++;
        //right
        if (direction == 1) sX[0]++;
        //left
        if (direction == 3) sX[0]--;

        if (sX[0] > Task1_3_10_3.WIDTH - 1) /*sX[0] = 0*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
        if (sX[0] < 0) /*sX[0] = Task1_3_10_3.WIDTH - 1*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
        if (sY[0] > Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
        if (sY[0] < 0) /*sY[0] = Task1_3_10_3.HEIGHT - 1*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
    }
}

/*class SnakeGame extends JPanel {

}*/

//        Конец Примера _ КККККККККККККККК
