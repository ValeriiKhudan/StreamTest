package input_stream;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GenKey {
    public static void main(String[] args) {
        final ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        long ts = System.currentTimeMillis();
        char[] pass = new char[4];
        getPass(pass, pass.length - 1, (char[] t) -> {
            executors.submit(()->{
                int len = t.length;
            });
        });
        System.out.println(System.currentTimeMillis() - ts);
        executors.shutdown();
        System.out.println(System.currentTimeMillis() - ts);
    }

    public static void getPass(char[] cK, int currentPos, Callback<char[]> callback) {
        if (currentPos >= 0) {
            for (char i = 'a'; i <= 'd'; i++) {
                cK[currentPos] = i;
                if (currentPos == 0) {
                    //System.out.println(Arrays.toString(cK));
                    char[] passBuf = new char[cK.length];
                    System.arraycopy(cK,0,passBuf,0,cK.length);
                    callback.call(passBuf);
                } else {
                    getPass(cK, currentPos - 1, callback);
                }
            }
        }
    }

    public interface Callback<T> {
        void call(T param);
    }
}
    //public static void


//    public static void callMe(int level) {
//        System.out.println("My Level is: " + level);
//        if (level > 0) {
//        callMe(level - 1);
//        }
//    }

