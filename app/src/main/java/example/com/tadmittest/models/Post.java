package example.com.tadmittest.models;

/**
 * Created by Nir on 4/21/2016.
 */
public class Post {

    String title;
    String category;
    String content;

    public Post() {
    }

    public Post(String title, String category, String content) {
        this.title = title;
        this.category = category;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
