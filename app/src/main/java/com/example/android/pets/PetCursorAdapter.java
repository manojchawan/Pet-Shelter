package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;


public class PetCursorAdapter extends CursorAdapter {


    public PetCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
       return LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
    }


    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameTxt = (TextView) view.findViewById(R.id.name);
        TextView summaryTxt = (TextView) view.findViewById(R.id.summary);

        // Extract properties from cursor
        String petName = cursor.getString(cursor.getColumnIndexOrThrow("name"));
        String petBreed = cursor.getString(cursor.getColumnIndexOrThrow("breed"));

        if (TextUtils.isEmpty(petBreed)) {
            petBreed = "Unknown Breed";
        }
        // Populate fields with extracted properties
        nameTxt.setText(petName);
        summaryTxt.setText(String.valueOf(petBreed));
    }
}