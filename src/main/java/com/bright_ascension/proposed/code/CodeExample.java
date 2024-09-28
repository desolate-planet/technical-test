package com.bright_ascension.proposed.code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/***
 * A class for testing best practice coding standards.
 * @author stephen munro
 */
public class CodeExample {
  public static void main(String[] args) {
    verifyMapContents();
    verifyPalindromeValue();
  }

  /***
   * Populates a map with values and exercises looping techniques as well
   * as string concatenation.
   */
  public static void verifyMapContents() {
    Map <Integer,String> map = new HashMap<>();
    map.putAll(Map.of(2,"Two", 25, "Twenty Five", 12, "Twelve"));

    System.out.println(map.size());


    StringBuilder sb = new StringBuilder("While Loop:\n");

    Iterator<Map.Entry<Integer,String>> itr = map.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry<Integer, String> me = itr.next();
      sb.append(String.format("Key is %s, value is %s\n", me.getKey(), me.getValue()));
    }

    System.out.println(sb);
    sb.setLength(0);

    sb.append("Advanced For Loop:\n");

    for (Map.Entry<Integer, String> me2 : map.entrySet()) {
      sb.append(String.format("Key is: %s, value is: %s\n", me2.getKey(), me2.getValue()));
    }

    System.out.println(sb);
    sb.setLength(0);

    sb.append("Stream:\n");
    sb.append(map.entrySet().stream()
                  .map(me -> String.format("Key is: %s, value is: %s", me.getKey(), me.getValue()))
                          .collect(Collectors.joining("\n")));
    System.out.println(sb);
    sb.setLength(0);
  }

  /***
   * Reads an input value (string or number) from stdin and checks if it is a valid palindrome or not.
   * @throws IllegalArgumentException if a blank value is provided.
   */
  public static void verifyPalindromeValue() {
    String original;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a number or String");
    original = in.nextLine();

    if (original.isBlank()) {
      throw new IllegalArgumentException("A blank value was provided, please enter a valid number or string");
    }

    StringBuilder sb = new StringBuilder(original);

    String reverseValue = sb.reverse().toString();
    System.out.printf("The reverse value is: %s\n", reverseValue);

    if (original.equals(reverseValue)) {
      System.out.println("The value entered is a valid palindrome");
    } else {
      System.out.println("The value entered is not a valid palindrome");
    }
  }

}
