import java.util.*;

/**
 * 225. Implement Stack Using Queues -- Easy
 */
class MyStack {

    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            Queue<Integer> q3 = new ArrayDeque<>(q2);
            q2 = q1;
            q1 = q3;
        }
        return q2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        int res = 0;
        if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            res = q1.peek();
            q2.offer(q1.poll());
            Queue<Integer> q3 = new ArrayDeque<>(q2);
            q2 = q1;
            q1 = q3;
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */