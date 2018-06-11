package is211.huffman;


import java.io.IOException;


/**
 * A BitSource is something you can read bits from.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public interface BitSource
{
    /**
     * Check for end of input.
     *
     * @return true if at least one more bit can be read from this BitSource
     */
    public boolean moreBits();

    /**
     * Read the next bit.
     *
     * @return the value of the next bit (0 or 1).
     * @throws IOException if no more bits are available.
     */
    public int nextBit() throws IOException;

    /**
     * Clean up the BitSource and stop serving bits.
     *
     * @throws IOException
     */
    public void close() throws IOException;
}
