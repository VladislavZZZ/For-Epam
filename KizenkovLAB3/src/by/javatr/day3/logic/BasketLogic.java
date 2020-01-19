package by.javatr.day3.logic;

import by.javatr.day3.exceptions.BasketOverloadedException;
import by.javatr.day3.validators.BasketValidation;

public class BasketLogic {

    public static void addBall(Basket basket,Ball ball)throws BasketOverloadedException{
        if (BasketValidation.isOverloaded(basket.getSize(),basket.getContainer().size()+1))
            throw new BasketOverloadedException("basket is full");
        basket.getContainer().add(ball);
    }

    public static void clearBasket(Basket basket){
        basket.getContainer().clear();
    }

    public static double weightOfBasket(Basket basket){
        double weight=0;
        for (Ball ball:basket.getContainer()){
            weight+=ball.getWeight();
        }
        return weight;
    }

    public static int ballsWithThatColor(Basket basket,String color){
        int count=0;
        for (Ball ball:basket.getContainer()){
            if(ball.getColor().equals(color)) count++;
        }
        return count;
    }
}
