package is211.huffman;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;


/**
 * Write a description of class HuffmanDemo here.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class HuffmanDemo
{
    public static void main(String[] args) throws IOException, Exception {
        runFileDemo("terjevigen.txt");
       // runStringDemo("Karakterer i teksten");
      
        

        // runStringDemo("Der bodde en underlig gråsprængt en på den yderste nøgne ø;-");
    }

    public static void runFileDemo(String filename) throws IOException, Exception {
        File infile = new File(filename); // the original text file
        File outfile = new File(filename + "-out.txt"); // decoded text
        File binfile = new File(filename + "-huffman.bin"); // encoded file

        // create huffman tree and encoding table, based on infile
        HuffmanCoDec huff = new HuffmanCoDec(infile);
        FileReader textIn = new FileReader(infile);
        FileBitSink binOut = new FileBitSink(binfile);
        
        // encode the text file contents
        huff.encode(textIn, binOut);
        binOut.close();
        //huff.encode(textIn, binOut);
       //huff.toByteSequence(filename);
        
        
        // decode the encoded file back to text
        FileBitSource binIn = new FileBitSource(binfile);
        FileWriter textOut = new FileWriter(outfile);
        huff.decode(binIn, textOut);
        textOut.close();
        
        // Count    
        //huff.countChar(0);
        //huff.CountWords(infile);
        //huff.ultimateCounter(infile);
        // huff.countFucker(infile);
        //huff.createCodeTable(textIn);
        
        
        // finished - compare the contents of infile and outfile
        // they should be identical
        // you can use diff (on mac/linux/unix). There is a similar
        // command on windows, comp or compare???
    }

    public static void runStringDemo(String text) throws IOException {
       System.out.println("Creating Huffman Tree and encode table");
        HuffmanCoDec huff = new HuffmanCoDec(text);
       //huff.countChar(0);

        // encode the string text
        Reader textIn = new StringReader(text);
        BitSink binOut = new StringBitSink();
        //huff.encode(textIn, binOut);
        binOut.close();
        String bin = binOut.toString();
        System.out.println("Encode result:'" + text + "' >>>>> " + bin);

        // decode
        BitSource binIn = new StringBitSource(binOut.toString());
        Writer textOut = new StringWriter();
        huff.decode(binIn, textOut);
        textOut.close();
        String dec = textOut.toString();
        System.out.println("Decode result:'" + dec + "' <<<<< " + bin);
        
        // count
        //huff.countChar(0);
    }
}
