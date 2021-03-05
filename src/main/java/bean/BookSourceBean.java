package bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by GKF on 2017/12/14.
 * 书源信息
 */
@NoArgsConstructor
@Data
public class BookSourceBean implements Cloneable {


    /**
     * bookSourceComment :
     * bookSourceGroup : JSon; 正则
     * bookSourceName : 猎鹰小说网
     * bookSourceType : 0
     * bookSourceUrl : http://api.book.lieying.cn
     * bookUrlPattern :
     * customOrder : 0
     * enabled : true
     * enabledExplore : false
     * exploreUrl :
     * header : {
     "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36"
     }
     * lastUpdateTime : 0
     * loginUrl :
     * ruleBookInfo : {"author":"##:author\"[^\"]+\"([^\"]*)##$1###","coverUrl":"##og:image\"[^\"]+\"([^\"]*)##$1###","intro":"##:description\"[^\"]+\"([\\w\\W]*?)\"/##$1###","kind":"##:category\"[^\"]+\"([^\"]*)##$1###","lastChapter":"##_chapter_name\"[^\"]+\"([^\"]*)##$1###","name":"##:book_name\"[^\"]+\"([^\"]*)##$1###","tocUrl":""}
     * ruleContent : {"content":"$.chapter.body","nextContentUrl":""}
     * ruleExplore : {}
     * ruleSearch : {"author":"$.author","bookList":"$..books[*]","bookUrl":"/Book/getChapterListByBookId?bookId={$._id}","coverUrl":"$.cover","intro":"$.shortIntro","kind":"$.minorCate","lastChapter":"$.lastChapter","name":"$.title"}
     * ruleToc : {"chapterList":"$.chapterInfo.chapters.[*]","chapterName":"$.title","chapterUrl":"$.link","nextTocUrl":""}
     * searchUrl : /Book/search?query={{key}}&start={{(page-1)*20}}&limit=40&device_type=android&app_version=165
     * weight : 0
     */

    @SerializedName("bookSourceComment")
    private String bookSourceComment;
    @SerializedName("bookSourceGroup")
    private String bookSourceGroup;
    @SerializedName("bookSourceName")
    private String bookSourceName;
    @SerializedName("bookSourceType")
    private Integer bookSourceType;
    @SerializedName("bookSourceUrl")
    private String bookSourceUrl;
    @SerializedName("bookUrlPattern")
    private String bookUrlPattern;
    @SerializedName("customOrder")
    private Integer customOrder;
    @SerializedName("enabled")
    private Boolean enabled;
    @SerializedName("enabledExplore")
    private Boolean enabledExplore;
    @SerializedName("exploreUrl")
    private String exploreUrl;
    @SerializedName("header")
    private String header;
    @SerializedName("lastUpdateTime")
    private Integer lastUpdateTime;
    @SerializedName("loginUrl")
    private String loginUrl;
    @SerializedName("ruleBookInfo")
    private RuleBookInfoDTO ruleBookInfo;
    @SerializedName("ruleContent")
    private RuleContentDTO ruleContent;
    @SerializedName("ruleExplore")
    private RuleExploreDTO ruleExplore;
    @SerializedName("ruleSearch")
    private RuleSearchDTO ruleSearch;
    @SerializedName("ruleToc")
    private RuleTocDTO ruleToc;
    @SerializedName("searchUrl")
    private String searchUrl;
    @SerializedName("weight")
    private Integer weight;

    public static BookSourceBean objectFromData(String str) {

        return new Gson().fromJson(str, BookSourceBean.class);
    }

    @NoArgsConstructor
    @Data
    public static class RuleBookInfoDTO {
        /**
         * author : ##:author"[^"]+"([^"]*)##$1###
         * coverUrl : ##og:image"[^"]+"([^"]*)##$1###
         * intro : ##:description"[^"]+"([\w\W]*?)"/##$1###
         * kind : ##:category"[^"]+"([^"]*)##$1###
         * lastChapter : ##_chapter_name"[^"]+"([^"]*)##$1###
         * name : ##:book_name"[^"]+"([^"]*)##$1###
         * tocUrl :
         */

        @SerializedName("author")
        private String author;
        @SerializedName("coverUrl")
        private String coverUrl;
        @SerializedName("intro")
        private String intro;
        @SerializedName("kind")
        private String kind;
        @SerializedName("lastChapter")
        private String lastChapter;
        @SerializedName("name")
        private String name;
        @SerializedName("tocUrl")
        private String tocUrl;

        public static RuleBookInfoDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleBookInfoDTO.class);
        }
    }

    @NoArgsConstructor
    @Data
    public static class RuleContentDTO {
        public static RuleContentDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleContentDTO.class);
        }
    }

    @NoArgsConstructor
    @Data
    public static class RuleExploreDTO {
        public static RuleExploreDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleExploreDTO.class);
        }
    }

    @NoArgsConstructor
    @Data
    public static class RuleSearchDTO {
        /**
         * author : $.author
         * bookList : $..books[*]
         * bookUrl : /Book/getChapterListByBookId?bookId={$._id}
         * coverUrl : $.cover
         * intro : $.shortIntro
         * kind : $.minorCate
         * lastChapter : $.lastChapter
         * name : $.title
         */

        @SerializedName("author")
        private String author;
        @SerializedName("bookList")
        private String bookList;
        @SerializedName("bookUrl")
        private String bookUrl;
        @SerializedName("coverUrl")
        private String coverUrl;
        @SerializedName("intro")
        private String intro;
        @SerializedName("kind")
        private String kind;
        @SerializedName("lastChapter")
        private String lastChapter;
        @SerializedName("name")
        private String name;

        public static RuleSearchDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleSearchDTO.class);
        }
    }

    @NoArgsConstructor
    @Data
    public static class RuleTocDTO {
        /**
         * chapterList : $.chapterInfo.chapters.[*]
         * chapterName : $.title
         * chapterUrl : $.link
         * nextTocUrl :
         */

        @SerializedName("chapterList")
        private String chapterList;
        @SerializedName("chapterName")
        private String chapterName;
        @SerializedName("chapterUrl")
        private String chapterUrl;
        @SerializedName("nextTocUrl")
        private String nextTocUrl;

        public static RuleTocDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleTocDTO.class);
        }
    }
}
