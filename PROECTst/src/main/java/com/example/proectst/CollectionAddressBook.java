package com.example.proectst;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook{
    @Override
    public void add(Person person) {
        personList.add(person);

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);

    }

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public void print(){
        int number = 0;

        for (Person person: personList){
            number++;
            System.out.println(number + ". PIP: " + person.getPip() + "; Phone:" + person.getPhone());
        }
    }

    public void fillTestData(){
        personList.add(new Person("Emil", "+380642848536"));
        personList.add(new Person("Oleg", "+38014278536"));
        personList.add(new Person("Mykola", "+380358848536"));
        personList.add(new Person("Sioga", "+380992848536"));
        personList.add(new Person("Stas", "+380642848536"));
        personList.add(new Person("Pasha", "+38014278536"));
        personList.add(new Person("Bogdan", "+380358848536"));
        personList.add(new Person("Illy", "+380992848536"));
        personList.add(new Person("Ruslan", "+380992848536"));

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }
}
