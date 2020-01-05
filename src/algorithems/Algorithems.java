
package algorithems;

import static algorithems.Algorithems.arr;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Algorithems {
     
     public static ArrayList input = new ArrayList();
     public static int arr[];
     public static String out=" ";
     public static void bubble(){
         for(int i = 1;i<arr.length;i++){
             for(int j = arr.length-1;j >= i;j--){
                 if(arr[j]<arr[j-1]){
                     int temp = arr[j];
                     arr[j]   =arr[j-1];
                     arr[j-1] =temp;
                 }
             }
         }
     }
     
      public static void insertion(){
          int j;
          for(int i = 1;i<arr.length;i++){
             int x=arr[i];
             j=i-1;
             while(arr[j]>x ){
                 arr[j+1] = arr[j];
                 arr[j]=x;
                 j--;
                 if(j == -1){
                     break;
                 }
             }
         }
             
     }
      
      
           public static void selection(){
              int k,temp,x;
              for(int i=0;i<arr.length;i++){
                  k=i;
                  x=arr[i];
                   for(int j=i+1;j<arr.length;j++){
                       if(arr[j] < arr[k]){
                           k=j;
                           x=arr[j];
                       }
                   }
                   temp=arr[k];
                   arr[k]=arr[i];
                   arr[i]=temp;
              }
              
             
           }
        
           public static int pivotIndex(int i,int j){
             
               for(int g=i ;g<j;g++){
                   if(arr[i] != arr[g+1] ){
                      if(arr[g] > arr[g+1]){
                          return g;
                      }else if(arr[g] < arr[g+1]){
                          return g+1;
                      }
                   }
               }
               return 0;
           }
           
           public static int partition(int i,int j,int p){
               int l=i;
               int r=j;
               while(l<r){
                   while(arr[l]<p){
                       l++;
                   }
                   while(arr[r] >= p){
                       r--;
                   }
                    if(l<r){
                        int temp=arr[l];
                        arr[l]=arr[r];
                        arr[j]=temp;   
                   }
               }
               return l;
           }
           
          public static void QuickSort(int i , int j){
              
            int n=pivotIndex(i,j);
            if( ( n != 1 ) && ( j>0) ){
                int p=arr[n];
                int k = partition(i,j,p);
                QuickSort(i,k-1);
                QuickSort(k,j);
            }
          }
          
          
          public static void heapSort(int s){
              int size=s;
              if(s == 0){
                  return ;
              }
              
              int start = (size)/2;
             
              for(int i=start-1;i>=0;i--){
                  int temp=arr[i];
                  boolean bo=true;
                  int j=i;
                  int n = 0;
                  
                  while(bo){
                      if((2*j+1)<size){
                         
                              temp=arr[(2*j+1)];
                               n=(2*j+1);
                              
                          if(2*j+2 <size){
                              if(arr[2*j+1]<arr[2*j+2]){
                                  temp=arr[(2*j+2)];
                                  n=(2*j+2);
                              }
                          } 
                      }
                      
                      
                      if(temp > arr[j]){
                          int x = arr[j];
                          arr[j]=temp;
                          arr[n]=temp=x;
                          j=n;
                        
                      }else{ 
                          bo = false; 

                      }
                  }
                  
              }
              int t=arr[size-1];
              arr[size-1]=arr[0];
              arr[0]=t;
              heapSort(s-1);    

          }
          
      public static  void merge(int arr[], int l, int m, int r) 
        { 
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        /* Create temp arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
  
        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
  
  
        /* Merge the temp arrays */
  
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarry array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
   
    public static  void mergeSort(int arr[], int l, int h) 
    { 
        if (l < h) 
        { 
            int mid = (l+h)/2;   
            mergeSort(arr, l, mid); 
            mergeSort(arr , mid+1, h); 
            merge(arr, l, mid, h); 
            print();
            
        } 
    }
   
     public static void print(){
        
         for(int i=0;i<arr.length;i++){
            out+=" "+arr[i]+" ";
         }
     }
    
    
    public static void main(String[] args) {
        boolean bo=true;
        while(true){
         String num = JOptionPane.showInputDialog(null,"1- Add number \n 2- Sort \n 3- Print \n 4-exit");
            if(num == null){
                System.exit(0);
            }
          if(num.equals("1")){
              try{
               String in = JOptionPane.showInputDialog(null,"Enter number :");
               int n= Integer.valueOf(in);
               input.add(n);
               arr=new int[input.size()];
               for(int i=0;i<input.size();i++){
                   arr[i]=(int) input.get(i);
               } 
              }catch(Exception e){
               JOptionPane.showMessageDialog(null,"try again .. ");
              }
               
          }else if(num.equals("2")){
              String num2 = JOptionPane.showInputDialog(null,"Sort by :\n 1- Bubble \n 2- insertion \n 3- Selection \n 4- Quick Sort  \n 5- Heap array \n 6- Merge  ");
                if(num.equals("1")){
                     if(arr !=null){
                        bubble();
                     }
                    
                 }else if(num.equals("2")){
                     if(arr !=null){
                        insertion();
                     }
                    
                 }else if(num.equals("3")){
                      if(arr !=null){
                        selection();
                     }
                    
                 }else if(num.equals("4")){
                      if(arr !=null){
                         QuickSort(0,arr.length-1);
                     }
                  
                 }else if(num.equals("5")){
                      if(arr !=null){
                         heapSort(arr.length);
                     }
                   
                  }else if(num.equals("6")){
                     if(arr !=null){
                         mergeSort(arr, 0, arr.length-1);
                     }
                 }
          
              
                
                }
        
          else if(num.equals("3") ){
              
               if(arr !=null){
                        print();
                        JOptionPane.showMessageDialog(null, out);
                        out="";
                     }
              
          }else if(num.equals("4")){
         
              System.exit(0);
          }else if(num.equals(null)){
              System.exit(0);
          }
        }
        


    }
    
}
