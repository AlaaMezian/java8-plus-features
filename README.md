# java8-plus-features
This repo will contain a documentation about the most import features of java after java 8 ,the motivation behind this repository is that java 17 oracle jdk is free LTS release from oracle, thus people like me who have been using java 8 for years now have a lot to keep up with and this document have to with keeping up.

# Java 9

# Modular System 
```
module com.baeldung.java9.modules.car {
    requires com.baeldung.java9.modules.engines;
    exports com.baeldung.java9.modules.car.handling;
}
```
