
package example.com.tadmittest.models.POJO;

import java.util.ArrayList;
import java.util.List;


public class Links {

    private List<Self> self = new ArrayList<Self>();
    private List<Collection> collection = new ArrayList<Collection>();
    private List<About> about = new ArrayList<About>();
    private List<Author> author = new ArrayList<Author>();
    private List<Reply> replies = new ArrayList<Reply>();
    private List<VersionHistory> versionHistory = new ArrayList<VersionHistory>();
    private List<HttpsApiWOrgFeaturedmedium> httpsApiWOrgFeaturedmedia = new ArrayList<HttpsApiWOrgFeaturedmedium>();
    private List<HttpsApiWOrgAttachment> httpsApiWOrgAttachment = new ArrayList<HttpsApiWOrgAttachment>();
    private List<HttpsApiWOrgTerm> httpsApiWOrgTerm = new ArrayList<HttpsApiWOrgTerm>();

    /**
     * 
     * @return
     *     The self
     */
    public List<Self> getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(List<Self> self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The collection
     */
    public List<Collection> getCollection() {
        return collection;
    }

    /**
     * 
     * @param collection
     *     The collection
     */
    public void setCollection(List<Collection> collection) {
        this.collection = collection;
    }

    /**
     * 
     * @return
     *     The about
     */
    public List<About> getAbout() {
        return about;
    }

    /**
     * 
     * @param about
     *     The about
     */
    public void setAbout(List<About> about) {
        this.about = about;
    }

    /**
     * 
     * @return
     *     The author
     */
    public List<Author> getAuthor() {
        return author;
    }

    /**
     * 
     * @param author
     *     The author
     */
    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    /**
     * 
     * @return
     *     The replies
     */
    public List<Reply> getReplies() {
        return replies;
    }

    /**
     * 
     * @param replies
     *     The replies
     */
    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    /**
     * 
     * @return
     *     The versionHistory
     */
    public List<VersionHistory> getVersionHistory() {
        return versionHistory;
    }

    /**
     * 
     * @param versionHistory
     *     The version-history
     */
    public void setVersionHistory(List<VersionHistory> versionHistory) {
        this.versionHistory = versionHistory;
    }

    /**
     * 
     * @return
     *     The httpsApiWOrgFeaturedmedia
     */
    public List<HttpsApiWOrgFeaturedmedium> getHttpsApiWOrgFeaturedmedia() {
        return httpsApiWOrgFeaturedmedia;
    }

    /**
     * 
     * @param httpsApiWOrgFeaturedmedia
     *     The https://api.w.org/featuredmedia
     */
    public void setHttpsApiWOrgFeaturedmedia(List<HttpsApiWOrgFeaturedmedium> httpsApiWOrgFeaturedmedia) {
        this.httpsApiWOrgFeaturedmedia = httpsApiWOrgFeaturedmedia;
    }

    /**
     * 
     * @return
     *     The httpsApiWOrgAttachment
     */
    public List<HttpsApiWOrgAttachment> getHttpsApiWOrgAttachment() {
        return httpsApiWOrgAttachment;
    }

    /**
     * 
     * @param httpsApiWOrgAttachment
     *     The https://api.w.org/attachment
     */
    public void setHttpsApiWOrgAttachment(List<HttpsApiWOrgAttachment> httpsApiWOrgAttachment) {
        this.httpsApiWOrgAttachment = httpsApiWOrgAttachment;
    }

    /**
     * 
     * @return
     *     The httpsApiWOrgTerm
     */
    public List<HttpsApiWOrgTerm> getHttpsApiWOrgTerm() {
        return httpsApiWOrgTerm;
    }

    /**
     * 
     * @param httpsApiWOrgTerm
     *     The https://api.w.org/term
     */
    public void setHttpsApiWOrgTerm(List<HttpsApiWOrgTerm> httpsApiWOrgTerm) {
        this.httpsApiWOrgTerm = httpsApiWOrgTerm;
    }

}
