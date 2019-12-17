package JavaIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class MappedIO {

    public static File toDirect(File f) throws IOException {
        FileChannel fcIn = new FileInputStream(f).getChannel();
        ByteBuffer b = ByteBuffer.allocateDirect((int) f.length());
        fcIn.read(b);
        b.flip();
        Charset cs = Charset.defaultCharset();
        CharBuffer cb = cs.decode(b);
        String cbD1 = cb.toString().replace(".allocate(", ".allocateDirect(");
        String cbD = cbD1.replace(f.getName().split("\\.")[0],
                f.getName().split("\\.")[0] + "Direct");
        CharBuffer cbNew = CharBuffer.wrap(cbD);
        String ext = (f.getName().split("\\."))[1];
        String outFile = (f.getName().split("\\."))[0] +
                "Direct." + ext;
        FileChannel fcOut = new FileOutputStream(new File(outFile)).getChannel();
        fcOut.write(cs.encode(cbNew));
        // fcIn.transferTo(0, f.length(), fcOut);
        fcIn.close();
        fcOut.close();
        return new File(outFile);
    }



    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        private String name;

        public Tester(String name) {
            this.name = name;
        }

        public void runTest() {
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n", duration / 1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] tests = {
            new Tester("Stream Write") {
                public void test() throws IOException {
                    DataOutputStream dos = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream(new File("temp.tmp"))));
                    for (int i = 0; i < numOfInts; i++)
                        dos.writeInt(i);
                    dos.close();
                }
            },
            new Tester("Mapped Write") {
                public void test() throws IOException {
                    FileChannel fc =
                            new RandomAccessFile("temp.tmp", "rw")
                                    .getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_WRITE, 0, fc.size())
                            .asIntBuffer();
                    for (int i = 0; i < numOfInts; i++)
                        ib.put(i);
                    fc.close();
                }
            },
            new Tester("Stream Read") {
                public void test() throws IOException {
                    DataInputStream dis = new DataInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("temp.tmp")));
                    for (int i = 0; i < numOfInts; i++)
                        dis.readInt();
                    dis.close();
                }
            },
            new Tester("Mapped Read") {
                public void test() throws IOException {
                    FileChannel fc = new FileInputStream(
                            new File("temp.tmp")).getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_ONLY, 0, fc.size())
                            .asIntBuffer();
                    while (ib.hasRemaining())
                        ib.get();
                    fc.close();
                }
            },
            new Tester("Stream Read/Write") {
                public void test() throws IOException {
                    RandomAccessFile raf = new RandomAccessFile(
                            new File("temp.tmp"), "rw");
                    raf.writeInt(1);
                    for (int i = 0; i < numOfUbuffInts; i++) {
                        raf.seek(raf.length() - 4);
                        raf.writeInt(raf.readInt());
                    }
                    raf.close();
                }
            },
            new Tester("Mapped Read/Write") {
                public void test() throws IOException {
                    FileChannel fc = new RandomAccessFile(
                            new File("temp.tmp"), "rw").getChannel();
                    IntBuffer ib = fc.map(
                            FileChannel.MapMode.READ_WRITE, 0, fc.size())
                            .asIntBuffer();
                    ib.put(0);
                    for (int i = 1; i < numOfUbuffInts; i++)
                        ib.put(ib.get(i - 1));
                    fc.close();
                }
            }
    };

    public static void main(String[] args) {
        for (Tester test : tests)
            test.runTest();
    }
}
