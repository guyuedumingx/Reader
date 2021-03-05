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
    /**
     * header : {
     "User-Agent": "Mozilla/5.0 (Linux; Android 9; JKM-AL00b Build/HUAWEIJKM-AL00b; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/79.0.3945.116 Mobile Safari/537.36"

     }
     * ruleContent : {"content":"class.content@html##$##---------📖本篇完---------","imageStyle":"full","nextContentUrl":"<js>\nif(result.indexOf('JSON.parse')>-1){\nresult.match(/JSON.parse\\('([^']+)'/)[1]}\n<\/js>\n$.data_list.ml..href","replaceRegex":"##[\\w\\d=/\\+]{30,}"}
     * ruleExplore : {"bookList":"<js>\nresult.match(/JSON.parse\\('([^']+)'/)[1]\n<\/js>\n$.data_list[*].list[*]","bookUrl":"$.href","coverUrl":"$.img","kind":"$.title","name":"$.span"}
     * ruleSearch : {"author":"","bookList":"<js>\nresult.match(/JSON.parse\\('([^']+)'/)[1]\n<\/js>\n$.data_list[*]","bookUrl":"$.href","coverUrl":"$.img","intro":"","kind":"$.span","lastChapter":"","name":"$.title"}
     * ruleToc : {"chapterList":"@js:\nif(result.match(/目录/)){\nlist=result.match(/\\{\"title\":\"([^\"]+)\"[\\s\\S]+?\"href\":\"([^\"]+)\"\\}/g);\nhtml=[];\nfor(i=1;i<list.length;i++){\njson=list[i].match(/\\{\"title\":\"([^\"]+)[\\s\\S]+?\"href\":\"([^\"]+)\"\\}/);\nhtml.push({\ntitle:unescape(json[1].replace(/\\\\/g,'%')),\nhref:json[2]\n})\n}\n}else{\n\nlist=result.match(/\\{\"title\":\"([^\"]+)\".*?\"span\":\"([^\"]+)\",\"href\":\"([^\"]+)\".*?\\}/g);\nhtml=[];\nfor(i in list){\njson=list[i].match(/\\{\"title\":\"([^\"]+)\".*?\"span\":\"([^\"]+)\",\"href\":\"([^\"]+)\".*?\\}/);\nhtml.push({\ntitle:unescape(json[2].replace(/\\\\/g,'%')),\nhref:json[3],\nchapter:unescape(json[1].replace(/\\\\/g,'%'))\n})\n}\n}\nhtml","chapterName":"title","chapterUrl":"href","updateTime":"chapter"}
     */

    @SerializedName("header")
    private String header;
    @SerializedName("ruleContent")
    private RuleContentDTO ruleContentX;
    @SerializedName("ruleExplore")
    private RuleSearchDTO ruleExploreX;
    @SerializedName("ruleSearch")
    private RuleSearchDTO ruleSearchX;
    @SerializedName("ruleToc")
    private RuleTocDTO ruleTocX;

    public static BookSourceBean objectFromData(String str) {

        return new Gson().fromJson(str, BookSourceBean.class);
    }

    @NoArgsConstructor
    @Data
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


    @NoArgsConstructor
    @Data
    public static class RuleExploreDTO {
        public static RuleExploreDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleExploreDTO.class);
        }
    }


    @NoArgsConstructor
    @Data
    public static class RuleContentDTO {
        /**
         * content : class.content@html##$##---------📖本篇完---------
         * imageStyle : full
         * nextContentUrl : <js>
         if(result.indexOf('JSON.parse')>-1){
         result.match(/JSON.parse\('([^']+)'/)[1]}
         </js>
         $.data_list.ml..href
         * replaceRegex : ##[\w\d=/\+]{30,}
         */

        @SerializedName("content")
        private String content;
        @SerializedName("imageStyle")
        private String imageStyle;
        @SerializedName("nextContentUrl")
        private String nextContentUrl;
        @SerializedName("replaceRegex")
        private String replaceRegex;

        public static RuleContentDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleContentDTO.class);
        }
    }

    @NoArgsConstructor
    @Data
    public static class RuleSearchDTO {
        /**
         * author :
         * bookList : <js>
         result.match(/JSON.parse\('([^']+)'/)[1]
         </js>
         $.data_list[*]
         * bookUrl : $.href
         * coverUrl : $.img
         * intro :
         * kind : $.span
         * lastChapter :
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
         * chapterList : @js:
         if(result.match(/目录/)){
         list=result.match(/\{"title":"([^"]+)"[\s\S]+?"href":"([^"]+)"\}/g);
         html=[];
         for(i=1;i<list.length;i++){
         json=list[i].match(/\{"title":"([^"]+)[\s\S]+?"href":"([^"]+)"\}/);
         html.push({
         title:unescape(json[1].replace(/\\/g,'%')),
         href:json[2]
         })
         }
         }else{

         list=result.match(/\{"title":"([^"]+)".*?"span":"([^"]+)","href":"([^"]+)".*?\}/g);
         html=[];
         for(i in list){
         json=list[i].match(/\{"title":"([^"]+)".*?"span":"([^"]+)","href":"([^"]+)".*?\}/);
         html.push({
         title:unescape(json[2].replace(/\\/g,'%')),
         href:json[3],
         chapter:unescape(json[1].replace(/\\/g,'%'))
         })
         }
         }
         html
         * chapterName : title
         * chapterUrl : href
         * updateTime : chapter
         */

        @SerializedName("chapterList")
        private String chapterList;
        @SerializedName("chapterName")
        private String chapterName;
        @SerializedName("chapterUrl")
        private String chapterUrl;
        @SerializedName("updateTime")
        private String updateTime;

        public static RuleTocDTO objectFromData(String str) {

            return new Gson().fromJson(str, RuleTocDTO.class);
        }
    }
}
