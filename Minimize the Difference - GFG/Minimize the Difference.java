  
class Solution {
    public static int minimizeDifference(int n, int k, int[] arr) {
        // code here
        //s1
      int rmax[] = new int[n]; rmax[n-1] = arr[n-1];
      int rmin[] = new int[n]; rmin[n-1] = arr[n-1];
      for(int i=n-2; i>=0; i--){
          rmax[i] = Math.max(arr[i], rmax[i+1]);
          rmin[i] = Math.min(arr[i], rmin[i+1]);
      }
      // 1st window
      int ans = rmax[k] - rmin[k];
      int lmax = arr[0], lmin = arr[0];
      //3//handling second window onwards till second last window
      // for each i , removing k ele starting from i
       for(int i=1; i<n-k; i++){
           int maxInRemaining  = Math.max(lmax, rmax[i+k]);
           int minInRemaining = Math.min(lmin, rmin[i+k]);
           int currDiff = maxInRemaining - minInRemaining;
            ans = Math.min(ans, currDiff);
           
           //update the lmax and lmin for next itr
            lmax = Math.max(arr[i],lmax);
          lmin = Math.min(arr[i], lmin);
       }
       //last window
       ans =  Math.min(ans, lmax-lmin);
       return ans;
     
    }
}
