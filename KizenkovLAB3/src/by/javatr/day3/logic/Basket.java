package by.javatr.day3.logic;

import by.javatr.day3.exceptions.BasketInputDataException;
import by.javatr.day3.validators.BasketValidation;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Ball> container;
    private int size;

    public Basket(int size) throws  BasketInputDataException{
        if (!BasketValidation.isValidSize(size)) throw new BasketInputDataException("size is not positive");
        this.size = size;
        container=new ArrayList<>(size);
    }

    public List<Ball> getContainer() {
        return container;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o==null) return  false;
        if (getClass()!=o.getClass()) return false;
        Basket basket = (Basket) o;
        return size == basket.size &&
                container.equals(basket.container);
    }

    @Override
    public int hashCode() {
        return 26*size+((container==null)?0:container.hashCode());
    }

    @Override
    public String toString() {
        return "Basket{"  +", size=" + size +" -> " +container+ "}";
    }
}
