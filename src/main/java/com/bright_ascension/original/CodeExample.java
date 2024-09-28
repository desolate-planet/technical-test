package com.bright_ascension.original;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CodeExample {
  public static void main(String[] args) {
    hashMapOutput();
    
    pallindrome();
  }

  public static void hashMapOutput() {
    HashMap <Integer,String> map;
    map = new HashMap<Integer,String>();
    map.put(2, "Two");
    map.put(25, "Twenty Five");
    map.put(12, "Twelve");
    
    System.out.println(map.size());

    System.out.println("While Loop:");
    Iterator itr = map.entrySet().iterator();
    while (itr.hasNext()) {
      Map.Entry me = (Map.Entry) itr.next();
      System.out.println("Key is " + me.getKey() + " Value is " + me.getValue());
    }

    System.out.println("Advanced For Loop:");
    for (Map.Entry me2 : map.entrySet()) {
      System.out.println("Key is: " + me2.getKey() + " Value is: " + me2.getValue());
    }

    System.out.println("Stream:");
    map.entrySet().stream().forEach(me3 -> {
      System.out.println("Key is: " + me3.getKey() + " Value is: " + me3.getValue());
    });
  }

  public static void pallindrome() {
    String original = "", reverse = "";
    Scanner in = new Scanner(System.in);
    int length;
    
    System.out.println("Enter the number or String");
    original = in.nextLine();
    length = original.length();
    
    for (int i = length - 1; i > 0; i--) {
      reverse = reverse + original.charAt(i);
    }
    
    String reverse_string = "reverse is:" + reverse;
    System.out.println(reverse_string);

    if (original.equals(reverse))
      System.out.println("The number is palindrome");
    else
      throw new NullPointerException("The number is not a palindrome");
  }
}
