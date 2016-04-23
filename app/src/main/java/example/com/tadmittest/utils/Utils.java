package example.com.tadmittest.utils;

import example.com.tadmittest.models.POJO.POJOpost;
import example.com.tadmittest.models.Post;

/**
 * Created by Nir on 4/23/2016.
 */
public class Utils {

    public static Post convertPOJOtoPost(POJOpost data){
        String mTitle;
        String mContent;
        String mCategory = "";

        //Get Data from POJO
        for (Integer category: data.getCategories()){
            mCategory = mCategory + category + " ";
        }
        mTitle = data.getTitle().getRendered();
        mContent = data.getContent().getRendered();

        //Clean HTML attr
        mCategory = cleanHTMLattributes(mCategory);
        mTitle = cleanHTMLattributes(mTitle);
        mContent = cleanHTMLattributes(mContent);

        //Return new post
        return new Post(mTitle,mCategory,mContent);
    }

    public static String cleanHTMLattributes(String txt){
        return android.text.Html.fromHtml(txt).toString();
    }
}
