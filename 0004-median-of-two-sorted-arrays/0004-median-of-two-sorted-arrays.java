class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        boolean even = (nums1.length+nums2.length)%2==0;
        int mid = (nums1.length+nums2.length)/2;
        // System.out.println(mid);
        int i=0,j=0,ctr=0,prev=0,curr=0;
        while(i<nums1.length || j<nums2.length){
            if(i<nums1.length && j<nums2.length){
                if(nums1[i]>nums2[j]){
                    curr = nums2[j];
                    j++;
                }else{
                    curr = nums1[i];
                    i++;
                }
            }else if(i<nums1.length){
                curr = nums1[i];
                i++;
            }else{
                curr = nums2[j];
                j++;
            }
            if(ctr==mid){
                if(even){
                    // System.out.println(even);
                    // System.out.println(prev + " : " + curr);
                    double res = ((double)(prev+curr))/2;
                    return res;
                }else{
                    return (double)(curr);
                }
            } else{
                ctr++;
                prev=curr;
            }
        }
        return 0.0;
    }
}
/*
odd:
- ctr==mid
    next element is median
even:
- ctr ==mid
    (prev + next)/2 element is median
*/