package loaders;

import java.util.HashMap;
import java.util.Set;

public class Loader {

  public static HashMap<String, String> mappings = new HashMap<>();

  static {
    mappings.put("hello", "Hello");
    mappings.put("hi", "Hi");
    mappings.put("god dag", "GodDag");
  }

  public static String get(String word) {
    return mappings.get(word);
  }

  public static Set<String> allWords() {
    return mappings.keySet();
  }
}
