package com.olxtechathon.olxmobiletechathon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImageCaptureActivity extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    private ImageView img5;
    private ImageView img6;
    private ImageView img7;
    private ImageView img8;
    private FrameLayout framePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);
        setupViews();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tv_next:
                startActivity(new Intent(ImageCaptureActivity.this, ProductDetailsActivity.class));
                break;
            case R.id.img_1:

                framePic.setBackground(img1.getDrawable());
                break;
            case R.id.img_2:
                framePic.setBackground(img2.getDrawable());
                break;
            case R.id.img_3:
                framePic.setBackground(img3.getDrawable());
                break;
            case R.id.img_4:
                framePic.setBackground(img4.getDrawable());
                break;
            case R.id.img_5:
                framePic.setBackground(img5.getDrawable());
                break;
            case R.id.img_6:
                framePic.setBackground(img6.getDrawable());
                break;
            case R.id.img_7:
                framePic.setBackground(img7.getDrawable());
                break;
            case R.id.img_8:
                framePic.setBackground(img8.getDrawable());
                break;
            case R.id.img_cam:
                if (getTotalImageCount()) {
                    Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                    }
                } else {
                    Toast.makeText(ImageCaptureActivity.this, "Cant upload more images", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.img_attach:
                break;

        }
    }

    private ImageView getVacentImageView() {
        if (img1.getDrawable() == null) {
            return img1;
        } else if (img2.getDrawable() == null) {
            return img2;
        } else if (img3.getDrawable() == null) {
            return img3;
        } else if (img4.getDrawable() == null) {
            return img4;
        } else if (img5.getDrawable() == null) {
            return img5;
        } else if (img6.getDrawable() == null) {
            return img6;
        } else if (img7.getDrawable() == null) {
            return img7;
        } else if (img8.getDrawable() == null) {
            return img8;
        } else {
            return null;
        }
    }

    private void setupViews() {
        TextView next = (TextView) findViewById(R.id.tv_next);
        framePic = (FrameLayout) findViewById(R.id.frame_img);
        ImageView imgCam = (ImageView) findViewById(R.id.img_cam);
        imgCam.setOnClickListener(this);
        ImageView imgAttach = (ImageView) findViewById(R.id.img_attach);
        imgAttach.setOnClickListener(this);
        img1 = (ImageView) findViewById(R.id.img_1);
        img1.setOnClickListener(this);
        img2 = (ImageView) findViewById(R.id.img_2);
        img2.setOnClickListener(this);
        img3 = (ImageView) findViewById(R.id.img_3);
        img3.setOnClickListener(this);
        img4 = (ImageView) findViewById(R.id.img_4);
        img4.setOnClickListener(this);
        img5 = (ImageView) findViewById(R.id.img_5);
        img5.setOnClickListener(this);
        img6 = (ImageView) findViewById(R.id.img_6);
        img6.setOnClickListener(this);
        img7 = (ImageView) findViewById(R.id.img_7);
        img7.setOnClickListener(this);
        img8 = (ImageView) findViewById(R.id.img_8);
        img8.setOnClickListener(this);
        next.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_capture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ImageView imageView = getVacentImageView();

            if (imageView != null) {
                imageView.setImageBitmap(photo);
            }
        }
    }

    private boolean getTotalImageCount() {
        if (img1.getDrawable() == null) {
            return true;
        } else if (img2.getDrawable() == null) {
            return true;
        } else if (img3.getDrawable() == null) {
            return true;
        } else if (img4.getDrawable() == null) {
            return true;
        } else if (img5.getDrawable() == null) {
            return true;
        } else if (img6.getDrawable() == null) {
            return true;
        } else if (img7.getDrawable() == null) {
            return true;
        } else if (img8.getDrawable() == null) {
            return true;
        } else {
            return false;
        }
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
//        mCurrentPhotoPath = "file:" + image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                        Uri.fromFile(photoFile));
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            }
        }
    }
}
