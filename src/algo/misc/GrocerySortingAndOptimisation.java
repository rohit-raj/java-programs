package algo.misc;

import java.util.*;

/**
 *
 * You are going on a camping trip, but before you leave you need to buy groceries. To optimize your time spent in the store, instead of buying the items from your shopping list in order, you plan to buy everything you need from one department before moving to the next.
 *
 * Given an unsorted list of products with their departments and a shopping list, return the time saved in terms of the number of department visits eliminated.
 *
 * Example:
 * products = [
 *     ["Cheese",          "Dairy"],
 *     ["Carrots",         "Produce"],
 *     ["Potatoes",        "Produce"],
 *     ["Canned Tuna",     "Pantry"],
 *     ["Romaine Lettuce", "Produce"],
 *     ["Chocolate Milk",  "Dairy"],
 *     ["Flour",           "Pantry"],
 *     ["Iceberg Lettuce", "Produce"],
 *     ["Coffee",          "Pantry"],
 *     ["Pasta",           "Pantry"],
 *     ["Milk",            "Dairy"],
 *     ["Blueberries",     "Produce"],
 *     ["Pasta Sauce",     "Pantry"]
 * ]
 *
 * list1 = ["Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"]
 *
 * For example, buying the items from list1 in order would take 5 department visits, whereas your method would lead to only visiting 3 departments, a difference of 2 departments.
 *
 * Produce(Blueberries)->Dairy(Milk)->Pantry(Coffee/Flour)->Dairy(Cheese)->Produce(Carrots) = 5 department visits
 * New: Produce(Blueberries/Carrots)->Pantry(Coffee/Flour)->Dairy(Milk/Cheese) = 3 department visits
 *
 * list2 = ["Blueberries", "Carrots", "Coffee", "Milk", "Flour", "Cheese"] => 2
 * list3 = ["Blueberries", "Carrots", "Romaine Lettuce", "Iceberg Lettuce"] => 0
 * list4 = ["Milk", "Flour", "Chocolate Milk", "Pasta Sauce"] => 2
 * list5 = ["Cheese", "Potatoes", "Blueberries", "Canned Tuna"] => 0
 *
 * All Test Cases:
 * shopping(products, list1) => 2
 * shopping(products, list2) => 2
 * shopping(products, list3) => 0
 * shopping(products, list4) => 2
 * shopping(products, list5) => 0
 *
 * Complexity Variable:
 * n: number of products
 *
 */
public class GrocerySortingAndOptimisation {

    public HashMap<String, String> productsList;
    public HashMap<String, List<String>> dataByStore;

    public GrocerySortingAndOptimisation() {
        productsList = new HashMap<>();
        dataByStore = new HashMap<>();
    }

    public void warehouseUpdate(String[][] products){
        for(int i=0;i<products.length;i++){
            String item = products[i][0];
            String cat = products[i][1];

            productsList.put(item, cat);
            if(!dataByStore.containsKey(cat)){
                dataByStore.put(cat, new ArrayList<>());
            }
            dataByStore.get(cat).add(item);
        }

//        System.out.println("productsList : " +productsList);
//        System.out.println("dataByStore : " +dataByStore);
//        System.out.println();
    }

    public int shopping(String[][] products, String[] list1){
        //Approach 1
        int stepsForApproach1 = 0;
        int stepsForApproach2 = 0;
        String cat = "";
        for(String item : list1){
            String fetchedCategory = productsList.get(item);
            if(!fetchedCategory.equals(cat)){
                stepsForApproach1++;
                cat = fetchedCategory;
            }
        }

        Set<String> catList = new HashSet<>();

        for(String listItem : list1){
            catList.add(listItem);
        }

        cat = "";
        for(String category : dataByStore.keySet()){
            List<String> items = dataByStore.get(category);
            for(String item : items){
                if(catList.contains(item) && !cat.equals(category)) {
                    cat = category;
                    stepsForApproach2++;
                }
            }
        }

        System.out.println("stepsForApproach1 : "+ stepsForApproach1 + " stepsForApproach2 :: "+ stepsForApproach2);

        //Approach 2
        return stepsForApproach1 - stepsForApproach2;
    }

    public static void main(String[] argv) {
        String[][] products = {
                {"Cheese",          "Dairy"},
                {"Carrots",         "Produce"},
                {"Potatoes",        "Produce"},
                {"Canned Tuna",     "Pantry"},
                {"Romaine Lettuce", "Produce"},
                {"Chocolate Milk",  "Dairy"},
                {"Flour",           "Pantry"},
                {"Iceberg Lettuce", "Produce"},
                {"Coffee",          "Pantry"},
                {"Pasta",           "Pantry"},
                {"Milk",            "Dairy"},
                {"Blueberries",     "Produce"},
                {"Pasta Sauce",     "Pantry"}
        };

        String[][] lists = {
                {"Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"},
                {"Blueberries", "Carrots", "Coffee", "Milk", "Flour", "Cheese"},
                {"Blueberries", "Carrots", "Romaine Lettuce", "Iceberg Lettuce"},
                {"Milk", "Flour", "Chocolate Milk", "Pasta Sauce"},
                {"Cheese", "Potatoes", "Blueberries", "Canned Tuna"}
        };

        GrocerySortingAndOptimisation sol = new GrocerySortingAndOptimisation();
        sol.warehouseUpdate(products);
        for (String[] list : lists) {
            int ans = sol.shopping(products, list);
            System.out.println("ans : " + ans);
        }

    }
}