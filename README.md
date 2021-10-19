# java8-plus-features
This repo will contain a documentation about the most import features of java after java 8 ,the motivation behind this repository is that java 17 oracle jdk is free LTS release from oracle, thus people like me who have been using java 8 for years now have a lot to keep up with and this document have to with keeping up.

# Java 9

# Modular System 

Let's say modularity is the best approach when writing an application, the re-usability aspect alongside and code separation are the most important benefits when it comes to writing clean code and java modules have to do just that.

Modules have a concept of dependencies, can export a public API and keep implementation details hidden/private which is most important no classes can tlk to each other unless a configuration is added in module.info (exports/requires).

One of the main motivations here is to provide modular JVM, which can run on devices with a lot less available memory.

```
module com.baeldung.java9.modules.car {
    requires com.baeldung.java9.modules.engines;
    exports com.baeldung.java9.modules.car.handling;
}
```

# New Http Client 

The new Http Client Provided by java 9 10 11 have some great features one of them is it support async api calls, easy connection to web sockets and default support for HTTP2

# Process Api Improvement 

Java has improved its process API in Java 9 version that helps to manage and control operating system processes.

In earlier versions, it was complex to manage and control operating system processes by using Java programming. Now, new classes and interfaces are added to perform this task.

# Interfaces private method 

Java 8 brought us default methods on interfaces. An interface can now also contain behavior instead of only method signatures.

But what happens if you have several default methods on an interface with code that does almost the same thing? Normally, you'd refactor those methods to call a private method containing the shared functionality. 

But default methods can't be private. Creating another default method with the shared code is not a solution,
because this helper method becomes part of the public API. With Java 9, you can add private helper methods to interfaces to solve this problem.

# Try With Resources enhancement 

In Java 7, the try-with-resources syntax requires a fresh variable to be declared for each resource being managed by the statement.


In Java SE 9, if we have a resource which is already declared outside the Try-With-Resource Statement as final or effectively final, then we do NOT need to declare a local variable.

We can use previously created variable within Try-With-Resource Statement without any issues.

# Stream api new Apis

In Java 9, Stream API has improved and new methods are added to the Stream interface.

Such as dropWhile , takeWhile , Stream.iterate and Stream of Nullable

# Java 9 way of initializing map and set

Java 9 comes with various factory methods in the Map interface that simplify the creation and initialization of immutable maps and sets.

# Java 10

# Local Variable Type Inference 

the introduction of var even though java is a strongly typed language the option to have a loosely type var keyword come in handy sometimes

# Java 11

# New String Methods
Java 11 adds a few new methods to the String class: isBlank, lines, strip, stripLeading, stripTrailing, and repeat.

# New File Methods

Java 11 adds an easier way to read and write string to file with the introduction of readString and writeString static methods from the Files.

# Collection to Array 

The java.util.Collection interface contains a new default toArray method which takes an IntFunction argument.

This makes it easier to create an array of the right type from a collection

# The Not Predicate

The not Predicate can be use with filter to make it read more naturally and other uses.