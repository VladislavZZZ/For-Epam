package by.javatr.task2.sevice;

import by.javatr.exception.ArrayNullPointerException;

public class JaggedArrayMethods {
    private int[][] jaggedArray;

    public JaggedArrayMethods(int[][] jaggedArray)throws ArrayNullPointerException{
        if (jaggedArray==null)throw new ArrayNullPointerException("array is empty");
        this.jaggedArray = jaggedArray;
    }

    public void sortBySumInLane(boolean isIncrease)throws ArrayNullPointerException{
        int[] sumOfLines=initArrayBySumOfLines();
        doBubbleSortBySecondArray(sumOfLines, isIncrease);
    }

    public void sortByMaxElementInLane(boolean isIncrease)throws ArrayNullPointerException{
        int[] maxOfLines=initArrayByExtremumInLine(true);
        doBubbleSortBySecondArray(maxOfLines,isIncrease);
    }

    public void sortByMinElementInLane(boolean isIncrease)throws ArrayNullPointerException{
        int[] minOfLines=initArrayByExtremumInLine(false);
        doBubbleSortBySecondArray(minOfLines,isIncrease);
    }

    private int[] initArrayBySumOfLines(){
        int[] rez=new int[jaggedArray.length];
        int sum;
        for (int i=0;i<jaggedArray.length;i++){
            sum=0;
            for (int elem:jaggedArray[i]){
                sum+=elem;
            }
            rez[i]=sum;
        }
        return rez;
    }

    private int[] initArrayByExtremumInLine(boolean isMax){
        int[] rez=new int[jaggedArray.length];
        int extremum;
        for (int i=0;i<jaggedArray.length;i++){
            extremum=jaggedArray[i][0];
            for(int elem:jaggedArray[i]){
                if (isMax && extremum<elem || !isMax && extremum>elem){
                    extremum=elem;
                }
            }
            rez[i]=extremum;
        }
        return rez;
    }

    private void doBubbleSortBySecondArray(int[] arr, boolean isIncrease) throws ArrayNullPointerException {
        if (arr==null) throw new ArrayNullPointerException("line is exist");
        int size=arr.length;
        int i, j;
        for (i = 0; i < size - 1; i++)
        {
            for (j = 0; j < size - i - 1; j++)
            {
                if (arr[j] > arr[j + 1]&& isIncrease || arr[j]<arr[j+1]&&!isIncrease)
                {
                    swap(arr,j,j+1);
                    swap(jaggedArray,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void swap(int[][] arr,int i,int j){
        int[] temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



}
