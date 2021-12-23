import java.util.HashMap;
import java.util.Map;

/**
 * @Author xin.hao
 * @create 2020/11/10 16:42
 */
public class test {
    public static void main(String[] args) {
        String code = null;
        String Msg = null;
        String result = getMsg(code, Msg);
//        System.out.println(code);
//        System.out.println(Msg);
//        System.out.println(result);

        Map<String, String> map = new HashMap();
        String a = "123";
        map.put(a, "abc");
        a = "123123";
        System.out.println(map.get(0));
        for (String key : map.keySet()) {
            System.out.println("key= " + key + " and value= " + map.get(key));
        }
    }

    public static String getMsg(String code, String Msg) {
        code = "1";
        Msg = "2";
        return code;
    }
}
