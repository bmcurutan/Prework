import java.util.*;

public class FlattenDict {
    public static Map<String, Object> flatten(Map<String, Object> map) {
        Map<String, Object> res = new HashMap<>();
        recurse("", map, res);
        return res;
    }

    private static void recurse(String initialKey, Map<String, Object> map, Map<String, Object> res) {
        for (String key : map.keySet()) {
            Object val = map.get(key);
            if (!(val instanceof Map)) { // Primitive
                if (initialKey == null || initialKey.equals("")) {
                    res.put(key, val);
                } else {
                    res.put(initialKey + "." + key, val);
                }
            } else { // HashMap
                if (initialKey == null || initialKey.equals("")) {
                    recurse(key, (Map)val, res);
                } else {
                    recurse(initialKey + "." + key, (Map)val, res);
                }
            }
        }
    }

    public static void main(String[] args) {
        Map<String, Object> test = new HashMap<>();
        test.put("Key1", "1");

        Map<String, Object> temp = new HashMap<>();
        temp.put("a", "2");
        temp.put("b", "3");

        Map<String, Object> temp2 = new HashMap<>();
        temp2.put("d", "3");
        temp2.put("e", "1");

        temp.put("c", temp2);
        test.put("Key2", temp);

        System.out.println(test);

        Map<String, Object> res = flatten(test);
        System.out.println(res);
    }
}

/*
function flattenDictionary(initialKey, dictionary, flatDictionary):
  for (key : dictionary.keyset())
    value = dictionary.get(key)
    if (!isHashMapInstance(value)) //the value is a primitive
      if (initialKey == null || initialKey == "")
        flatDictionary.put(key, value)
      else
        flatDictionary.put(initialKey + "." + key, value)
    else
      if (initialKey == null || initialKey == "")
        flattenDictionary(key, value, flatDictionary)
      else
        flattenDictionary(initialKey + "." + key, value, flatDictionary)

Input:
{
  'Key1': '1',
  'Key2': {
    'a' : '2',
    'b' : '3',
    'c' : {
      'd' : '3',
      'e' : '1'
      }
    }
}

Output:
{
  'Key1': '1',
  'Key2.a': '2',
  'Key2.b' : '3',
  'Key2.c.d' : '3',
  'Key2.c.e' : '1'
}
*/