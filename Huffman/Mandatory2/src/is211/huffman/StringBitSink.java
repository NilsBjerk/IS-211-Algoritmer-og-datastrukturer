package is211.huffman;


import java.io.IOException;


/**
 * An implementation of BitSink that stores data temporarily in a StringBuilder
 * and returns a String as the final result.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class StringBitSink implements BitSink
{
    private StringBuilder buf;

    public StringBitSink() {
        buf = new StringBuilder();
    }

    public void writeBit(int bit) throws IOException {
        if (bit == 0)
            buf.append("0");
        else if (bit == 1)
            buf.append("1");
        else
            throw new IOException("Illegal bit value : " + bit);
    }

    public String toString() {
        return buf.toString();
    }

    public void close() {
        // ok
    }
}
