package training.mccasugadev.com.project_uno_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {

    LayoutInflater inflater;
    String[] theItems;
    String[] theDescription;
    String[] thePrices;


    public ItemAdapter(Context context, String[] theItems, String[] theDescription, String[] thePrices) {
        this.theItems = theItems;
        this.theDescription = theDescription;
        this.thePrices = thePrices;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return theItems.length;
    }

    @Override
    public Object getItem(int position) {
        return theItems[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(android.R.layout.the_)

        TextView nameTextView = (TextView) view.findViewById(R.id.nameTextView);
        TextView descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView) view.findViewById(R.id.priceTextView);

        nameTextView.setText(theItems[position]);
        descriptionTextView.setText(theDescription[position]);
        priceTextView.setText(thePrices[position]);

        return view;
    }
}
