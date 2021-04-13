package nextstep.ladder.domain;

import static java.util.Collections.unmodifiableList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Persons {

  private final List<Person> persons;

  private Persons(List<Person> persons) {
    this.persons = persons;
  }

  public static Persons generate(String[] names) {
    List<Person> persons = Arrays.stream(names)
        .map(Person::generate)
        .collect(Collectors.toList());
    return new Persons(persons);
  }

  public List<Person> getPersons() {
    return unmodifiableList(persons);
  }

  public int size() {
    return persons.size();
  }

  public int findIndex(String name) {
    int personIndex = persons.indexOf(Person.generate(name));
    if (personIndex < 0) {
      throw new IllegalArgumentException("not matched person.");
    }
    return personIndex;
  }
}
