package by.javatr.task1.service;

import by.javatr.task1.bean.SimpleArray;
import by.javatr.exception.ArrayNullPointerException;
import by.javatr.console.ConsoleReader;
import by.javatr.task1.dao.SimpleArrayDAO;
import by.javatr.task1.dao.exception.DAOException;
import by.javatr.task1.dao.factory.DAOFactory;
import by.javatr.task1.service.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

public class ArrayMethods {
    private static final int MIN_THREE_DIGIT_NUMBER=100;
    private static final int MAX_THREE_DIGIT_NUMBER=999;
    private static final int DIVIDER=10;
    private static final int MAXIMAL_RANDOM_NUMBER=1000;
    private SimpleArray array;

    public ArrayMethods(SimpleArray array)throws ArrayNullPointerException {
        if (array==null)throw new ArrayNullPointerException("array doesn't exist");
        this.array = array;
    }

    public int findMax(){
    return findExtremum(array.getArr(),true);
}

public int findMin(SimpleArray array){
    return findExtremum(array.getArr(),false);
}

public List<Integer> findAllSimpleNumbers(SimpleArray array) {
    List<Integer> ans =new ArrayList<>();
    for (int elem: array.getArr()){
        if (isSimpleNumber(elem))
            ans.add(elem);
    }
    return ans;
}

public List<Integer> findAllFibbonachiNumbers(SimpleArray array){
    List<Integer> ans=new ArrayList<>();
    for (int elem: array.getArr()){
        if(isFibonnachiNumber(elem))
            ans.add(elem);
    }
    return ans;
}

public List<Integer> findAllThreeDigitNumbersWithDifferentDigits(SimpleArray array){
    List<Integer> ans=new ArrayList<>();
    for (int elem: array.getArr()){
        if(isThreeDigitNumberWithDifferentDigits(elem))
            ans.add(elem);
    }
    return ans;
}

public void fillArrayByRandomNumbers(SimpleArray array,int limit){
    int[] arr=array.getArr();
    int size=array.getSize();
    for (int i=0;i<size;i++){
        arr[i]=(int)(Math.random()*MAXIMAL_RANDOM_NUMBER)%limit;
    }
}

public void fillArrayFromFile(SimpleArray array,String path)throws ArrayNullPointerException, ServiceException {
    DAOFactory daoObjectFactory=DAOFactory.getInstance();
    SimpleArrayDAO simpleArrayDAO=daoObjectFactory.getFileSimpleArrayDAO();
    try {
        simpleArrayDAO.fillArray(array, path);
    }catch (DAOException ex){
        throw new ServiceException("Problem with file");
    }
}

public void fillArrayFromConsole(SimpleArray array){
    ConsoleReader consoleReader=new ConsoleReader();
    int[] arr=array.getArr();
    int size=array.getSize();
    for (int i=0;i<size;i++){
        arr[i]=consoleReader.readInt();
    }
}

private boolean isThreeDigitNumberWithDifferentDigits(int elem){
    if (elem < MIN_THREE_DIGIT_NUMBER || elem > MAX_THREE_DIGIT_NUMBER)return false;
    int first=takeDigit(elem,1);
    int second=takeDigit(elem,2);
    if (first!=second){
        int third=takeDigit(elem,3);
        if (first!=third && second!=third)
            return true;
    }
    return false;
}

private int takeDigit(int number,int numberOfDigit){
    return number%(int)Math.pow(DIVIDER,numberOfDigit);
}

private boolean isSimpleNumber(int elem){
    int limit=(int)Math.sqrt(elem);
    if (elem<2)return false;
    for(int i=2;i<=limit;i++){
        if (elem%i==0){
            return false;
        }
    }
    return true;
}

private boolean isFibonnachiNumber(int elem){
    if (elem<0)return false;
    if(elem==0)return true;
    int prevFib=0;
    int fib=1;
    int t;
    while (fib<=elem){
        if(fib==elem)return true;
        t=prevFib;
        prevFib=fib;
        fib=t+prevFib;
    }
    return false;
}

private int findExtremum(int[] arr,boolean isMax){
    int extremum=arr[0];
    for (int elem:arr){
        if (isMax && extremum<elem || !isMax && extremum>elem) {
            extremum = elem;
        }
    }
    return extremum;
}


}
