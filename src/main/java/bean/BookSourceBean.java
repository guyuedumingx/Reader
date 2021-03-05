package bean;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

/**
 * Created by GKF on 2017/12/14.
 * 书源信息
 */
@lombok.NoArgsConstructor
@lombok.Data
public class BookSourceBean implements Cloneable {

    /**
     * bookSourceComment :
     * bookSourceGroup : Haxc.
     * bookSourceName : 九七阅读网
     * bookSourceType : 0
     * bookSourceUrl : http://m.bokcms.com
     * customOrder : -3596
     * enabled : true
     * enabledExplore : true
     * exploreUrl :
     * lastUpdateTime : 1602219578340
     * ruleBookInfo : {"author":"[property=\"og:novel:author\"]@content","coverUrl":"[property=\"og:image\"]@content","intro":"[property=\"og:description\"]@content","kind":"[property=\"og:novel:category\"]@content","lastChapter":"[property=\"og:novel:latest_chapter_name\"]@content","name":"[property=\"og:novel:book_name\"]@content","tocUrl":"class.ksaa_btn@href","wordCount":"class.xq_bookne@tag.div.-2@text##字数："}
     * ruleContent : {"content":"id.content@html","nextContentUrl":"text.下一页@href"}
     * ruleExplore : {}
     * ruleSearch : {"author":"class.book_other@ownText","bookList":"id.sitebox@dl","bookUrl":"tag.a@href","coverUrl":"tag.img@src","intro":"class.book_des@text","kind":"class.uptime@text","name":"tag.h3@a@text"}
     * ruleToc : {"chapterList":"class.readlist@tag.li","chapterName":"tag.a@text","chapterUrl":"tag.a@href","nextTocUrl":"class.pg-next@href"}
     * searchUrl : http://m.bokcms.com/search/,{
     "charset": "",
     "method": "POST",
     "body": "submit=搜索&searchkey={{key}}"
     }
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
    @SerializedName("customOrder")
    private Integer customOrder;
    @SerializedName("enabled")
    private Boolean enabled;
    @SerializedName("enabledExplore")
    private Boolean enabledExplore;
    @SerializedName("exploreUrl")
    private String exploreUrl;
    @SerializedName("lastUpdateTime")
    private Long lastUpdateTime;
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

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class RuleBookInfoDTO {
        /**
         * author : [property="og:novel:author"]@content
         * coverUrl : [property="og:image"]@content
         * intro : [property="og:description"]@content
         * kind : [property="og:novel:category"]@content
         * lastChapter : [property="og:novel:latest_chapter_name"]@content
         * name : [property="og:novel:book_name"]@content
         * tocUrl : class.ksaa_btn@href
         * wordCount : class.xq_bookne@tag.div.-2@text##字数：
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
        @SerializedName("wordCount")
        private String wordCount;

        public static RuleBookInfoDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleBookInfoDTO.class);
        }
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class RuleContentDTO {
        public static RuleContentDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleContentDTO.class);
        }
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class RuleExploreDTO {
        public static RuleExploreDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleExploreDTO.class);
        }
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class RuleSearchDTO {
        /**
         * author : class.book_other@ownText
         * bookList : id.sitebox@dl
         * bookUrl : tag.a@href
         * coverUrl : tag.img@src
         * intro : class.book_des@text
         * kind : class.uptime@text
         * name : tag.h3@a@text
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
        @SerializedName("name")
        private String name;

        public static RuleSearchDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleSearchDTO.class);
        }
    }

    @lombok.NoArgsConstructor
    @lombok.Data
    public static class RuleTocDTO {
        /**
         * chapterList : class.readlist@tag.li
         * chapterName : tag.a@text
         * chapterUrl : tag.a@href
         * nextTocUrl : class.pg-next@href
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
