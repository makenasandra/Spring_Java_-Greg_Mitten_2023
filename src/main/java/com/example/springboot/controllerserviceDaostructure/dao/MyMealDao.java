package com.example.springboot.controllerserviceDaostructure.dao;

import com.example.springboot.model.Meal;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MyMealDao {
    Meal meal1 = new Meal("Grilled Chicken Salad", "A healthy salad with grilled chicken breast, mixed greens, and balsamic vinaigrette.", 12.99, true);
    Meal meal2 = new Meal("Margherita Pizza", "Classic Margherita pizza with fresh tomatoes, mozzarella cheese, and basil.", 10.99, false);
    Meal meal3 = new Meal("Tropical Fruit Smoothie Bowl", "A refreshing smoothie bowl with tropical fruits, granola, and honey drizzle.", 8.49, true);
    Meal meal4 = new Meal("Spaghetti Bolognese", "Homemade spaghetti with a rich meat sauce and Parmesan cheese.", 14.99, false);
    Meal meal5 = new Meal("Grilled Veggie Wrap", "A vegetarian wrap filled with grilled vegetables and hummus.", 9.99, true);
    Meal meal6 = new Meal("BBQ Pulled Pork Sandwich", "Slow-cooked pulled pork with barbecue sauce served on a bun.", 11.49, false);
    Meal meal7 = new Meal("Caprese Salad", "A classic Caprese salad with ripe tomatoes, fresh mozzarella, basil, and balsamic glaze.", 9.99, true);
    private List<Meal> meals = List.of(meal1, meal2, meal3, meal4, meal5, meal6, meal7);


    public List<Meal> getMeals() {
        return meals;
    }

    public void addMeal (Meal meal){

        this.meals.add(meal);
    }

    public void updateMeal (Meal meal){
        this.meals.removeIf(m -> m.getName().equals(meal.getName()));
        this.meals.add(meal);
    }

    public void deleteMeal (String name){
        this.meals.removeIf(meal -> meal.getName().equals(name));
    }
}
