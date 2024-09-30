package com.bright_ascension.proposed.username.impl;

import com.bright_ascension.proposed.username.UsernameStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/***
 * A read-only implementation of UsernameStore, allowing usernames to
 * be stored, but not updated.
 * @author stephen munro
 */
public class UsernameReadOnlyStoreImpl implements UsernameStore {

    Logger logger = LoggerFactory.getLogger(UsernameReadOnlyStoreImpl.class);

    private String theName;

    /***
     * Constructor for initializing instances of UsernameRepositoryImpl.
     * @param theName the initial username to store.
     */
    public UsernameReadOnlyStoreImpl(String theName) {

        if(!Objects.isNull(theName)){
            logger.debug(String.format("Setting username to: %s", theName));
            this.theName = theName;
        }
        else{
            logger.warn("A null username was provided, using default");
            this.theName = UsernameStore.DEFAULT_NAME;
        }
    }

    /**
     * This method is not supported in this implementation.
     * @param theName the name to update.
     * @throws UnsupportedOperationException if the method is invoked.
     */
    @Override
    public void setName(String theName) {
        logger.warn("Invoking unsupported method");
        throw new UnsupportedOperationException("Method not supported in this implementation");
    }

    @Override
    public String getName() {
        return theName;
    }
}
