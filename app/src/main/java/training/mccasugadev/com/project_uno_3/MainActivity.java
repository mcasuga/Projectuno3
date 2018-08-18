package training.mccasugadev.com.project_uno_3;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView theListView;
    String[] theItems;
    String[] theDescription;
    String[] thePrices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference the resources on strings.xml
        Resources resources = getResources();

        // Initialize the ListView
        theListView = (ListView) findViewById(R.id.theListView);

        // Get the 'theItems' resources on strings.xml
        theItems = resources.getStringArray(R.array.theItems);
        theDescription = resources.getStringArray(R.array.theDescription);
        thePrices = resources.getStringArray(R.array.thePrices);

        ItemAdapter adapter = new ItemAdapter(this, theItems, theDescription, thePrices);

        theListView.setAdapter(adapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent transferToIMG = new Intent(getApplicationContext(), DetailActivity.class);
                transferToIMG.putExtra("training.mccasugadev.com.project_uno_3.ITEM_INDEX", position);
                startActivity(transferToIMG);
            }
        });
    }
}
