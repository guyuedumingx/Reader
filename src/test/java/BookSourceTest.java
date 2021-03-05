import analyzeRule.AnalyzeHeaders;
import analyzeRule.AnalyzeUrl;
import bean.BookSourceBean;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
        List<BookSourceBean> bookSourceBeans = BookSourceManager.importSource(builder.toString());
        headerMap = AnalyzeHeaders.getMap(bookSourceBeans.get(0));
        tag = bookSourceBeans.get(0).getSearchUrl();
        AnalyzeUrl analyzeUrl = new AnalyzeUrl(tag, content, page, headerMap,bookSourceBeans.get(0).getBookSourceUrl());
    }
}
