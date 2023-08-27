public class Snake_3 {

    public int length = 2;
    public int direction = 2;

    public int sX[] = new int[300];
    public int sY[] = new int[300];

    public Snake_3(int x1, int y1, int x2, int y2) {
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
        if (sX[0] < 0) /*sX[0] = Draft_Task1_3_10_3.WIDTH - 1*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
        if (sY[0] > Task1_3_10_3.HEIGHT - 1) /*sY[0] = 0*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
        if (sY[0] < 0) /*sY[0] = Draft_Task1_3_10_3.HEIGHT - 1*/ {
            System.out.println("Snake collided into wall. Game over.");
            System.exit(0);
        }
    }
}
