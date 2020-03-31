import java.utils.*;

class MyCalendarTwo {
    private ArrayList<ArrayList<Integer>> single;
    private ArrayList<ArrayList<Integer>> twice;

    public MyCalendarTwo() {
        single = new ArrayList<>();
        twice = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for (ArrayList<Integer> arr : twice) {
        	if (arr.get(0) < end && start < arr.get(1))
        		return false;
        }

        for (ArrayList<Integer> arr : single) {
        	if (arr.get(0) < end && start < arr.get(1)) {
        		ArrayList<Integer> A = new ArrayList<>();
        		A.add(Math.max(arr.get(0), start));
        		A.add(Math.min(arr.get(1), end));
        		twice.add(A);
        	}
        }
        single.add(
        	new ArrayList<Integer>(Arrays.asList(start, end))
        	);
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */