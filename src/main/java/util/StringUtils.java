package util;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class StringUtils {

    private final static HashMap<Character, Integer> ChnMap = getChnMap();

    public static boolean startWithIgnoreCase(String src, String obj) {
        if (src == null || obj == null) return false;
        if (obj.length() > src.length()) return false;
        return src.substring(0, obj.length()).equalsIgnoreCase(obj);
    }

    private static HashMap<Character, Integer> getChnMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        String cnStr = "零一二三四五六七八九十";
        char[] c = cnStr.toCharArray();
        for (int i = 0; i <= 10; i++) {
            map.put(c[i], i);
        }
        cnStr = "〇壹贰叁肆伍陆柒捌玖拾";
        c = cnStr.toCharArray();
        for (int i = 0; i <= 10; i++) {
            map.put(c[i], i);
        }
        map.put('两', 2);
        map.put('百', 100);
        map.put('佰', 100);
        map.put('千', 1000);
        map.put('仟', 1000);
        map.put('万', 10000);
        map.put('亿', 100000000);
        return map;
    }

    public static String formatHtml(String html) {
        if (TextUtils.isEmpty(html)) return "";
        return html.replaceAll("(?i)<(br[\\s/]*|/?p[^>]*|/?div[^>]*)>", "\n")// 替换特定标签为换行符
                //.replaceAll("<(script[^>]*>)?[^>]*>|&nbsp;", "")// 删除script标签对和空格转义符
                .replaceAll("</?[a-zA-Z][^>]*>", "")// 删除标签对
                .replaceAll("\\s*\\n+\\s*", "\n　　")// 移除空行,并增加段前缩进2个汉字
                .replaceAll("^[\\n\\s]+", "　　")//移除开头空行,并增加段前缩进2个汉字
                .replaceAll("[\\n\\s]+$", "");//移除尾部空行
    }

    public static int stringToInt(String str) {
        if (str != null) {
            String num = fullToHalf(str).replaceAll("\\s", "");
            try {
                return Integer.parseInt(num);
            } catch (Exception e) {
                return chineseNumToInt(num);
            }
        }
        return -1;
    }

    //功能：字符串全角转换为半角
    public static String fullToHalf(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 12288) //全角空格
            {
                c[i] = (char) 32;
                continue;
            }

            if (c[i] > 65280 && c[i] < 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }

    public static int chineseNumToInt(String chNum) {
        int result = 0;
        int tmp = 0;
        int billion = 0;
        char[] cn = chNum.toCharArray();

        // "一零二五" 形式
        if (cn.length > 1 && chNum.matches("^[〇零一二三四五六七八九壹贰叁肆伍陆柒捌玖]$")) {
            for (int i = 0; i < cn.length; i++) {
                cn[i] = (char) (48 + ChnMap.get(cn[i]));
            }
            return Integer.parseInt(new String(cn));
        }

        // "一千零二十五", "一千二" 形式
        try {
            for (int i = 0; i < cn.length; i++) {
                int tmpNum = ChnMap.get(cn[i]);
                if (tmpNum == 100000000) {
                    result += tmp;
                    result *= tmpNum;
                    billion = billion * 100000000 + result;
                    result = 0;
                    tmp = 0;
                } else if (tmpNum == 10000) {
                    result += tmp;
                    result *= tmpNum;
                    tmp = 0;
                } else if (tmpNum >= 10) {
                    if (tmp == 0)
                        tmp = 1;
                    result += tmpNum * tmp;
                    tmp = 0;
                } else {
                    if (i >= 2 && i == cn.length - 1 && ChnMap.get(cn[i - 1]) > 10)
                        tmp = tmpNum * ChnMap.get(cn[i - 1]) / 10;
                    else
                        tmp = tmp * 10 + tmpNum;
                }
            }
            result += tmp + billion;
            return result;
        } catch (Exception e) {
            return -1;
        }
    }

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
    public static String base64Decode(String str) {
        byte[] bytes = Base64.decode(str);
        try {
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            return new String(bytes);
        }
    }

    public static String escape(String src) {
        int i;
        char j;
        StringBuilder tmp = new StringBuilder();
        tmp.ensureCapacity(src.length() * 6);
        for (i = 0; i < src.length(); i++) {
            j = src.charAt(i);
            if (Character.isDigit(j) || Character.isLowerCase(j)
                    || Character.isUpperCase(j))
                tmp.append(j);
            else if (j < 256) {
                tmp.append("%");
                if (j < 16)
                    tmp.append("0");
                tmp.append(Integer.toString(j, 16));
            } else {
                tmp.append("%u");
                tmp.append(Integer.toString(j, 16));
            }
        }
        return tmp.toString();
    }

    public static String getBaseUrl(String url) {
        if (url == null || !url.startsWith("http")) return null;
        int index = url.indexOf("/", 9);
        if (index == -1) {
            return url;
        }
        return url.substring(0, index);
    }
}
