class Solution {
    private int abc(String s) {
        int[] m = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        return m[Integer.parseInt(s.substring(0, 2)) - 1] + Integer.parseInt(s.substring(3, 5));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int st = Math.max(abc(arriveAlice), abc(arriveBob));
        int en = Math.min(abc(leaveAlice), abc(leaveBob));
        return Math.max(0, en - st + 1);
    }
}