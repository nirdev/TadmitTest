package example.com.tadmittest.network;

import java.util.List;

import example.com.tadmittest.Constants;
import example.com.tadmittest.models.POJO.POJOpost;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Nir on 4/21/2016.
 */
public interface PostService {

    //Callback interface to use while calling the RestClient class
    @GET(Constants.URL_QUERY_PARAM)
    public void getArray(Callback<List<POJOpost>> items);


}
