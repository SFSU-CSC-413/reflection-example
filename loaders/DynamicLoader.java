package loaders;

import java.io.File;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Stream;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class DynamicLoader {

  public static HashMap<String, String> mappings = new HashMap<>();

  static {
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

    Stream
      .of(new File("greetings").listFiles())
      .filter(file ->
        !file.isDirectory() &&
        file.getName().endsWith("java") &&
        // Ignore the abstract base class
        !file.getName().equals("Greeting.java")
      )
      .forEach(file -> {
        String className = file.getName().replace(".java", "");
        String targetString = className
          .replaceAll(
            String.format(
              "%s|%s|%s",
              "(?<=[A-Z])(?=[A-Z][a-z])",
              "(?<=[^A-Z])(?=[A-Z])",
              "(?<=[A-Za-z])(?=[^A-Za-z])"
            ),
            " "
          )
          .toLowerCase();

        compiler.run(null, null, null, file.getPath());
        mappings.put(targetString, className);
      });
  }

  public static Set<String> allWords() {
    return mappings.keySet();
  }

  public static String get(String word) {
    return mappings.get(word);
  }
}
