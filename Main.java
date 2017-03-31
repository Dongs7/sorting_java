package com.company;

import java.util.Scanner;

public class Main {

    public static int [] insertionSort(int [] a){

        for(int i = 1; i < a.length; i++)
        {
            int temp = a[i];
            int j;
            for(j = i - 1; j >=0 && temp < a[j]; j--)
            {
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }

        return a ;
    }

    public static int [] selectionSort(int [] a){
        for(int i = 0; i < a.length-1; i++)
        {
            for(int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }

        return a;
    }

    public static int [] merge(int [] a, int [] b){
        int [] temp = new int[a.length + b.length];
        int i = 0; int j=0;
        for(int k = 0; k < temp.length; k++){
            if(i >= a.length) temp[k] = b[j++];
            else if(j >= b.length) temp[k] = a[i++];
            else if(a[i] <= b[j]) temp[k] = a[i++];
            else temp[k] = b[j++];
        }

        for(int h = 0; h < temp.length; h++){
            System.out.print(temp[h] + " ");
        }
        return temp;
    }

    public static int [] mergeSort(int [] a){
        int start = 0;
        int last = a.length-1;

        if(start >= last) return a;

        int mid = a.length / 2;
        System.out.println("mid value: " + mid);
        int [] leftArr = new int [mid];
        int [] rightArr = new int [last - mid + 1];

        for(int i =0; i < mid; i++){
            leftArr[i] = a[i];
        }

        for(int i =0; i < last - mid+1; i++){
            rightArr[i] = a[i + mid];
        }

        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }


    public static void quickSort(int [] a, int left, int right){
        if (a == null || a.length == 0) return;
        if (left >= right) return;

        int mid = (left + right) / 2;
        int pivot = a[mid];
        int temp;
        int i = left; int j = right;

        while (i <=j){
            while(a[i] < pivot){
                i++;
            }

            while(a[j] > pivot){
                j--;
            }

            if(i <= j){
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }

        if(left < j) quickSort(a,left,j);
        if(right > i) quickSort(a,i,right);

    }

    public static void bubbleSort(int [] a){
        boolean isSorted = true;
        int j = 0;
        int tmp;

        while(isSorted){
            isSorted = false;
            j++;
            for(int i = 0; i < a.length-j; i++){
                if (a[i] > a[i + 1]){
                    tmp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = tmp;
                    isSorted = true;
                }
            }
        }
    }


    public static void main(String[] args) {

        boolean isDone = false;
        Scanner input = new Scanner(System.in);

        System.out.print("How many numbers are in the array?: ");
        int arr_length = input.nextInt();
        int [] arr = new int [arr_length];
        int i = 0;
        int total = arr_length;
        while(!isDone && total > 0){
            System.out.print("Please enter numbers (" + total +"/"+ arr_length +" left) :");
            if( i < arr_length){
                arr[i++] = input.nextInt();
                --total;
            }
            else isDone = true;
        }

        boolean isEnd = false;
        while(!isEnd){
            System.out.println(" ");
            System.out.print("Current Array is: ");
            printArray(arr);
            System.out.println(" ");
            System.out.println("1. Insertion Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Merge Sort");
            System.out.println("4. Quick Sort");
            System.out.println("5. Bubble Sort");
            System.out.println("0. EXIT");
            System.out.print("Please Select your sorting algorithm: ");
            int select = input.nextInt();

            switch(select){
                case 1:
                    int [] result = insertionSort(arr);
                    printArray(result);
                    break;
                case 2:
                    result = selectionSort(arr);
                    printArray(result);
                    break;
                case 3:
                    result = mergeSort(arr);
                    printArray(result);
                    break;
                case 4:
                    quickSort(arr,0,arr.length -1);
                    printArray(arr);
                    break;
                case 5:
                    bubbleSort(arr);
                    printArray(arr);
                    break;
                case 0:
                    isEnd = true;
            }

        }




//       int [] result = m.insertionSort(arr);
//       int [] result = m.selectionSort(arr);
//       int [] result = m.mergeSort(arr);
//        quickSort(arr,0,arr.length-1);
//        bubbleSort(arr);
//        printArray(arr);
//       System.out.print(result);
    }



    public static void printArray(int [] a)
    {
        for(int i=0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }
}
