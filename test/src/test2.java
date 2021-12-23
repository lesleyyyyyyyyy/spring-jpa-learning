import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author xin.hao
 * @create 2021/3/1 9:56
 */
public class test2 {
    public static void main(String[] args) throws IOException {
        ex10();

    }


    static void ex10() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(",");
            if (str.length > 1) {
                Arrays.sort(str);
            }
            for (int i = 0; i < str.length; i++) {
                if (i == (str.length - 1)) System.out.print(str[i]);
                else System.out.print(str[i] + ",");
            }
            System.out.println();
        }
        sc.close();
    }

    public void ex9() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {

            String[] str = sc.nextLine().split(" ");
            //if(Integer.parseInt(str[0])==0) break;
            int sum = 0;
            if (str.length >= 1) {
                for (int i = 0; i < str.length; i++) {
                    sum += Integer.parseInt(str[i]);
                }
                System.out.println(sum);

            }
        }
        sc.close();
    }

}
