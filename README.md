# java8-plus-features
This repo will contain a documentation about the most import features of java after java 8 ,the motivation behind this repository is that java 17 oracle jdk is free LTS release from oracle, thus people like me who have been using java 8 for years now have a lot to keep up with and this document have to with keeping up.

# Java 9

# Modular System 

Lets say moduliraty is the best approach when writing an application, the re usability aspect along side and code speration are the most important benifits when it comes to writing clean code and java modules have to do just that.

Modules have a concept of dependencies, can export a public API and keep implementation details hidden/private which is most important no calsses can tlk to each other unless a configuration is added in module.info (exports/requires).

One of the main motivations here is to provide modular JVM, which can run on devices with a lot less available memory.

```
module com.baeldung.java9.modules.car {
    requires com.baeldung.java9.modules.engines;
    exports com.baeldung.java9.modules.car.handling;
}
```
