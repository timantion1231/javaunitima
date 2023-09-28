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

        SortedMap<MyInt, MyChar> sm = new TreeMap<>();

        for(Map.Entry<MyChar, Integer> item: mapa.entrySet()){
            sm.put(new MyInt(item.getValue()), item.getKey());
        }
        mapa.clear();

        for(Map.Entry<MyInt, MyChar>item: sm.entrySet()){
            mapa.put(item.getValue(), item.getKey().getVal());
        }
      return mapa;
    }
}
