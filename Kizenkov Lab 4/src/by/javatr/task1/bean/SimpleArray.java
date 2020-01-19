package by.javatr.task1.bean;

import by.javatr.exception.ArrayNullPointerException;
import by.javatr.task1.bean.exception.SimpleArrayIncorrectSizeException;
import by.javatr.task1.bean.validation.SimpleArrayValidator;

import java.util.Arrays;

public class SimpleArray {
    private static final int DEFAULT_SIZE=5;
    private int[] arr;
    private int size;

    public SimpleArray() {
        size=DEFAULT_SIZE;
        arr=new int[size];
    }

    public SimpleArray(int[] arr) throws ArrayNullPointerException {
        if (arr==null)throw new ArrayNullPointerException("empty method's argument");
        this.arr=arr;
        size=arr.length;
    }

    public SimpleArray(int size) throws SimpleArrayIncorrectSizeException {
        if (!SimpleArrayValidator.isValidSize(size))throw new SimpleArrayIncorrectSizeException("incorrect size");
        this.size=size;
        arr=new int[size];
    }

    public int[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public void setElem(int elem,int index){
        arr[index]=elem;
    }

    public int getElem(int index){
        return arr[index];
    }

    public void doBubbleSort(){
        int i, j;
        for (i = 0; i < size - 1; i++)
        {
            for (j = 0; j < size - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    swap(arr,j,j+1);
                }
            }

        }
    }

    public void doInsertionSort(){
        for (int left = 0; left < size; left++) {
            int value = arr[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < arr[i]) {
                    arr[i + 1] = arr[i];
                } else {
                    break;
                }
            }
            arr[i + 1] = value;
        }
    }

    public void doQuickSort(){
        quickSort(0,size-1);
    }

    public int findIndex(int elem){
        return doBinarySearch(elem,0,size-1);
    }

    private void quickSort(int left,int right){
        if (arr.length == 0 || left >= right)
            return;
        int middle = left + (right - left) / 2;
        int ord = arr[middle];

        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < ord) {
                i++;
            }

            while (arr[j] > ord) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (left < j)
            quickSort(left, j);

        if (right > i)
            quickSort(i, right);
    }

    private int doBinarySearch(int key,int left, int right){
        int index = -1;
        if(!isSortedIncreaseArray())return index;
        while (left <= right) {
            int mid = (left + right)/2;
            if (arr[mid]< key) {
                left = mid + 1;
            } else if (arr[mid]> key) {
                right = mid - 1;
            } else if (arr[mid]== key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    private boolean isSortedIncreaseArray(){
        for (int i=1;i<size;i++){
            if (arr[i]<arr[i-1]){
                return false;
            }
        }
        return true;
    }


    private static void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this!=o) return false;
        if (this.getClass()!=o.getClass())return false;
        SimpleArray other=(SimpleArray)o;
        return size == other.size &&
                Arrays.equals(arr, other.arr);
    }

    @Override
    public int hashCode() {
        return 31 * size + Arrays.hashCode(arr);
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (int elem: arr){
            sb.append(elem+" ");
        }
        return sb.toString();
    }

}
