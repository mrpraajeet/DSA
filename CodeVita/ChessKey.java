import java.util.*;

//Didn't pass
public class ChessKey {
    static int maxDepth;
    static HashSet<String> positions;
    //no need to track the entire board, a hash representation can be used

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] pieces = sc.nextLine().split(" ");
        maxDepth = sc.nextInt();

        int[] initialPosition = new int[3]; //0 for Q, 1 for R, 2 for B
        positions = new HashSet<>();

        for (String piece : pieces) {
            char ch = piece.charAt(0);
            int row = piece.charAt(2) - '0'; //ten's place for row
            int col = piece.charAt(1) - 'A' + 1; //one's place for col
            //Uppercase - A will be 0 based, so +1 to match row format

            if (ch == 'Q') initialPosition[0] = row * 10 + col;
            else if (ch == 'R') initialPosition[1] = row * 10 + col;
            else initialPosition[2] = row * 10 + col;
        }

        plies(initialPosition, 0);
        System.out.println(positions.size());
        sc.close();
    }

    private static void plies(int[] currentPosition, int currentDepth) {
        if (currentDepth > maxDepth || !positions.add(Arrays.toString(currentPosition))) return;
        System.out.println(Arrays.toString(currentPosition));

        for (int p = 0; p < 3; p++) {
            if (currentPosition[p] == 0) continue;
            int row = currentPosition[p] / 10;
            int col = currentPosition[p] % 10;
            int[][] directions;

            if (p == 1) directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            else if (p == 2) directions = new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
            else directions = new int[][]{{1, 1}, {-1, -1}, {1, -1}, {-1, 1}, {0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            for (int[] d : directions) {
                for (int i = 1; i < 8; i++) {
                    int nrow = row + d[0] * i;
                    int ncol = col + d[1] * i;
                    int next = nrow * 10 + ncol;

                    if (nrow < 1 || nrow > 8
                        || ncol < 1 || ncol > 8
                        || next == currentPosition[0]
                        || next == currentPosition[1]
                        || next == currentPosition[2]) break;

                    int[] nextPosition = Arrays.copyOf(currentPosition, 3);
                    nextPosition[p] = next;
                    plies(nextPosition, currentDepth + 1);
                }
            }
        }
    }
}
