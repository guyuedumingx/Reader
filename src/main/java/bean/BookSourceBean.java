package bean;

import java.util.ArrayList;

/**
 * Created by GKF on 2017/12/14.
 * 书源信息
 */
public class BookSourceBean implements Cloneable {
    private String bookSourceUrl;
    private String bookSourceName;
    private String bookSourceGroup;
    private String bookSourceType;
    private String loginUrl;
    private Long lastUpdateTime;

    private int serialNumber;

    private int weight = 0;
    private boolean enable;
    //发现规则
    private String ruleFindUrl;
    private String ruleFindList;
    private String ruleFindName;
    private String ruleFindAuthor;
    private String ruleFindKind;
    private String ruleFindIntroduce;
    private String ruleFindLastChapter;
    private String ruleFindCoverUrl;
    private String ruleFindNoteUrl;
    //搜索规则
    private String ruleSearchUrl;
    private String ruleSearchList;
    private String ruleSearchName;
    private String ruleSearchAuthor;
    private String ruleSearchKind;
    private String ruleSearchIntroduce;
    private String ruleSearchLastChapter;
    private String ruleSearchCoverUrl;
    private String ruleSearchNoteUrl;
    //详情页规则
    private String ruleBookUrlPattern;
    private String ruleBookInfoInit;
    private String ruleBookName;
    private String ruleBookAuthor;
    private String ruleCoverUrl;
    private String ruleIntroduce;
    private String ruleBookKind;
    private String ruleBookLastChapter;
    private String ruleChapterUrl;
    //目录页规则
    private String ruleChapterUrlNext;
    private String ruleChapterList;
    private String ruleChapterName;
    private String ruleContentUrl;
    //正文页规则
    private String ruleContentUrlNext;
    private String ruleBookContent;
    private String ruleBookContentReplace;
    private String httpUserAgent;

    private transient ArrayList<String> groupList;

    public BookSourceBean(String bookSourceUrl, String bookSourceName, String bookSourceGroup, String bookSourceType, String loginUrl, Long lastUpdateTime, int serialNumber, int weight, boolean enable, String ruleFindUrl, String ruleFindList,
                          String ruleFindName, String ruleFindAuthor, String ruleFindKind, String ruleFindIntroduce, String ruleFindLastChapter, String ruleFindCoverUrl, String ruleFindNoteUrl, String ruleSearchUrl, String ruleSearchList,
                          String ruleSearchName, String ruleSearchAuthor, String ruleSearchKind, String ruleSearchIntroduce, String ruleSearchLastChapter, String ruleSearchCoverUrl, String ruleSearchNoteUrl, String ruleBookUrlPattern,
                          String ruleBookInfoInit, String ruleBookName, String ruleBookAuthor, String ruleCoverUrl, String ruleIntroduce, String ruleBookKind, String ruleBookLastChapter, String ruleChapterUrl, String ruleChapterUrlNext,
                          String ruleChapterList, String ruleChapterName, String ruleContentUrl, String ruleContentUrlNext, String ruleBookContent, String ruleBookContentReplace, String httpUserAgent) {
        this.bookSourceUrl = bookSourceUrl;
        this.bookSourceName = bookSourceName;
        this.bookSourceGroup = bookSourceGroup;
        this.bookSourceType = bookSourceType;
        this.loginUrl = loginUrl;
        this.lastUpdateTime = lastUpdateTime;
        this.serialNumber = serialNumber;
        this.weight = weight;
        this.enable = enable;
        this.ruleFindUrl = ruleFindUrl;
        this.ruleFindList = ruleFindList;
        this.ruleFindName = ruleFindName;
        this.ruleFindAuthor = ruleFindAuthor;
        this.ruleFindKind = ruleFindKind;
        this.ruleFindIntroduce = ruleFindIntroduce;
        this.ruleFindLastChapter = ruleFindLastChapter;
        this.ruleFindCoverUrl = ruleFindCoverUrl;
        this.ruleFindNoteUrl = ruleFindNoteUrl;
        this.ruleSearchUrl = ruleSearchUrl;
        this.ruleSearchList = ruleSearchList;
        this.ruleSearchName = ruleSearchName;
        this.ruleSearchAuthor = ruleSearchAuthor;
        this.ruleSearchKind = ruleSearchKind;
        this.ruleSearchIntroduce = ruleSearchIntroduce;
        this.ruleSearchLastChapter = ruleSearchLastChapter;
        this.ruleSearchCoverUrl = ruleSearchCoverUrl;
        this.ruleSearchNoteUrl = ruleSearchNoteUrl;
        this.ruleBookUrlPattern = ruleBookUrlPattern;
        this.ruleBookInfoInit = ruleBookInfoInit;
        this.ruleBookName = ruleBookName;
        this.ruleBookAuthor = ruleBookAuthor;
        this.ruleCoverUrl = ruleCoverUrl;
        this.ruleIntroduce = ruleIntroduce;
        this.ruleBookKind = ruleBookKind;
        this.ruleBookLastChapter = ruleBookLastChapter;
        this.ruleChapterUrl = ruleChapterUrl;
        this.ruleChapterUrlNext = ruleChapterUrlNext;
        this.ruleChapterList = ruleChapterList;
        this.ruleChapterName = ruleChapterName;
        this.ruleContentUrl = ruleContentUrl;
        this.ruleContentUrlNext = ruleContentUrlNext;
        this.ruleBookContent = ruleBookContent;
        this.ruleBookContentReplace = ruleBookContentReplace;
        this.httpUserAgent = httpUserAgent;
    }

    public BookSourceBean(BookSourceBean sourceBean) {
        this.bookSourceUrl = sourceBean.bookSourceUrl;
        this.bookSourceName = sourceBean.bookSourceName;
        this.bookSourceGroup = sourceBean.bookSourceGroup;
        this.bookSourceType = sourceBean.bookSourceType;
        this.loginUrl = sourceBean.loginUrl;
        this.lastUpdateTime = sourceBean.lastUpdateTime;
        this.serialNumber = sourceBean.serialNumber;
        this.weight = sourceBean.weight;
        this.enable = sourceBean.enable;
        this.ruleFindUrl = sourceBean.ruleFindUrl;
        this.ruleFindList = sourceBean.ruleFindList;
        this.ruleFindName = sourceBean.ruleFindName;
        this.ruleFindAuthor = sourceBean.ruleFindAuthor;
        this.ruleFindKind = sourceBean.ruleFindKind;
        this.ruleFindIntroduce = sourceBean.ruleFindIntroduce;
        this.ruleFindLastChapter = sourceBean.ruleFindLastChapter;
        this.ruleFindCoverUrl = sourceBean.ruleFindCoverUrl;
        this.ruleFindNoteUrl = sourceBean.ruleFindNoteUrl;
        this.ruleSearchUrl = sourceBean.ruleSearchUrl;
        this.ruleSearchList = sourceBean.ruleSearchList;
        this.ruleSearchName = sourceBean.ruleSearchName;
        this.ruleSearchAuthor = sourceBean.ruleSearchAuthor;
        this.ruleSearchKind = sourceBean.ruleSearchKind;
        this.ruleSearchIntroduce = sourceBean.ruleSearchIntroduce;
        this.ruleSearchLastChapter = sourceBean.ruleSearchLastChapter;
        this.ruleSearchCoverUrl = sourceBean.ruleSearchCoverUrl;
        this.ruleSearchNoteUrl = sourceBean.ruleSearchNoteUrl;
        this.ruleBookUrlPattern = sourceBean.ruleBookUrlPattern;
        this.ruleBookInfoInit = sourceBean.ruleBookInfoInit;
        this.ruleBookName = sourceBean.ruleBookName;
        this.ruleBookAuthor = sourceBean.ruleBookAuthor;
        this.ruleCoverUrl = sourceBean.ruleCoverUrl;
        this.ruleIntroduce = sourceBean.ruleIntroduce;
        this.ruleBookKind = sourceBean.ruleBookKind;
        this.ruleBookLastChapter = sourceBean.ruleBookLastChapter;
        this.ruleChapterUrl = sourceBean.ruleChapterUrl;
        this.ruleChapterUrlNext = sourceBean.ruleChapterUrlNext;
        this.ruleChapterList = sourceBean.ruleChapterList;
        this.ruleChapterName = sourceBean.ruleChapterName;
        this.ruleContentUrl = sourceBean.ruleContentUrl;
        this.ruleContentUrlNext = sourceBean.ruleContentUrlNext;
        this.ruleBookContent = sourceBean.ruleBookContent;
        this.ruleBookContentReplace = sourceBean.ruleBookContentReplace;
        this.httpUserAgent = sourceBean.httpUserAgent;
    }

    public BookSourceBean() {
    }

    public String getBookSourceUrl() {
        return bookSourceUrl;
    }

    public void setBookSourceUrl(String bookSourceUrl) {
        this.bookSourceUrl = bookSourceUrl;
    }

    public String getBookSourceName() {
        return bookSourceName;
    }

    public void setBookSourceName(String bookSourceName) {
        this.bookSourceName = bookSourceName;
    }

    public String getBookSourceGroup() {
        return bookSourceGroup;
    }

    public void setBookSourceGroup(String bookSourceGroup) {
        this.bookSourceGroup = bookSourceGroup;
    }

    public String getBookSourceType() {
        return bookSourceType;
    }

    public void setBookSourceType(String bookSourceType) {
        this.bookSourceType = bookSourceType;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getRuleFindUrl() {
        return ruleFindUrl;
    }

    public void setRuleFindUrl(String ruleFindUrl) {
        this.ruleFindUrl = ruleFindUrl;
    }

    public String getRuleFindList() {
        return ruleFindList;
    }

    public void setRuleFindList(String ruleFindList) {
        this.ruleFindList = ruleFindList;
    }

    public String getRuleFindName() {
        return ruleFindName;
    }

    public void setRuleFindName(String ruleFindName) {
        this.ruleFindName = ruleFindName;
    }

    public String getRuleFindAuthor() {
        return ruleFindAuthor;
    }

    public void setRuleFindAuthor(String ruleFindAuthor) {
        this.ruleFindAuthor = ruleFindAuthor;
    }

    public String getRuleFindKind() {
        return ruleFindKind;
    }

    public void setRuleFindKind(String ruleFindKind) {
        this.ruleFindKind = ruleFindKind;
    }

    public String getRuleFindIntroduce() {
        return ruleFindIntroduce;
    }

    public void setRuleFindIntroduce(String ruleFindIntroduce) {
        this.ruleFindIntroduce = ruleFindIntroduce;
    }

    public String getRuleFindLastChapter() {
        return ruleFindLastChapter;
    }

    public void setRuleFindLastChapter(String ruleFindLastChapter) {
        this.ruleFindLastChapter = ruleFindLastChapter;
    }

    public String getRuleFindCoverUrl() {
        return ruleFindCoverUrl;
    }

    public void setRuleFindCoverUrl(String ruleFindCoverUrl) {
        this.ruleFindCoverUrl = ruleFindCoverUrl;
    }

    public String getRuleFindNoteUrl() {
        return ruleFindNoteUrl;
    }

    public void setRuleFindNoteUrl(String ruleFindNoteUrl) {
        this.ruleFindNoteUrl = ruleFindNoteUrl;
    }

    public String getRuleSearchUrl() {
        return ruleSearchUrl;
    }

    public void setRuleSearchUrl(String ruleSearchUrl) {
        this.ruleSearchUrl = ruleSearchUrl;
    }

    public String getRuleSearchList() {
        return ruleSearchList;
    }

    public void setRuleSearchList(String ruleSearchList) {
        this.ruleSearchList = ruleSearchList;
    }

    public String getRuleSearchName() {
        return ruleSearchName;
    }

    public void setRuleSearchName(String ruleSearchName) {
        this.ruleSearchName = ruleSearchName;
    }

    public String getRuleSearchAuthor() {
        return ruleSearchAuthor;
    }

    public void setRuleSearchAuthor(String ruleSearchAuthor) {
        this.ruleSearchAuthor = ruleSearchAuthor;
    }

    public String getRuleSearchKind() {
        return ruleSearchKind;
    }

    public void setRuleSearchKind(String ruleSearchKind) {
        this.ruleSearchKind = ruleSearchKind;
    }

    public String getRuleSearchIntroduce() {
        return ruleSearchIntroduce;
    }

    public void setRuleSearchIntroduce(String ruleSearchIntroduce) {
        this.ruleSearchIntroduce = ruleSearchIntroduce;
    }

    public String getRuleSearchLastChapter() {
        return ruleSearchLastChapter;
    }

    public void setRuleSearchLastChapter(String ruleSearchLastChapter) {
        this.ruleSearchLastChapter = ruleSearchLastChapter;
    }

    public String getRuleSearchCoverUrl() {
        return ruleSearchCoverUrl;
    }

    public void setRuleSearchCoverUrl(String ruleSearchCoverUrl) {
        this.ruleSearchCoverUrl = ruleSearchCoverUrl;
    }

    public String getRuleSearchNoteUrl() {
        return ruleSearchNoteUrl;
    }

    public void setRuleSearchNoteUrl(String ruleSearchNoteUrl) {
        this.ruleSearchNoteUrl = ruleSearchNoteUrl;
    }

    public String getRuleBookUrlPattern() {
        return ruleBookUrlPattern;
    }

    public void setRuleBookUrlPattern(String ruleBookUrlPattern) {
        this.ruleBookUrlPattern = ruleBookUrlPattern;
    }

    public String getRuleBookInfoInit() {
        return ruleBookInfoInit;
    }

    public void setRuleBookInfoInit(String ruleBookInfoInit) {
        this.ruleBookInfoInit = ruleBookInfoInit;
    }

    public String getRuleBookName() {
        return ruleBookName;
    }

    public void setRuleBookName(String ruleBookName) {
        this.ruleBookName = ruleBookName;
    }

    public String getRuleBookAuthor() {
        return ruleBookAuthor;
    }

    public void setRuleBookAuthor(String ruleBookAuthor) {
        this.ruleBookAuthor = ruleBookAuthor;
    }

    public String getRuleCoverUrl() {
        return ruleCoverUrl;
    }

    public void setRuleCoverUrl(String ruleCoverUrl) {
        this.ruleCoverUrl = ruleCoverUrl;
    }

    public String getRuleIntroduce() {
        return ruleIntroduce;
    }

    public void setRuleIntroduce(String ruleIntroduce) {
        this.ruleIntroduce = ruleIntroduce;
    }

    public String getRuleBookKind() {
        return ruleBookKind;
    }

    public void setRuleBookKind(String ruleBookKind) {
        this.ruleBookKind = ruleBookKind;
    }

    public String getRuleBookLastChapter() {
        return ruleBookLastChapter;
    }

    public void setRuleBookLastChapter(String ruleBookLastChapter) {
        this.ruleBookLastChapter = ruleBookLastChapter;
    }

    public String getRuleChapterUrl() {
        return ruleChapterUrl;
    }

    public void setRuleChapterUrl(String ruleChapterUrl) {
        this.ruleChapterUrl = ruleChapterUrl;
    }

    public String getRuleChapterUrlNext() {
        return ruleChapterUrlNext;
    }

    public void setRuleChapterUrlNext(String ruleChapterUrlNext) {
        this.ruleChapterUrlNext = ruleChapterUrlNext;
    }

    public String getRuleChapterList() {
        return ruleChapterList;
    }

    public void setRuleChapterList(String ruleChapterList) {
        this.ruleChapterList = ruleChapterList;
    }

    public String getRuleChapterName() {
        return ruleChapterName;
    }

    public void setRuleChapterName(String ruleChapterName) {
        this.ruleChapterName = ruleChapterName;
    }

    public String getRuleContentUrl() {
        return ruleContentUrl;
    }

    public void setRuleContentUrl(String ruleContentUrl) {
        this.ruleContentUrl = ruleContentUrl;
    }

    public String getRuleContentUrlNext() {
        return ruleContentUrlNext;
    }

    public void setRuleContentUrlNext(String ruleContentUrlNext) {
        this.ruleContentUrlNext = ruleContentUrlNext;
    }

    public String getRuleBookContent() {
        return ruleBookContent;
    }

    public void setRuleBookContent(String ruleBookContent) {
        this.ruleBookContent = ruleBookContent;
    }

    public String getRuleBookContentReplace() {
        return ruleBookContentReplace;
    }

    public void setRuleBookContentReplace(String ruleBookContentReplace) {
        this.ruleBookContentReplace = ruleBookContentReplace;
    }

    public String getHttpUserAgent() {
        return httpUserAgent;
    }

    public void setHttpUserAgent(String httpUserAgent) {
        this.httpUserAgent = httpUserAgent;
    }

    public ArrayList<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(ArrayList<String> groupList) {
        this.groupList = groupList;
    }
}
