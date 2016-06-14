import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.lang.System.out;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class HWStream{
    public static void main(String[] args) {
        List<Dish> menu = asList(
                new Dish("pork",false,800, Dish.Type.MEAT),
                new Dish("beef",false,700, Dish.Type.MEAT),
                new Dish("chicken",false,400, Dish.Type.MEAT),
                new Dish("french fries",true,530, Dish.Type.OTHER),
                new Dish("rice",true,350, Dish.Type.OTHER),
                new Dish("season fruit",true,120, Dish.Type.OTHER),
                new Dish("pizza",true,550, Dish.Type.OTHER),
                new Dish("prawns",false,300, Dish.Type.FISH),
                new Dish("salmon",false,450, Dish.Type.FISH)
        );

        List<List<Integer>> intlist1 = asList(
                asList(0, 2, 4, 6, 8, 10, 12, 14, 16, 18),
                asList(0, 5, 10, 15, 20, 25, 30, 35, 40));
        List<Integer> intlist2 = asList(0, 3, 6, 9, 12, 15, 18, 21);

        long count = intlist1.stream().flatMap(l -> l.stream()).flatMap(i1 -> intlist2.stream().filter(i2 -> i1 == i2)).count();

    }
}

class Dish{

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName(){
        return name;
    }
    public boolean isVegetarian(){
        return vegetarian;
    }
    public int getCalories(){
        return calories;
    }
    public Type getType(){
        return type;
    }

    @Override
    public String toString(){
        return name;
    }

    public enum Type{
        MEAT,FISH,OTHER
    }

}
