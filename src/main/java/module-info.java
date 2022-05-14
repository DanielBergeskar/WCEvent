module com.bergeskar.wcevent {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.persistence;
    requires org.hibernate.orm.core;

    opens com.bergeskar.eventgui to javafx.fxml;
    opens com.bergeskar.eventgui.entity;
   //opens com.bergeskar.eventgui.controllers to javafx.fxml;
    exports com.bergeskar.eventgui;
}