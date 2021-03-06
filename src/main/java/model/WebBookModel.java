package model;

import bean.BookInfoBean;
import bean.BookShelfBean;
import bean.BookSourceBean;
import content.WebBook;
import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import static constant.AppConstant.TIME_OUT;

public class WebBookModel {

    public static WebBookModel getInstance() {
        return new WebBookModel();
    }

    /**
     * 网络请求并解析书籍信息
     * return BookShelfBean
     */
    public BookShelfBean getBookInfo(BookShelfBean bookShelfBean, BookSourceBean bookSourceBean ) {
        WebBook.getInstance(bookShelfBean.getTag(),bookSourceBean).getBookInfo(bookShelfBean);
        return null;
    }
}

