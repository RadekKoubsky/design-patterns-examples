package org.rkoubsky.examples.designpatterns.structural.decorator.inputstream;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class InputStreamTest {
    public static void main(final String[] args) {
        int c;
        try (InputStream in = new LowerCaseInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream("I know the Decorator Pattern therefore I RULE!".getBytes())))) {
            while ((c = in.read()) >= 0) {
                System.out.print((char) c);
            }
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }
}
