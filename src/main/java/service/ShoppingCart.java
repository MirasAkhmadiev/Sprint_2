package service;

import model.Food;
import model.constants.Discount;

public class ShoppingCart {
    private final Food[] foods;
    public ShoppingCart(Food[] foods) {
        this.foods = foods;
    }

    public double totalFoodsWithoutDiscount(){
        double totalSum = 0;
        for (Food food : foods) {
            double sumOfFood = food.getPrice() * food.getAmount();
            totalSum = totalSum + sumOfFood;
        }
        return totalSum;
    }

    public double totalFoodsWithDiscount(){
        double totalSum = 0;
        for (Food food : foods) {
            double sumOfFood = food.getPrice() * food.getAmount();
            double discountSum = sumOfFood * food.getDiscount() / Discount.PERCENT_DIVISOR;
            double totalWithDiscount = sumOfFood - discountSum;
            totalSum = totalSum + totalWithDiscount;
        }
        return totalSum;
    }

    public double totalVegetarianFoodsWithoutDiscount(){
        double totalSum = 0;
        for (Food food : foods) {
            if (food.isVegetarian()) {
                double sumOfFood = food.getPrice() * food.getAmount();
                totalSum = totalSum + sumOfFood;
            }
        }
        return totalSum;
    }
}


