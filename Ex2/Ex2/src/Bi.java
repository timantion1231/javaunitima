import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Bi {

    public static HashMap<Character, Integer> b(String s) {
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if(!sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), 1);
            }
            else {
                int v = sMap.get(s.charAt(i));
                sMap.put(s.charAt(i), v+1);
            }
        }

        return sMap;
    }

    public static HashMap<Character, Integer> sortedKey(HashMap<Character, Integer>mapa){
        SortedMap<Character, Integer> smk = new TreeMap<>();

        for(Map.Entry<Character, Integer> item : mapa.entrySet()){
            smk.put(item.getKey(), item.getValue());
        }

        mapa.clear();
        mapa.putAll(smk);
        return mapa;
    }

    public static HashMap<Integer, Character> sortedValue(Map<Character, Integer>mapa) {
        SortedMap<Integer, Character> smv = new TreeMap<>();
        for(Map.Entry<Character, Integer> item : mapa.entrySet()){
            smv.put(item.getValue(), item.getKey());
        }

        mapa.clear();
        return new HashMap<>(smv);
    }


}
