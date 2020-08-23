package com.boliviajug.demo.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

@Route
@PWA(name = "UI en Java", shortName = "Hola Mundo")
public class MainView extends VerticalLayout {
    public MainView() {
        TextField name = new TextField("Nombre");
        Paragraph greeting = new Paragraph("");

        Button button = new Button("Saludo", event -> {
            greeting.setText("Hola " + name.getValue());
        });

        add(name, button, greeting);
    }
}
