package is211.huffman;


import java.io.IOException;


/**
 * Write a description of class StringBitSource here.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class StringBitSource implements BitSource
{
    private String data;
    private int pos;

    public StringBitSource(String data) {
        this.data = data;
        pos = 0;
    }

    public int nextBit() throws IOException {
        if (pos < data.length()) {
            int c = data.charAt(pos);
            pos++;
            if (c == '0')
                return 0;
            else if (c == '1')
                return 1;
            else
                throw new IOException("Illegal character in data : " + c);
        }
        else
            throw new IOException("No more bits to read!");
    }

    public boolean moreBits() {
        return (pos < data.length());
    }

    public void close() {
    }
}
