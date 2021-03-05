
package analyzeRule;

import bean.BookSourceBean;
import com.google.gson.Gson;
import util.StringUtils;
import java.util.HashMap;
import java.util.Map;
import static constant.AppConstant.MAP_STRING;
import static util.TextUtils.isEmpty;
/**
 * Created by GKF on 2018/3/2.
 * 解析Headers
 */

public class AnalyzeHeaders {

    public static Map<String, String> getMap(BookSourceBean bookSourceBean) {
        Map<String, String> headerMap = new HashMap<>();
        if (bookSourceBean != null) {
            String headers = bookSourceBean.getSearchUrl();
            if (!isEmpty(headers)) {
                if (StringUtils.isJsonObject(headers)) {
                    Map<String, String> map = new Gson().fromJson(headers, MAP_STRING);
                    headerMap.putAll(map);
                } else {
                    headerMap.put("User-Agent", headers);
                }
            } else {
                headerMap.put("User-Agent", getDefaultUserAgent());
            }
//            CookieBean cookie = DbHelper.getDaoSession().getCookieBeanDao().load(bookSourceBean.getBookSourceUrl());
//            if (cookie != null) {
//                headerMap.put("Cookie", cookie.getCookie());
//            }
        } else {
            headerMap.put("User-Agent", getDefaultUserAgent());
        }
        return headerMap;
    }

    private static String getDefaultUserAgent() {
        return "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.182 Safari/537.36 Edg/88.0.705.81";
    }
}
