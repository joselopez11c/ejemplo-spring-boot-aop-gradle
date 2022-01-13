package com.coderhouse.model.examples;

import com.coderhouse.annotations.CustomClassAnnotation;

@CustomClassAnnotation
public class ExampleClassAnnotation {
    String id;
    String nombre;

    public ExampleClassAnnotation() {}

    public ExampleClassAnnotation(String id) {
        this.id = id;
    }
}
