import java.util.HashSet;
import java.util.Scanner;

//Attempted this in Round 1, Didn't pass
public class EquationsPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().strip().split("\\D+");
        String[] s2 = sc.nextLine().strip().split("\\D+");
        int r = sc.nextInt();
        sc.close();

        int[] e1 = new int[5], e2 = new int[5];
        HashSet<Integer> set1 = new HashSet<>(), set2 = new HashSet<>();
        for(int i = 0; i < 5; i++) e1[i] = Integer.parseInt(s1[i]);
        for(int i = 0; i < 5; i++) e2[i] = Integer.parseInt(s2[i]);

        for(int x = 0; x < r; x++) {
            for(int y = 0; y < r - x; y++) {
                for(int z = 0; z < r - x - y; z++) {
                    for(int w = 0; w < r - x - y - z; w++) {
                        int sum1 = e1[0]*x + e1[1]*y + e1[2]*z + e1[3]*w;
                        int sum2 = e2[0]*x + e2[1]*y + e2[2]*z + e2[3]*w;
                        if(sum1 <= e1[4]) {
                            set1.add(sum1);
                            System.out.println("e1: " + sum1 + " " + x + " " + y + " " + z + " " + w);
                        }
                        if(sum2 <= e2[4]) {
                            set2.add(sum2);
                            System.out.println("e2: " + sum2 + " " + x + " " + y + " " + z + " " + w);
                        }
                    }
                }
            }
        }

        for(Integer i : set1) if(set2.contains(i)) System.out.println(i);
        set1.retainAll(set2);
        System.out.println(set1.size());
    }
}
