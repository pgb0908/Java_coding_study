import java.util.*;

public class MeetingRoom2 {
    public static void main(String[] args) {
        Interval in1 = new Interval(5, 10);
        Interval in2 = new Interval(15, 20);
        Interval in3 = new Interval(0, 30);
        
        Interval[] intervals = {in1, in2, in3};
        MeetingRoom2 test = new MeetingRoom2();
        System.out.println(test.solve2(intervals));
        
    }

    private int solve2(Interval[] intervals) {
        if(intervals.length == 0 || intervals == null){
            return 0;
        }

        // 맨 처음 첫 번째 인자 크기로 정렬렬
       //Collections.sort(intervals, (a, b) -> a.start - b.start);
        Arrays.sort(intervals, (a,b) -> a.start - b.start);

        int max = 0;
        Queue<Interval> minQ = new PriorityQueue<>(intervals.length, (a,b) -> a.end - b.end);
        // 이진 배열에 넣기
        //   이진 배열 안에서 크기 비교
        for(int i = 0; i < intervals.length; i++){

            while(!minQ.isEmpty() && minQ.peek().end <= intervals[i].start){
                minQ.poll();
            }

            minQ.offer(intervals[i]);
            max = Math.max(max, minQ.size());
        }

        return max;
    }



}


