package org.rkoubsky.examples.designpatterns.creational.singleton.nonthreadsafe;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class NonThreadSafeSingletonTest {
    @Test
    public void nonThreadSafeSingletonFailsToCreateSingleInstance() throws InterruptedException {
        final Set<NonThreadSafeSingleton> singletonSet = Collections
                .synchronizedSet(new HashSet<NonThreadSafeSingleton>());
        final Thread[] threads = new Thread[5];
        startThreads(singletonSet, threads);
        joinThreads(threads);

        Assertions.assertThat(singletonSet.size())
                .as(String.format("The set: %s should contain only one instance of a singleton class",
                        singletonSet))
                .isEqualTo(1);
    }

    private void startThreads(final Set<NonThreadSafeSingleton> singletonSet, final Thread[] threads) {
        IntStream.range(0, 5).forEach(i -> {
            threads[i] = createThread(singletonSet);
            threads[i].start();
        });
    }

    private Thread createThread(
            final Set<NonThreadSafeSingleton> singletonSet) {
        final Thread thread = new Thread(() -> {
            final NonThreadSafeSingleton singleton = NonThreadSafeSingleton.getInstance();
            singletonSet.add(singleton);
            System.out.println("Got a singleton instance: " + singleton);
        });

        return thread;
    }

    private void joinThreads(final Thread[] threads) {
        Stream.of(threads).forEach(thread -> {
            join(thread);
        });
    }

    private void join(final Thread thread) {
        try {
            thread.join();
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}