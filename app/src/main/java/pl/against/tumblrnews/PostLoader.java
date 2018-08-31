package pl.against.tumblrnews;


import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list of news by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class PostLoader extends AsyncTaskLoader<List<Post>> {

    /** Tag for log messages */
    // private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link PostLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public PostLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Post> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news.
        List<Post> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }
}
