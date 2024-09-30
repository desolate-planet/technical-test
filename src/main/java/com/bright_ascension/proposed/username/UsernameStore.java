package com.bright_ascension.proposed.username;

/***
 * An interface for storing and setting usernames
 * @author stephen munro
 */
public interface UsernameStore {

    String DEFAULT_NAME = "Default name";

    /**
     * Sets the username
     * @param theName the string value for the username
     */
    void setName(String theName);

    /**
     * Returns the username
     * @return a string value representing the username.
     */
    String getName();
}
