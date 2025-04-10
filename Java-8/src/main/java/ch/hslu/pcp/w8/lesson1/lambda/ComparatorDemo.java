/*
* HSLU I
* Module PCP
* ruedi.arnold@hslu.ch
*/

package ch.hslu.pcp.w8.lesson1.lambda;

import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

  public static void main(String[] args) {
   
    List<Person> personList = Person.createShortList();
  
    // Sort with Inner Class
    personList.sort(new Comparator<Person>(){
      @Override
      public int compare(Person p1, Person p2){
        return p1.getSurName().compareTo(p2.getSurName());
      }
    });
    
    // TODO: add unit-tests for the following code! (Ruedi 15.4.20)
    
    System.out.println("=== Sorted Asc SurName ===");
    for(Person p:personList){
      System.out.println(p);
    }
    
    // Use Lambda instead
    
    // Print Asc
    System.out.println("=== Sorted Asc SurName ===");
    personList.sort((p1, p2) -> p1.getSurName().compareTo(p2.getSurName()));

    // Alternative with Comparator.comparing(...)
    personList.sort(Comparator.comparing(Person::getSurName));
    
    Comparator<Person> c = Comparator.comparing(Person::getSurName);
    BiToIntFunction<Person> b = (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName());
    
    // Print Desc
    System.out.println("=== Sorted Desc SurName ===");
    personList.sort((p1,  p2) -> p2.getSurName().compareTo(p1.getSurName()));

    for(Person p:personList){
      System.out.println(p);
    }
    
  }
}