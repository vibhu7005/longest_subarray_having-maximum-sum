//find longest subarray having maximum sum
import java.util.*;
public class Main
{
    int findMaxSum(int arr[])
    {
        int sum,maxsum;
        sum=arr[0];maxsum=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            sum+=arr[i];
            sum=Math.max(arr[i],sum);
            maxsum=Math.max(maxsum,sum);
        }
        return maxsum;
    }
    int findLength(int arr[],int k)
    {
        int sum=0,length=0,start=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(sum==k)
            length=i+1;
            if(!map.containsKey(sum))
            {
             map.put(sum,i);  
            }
            if(map.containsKey(sum-k))
            {
                if(length<(i-map.get(sum-k)))
                {
                    start=map.get(sum-k)+1;
                length=i-map.get(sum-k);
                }
            }
        }
        for(int i=start;i<length+start;i++)
        System.out.print(arr[i]+" ");
        return length;
    }
    public static void main(String[] args)
    {
        Main obj=new Main();
        int arr[]={5,-2,-1,3,-4};
        int k=obj.findMaxSum(arr);
        System.out.println(k);
        System.out.print(obj.findLength(arr,k));
    }
}


