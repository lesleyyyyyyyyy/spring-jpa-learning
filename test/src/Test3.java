import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author xin.hao
 * @create 2021/3/1 11:05
 */

class Test3 {

    @Test
    public void main() {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            if (str.length > 1) {
                Arrays.sort(str);
            }
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        sc.close();
    }

    @Test
    void t2() {

    }

}
