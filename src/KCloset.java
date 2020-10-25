import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KCloset {
    public static void main(String[] args) {
        KCloset a = new KCloset();
        int[][] points = {{1, 3}, {-2, 2}, {5,10}};
        int k = 2;
        int[][] result = a.solve(points, k);
        a.print(result);
    }

    private void print(int[][] result) {
        int m = result.length;
        int n = result[0].length;

        for(int i=0; i < result.length; i++){
            for(int j=0; j < result[i].length; j++){
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] solve(int[][] points, int k) {
        // priorityQ를 이용
        Queue<int[]> q = new PriorityQueue<>(points.length, comp);
        int[][] res = new int[k][2];
        int idx = 0;

        // Q에 담기
        for(int[] ele: points){
            q.offer(ele);
        }

        // k만큼 빼오기
        while(idx < k){
            res[idx] = q.poll();
            idx++;
        }

        return res;
    }

    Comparator<int[]> comp = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]);
        }
    };
}
