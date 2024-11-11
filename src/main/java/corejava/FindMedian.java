package corejava;

public class FindMedian {
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 5, 8};
        int[] arr2 = {10, 12, 14, 16, 18, 20};
      //  System.out.println(findMedianSortedArrays(arr1, arr2));
        System.out.println(medianOfTwo(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] merged = new int[totalLength];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        if (totalLength % 2 == 0) {
            return (merged[totalLength / 2 - 1] + merged[totalLength / 2]) / 2.0;
        } else {
            return merged[totalLength / 2];
        }
    }
    public static int medianOfTwo(int[] arr,int[] arr1){
        if (arr.length > arr1.length) {
            int[] temp = arr;
            arr = arr1;
            arr1 = temp;
        }
        int median=(arr.length+arr1.length)/2;
        System.out.println(median);
        int end =arr1.length/2;
        System.out.println(end);
        int start =(median- end)-1;
        System.out.println(start);
        while(end >-1){
            if(Math.max(arr[start],arr1[end])<Math.min(arr[start +1],arr1[end +1]))
            {
                return Math.max(arr[start],arr1[end]);
            }
            else {
                end--;
                start++;
            }
        }    return -1;
    }
}
