import greetings.Greeting;
import java.lang.reflect.InvocationTargetException;
import loaders.Loader;

class Example {

  public static void main(String[] args)
    throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
    for (String className : Loader.allWords()) {
      Greeting thing = (Greeting) (
        Class
          .forName("greetings." + Loader.get(className))
          .getConstructor()
          .newInstance()
      );
      System.out.println(thing.toString());
    }
  }
}
