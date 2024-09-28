package com.bright_ascension.proposed.username;

/***
 * An interface for storing and setting usernames
 * @author stephen munro
 */
public interface UsernameStore {

    String DEFAULT_NAME = "Default name";

    void setName(String theName);
    String getName();
}
