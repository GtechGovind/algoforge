import java.util.LinkedList;
import java.util.Queue;

/**
 * Queue-based stack for beginners:
 * push puts on the queue; pop moves all old items once to expose the newest one.
 */
public class Data_structures_article_15 {
    public Object solve(Object... args) {
        return new MyStack();
    }

    static class MyStack {
        Queue<Integer> q = new LinkedList<>();
        int topElem = 0;

        public void push(int x) {
            q.offer(x);
            topElem = x;
        }

        public int top() {
            return topElem;
        }

        public int pop() {
            int size = q.size();
            while (size > 2) {
                q.offer(q.poll());
                size--;
            }
            topElem = q.peek();
            q.offer(q.poll());
            return q.poll();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }
}
