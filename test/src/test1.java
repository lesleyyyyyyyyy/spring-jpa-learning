import java.io.FileWriter;
import java.io.IOException;

/**
 * @Author xin.hao
 * @create 2021/2/3 14:44
 */
public class test1 {
    public static void main(String[] args) throws IOException {
        String start = "7501";
        String end = "00";
        String mid = "";
        String str = "";

        Integer i;


        FileWriter out = null;
        out = new FileWriter("D:\\output.txt");


        try {
            for (i = 1; i < 100; i++) {
                if (i < 10) {
                    mid = "0" + i.toString();
                } else {
                    mid = i.toString();
                }
                str = start + mid + end + ",moduleName" + start + mid + end;
                System.out.println(str);
                out.write(str + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }


    }
}
