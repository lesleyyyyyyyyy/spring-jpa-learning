import java.util.stream.Stream;

/**
 * @Author xin.hao
 * @create 2021/3/24 16:41
 */
public class test0324 {
    public static void main(String[] args) {
        /*Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        StringBuilder str = new StringBuilder();
        Integer i = 01;
        //String format = String.format("%02d", i + 1);
        str.append("TF-"+formatter.format(date)+"-"+String.format("%02d", i + 1));
        System.out.println(str);
        //System.out.println(str.substring(12));*/

      /*
        Long a = 1L;
        Long b = 1L;
        System.out.println(a.equals(b));
        */

        Stream<Integer> list = Stream.of(5, 6, 2, 8, 24, 52, 1, 3, 565, 6, 7);
        Stream<Integer> integerStream = list.filter(x -> x > 5).sorted();
        //list.forEach(System.out::println);
        System.out.println("-----------------------------");
        integerStream.forEach(System.out::println);


    }
}
