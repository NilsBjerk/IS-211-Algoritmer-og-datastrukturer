package is211.huffman;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * This class can be used to write individual bits to a file.
 *
 * The close() method must be called to terminate the file properly.
 *
 * If the number of bits writen is not a multiple of 8, the final byte is only
 * partially used. Therefore the number of "real" data bits in the last byte is
 * appended to the file just before it is closed.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class FileBitSink implements BitSink
{
    private FileOutputStream out;
    private int buffer;
    private int numBits;

    /**
     * Open file f for writing bits.
     */
    public FileBitSink(File f) throws IOException {
        out = new FileOutputStream(f);
    }

    /**
     * Write one bit
     */
    public void writeBit(int bit) throws IOException {
        if (bit != 0 && bit != 1)
            throw new IOException("Bit value not 0 or 1: " + bit);

        buffer = buffer | (bit << numBits);
        numBits++;
        if (numBits == 8) {
            // buffer is full - write to file
            out.write((byte) buffer);
            numBits = 0;
            buffer = 0;
        }
    }

    /**
     * Writes the final bits and closes the file
     */
    public void close() throws IOException {
        if (numBits > 0) {
            // write the buffer
            out.write((byte) buffer);
            // and the number of real bits in the final byte
            out.write((byte) numBits);
        }
        // buffer has just been flushed so all 8 bits are used
        else
            out.write((byte) 8);
        out.close();
    }
}
