import bean.BookSourceBean;
import util.GsonUtils;
import util.StringUtils;
import util.TextUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BookSourceManager {
    /**
     * 添加书源
     * @param string
     * @return
     */
    public static List<BookSourceBean> importSource(String string) {
        if (StringUtils.isTrimEmpty(string)) return null;
        string = string.trim();
//        if (NetworkUtils.isIPv4Address(string)) {
//            string = String.format("http://%s:65501", string);
//        }
        if (StringUtils.isJsonType(string)) {
            return importBookSourceFromJson(string.trim());
        }else if(StringUtils.isCompressJsonType(string)){
            return importBookSourceFromJson(StringUtils.unCompressJson(string));
        }
        //TODO NEtwork BookSource
//        if (NetworkUtils.isUrl(string)) {
//            return BaseModelImpl.getInstance().getRetrofitString(StringUtils.getBaseUrl(string), "utf-8")
//                    .create(IHttpGetApi.class)
//                    .get(string, AnalyzeHeaders.getMap(null))
//                    .flatMap(rsp -> importBookSourceFromJson(rsp.body()))
//                    .compose(RxUtils::toSimpleSingle);
//        }
        return new ArrayList<>();
    }

    private static List<BookSourceBean> importBookSourceFromJson(String json) {
        List<BookSourceBean> bookSourceBeans = new ArrayList<>();
        if (StringUtils.isJsonArray(json)) {
            try {
                bookSourceBeans = GsonUtils.parseJArray(json, BookSourceBean.class);
                for (BookSourceBean bookSourceBean : bookSourceBeans) {
                    try {
                        new URL(bookSourceBean.getBookSourceUrl());
                    } catch (Exception exception) {
                        //删除书源
                    }
                }
            } catch (Exception ignored) {
            }
        }
        if (StringUtils.isJsonObject(json)) {
            try {
                BookSourceBean bookSourceBean = GsonUtils.parseJObject(json, BookSourceBean.class);
                addBookSource(bookSourceBean);
                bookSourceBeans.add(bookSourceBean);
            } catch (Exception ignored) {
            }
        }
        return bookSourceBeans;
    }

    // TODO add BookSource to db
    public static void addBookSource(BookSourceBean bookSourceBean) {
        if (TextUtils.isEmpty(bookSourceBean.getBookSourceName()) || TextUtils.isEmpty(bookSourceBean.getBookSourceUrl()))
            return;
        if (bookSourceBean.getBookSourceUrl().endsWith("/")) {
            bookSourceBean.setBookSourceUrl(bookSourceBean.getBookSourceUrl().replaceAll("/+$", ""));
        }
//        BookSourceBean temp = DbHelper.getDaoSession().getBookSourceBeanDao().queryBuilder()
//                .where(BookSourceBeanDao.Properties.BookSourceUrl.eq(bookSourceBean.getBookSourceUrl())).unique();
//        if (temp != null) {
//            bookSourceBean.setSerialNumber(temp.getSerialNumber());
//        }
//        if (bookSourceBean.getSerialNumber() < 0) {
//            bookSourceBean.setSerialNumber((int) (DbHelper.getDaoSession().getBookSourceBeanDao().queryBuilder().count() + 1));
//        }
//        DbHelper.getDaoSession().getBookSourceBeanDao().insertOrReplace(bookSourceBean);
    }

}
