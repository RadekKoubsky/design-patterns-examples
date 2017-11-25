package org.rkoubsky.examples.designpatterns.structural.decorator.inputstream;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Radek Koubsky (radekkoubsky@gmail.com)
 */
public class LowerCaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowerCaseInputStream(final InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        final int c = super.read();
        return c == -1 ? c : Character.toLowerCase((char) c);
    }
}
