package com.bright_ascension.proposed.username.impl;

import com.bright_ascension.proposed.username.UsernameStore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/***
 * Tests for UsernameReadOnlyStoreImpl
 * @author stephen munro
 */
class UsernameReadOnlyStoreImplTest {

    @Test
    public void testUsernameReadOnlyStoreCreation(){
        assertThat(new UsernameReadOnlyStoreImpl("stephen").getName()).isEqualTo("stephen");
        assertThat(new UsernameReadOnlyStoreImpl(null).getName()).isEqualTo(UsernameStore.DEFAULT_NAME);
    }

    @Test
    public void testUpdateUsername(){
        UsernameStore usernameStore = new UsernameReadOnlyStoreImpl("stephen");
        assertThat(usernameStore.getName()).isEqualTo("stephen");

        assertThrows(UnsupportedOperationException.class,
                ()->{
                    usernameStore.setName("john");
                });
    }

}