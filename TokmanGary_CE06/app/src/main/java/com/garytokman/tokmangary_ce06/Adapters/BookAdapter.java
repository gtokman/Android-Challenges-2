package com.garytokman.tokmangary_ce06.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.garytokman.tokmangary_ce06.Helpers.CursorHelper;
import com.garytokman.tokmangary_ce06.R;
import com.squareup.picasso.Picasso;

// Gary Tokman
// JAV2 - 1609
// BookAdapter

public class BookAdapter extends CursorAdapter {
    public BookAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        LayoutInflater inflater = LayoutInflater.from(context);

        return inflater.inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.bindView(cursor, context);
    }

    private static class ViewHolder {
        TextView bookTitle;
        ImageView bookThumbnail;

        public ViewHolder(View view) {
            bookTitle = (TextView) view.findViewById(R.id.book_name);
            bookThumbnail = (ImageView) view.findViewById(R.id.thumbnail_image);
        }

        public void bindView(Cursor cursor, Context context) {
            CursorHelper cursorHelper = new CursorHelper(cursor);
            bookTitle.setText(cursorHelper.getBookTitle());
            String imageLink = cursorHelper.getBookThumbnail();
            Picasso.with(context)
                    .load(imageLink)
                    .placeholder(R.drawable.ic_mood_black_24dp)
                    .into(bookThumbnail);
        }
    }
}
