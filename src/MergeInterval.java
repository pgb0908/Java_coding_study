import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MergeInterval {
    public static void main(String args[]){
        /*
            Given a collection of intervals, merge all overlapping intervals
         */

        Interval in2 = new Interval(1, 3);
        Interval in1 = new Interval(2, 6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        MergeInterval exam = new MergeInterval();
        List<Interval> list = exam.merge(intervals);

        exam.print(list);
    }

    private void print(List<Interval> list) {
        for(Interval val : list){
            System.out.print(val.start + " " + val.end + "|");
        }
    }

    private List<Interval> merge(List<Interval> intervals) {
        if(intervals.isEmpty()) return intervals;
        List<Interval> result = new ArrayList<>();

        // 정렬
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval before = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval current = intervals.get(i);

            if(before.end >= current.start) {
                before.end = Math.max(before.end, current.end);
            }else{
                result.add(before);
                before = current;
            }
        }

        if(!result.contains(before)){
            result.add(before);
        }

        return result;
    }



}

class Interval {
    int start;
    int end;

    Interval() {start = 0; end = 0;}
    Interval(int s, int e) { start =s; end =e;}
}
