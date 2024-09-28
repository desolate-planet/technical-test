package com.bright_ascension.proposed.username.impl;

import com.bright_ascension.proposed.username.UsernameStore;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/***
 * Tests for UsernameStoreImpl
 * @author stephen munro
 */
class UsernameStoreImplTest {


    @Test
    public void testUsernameStoreCreation(){
        assertThat(new UsernameStoreImpl("stephen").getName()).isEqualTo("stephen");
        assertThat(new UsernameStoreImpl(null).getName()).isEqualTo(UsernameStore.DEFAULT_NAME);
    }

    @Test
    public void testUpdateUsername(){
        UsernameStore usernameStore = new UsernameStoreImpl("stephen");
        assertThat(usernameStore.getName()).isEqualTo("stephen");
        usernameStore.setName(null); // check to ensure the null value is ignored.
        assertThat(usernameStore.getName()).isEqualTo("stephen");
        usernameStore.setName("john");
        assertThat(usernameStore.getName()).isEqualTo("john");
    }
}