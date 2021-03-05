import bean.BookSourceBean;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class BookSourceTest {

    @Test
    public void importTest() throws FileNotFoundException {
        String path = this.getClass().getClassLoader().getResource("rules.json").getPath();
        Scanner in = new Scanner(new File(path));
        StringBuilder builder = new StringBuilder();
        while(in.hasNext()) {
            builder.append(in.next()) ;
        }
        List<BookSourceBean> bookSourceBeans = BookSourceManager.importSource(builder.toString());

    }
}
