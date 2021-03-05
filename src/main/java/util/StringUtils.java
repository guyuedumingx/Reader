package util;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class StringUtils {

    public static boolean isJsonType(String str) {
        boolean result = false;
        if (!TextUtils.isEmpty(str)) {
            str = str.trim();
            if (str.startsWith("{") && str.endsWith("}")) {
                result = true;
            } else if (str.startsWith("[") && str.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isCompressJsonType(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.replaceAll("(\\s|\n)*", "").matches("^\\{.*[^}]$")) {
                return true;
            }
        }
        return false;
    }

    public static String unCompressJson(String str) {
        if (TextUtils.isEmpty(str))
            return "";
        // 如果是未压缩的json
        if (str.replaceAll("(\\s|\n)*", "").matches("^\\{.*\\}$"))
            return str;
//        if (str.replaceAll("(\\s|\n)*","").matches("^\\{.*[^}]$"))
        String string = null;
        str = str.trim();
        try {
            if (str.charAt(0) == '{')
                string = unzipString(str.substring(1));
            else
                string = unzipString(str);
            if (string.charAt(string.length() - 1) == '}')
                return "{" + string;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static boolean isJsonObject(String text) {
        boolean result = false;
        if (!TextUtils.isEmpty(text)) {
            text = text.trim();
            if (text.startsWith("{") && text.endsWith("}")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isJsonArray(String text) {
        boolean result = false;
        if (!TextUtils.isEmpty(text)) {
            text = text.trim();
            if (text.startsWith("[") && text.endsWith("]")) {
                result = true;
            }
        }
        return result;
    }

    public static boolean isTrimEmpty(String text) {
        if (text == null) return true;
        if (text.length() == 0) return true;
        return text.trim().length() == 0;
    }
    /**
     * 解压缩
     */
    public static String unzipString(String zipString) {
        byte[] decode //= Base64.decodeBase64(zipString);
                = Base64.decode(zipString);
        //创建一个新的解压缩器  https://www.yiibai.com/javazip/javazip_inflater.html

        Inflater inflater = new Inflater();
        //设置解压缩的输入数据。
        inflater.setInput(decode);
        final byte[] bytes = new byte[512];
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(512);
        try {
            //finished() 如果已到达压缩数据流的末尾，则返回true。
            while (!inflater.finished()) {
                //将字节解压缩到指定的缓冲区中。
                int length = inflater.inflate(bytes);
                outputStream.write(bytes, 0, length);
            }
        } catch (DataFormatException e) {
            e.printStackTrace();
            return null;
        } finally {
            //关闭解压缩器并丢弃任何未处理的输入。
            inflater.end();
        }

        try {
            return outputStream.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }


}
