package pl.against.tumblrnews;


        import android.content.Context;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.util.List;

/**
 * An {@link PostAdapter} knows how to create a list item layout for each news
 * in the data source (a list of {@link Post} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class PostAdapter extends ArrayAdapter<Post> {


    /**
     * Constructs a new {@link PostAdapter}.
     *
     * @param context of the app
     * @param news is the list of news, which is the data source of the adapter
     */
    public PostAdapter(Context context, List<Post> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news at the given position
     * in the list of news.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news at the given position in the list of news
        Post currentNews = getItem(position);

        String webTitle = currentNews.getWebTitle();
        // Find the TextView with view ID webtitle
        TextView webTitleView = listItemView.findViewById(R.id.webtitle);
        webTitleView.setText(webTitle);

        String authorName = currentNews.getAuthorName();
        TextView authorNameView = listItemView.findViewById(R.id.authorname);
        authorNameView.setText(authorName);

        String sectionName = currentNews.getSectionName();
        TextView sectionNameView = listItemView.findViewById(R.id.sectionname);
        sectionNameView.setText(sectionName);

        String webPublicationDate = currentNews.getWebPublicationDate();
        TextView webPublicationDateView = listItemView.findViewById(R.id.webpublicationdate);
        webPublicationDateView.setText(webPublicationDate);

//
        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }

}