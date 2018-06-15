package pio.person;

public abstract class Person {

  private String name;
  private String surname;
  private static int idIterator = 0;
  private int id;

  Person(String name, String surname) {
    this.name = name;
    this.surname = surname;
    id = idIterator++;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return id == person.id;
  }

  @Override
  public int hashCode() {
    return id;
  }
}
