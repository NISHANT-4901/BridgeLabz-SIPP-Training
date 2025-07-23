package Day1_Generics;
import java.util.ArrayList;
import java.util.List;

public class PersonalizedMealPlanGenerator {
    interface MealPlan {
        String getMealName();

        String getCategory();
    }

    static class VegetarianMeal implements MealPlan {
        private String mealName;

        VegetarianMeal(String mealName) {
            this.mealName = mealName;
        }

        public String getMealName() {
            return mealName;
        }

        public String getCategory() {
            return "Vegetarian";
        }
    }

    static class VeganMeal implements MealPlan {
        private String mealName;

        VeganMeal(String mealName) {
            this.mealName = mealName;
        }

        public String getMealName() {
            return mealName;
        }

        public String getCategory() {
            return "Vegan";
        }
    }

    static class KetoMeal implements MealPlan {
        private String mealName;

        KetoMeal(String mealName) {
            this.mealName = mealName;
        }

        public String getMealName() {
            return mealName;
        }

        public String getCategory() {
            return "Keto";
        }
    }

    static class HighProteinMeal implements MealPlan {
        private String mealName;

        HighProteinMeal(String mealName) {
            this.mealName = mealName;
        }

        public String getMealName() {
            return mealName;
        }

        public String getCategory() {
            return "High-Protein";
        }
    }

    static class Meal<T extends MealPlan> {
        private T plan;

        Meal(T plan) {
            this.plan = plan;
        }

        T getPlan() {
            return plan;
        }
    }

    static <T extends MealPlan> Meal<T> generatePlan(T plan) {
        return new Meal<>(plan);
    }

    public static void main(String[] args) {
        List<Meal<? extends MealPlan>> personalizedPlans = new ArrayList<>();

        Meal<VegetarianMeal> vegPlan = generatePlan(new VegetarianMeal("Paneer Curry"));
        Meal<VeganMeal> veganPlan = generatePlan(new VeganMeal("Tofu Stir-Fry"));
        Meal<KetoMeal> ketoPlan = generatePlan(new KetoMeal("Avocado Chicken Salad"));
        Meal<HighProteinMeal> proteinPlan = generatePlan(new HighProteinMeal("Grilled Salmon"));

        personalizedPlans.add(vegPlan);
        personalizedPlans.add(veganPlan);
        personalizedPlans.add(ketoPlan);
        personalizedPlans.add(proteinPlan);

        for (Meal<? extends MealPlan> meal : personalizedPlans) {
            System.out.println(meal.getPlan().getMealName() + " | " + meal.getPlan().getCategory());
        }
    }
}
