import analyzeRule.AnalyzeHeaders;
import analyzeRule.AnalyzeRule;
import analyzeRule.AnalyzeUrl;
import bean.BookShelfBean;
import bean.BookSource3Bean;
import bean.BookSourceBean;
import com.google.gson.Gson;
import content.BookList;
import content.WebBook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static constant.AppConstant.TIME_OUT;

public class BookSourceTest {
    private Map<String, String> headerMap;
    private String content="圣墟";
    private String tag;
    private int page = 1;

    @Test
    public void importTest() throws Exception {
        String path = this.getClass().getClassLoader().getResource("1.json").getPath();
        Scanner in = new Scanner(new File(path));
        StringBuilder builder = new StringBuilder();
        while(in.hasNext()) {
            builder.append(in.next()) ;
        }
        List<BookSource3Bean> bookSource3Beans = BookSourceManager.importSource3(builder.toString());
        List<BookSourceBean> bookSourceBeans = new ArrayList<>();
        for(BookSource3Bean bean : bookSource3Beans) {
            bookSourceBeans.add(bean.toBookSourceBean());
        }
        headerMap = AnalyzeHeaders.getMap(bookSourceBeans.get(0));
        tag = bookSourceBeans.get(0).getBookSourceUrl();
        AnalyzeUrl analyzeUrl = new AnalyzeUrl(tag, content, page, headerMap,bookSourceBeans.get(0).getBookSourceUrl());
    }

    @Test
    public void importSource2Test() throws Exception {
        String path = this.getClass().getClassLoader().getResource("2.json").getPath();
        Scanner in = new Scanner(new File(path));
        StringBuilder builder = new StringBuilder();
        while(in.hasNext()) {
            builder.append(in.next()) ;
        }
        List<BookSourceBean> bookSourceBeans = BookSourceManager.importSource(builder.toString());
        headerMap = AnalyzeHeaders.getMap(bookSourceBeans.get(0));
        tag = bookSourceBeans.get(0).getBookSourceUrl();
        AnalyzeUrl analyzeUrl = new AnalyzeUrl(bookSourceBeans.get(0).getRuleSearchUrl(), content, page, headerMap,tag);
        BookList bookList = new BookList(tag, bookSourceBeans.get(0).getBookSourceName(),bookSourceBeans.get(0),true);
        bookList.getItemInList(new AnalyzeRule(null),tag,true);
        Gson gson = new Gson();
        BookShelfBean bookShelfBean = gson.fromJson(analyzeUrl.getPostData(),BookShelfBean.class);
        WebBook webBook = new WebBook(bookShelfBean.getTag(),bookSourceBeans.get(0));
    }
}
