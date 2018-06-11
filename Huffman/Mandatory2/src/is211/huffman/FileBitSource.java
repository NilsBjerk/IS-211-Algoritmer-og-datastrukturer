package is211.huffman;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * Write a description of class FileBitSource here.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class FileBitSource implements BitSource
{
    private FileInputStream input;
    /**
     * The fields buf1, buf2 and buf3 constitute a 3-byte window that slides
     * along the file. When EOF is reached, buf3 == -1, and buf2 will contain
     * the number of valid bits in buf1 (read from the final byte of the file -
     * see FileBitSink)
     */
    private int buf1;
    private int buf2;
    private int buf3;
    private int readBit;

    /**
     * Open file f for reading bits
     */
    public FileBitSource(File f) throws IOException {
        input = new FileInputStream(f);
        buf2 = input.read();
        buf3 = input.read();
        readBit = 8;
    }

    /**
     * Read the next bit.
     *
     * @return 0 or 1.
     * @throws IOException if no more bits to read
     */
    public int nextBit() throws IOException {
        if (readBit == 8) {
            nextByte();
        }

        if (!moreBits())
            throw new IOException("Attempt to read beyond EOF!");

        // get a single bit out of buffer
        int bit = buf1 & (1 << readBit);
        // and make sure it is 0/1
        if (bit != 0)
            bit = 1;
        readBit++;
        return bit;
    }

    /**
     * Move the "window" one byte
     */
    private void nextByte() throws IOException {
        buf1 = buf2;
        buf2 = buf3;
        buf3 = input.read();
        readBit = 0;
    }

    public boolean moreBits() {
        if (buf3 != -1)
            return true; // not EOF yet...
        else
            return readBit < buf2;
    }

    public void close() throws IOException {
        input.close();
    }
}
