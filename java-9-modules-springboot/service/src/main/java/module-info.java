module service {
    requires spring.context;
    requires spring.beans;

    exports com.springboot.java9modules.service.domain to api;
    exports com.springboot.java9modules.service.services to api;

    opens com.springboot.java9modules.service.domain;
    opens com.springboot.java9modules.service.services;
}