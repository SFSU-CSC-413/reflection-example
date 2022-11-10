import greetings.Greeting;
import java.lang.reflect.InvocationTargetException;
import loaders.DynamicLoader;

public class DynamicExample {

  public static void main(String[] args)
    throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
    for (String className : DynamicLoader.allWords()) {
      Greeting thing = (Greeting) (
        Class
          .forName("greetings." + DynamicLoader.get(className))
          .getConstructor()
          .newInstance()
      );
      System.out.println(thing.toString());
    }
  }
}
