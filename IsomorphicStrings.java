/*
Given two strings, check whether two strings are isomorphic to each other or not.  
Two strings are isomorphic if a fixed mapping exists from the characters of one string to the characters of the other string. 
For example, if there are two instances of the character "a"  in the first string, both these instances should be converted to another character 
(which could also remain the same character if "a" is mapped to itself) in the second string. 
This converted character should remain the same in both positions of the second string since there is a fixed mapping from the character
"a" in the first string to the converted character in the second string.

*/
import java.util.*;


public class Main {
    public static boolean isIsomorphic(String string1, String string2) {
        HashMap<Character, Character> str12str2 = new HashMap<>();
        HashMap<Character, Character> str22str1 = new HashMap<>();

        int i = 0, j = 0;
        while (i < string1.length()) {
            char char1 = string1.charAt(i++);
            char char2 = string2.charAt(j++);

            if (str12str2.containsKey(char1) && str12str2.get(char1) != char2) {
                return false;
            }

            if (str22str1.containsKey(char2) && str22str1.get(char2) != char1) {
                return false;
            }

            str12str2.put(char1, char2);
            str22str1.put(char2, char1);
        }
        return true;
    }
}
