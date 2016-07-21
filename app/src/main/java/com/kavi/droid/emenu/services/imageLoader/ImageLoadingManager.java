package com.kavi.droid.emenu.services.imageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by kavi on 7/15/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class ImageLoadingManager {

    private String selectedImageUrl;
    private ImageView selectedImageView;

    /**
     * Get the image url and ImageView to manager
     * Call the async task to load image from url and set it to given ImageView
     * @param imageUrl Given image url
     * @param imageView Given ImageView object
     */
    public void loadImageToImageView (String imageUrl, ImageView imageView) {
        this.selectedImageUrl = imageUrl;
        this.selectedImageView = imageView;

        if (selectedImageUrl != null && selectedImageView != null) {
            new LoadImageTask().execute();
        }
    }

    /**
     * AsyncTask loadImageTask
     * This load the image recipe from given url in background
     */
    private class LoadImageTask extends AsyncTask<Void, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(Void... voids) {
            Bitmap bmp = null;
            try {
                URL url = new URL(selectedImageUrl);
                bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return bmp;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            selectedImageView.setImageBitmap(bitmap);
        }
    }
}
