package by.javatr.day3.logic;

import by.javatr.day3.exceptions.BallInputDataException;
import by.javatr.day3.validators.BallValidation;

public class Ball {
    private double weight;
    private String color;

    public Ball() {
        this.weight=0;
        this.color=null;
    }

    public Ball(double weight, String color)throws BallInputDataException {
        if (!BallValidation.isValidWeight(weight)) throw new BallInputDataException("incorrect weight");
        this.weight = weight;
        this.color = color.toLowerCase();
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Ball{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null) return false;
        if (getClass()!=o.getClass()) return false;
        Ball ball = (Ball) o;
        return Double.compare(ball.weight, weight) == 0 &&
                color.equals(ball.color);
    }

    @Override
    public int hashCode() {
        return (int)(27*weight + ((color==null) ? 0:color.hashCode()));
    }
}
