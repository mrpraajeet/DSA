import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

//Didn't finish
public class MaxWorth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        HashMap<String, Integer> strings = new HashMap<>();
        int[] worth = new int[n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            strings.put(s, i);
            for (int j = 0; j < s.length(); j++) {
                worth[i] += s.charAt(j) - 'a' + 1;
            }
        }

        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = sc.nextInt();
        }

        HashSet<Integer>[] contra = new HashSet[n];
        for (int i = 0; i < m; i++) {
            contra[i] = new HashSet<>();
        }

        for (int i = 0; i < m; i++) {
            Integer a = strings.get(sc.next());
            Integer b = strings.get(sc.next());
            contra[a].add(b);
            contra[b].add(a);
        }

        int budget = sc.nextInt();

        int maxWorth = 0;
        int[][] dp = new int[n + 1][budget + 1];

        System.out.println(maxWorth);
        sc.close();
    }
}
