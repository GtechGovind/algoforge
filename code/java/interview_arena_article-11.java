import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Exam Room seating pattern:
 * keep empty intervals in a TreeSet and always take the currently best seat.
 */
public class Interview_arena_article_11 {
    public Object solve(Object... args) {
        if (args == null || args.length != 1) {
            throw new IllegalArgumentException("Expected: (int N)");
        }
        return new ExamRoom(toInt(args[0]));
    }

    private int toInt(Object value) {
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return Integer.parseInt(String.valueOf(value));
    }

    private static class ExamRoom {
        private final Map<Integer, int[]> startMap;
        private final Map<Integer, int[]> endMap;
        private final TreeSet<int[]> pq;
        private final int N;

        public ExamRoom(int N) {
            this.N = N;
            startMap = new HashMap<>();
            endMap = new HashMap<>();
            pq = new TreeSet<>((a, b) -> {
                int distA = distance(a);
                int distB = distance(b);
                if (distA == distB) {
                    return b[0] - a[0];
                }
                return distA - distB;
            });
            addInterval(new int[] {-1, N});
        }

        public int seat() {
            int[] longest = pq.last();
            int x = longest[0];
            int y = longest[1];
            int seat;
            if (x == -1) {
                seat = 0;
            } else if (y == N) {
                seat = N - 1;
            } else {
                seat = (y - x) / 2 + x;
            }
            int[] left = new int[] {x, seat};
            int[] right = new int[] {seat, y};
            removeInterval(longest);
            addInterval(left);
            addInterval(right);
            return seat;
        }

        public void leave(int p) {
            int[] right = startMap.get(p);
            int[] left = endMap.get(p);
            int[] merged = new int[] {left[0], right[1]};
            removeInterval(left);
            removeInterval(right);
            addInterval(merged);
        }

        private void addInterval(int[] intv) {
            pq.add(intv);
            startMap.put(intv[0], intv);
            endMap.put(intv[1], intv);
        }

        private void removeInterval(int[] intv) {
            pq.remove(intv);
            startMap.remove(intv[0]);
            endMap.remove(intv[1]);
        }

        private int distance(int[] intv) {
            int x = intv[0];
            int y = intv[1];
            if (x == -1) {
                return y;
            }
            if (y == N) {
                return N - 1 - x;
            }
            return (y - x) / 2;
        }
    }
}
