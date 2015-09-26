package com.olxtechathon.olxmobiletechathon;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageCaptureActivity extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_capture);
        setupViews();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_next:
                startActivity(new Intent(ImageCaptureActivity.this, ProductDetailsActivity.class));
                break;
            case R.id.img_1:

                break;
            case R.id.img_2:
                break;
            case R.id.img_3:
                break;
            case R.id.img_4:
                break;
            case R.id.img_5:
                break;
            case R.id.img_6:
                break;
            case R.id.img_7:
                break;
            case R.id.img_8:
                break;
            case R.id.img_cam:
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
                break;
            case R.id.img_attach:

        }
    }

    private void setupViews() {
        TextView next = (TextView) findViewById(R.id.tv_next);
        FrameLayout framePic = (FrameLayout) findViewById(R.id.frame_img);
        framePic.setBackgroundResource(android.R.drawable.ic_menu_camera);
        ImageView imgCam = (ImageView) findViewById(R.id.img_cam);
        imgCam.setOnClickListener(this);
        ImageView imgAttach = (ImageView) findViewById(R.id.img_attach);
        imgAttach.setOnClickListener(this);
        ImageView img1 = (ImageView) findViewById(R.id.img_1);
        img1.setOnClickListener(this);
        ImageView img2 = (ImageView) findViewById(R.id.img_2);
        img2.setOnClickListener(this);
        ImageView img3 = (ImageView) findViewById(R.id.img_3);
        img3.setOnClickListener(this);
        ImageView img4 = (ImageView) findViewById(R.id.img_4);
        img4.setOnClickListener(this);
        ImageView img5 = (ImageView) findViewById(R.id.img_5);
        img5.setOnClickListener(this);
        ImageView img6 = (ImageView) findViewById(R.id.img_6);
        img6.setOnClickListener(this);
        ImageView img7 = (ImageView) findViewById(R.id.img_7);
        img7.setOnClickListener(this);
        ImageView img8 = (ImageView) findViewById(R.id.img_8);
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
    }
}
