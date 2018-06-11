package is211.huffman;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.io.File;

/**
 * A simple Huffman encoder/decoder.
 *
 * @author Even Åby Larsen
 * @version 1.0
 */
public class HuffmanCoDec
{
    // declare fields for the necessary data
    // hint you need a Huffman tree, and a structure
    // where you can quickly retrieve the huffman code
    // for a character (when you are encoding the text)
    private HashMap<Integer, HuffmanNode> encodeTable;
    private PriorityQueue<HuffmanNode> priorityQueue;
    private HuffmanNode root;

    /**
     * Create Huffman encoder/decoder with optimal encoding for the data
     * provided. This constructor will read the text form a java.io.Reader
     *
     * @param src the text to build the code table for.
     */
    public HuffmanCoDec(Reader src) throws IOException {
        createCodeTable(src);
    }

    /**
     * This constructor will read the text from a String
     *
     * @param src
     * @throws IOException
     */
    public HuffmanCoDec(String src) throws IOException {
        this(new StringReader(src));
    }

    /**
     * And this one will read from a file
     *
     * @param f
     * @throws IOException
     */
    public HuffmanCoDec(File f) throws IOException {
        this(new BufferedReader(new FileReader(f)));
    }

    /**
     * Build the huffman tree and encoding table for the text that can be read
     * from src
     *
     * @param src the text to create the code table for
     */
    public final void createCodeTable(Reader src) throws IOException {
        encodeTable = new HashMap<>();
        int data;
        
        // Phase 1 - count character frequencies
        while ((data = src.read()) != -1) {
            countChar(data);
        }
        int[] arr = new int[encodeTable.size()];
        root = createTree();
        
        //show frequency of char
        showFrequency();
        // phase 2 - build the huffman tree
        createTree();
        // assign codes to each character
        //traverse the tree
        traverse(root, "");
    }

        /**
     * Traverses the tree to find the huffman code for each character. When you
     * go left, add a zero to the code, and a one when moving right
     *
     *
     */
    private void traverse(HuffmanNode root, String path) throws NullPointerException {
    if ((root.zero == null) && (root.one == null)) {
            root.code = path;
        } else {
            traverse(root.one, path + 1);

            traverse(root.zero, path + 0);
        
        }
        System.out.println(path);  
        }

      /**
     * Builds the huffmantree based on
     * priorityQueue
     * @return RootNode for the huffman tree
     *
     */
    public HuffmanNode createTree() {
        System.out.println();
          priorityQueue = new PriorityQueue<>();
        for (int i : encodeTable.keySet()) {
            priorityQueue.add(encodeTable.get(i));
        }

        while (priorityQueue.size() > 1) {
        HuffmanNode lNode = priorityQueue.poll();
        HuffmanNode rNode = priorityQueue.poll();

        HuffmanNode newNode = new HuffmanNode(lNode, rNode);
        priorityQueue.add(newNode);
        }
        return priorityQueue.poll();

    }
     /* *
     *
     * @param src
     * @throws IOException
     */
    public void countChar(int c) throws IOException, NullPointerException {
        if (!encodeTable.containsKey(c)) {
            encodeTable.put(c, new HuffmanNode(c));
            encodeTable.get(c).count++;
        }
        else {
            encodeTable.get(c).count++;
        }
    }

    private void showFrequency() {
        System.out.println("Frequency for the characters in the file ");
        for (HashMap.Entry<Integer, HuffmanNode> entry : encodeTable.entrySet()) {
            Integer key = entry.getKey();
            int i = key;
            Character c  = (char) i;
            HuffmanNode value = entry.getValue();
            int count = value.getCount();
            
            System.out.println("Key: " + c + " value: " + count );
        }
    }

    /**
     * Encode a string
     *
     * @param input the text to encode
     * @param output the destination for the encoded text
     * @throws java.io.IOException
     */
    public void encode(Reader input, BitSink output) throws IOException{
        int data;
        while ((data = input.read()) != -1) {
            StringBitSource sbs = new StringBitSource(encodeTable.get(data).code);
            while (sbs.moreBits()) {
                output.writeBit(sbs.nextBit());
            }
        }
    }
    
  
    /**
     * Decode a huffman encoded text. See assignment text for details
     *
     * @param input the encoded text
     * @param output the destination for the decoded text.
     */
    public void decode(BitSource input, Writer output) throws IOException {
        HuffmanNode node = root;
        while (input.moreBits()) {
            int bit = input.nextBit();
    
            if (bit == 1) {
                node = node.one;
            }
            else  {
                node = node.zero;
            }
            if (node.one == null & node.zero == null) {
                int code =  node.c;
                output.write(code);
                node = root;
            }
        }
    }

    /**
     * The node class. It must implement comparable, so the nodes can be
     * compared by the priority queue.
     *
     */
    public class HuffmanNode implements Comparable<HuffmanNode>
    {
        int c; // the character that this node represents
        int count; // the number of occurences of the character in the txt
        String code; // the huffman code for the characters  
        HuffmanNode zero, one; // the children of the node
        int codeBits;
        char ch = (char) c; 

        /**
         * Constructor for leaf nodes
         *
         * @param c
         */
        public HuffmanNode(int c) {
            this.c = c;
            count = 0;
            zero = one = null;
        }
        public HuffmanNode getLeft() {
            return zero;
        }
        
        public HuffmanNode getLeftRight() {
            return one;
        }

        /**
         * Constructor for creating a parent for two nodes
         *
         * @param zero
         * @param one
         */
        public HuffmanNode(HuffmanNode zero, HuffmanNode one) {
            this.zero = zero;
            this.one = one;
            c = 0;
            count = zero.count + one.count;
        }
        
        public int getCount() {
            return count;
        }

        /**
         * ToString is useful for debugging...
         *
         * @return
         *//*
        public String toString() {
            StringWriter out1 = new StringWriter();
            PrintWriter out2 = new PrintWriter(out1);

            out2.format("%3c %5d ", c, count);
            for (int i : code)
            out2.print(i);
            out2.flush();
            out1.flush();
            return out1.toString();
        }*/

        /**
         * compareTo is defined in the Comparable interface. A priority queue
         * will call this method to determine which of two nodes go first.
         *
         * @param that the node to compare this to.
         * @return this.count - that.count
         */
        public int compareTo(HuffmanNode that) {
            return -(that.count - this.count);
        } 
}   
}
