import java.util.*;
public class maxmin{
public static void main(String[] args){
     
    System.out.println("enter array size : ");
    Scanner sc= new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println("Give array numbers : ");
    int arr[] = new int[n];
    for(int i = 0;i<n;i++){
        arr[i]= sc.nextInt();
    }
    System.out.println("Given array numbers are :");
    for(int i =0;i<n;i++){
        System.out.println(arr[i]);
    }
   int max=arr[0];
   int min=arr[0];
    for(int i = 0;i<n;i++){
        if(arr[i]>max){
            max = arr[i];
        }
        if(arr[i]<min){
            min = arr[i];
        }
    }
    System.out.println("Max number is "+ max);
    System.out.println("Min number is "+ min);
   }
}