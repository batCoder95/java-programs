/**
 * Created by Vatsal on 15-Jul-16.
 * PROBLEM: Given the current position(x) of a frog and destination(y),
 *          compute the number of jumps required to reach from x to y,
 *          if the covers D blocks in a single jump.
 */

class FrogJumps {

    public int solution(int x, int y, int D){
        int jumps;

        if(x==y) return 0;

        else{
            int distance = Math.abs((y-x));
            if(distance%D==0) jumps = distance/D;
            else jumps = (distance/D)+1;

            return jumps;
        }
    }

    public static void main(String[] args) {
        FrogJumps t = new FrogJumps();
        int jumps = t.solution(0, 10, 3);
        System.out.println("No. of jumps = "+jumps);


    }

}
