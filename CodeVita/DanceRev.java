import java.util.*;

public class DanceRev {
    public static void main(String[] args) {
        //This problem kinda feels similar to CPU caching, minimum leg moves = minimum memory misses

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] instructions = new String[n];
        for(int i = 0; i < n; i++) instructions[i] = sc.next();

        Map<String, Integer> map = Map.of("left",0,"right",1,"up",2,"down",3);
        //Integer is faster to work with, also I don't wanna use equals() since == won't work with string
        //Creating an immutable map instead of regular HashMap, habit from Kotlin

        int[][][] michael_jackson = new int[n][4][4];
        //I don't know any better ways, since N is small I am just keep tracking of all leg combinations
        for (int[][] move_left : michael_jackson)
            for (int[] right : move_left)
                Arrays.fill(right, 80); //moves can't exceed N constraint

        int left = map.get(instructions[0]);
        //we have the ability to start anywhere, so might as well stand in the first instruction tile
        int right = left; //if all instructions are same then below loop won't work
        for(int i = 1; i < n; i++) {
            if(map.get(instructions[i]) != left) {
                right = map.get(instructions[i]);
                break;
            } //right leg is 2nd unique instruction, not necessarily the 2nd instruction itself
        } //eg: up up up down..., here right leg will initially be in down

        michael_jackson[0][left][right] = 0; //initial position doesn't need moves

        for (int i = 1; i < n; i++) {
            int instruction = map.get(instructions[i]);
            //this is the instruction tile that is going to be used in moves whereas 'i' is the sequence index
            for (left = 0; left < 4; left++) {
                for (right = 0; right < 4; right++) {
                    if (michael_jackson[i - 1][left][right] == 80) continue;
                    //ignore impossible/inefficient states using filled value, eg: both legs moving at once

                    if (instruction != right) //try left leg only if right isn't already covering
                        michael_jackson[i][instruction][right] = Math.min(
                                michael_jackson[i][instruction][right], //current minimum
                                michael_jackson[i - 1][left][right] //previous minimum
                                + (left != instruction ? 1 : 0) //if left is already covering then don't move
                        );

                    if (instruction != left) //similarly try right leg
                        michael_jackson[i][left][instruction] = Math.min(
                                michael_jackson[i][left][instruction],
                                michael_jackson[i - 1][left][right]
                                + (right != instruction ? 1 : 0)
                        );
                }
            }
        }

        int ans = 80;
        for (left = 0; left < 4; left++)
            for (right = 0; right < 4; right++)
                ans = Math.min(ans, michael_jackson[n - 1][left][right]);
        System.out.println(ans); //answer is minimum of the last instruction
    }
}
