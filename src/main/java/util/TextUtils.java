package util;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {
    public static boolean isEmpty(CharSequence str) {
        if (str == null || str.length() == 0)
            return true;
        else
            return false;
    }

    public static <T> String join(String str1, List<T> str2) {
        List<String> strs = new ArrayList<>();
        for(T t: str2) {
            strs.add(t.toString());
        }
        return String.join(str1,strs);
    }
}
