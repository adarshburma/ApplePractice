/*
Implement a Random Set data structure that can perform the following operations:

Constructor(): This initializes the Random Set object.
Insert(): This function takes an integer, data, as its parameter and, if it does not already exist in the set, add it to the set, returning TRUE. If the integer already exists in the set, the function returns FALSE.
Delete(): This function takes an integer, data, as its parameter and, if it exists in the set, removes it, returning TRUE. If the integer does not exist in the set, the function returns FALSE.
GetRandom(): This function takes no parameters. It returns an integer chosen at random from the set.

*/

import java.util.*;


class RandomSet {
    // Initialize your data structure here
    HashMap<Integer, Integer> indexLookup;
    List<Integer> data;
    Random rand = new Random();
    public RandomSet() {
        // Write your code here
        data = new ArrayList<>();
        indexLookup = new HashMap<>();

    }

    // Inserts a value to the dataset
    // Returns true if the dataset did not already contain the specified value
    public boolean insert(int val) {
        // Replace this placeholder return statement with your code
        if (indexLookup.containsKey(val)) {
            return false;
        }

        indexLookup.put(val, data.size());
        data.add(val);
        return true;
    }

    // Deletes a value from the dataset
    // Returns true if the dataset contained the specified value
    public boolean delete(int val) {
        // Replace this placeholder return statement with your code
        if (!indexLookup.containsKey(val)) {
            return false;
        }

        int index = indexLookup.get(val);
        int last = data.get(data.size()-1);
        data.set(index, last);
        indexLookup.put(last, index);
        data.remove(data.size()-1);
        indexLookup.remove(val);

        return true;
    }

    // Get a random value from the dataset
    public int getRandomData() {
        // Replace this placeholder return statement with your code
        return data.get(rand.nextInt(data.size()));
    }

}
