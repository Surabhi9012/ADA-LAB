import java.util.Scanner;

class sort{
    void read(int a[], int n){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the elements of the array: ");
        for(int i=0; i<n; i++){
            
            a[i]=sc.nextInt();
        }
        System.out.println();
    }

    void print(int a[], int n){
        for(int i=0; i<n; i++){
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

    void bubblePartitionSort(int a[], int n){
        int temp;
        boolean swapped;
        for(int i=0; i<n; i++){
           swapped= false;
           for(int j=0; j<n-i-1; j++){
            if((a[j]%2==0 && a[j+1]%2==0 && a[j]<a[j+1]) || 
            (a[j]%2!=0 && a[j+1]%2!=0 && (a[j]>a[j+1])) || 
            (a[j]%2!=0 && a[j+1]%2==0)){
               temp=a[j];
               a[j]=a[j+1];
               a[j+1]=temp;
               swapped=true; 
            }
           } 
           if(swapped==false){
            break;
           }
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n=sc.nextInt();

        int a[]=new int[n];

        sort s= new sort();
        s.read(a, n);
        s.bubblePartitionSort(a, n);
        s.print(a, n);

    }
}