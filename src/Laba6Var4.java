import java.io.*;
import java.util.Scanner;

public class Laba6Var4 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try {
            in = new FileInputStream("C:\\Java\\in.txt");
            file = new InputStreamReader(in, "utf-8");
            buf = new BufferedReader(file);

            File f2 = new File("C:\\Java\\out.txt");
            f2.createNewFile();
            out = new FileOutputStream(f2);
            wr = new OutputStreamWriter(out, "utf-8");
            if (f2.exists()) {
                String line = " ";
                String [] words;
                while ((line=buf.readLine())!=null) {
                    words = line.split(" ");
                    int n = words[0].length();
                    System.out.println("Первое слово = " + words[0] + " length = " + words[0].length());
                    for (int i = 0; i < words.length; i++) {
                        if (words[i].length() < n){
                            wr.append(words[i] + " ");
                            System.out.println(words[i] + " ");
                        }
                    }
                    System.out.println(" ");
                    wr.append("\n");
                }
            }
        }
        catch (IOException io) {
            io.printStackTrace();
        }
        finally {
            buf.close();
            in.close();
            file.close();
            out.flush();
            wr.flush();
        }
    }
}
