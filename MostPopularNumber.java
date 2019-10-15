/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mostpopularnumber;

/**
 *
 * @author zpierucci
 */
import java.lang.Character;
import java.util.Collection;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class MostPopularNumber
{
    HashMap buildMapOfNumbersToCounts(String inputString)
    {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        // Iterate through the string of digits
        // Build the map of Numbers to counts (number of occurrences)
        // Use the following to convert a char to an integer
        //     Integer num = Character.getNumericValue(c)
        
        int length = inputString.length();
        int count = 1;
        
        for(int i = 0; i <= length-1; i++){          
            Integer num = Character.getNumericValue(inputString.charAt(i));
            //if number doesn't already has a key
            if(map.containsKey(num) == false) {
                map.put(num, 1);
            } else {
                //add 1 to the count of the number being added
                count = map.get(num);
                map.put(num, count + 1);
            } 
        }
            
        System.out.println(map);
        return map;
    }

    Integer findMostPopularNumber(HashMap map)
    {
        Integer keyWithMost = null;
        Integer most = 0;
        
        for(Object entry : map.entrySet())
        {
            HashMap.Entry<Object, Object> e = (HashMap.Entry<Object, Object>) entry;
            
            Object key = e.getKey();
            Object value = e.getValue();
            
            int currentValue = (int) value;
            if (currentValue > most){
                most = currentValue; 
                keyWithMost = (int)key;
                
            }
        }
        

        // return the most popular number
        return(keyWithMost);
    }

    // Driver method to test the counting of the string "her"
    public static void main(String args[])
    {
        // find the number that appears the most often, but don't
        // worry about ties. Using the HashMap class should help
        MostPopularNumber mpn = new MostPopularNumber();
        String theInputStr = "95474368045034430538240239000345598274982347590234";

        HashMap map = mpn.buildMapOfNumbersToCounts(theInputStr);
        Integer mostPopularNumber = mpn.findMostPopularNumber(map);
        Integer numOfOccurrences = (Integer) map.get(mostPopularNumber);
        
        System.out.println("The number that occurs the most is: " + mostPopularNumber);
        System.out.println("It appeared " + numOfOccurrences + " times");
    }
}

