package com.example.suvp.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by suvp on 1/23/2016.
 */
public class CustomAdapter extends ArrayAdapter<Product> {

    private final Context context;
    private final Product[] values;

    public CustomAdapter(Context aInContext, Product[] aInValues)
    {
        super(aInContext,-1 , aInValues);
        context = aInContext;
        values = aInValues;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);
        TextView firstTextView = (TextView)(rowView.findViewById(R.id.list_firstLine));
        TextView secondTextView = (TextView)(rowView.findViewById(R.id.list_secondLine));
        Product lProduct = values[position];

        firstTextView.setText(lProduct.getName_());
        secondTextView.setText("madan");
        return rowView;
    }
}
