package input_stream;

import java.util.Arrays;

/**
 * Created by vertex0008 on 29.05.2016.
 */
public class GenKey {
    public static void main(String[] args) {
        char[] pass = new char[4];
        getPass(pass, pass.length-1);

    }

    public static void getPass(char[] pass, int currentPos) {
        if (currentPos >= 0) {
            for (char i = 'a'; i <= 'd'; i++) {
                pass[currentPos] = i;
                if (currentPos == 0) {
                    System.out.println(Arrays.toString(pass));
                } else {
                    getPass(pass, currentPos - 1);
                }
            }
        }
    }

    //public static void


//    public static void callMe(int level) {
//        System.out.println("My Level is: " + level);
//        if (level > 0) {
//        callMe(level - 1);
//        }
//    }
}
