package example.com.tadmittest;

/**
 * Created by Nir on 4/22/2016.
 */
public class Constants {
    //fragments
    public final static String POST_ONE_FRAGMENT_TAG = "1";
    public final static String POST_TWO_FRAGMENT_TAG = "2";
    public final static String FRAGMENT_TITLE_KEY = "titlekey";
    public final static String FRAGMENT_CATEGORY_KEY = "categorykey";
    public final static String FRAGMENT_CONTENT_KEY = "contentkey";

    //network
    public static final String URL = "http://ipets.co.il/json";
    public static final int NUMBER_OF_POSTS = 2;
    public static final String URL_QUERY_PARAM = "/wp-json/wp/v2/posts";//"/wp-json/wp/v2/posts/filter[offset]=" + NUMBER_OF_POSTS;
}
