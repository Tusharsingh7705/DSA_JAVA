import java.util.*;

public class SegmentTree {

    static void buildSeg(int arr[], int seg[], int idx, int low, int high) {

        if (low == high) {
            seg[idx] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        buildSeg(arr, seg, 2 * idx + 1, low, mid);
        buildSeg(arr, seg, 2 * idx + 2, mid + 1, high);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }

    public static void main(String[] args) {

        int arr[] = {1, 3, 5, 7, 9, 11};
        int n = arr.length;

        int seg[] = new int[4 * n];

        buildSeg(arr, seg, 0, 0, n - 1);

        System.out.println(Arrays.toString(seg));
    }
}