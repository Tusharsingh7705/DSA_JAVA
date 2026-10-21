import java.util.*;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if (IntStream.range(1, n).allMatch(i -> s.charAt(i - 1) <= s.charAt(i))) return 0;  // already sorted
        if (n == 2) return -1;  // only single letters can be sorted, which changes nothing
        IntSummaryStatistics mid = s.chars().skip(1).limit(n - 2).summaryStatistics();  // the middle's smallest and largest letters
        int first = s.charAt(0), last = s.charAt(n - 1), lo = mid.getMin(), hi = mid.getMax();
        if (first <= Math.min(lo, last) || Math.max(first, hi) <= last) return 1;  // the first letter is the smallest, or the last the largest
        return last < lo && hi < first ? 3 : 2;  // the middle sits strictly between the last letter and the first
    }
}