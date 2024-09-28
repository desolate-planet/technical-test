package com.bright_ascension.original;

import java.util.HashSet;
import java.util.Set;

public class ClassExample {
  public static String defaultName = "Default name";
  
  public static void main(String[] args) {
    // create my list
    Set<UserInterface> people = new HashSet<>();
    
    // add some people
    UserInterface myUser = new UserImplementation("Peter");
    people.add(myUser);
    
    myUser = new ReadOnlyUserImplementation("Mark");
    people.add(myUser);
    
    myUser = new UserImplementation(null);
    myUser.setName("Sam");
    people.add(myUser);
    
    // print them out!!
    for (UserInterface person : people) {
      String peopleString = "Person: ";
      peopleString += person.getName();
      
      System.out.println(peopleString);
    }
    
    // reset everything
    people.stream().forEach(person -> person.setName(defaultName));
    
    // now clean up
    people.clear();
  }

  public interface UserInterface {
    public void setName(String theName);
    public String getName();
  }
  
  private static class UserImplementation implements UserInterface {
    private String theName = defaultName;
    private int cachedNameLength;

    public UserImplementation(String theName) {
      theName = theName;
      
      cachedNameLength = theName.length();
    }
    
    @Override
    public void setName(String theNewName) {
      theName = theName;
    }

    @Override
    public String getName() {
      return theName;
    }
  }
  
  public static class ReadOnlyUserImplementation implements UserInterface {
    public String theName = defaultName;

    public ReadOnlyUserImplementation(String theName) {
      theName = theName;
    }
    
    @Override
    public void setName(String theName) {
      throw new RuntimeException("Implementation is invariant");
    }

    @Override
    public String getName() {
      return theName;
    }
  }
}
