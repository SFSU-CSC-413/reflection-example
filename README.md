## Instructions

If using the basic Example that follows the same pattern we use in our `ByteCodeLoader`, you will need to compile all the greetings first:

```
javac greetings/*.java
javac Example.java
java Example
```

Otherwise, when you attempt to run, you will see the following error:

```
➜  javac Example.java                             [21:01:45 11/9/22]
➜  java Example                                   [21:08:17 11/9/22]
Exception in thread "main" java.lang.ClassNotFoundException: greetings.HiWorld
	at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:641)
	at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:188)
	at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:521)
	at java.base/java.lang.Class.forName0(Native Method)
	at java.base/java.lang.Class.forName(Class.java:383)
	at java.base/java.lang.Class.forName(Class.java:376)
	at Example.main(Example.java:12)
```

Since these classes are not referenced in `Example.java`, when we compile the Example file, the java compiler does not know that there are additional files that need to be compiled. When running the `Example` program, the class implementations are needed by `Reflection` in order to create instances are not found on the `CLASSPATH`.

Manually compiling before running `Example` places the `.class` definitions in the classpath, so that the class implementations can be found at runtime.

## Dynamically loading the class mappings

The above steps are tedious; Java gives us the tools to dynamically compile `.java` files when necessary. This is **not** a requirement for Assignment 4, and is just provided here as an example of the flexibility that `Reflection` gives us - if I want to add another "Greeting", I just need to create the implementation and drop it in the `greetings` package.

```
javac DynamicExample.java
java DynamicExample
```
