package org.codancer;

import org.springframework.validation.DataBinder;

public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(201);
        person.setName("sasa");

        DataBinder binder = new DataBinder(person);

        binder.setValidator(new PersonValiditor());

        binder.validate();

        System.out.println(binder.getBindingResult().getAllErrors());
    }
}
