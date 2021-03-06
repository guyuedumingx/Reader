package content;

import analyzeRule.AnalyzeByRegex;
import analyzeRule.AnalyzeHeaders;
import analyzeRule.AnalyzeRule;
import analyzeRule.AnalyzeUrl;
import base.BaseModelImpl;
import bean.BookInfoBean;
import bean.BookShelfBean;
import bean.BookSourceBean;
import bean.SearchBookBean;
import retrofit2.Response;
import util.StringUtils;
import util.TextUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import io.reactivex.Observable;
import java.util.Map;

import static util.TextUtils.isEmpty;

public class WebBook {

    private String tag;
    private String name;
    private BookSourceBean bookSourceBean;
    private Map<String, String> headerMap;

    private BaseModelImpl baseModel = new BaseModelImpl();

    public static WebBook getInstance(String tag, BookSourceBean bookSourceBean) {
        return new WebBook(tag, bookSourceBean);
    }

    public WebBook(String tag, BookSourceBean bookSourceBean) {
        this.tag = tag;
        try {
            URL url = new URL(tag);
            name = url.getHost();
        } catch (MalformedURLException e) {
            name = tag;
        }
        //
        this.bookSourceBean = bookSourceBean;
        if (bookSourceBean != null) {
            name = bookSourceBean.getBookSourceName();
            headerMap = AnalyzeHeaders.getMap(bookSourceBean);
        }
    }

    public BookShelfBean getBookInfo(final BookShelfBean bookShelfBean) {
        if (bookSourceBean == null) {
            return null;
        }
        BookInfo bookInfo = new BookInfo(tag, name, bookSourceBean);
        if (!TextUtils.isEmpty(bookShelfBean.getBookInfoBean().getBookInfoHtml())) {
            return bookInfo.analyzeBookInfo(bookShelfBean.getBookInfoBean().getBookInfoHtml(), bookShelfBean);
        }
        try {
            AnalyzeUrl analyzeUrl = new AnalyzeUrl(bookShelfBean.getNoteUrl(), headerMap, tag);
            Response<String> responseO = baseModel.getResponseO(analyzeUrl);
            new BookList(tag,bookSourceBean.getBookSourceName(),bookSourceBean,responseO.isSuccessful()).analyzeSearchBook(responseO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 搜索
     */
    public List<SearchBookBean> searchBook(String content, int page) {
        if (bookSourceBean == null || isEmpty(bookSourceBean.getRuleSearchUrl())) {
        }
        BookList bookList = new BookList(tag, name, bookSourceBean, false);
        try {
            AnalyzeUrl analyzeUrl = new AnalyzeUrl(bookSourceBean.getRuleSearchUrl(), content, page, headerMap, tag);
            Response<String> responseO = baseModel.getResponseO(analyzeUrl);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
