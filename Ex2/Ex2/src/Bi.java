import java.util.*;

public class Bi {

    public static HashMap<MyChar, Integer> b(String s) {
        HashMap<MyChar, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> checkMap = new HashMap<>();

        int v;
        for (int i = 0; i < s.length(); i++) {
            if (!checkMap.containsKey(s.charAt(i))) {
                checkMap.put(s.charAt(i), 1);
            } else {
                v = checkMap.get(s.charAt(i));
                checkMap.put(s.charAt(i), v + 1);
            }
        }

        for (Map.Entry<Character, Integer> item : checkMap.entrySet()) {
            sMap.put(new MyChar(item.getKey()), item.getValue());
        }
        return sMap;
    }


    public static HashMap<MyChar, Integer> sortedKey(HashMap<MyChar, Integer> mapa) {
        SortedMap<MyChar, Integer> smk = new TreeMap<>(mapa);
        return new HashMap<>(smk);
    }

    public static HashMap<MyChar, Integer> sortedValue(HashMap<MyChar, Integer> mapa) {

        List<MyChar> charList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();

        for (Map.Entry<MyChar, Integer> item : mapa.entrySet()) {
            charList.add(item.getKey());
            intList.add(item.getValue());
        }

        int n = charList.size()-1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (intList.get(j) > intList.get(j + 1)) {
                    int intTemp = intList.get(j);
                    MyChar charTemp = charList.get(j);

                    intList.set(j, intList.get(j + 1));
                    charList.set(j, charList.get(j + 1));

                    intList.set(j + 1, intTemp);
                    charList.set(j + 1, charTemp);
                }
            }
        }

        mapa.clear();

        for(int i = 0; i< intList.size();i++){
            mapa.put(charList.get(i), intList.get(i));
        }
        return mapa;
    }
}
