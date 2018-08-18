package training.mccasugadev.com.project_uno_3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ImageView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent mainIntent = getIntent();
        int imageIndex = mainIntent.getIntExtra("training.mccasugadev.com.project_uno_3.ITEM_INDEX", -1);
        ImageView pic = (ImageView) findViewById(R.id.theImage);

        if (imageIndex > -1) {
            int thePicture = getImg(imageIndex);
            scaleImg(pic, thePicture);

//            pic.setImageResource(getImg(imageIndex));
        } else {
            System.err.println("There is no extra");
        }
    }

    private int getImg(int index) {
        switch (index){
            case 0:
                return R.drawable.ruler;
            case 1:
                return R.drawable.marker;
            case 2:
                return R.drawable.frixion;
            default:
                return -1;
        }
    }

    private void scaleImg(ImageView imgView, int pic) {
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;

        BitmapFactory.decodeResource(getResources(), pic, options);

        DisplayMetrics metrics = getResources().getDisplayMetrics();

        int imgWidth = options.outWidth;
        int screenWidth = metrics.widthPixels;

        if (imgWidth > screenWidth) {
            int ratio = Math.round((float) imgWidth / (float) screenWidth);
            options.inSampleSize = ratio;
        }

        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), pic, options);
        imgView.setImageBitmap(scaledImg);
    }
}
