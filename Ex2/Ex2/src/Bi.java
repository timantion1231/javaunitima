import com.sun.source.tree.Tree;

import java.lang.reflect.Array;
import java.util.*;

public class Bi {

    public static LinkedHashMap<Character, Integer> b(String s) {
        LinkedHashMap<MyChar, Integer> sMap = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> checkMap = new LinkedHashMap<>();

        int v;
        for (int i = 0; i < s.length(); i++) {
            if (!checkMap.containsKey(s.charAt(i))) {
                checkMap.put(s.charAt(i), 1);
            } else {
                v = checkMap.get(s.charAt(i));
                checkMap.put(s.charAt(i), v + 1);
            }
        }
/*
        for (Map.Entry<Character, Integer> item : checkMap.entrySet()) {
            sMap.put(new MyChar(item.getKey()), item.getValue());
        }
        */

        return checkMap;
    }


    public static LinkedHashMap<Character, Integer> sortedKey(LinkedHashMap<Character, Integer> mapa) {
        SortedMap<MyChar, Integer> smk = new TreeMap<>(convert(mapa));
        return reconvert(new LinkedHashMap<>(smk));
    }

    public static LinkedHashMap<Character, Integer> sortedValue(LinkedHashMap<Character, Integer> mapa) {

        Character[] charArray = new Character[mapa.size()];
        Integer[] intArray = new Integer[mapa.size()];
        LinkedHashMap<Character, Integer> out = new LinkedHashMap<>();

        int iterator = 0;
        for (Map.Entry<Character, Integer> item : mapa.entrySet()) {
            charArray[iterator] = item.getKey();
            intArray[iterator] = item.getValue();
            iterator++;
        }

        int n = charArray.length;
        int intTemp;
        Character charTemp;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (intArray[j - 1] > intArray[j]) {
                    intTemp = intArray[j - 1];
                    charTemp = charArray[j - 1];

                    intArray[j - 1] = intArray[j];
                    charArray[j - 1] = charArray[j];

                    intArray[j] = intTemp;
                    charArray[j] = charTemp;
                }
            }
        }

        for(int i=0; i<n; i++){
            out.put(charArray[i], intArray[i]);
        }

        return out;

    }

    private static LinkedHashMap<MyChar, Integer> convert(LinkedHashMap<Character, Integer> mapa) {
        LinkedHashMap<MyChar, Integer> out = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> item : mapa.entrySet()) {
            out.put(new MyChar(item.getKey()), item.getValue());
        }
        return out;
    }

    private static LinkedHashMap<Character, Integer> reconvert(LinkedHashMap<MyChar, Integer> mapa) {
        LinkedHashMap<Character, Integer> out = new LinkedHashMap<>();
        for (Map.Entry<MyChar, Integer> item : mapa.entrySet()) {
            out.put(item.getKey().getC(), item.getValue());
        }
        return out;
    }
}
