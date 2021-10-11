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
