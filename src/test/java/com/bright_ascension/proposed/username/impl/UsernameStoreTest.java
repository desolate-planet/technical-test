package com.bright_ascension.proposed.username.impl;

import com.bright_ascension.proposed.username.UsernameStore;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

/***
 * Tests covering all implementations of UsernameStore
 * @author stephen munro
 */
public class UsernameStoreTest {

    @Test
    void testDifferentStores() {

        Set<UsernameStore> people = new HashSet<>();
        // add some people
        people.add(new UsernameStoreImpl("Peter"));
        people.add(new UsernameReadOnlyStoreImpl("Mark"));

        UsernameStore testStore = new UsernameStoreImpl(null);
        testStore.setName("Sam");
        people.add(testStore);

        assertThat(people).hasSize(3);

        printUsernames(people);

        // reset everything
        resetUsernames(people);

        assertThat(people.stream()
                  .filter(person -> person.getName().equals(UsernameStore.DEFAULT_NAME))
                  .count()).isEqualTo(2);

        assertThat(people.stream()
                .filter(person -> person.getName().equals("Mark"))
                        .count()).isEqualTo(1);


        // now clean up
        people.clear();
        assertThat(people.size()).isEqualTo(0);
    }

    private void printUsernames(Set<UsernameStore> usernames){

        StringBuilder usernameOutput = new StringBuilder();
        for(UsernameStore username: usernames){
            usernameOutput.append("Person: ")
                          .append(username.getName())
                          .append("\n");
            }

        System.out.println(usernameOutput);
        usernameOutput.setLength(0);
    }

    private void resetUsernames(Set<UsernameStore> usernames){
        usernames.stream().filter(not(usernameStore -> usernameStore instanceof UsernameReadOnlyStoreImpl ))
                .forEach(usernameStore -> usernameStore.setName(UsernameStore.DEFAULT_NAME));
    }
}
