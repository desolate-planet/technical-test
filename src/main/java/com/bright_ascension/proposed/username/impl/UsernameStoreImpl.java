package com.bright_ascension.proposed.username.impl;

import com.bright_ascension.proposed.username.UsernameStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/***
 * a read/write implementation of UsernameStore allowing
 * usernames to be stored and updated.
 * @author stephen munro
 */

public class UsernameStoreImpl implements UsernameStore {

    Logger logger = LoggerFactory.getLogger(UsernameStoreImpl.class);

    private String theName;

    private int cachedNameLength;

    /***
     * Constructor for initializing instances of UsernameRepositoryImpl.
     * @param theName the initial username to store.
     */
    public UsernameStoreImpl(String theName) {

        if(!Objects.isNull(theName)){
            logger.debug(String.format("Setting username to: %s", theName));
            this.theName = theName;
        }
        else{
            logger.warn("A null username was provided, using default");
            this.theName = UsernameStore.DEFAULT_NAME;
        }
        cachedNameLength = this.theName.length();
    }

    @Override
    public void setName(String theNewName) {

        if(!Objects.isNull(theNewName)){
            logger.debug(String.format("Updating username to: %s", theNewName));
            this.theName = theNewName;
            this.cachedNameLength = theNewName.length();
        }
        else{
            logger.warn("New name provided was null, ignoring update");
        }
    }

    @Override
    public String getName() {
        return theName;
    }
}
