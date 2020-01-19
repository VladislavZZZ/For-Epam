package by.javatr.day3.runner;

import by.javatr.day3.exceptions.BallInputDataException;
import by.javatr.day3.exceptions.BasketInputDataException;
import by.javatr.day3.exceptions.BasketOverloadedException;
import by.javatr.day3.logic.Ball;
import by.javatr.day3.logic.Basket;
import by.javatr.day3.logic.BasketLogic;

public class Main {

    public static void main(String[] args) {
        try {
            Basket basket=new Basket(5);
            BasketLogic.addBall(basket,new Ball(2.1,"blue"));
            BasketLogic.addBall(basket,new Ball(15,"green"));
            BasketLogic.addBall(basket,new Ball(2.0001,"BLUE"));
            BasketLogic.addBall(basket,new Ball(1,"Red"));
            BasketLogic.addBall(basket,new Ball(0.1,"bLue"));
            System.out.println(" number of that color is "+BasketLogic.ballsWithThatColor(basket,"blue"));
            System.out.println("weight of that basket is "+BasketLogic.weightOfBasket(basket));
            System.out.println(basket);

            BasketLogic.clearBasket(basket);
            BasketLogic.addBall(basket,new Ball(0.1,"bLue"));
            System.out.println(" number of that color is "+BasketLogic.ballsWithThatColor(basket,"blue"));
            System.out.println("weight of that basket is "+BasketLogic.weightOfBasket(basket));

        } catch (BasketInputDataException e) {
            System.out.println("size cannot be null or negative");
        }catch (BallInputDataException ex){
            System.out.println("weight of ball is incorrect");
        }catch (BasketOverloadedException ex){
            System.out.println("Basket is full of balls, clear the basket");
        }

    }
}
