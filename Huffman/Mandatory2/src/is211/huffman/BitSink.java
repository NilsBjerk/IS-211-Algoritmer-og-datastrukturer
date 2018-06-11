package is211.huffman;


import java.io.IOException;


/**
 * A BitSink is something you can write bits to.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public interface BitSink
{
    /**
     * Write a single bit.
     *
     * @param bit the value to write (it must be 0 or 1)
     * @throws IOException if bit is not 0 or 1
     */
    public void writeBit(int bit) throws IOException;

    /**
     * Clean up the BitSink, send any buffered bits to the destination, and stop
     * receiving more bits.
     *
     * @throws IOException
     */
    public void close() throws IOException;
}
