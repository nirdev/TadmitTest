package example.com.tadmittest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import example.com.tadmittest.Constants;
import example.com.tadmittest.R;
import example.com.tadmittest.models.Post;


public class PostFragment extends Fragment {

    View view;
    Post mPost;
    TextView titleTextView;
    TextView categoryTextView;
    TextView contentTextView;

    public PostFragment() {}

    //Similar to a Constructor pattern to simply add args to the fragment
    //because fragment don't allow more then one empty constructor
    public static PostFragment newInstance(Post data) {
        //New PostFragment instance
        PostFragment postFragmentInstance = new PostFragment();

        //New bundle instance
        Bundle args = new Bundle();

        //Set the bundle arguments as key-value pairs
        args.putString(Constants.FRAGMENT_TITLE_KEY, data.getTitle());
        args.putString(Constants.FRAGMENT_CATEGORY_KEY, data.getCategory());
        args.putString(Constants.FRAGMENT_CONTENT_KEY, data.getContent());

        //Add the the bundle to the fragment instance
        postFragmentInstance.setArguments(args);

        //Return the fragment instance
        return postFragmentInstance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Take the bundle attached args and set them into local Post var
        mPost = new Post();
        mPost.setTitle(getArguments().getString(Constants.FRAGMENT_TITLE_KEY, ""));
        mPost.setCategory(getArguments().getString(Constants.FRAGMENT_CATEGORY_KEY, ""));
        mPost.setContent(getArguments().getString(Constants.FRAGMENT_CONTENT_KEY, ""));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the right layout for this fragment depends on the TAG and set up the child views data
        if (getTag() == Constants.POST_ONE_FRAGMENT_TAG){
            //Layout one views
            view = inflater.inflate(R.layout.fragment_post__first_layout, container, false);
        }else if (getTag() == Constants.POST_TWO_FRAGMENT_TAG){
            //Layout two views
            view = inflater.inflate(R.layout.fragment_post_second_layout, container, false);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getTag() == Constants.POST_ONE_FRAGMENT_TAG){
            //Layout one views
            titleTextView = (TextView) view.findViewById(R.id.fg_one_title);
            categoryTextView = (TextView) view.findViewById(R.id.fg_one_category);
            contentTextView = (TextView) view.findViewById(R.id.fg_one_content);

        }else if (getTag() == Constants.POST_TWO_FRAGMENT_TAG){
            //Layout two views

            titleTextView = (TextView) view.findViewById(R.id.fg_two_title);
            categoryTextView = (TextView) view.findViewById(R.id.fg_two_category);
            contentTextView = (TextView) view.findViewById(R.id.fg_two_content);

        }
        titleTextView.setText(mPost.getTitle());
        categoryTextView.setText(mPost.getCategory());
        contentTextView.setText(mPost.getContent());
    }
}
