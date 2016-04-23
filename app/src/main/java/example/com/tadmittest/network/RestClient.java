package example.com.tadmittest.network;

import example.com.tadmittest.Constants;

/**
 * Created by Nir on 4/21/2016.
 */
public class RestClient {

    private retrofit.RestAdapter restAdapter;
    private PostService postService;

    public RestClient()
    {
        //Build retrofit REST Adapter with chosen URL
        restAdapter = new retrofit.RestAdapter.Builder()
                .setEndpoint(Constants.URL)
                .setLogLevel(retrofit.RestAdapter.LogLevel.FULL)
                .build();

        postService = restAdapter.create(PostService.class);
    }

    //Get function for RestClient instance
    public PostService getService()
    {
        return postService;
    }
}
