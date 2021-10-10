module api {

    requires spring.core;
    requires spring.beans;
    requires spring.context;
    requires spring.web;

    requires service;
    requires spring.boot.autoconfigure;
    requires spring.boot;

    exports com.springboot.java9modules.api;
    exports com.springboot.java9modules.api.controller;

    opens com.springboot.java9modules.api;
    opens com.springboot.java9modules.api.controller;


}