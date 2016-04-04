package com.example.user.scanner;



import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.widget.ImageView;

import com.dlazaro66.qrcodereaderview.QRCodeReaderView;
import com.dlazaro66.qrcodereaderview.QRCodeReaderView.OnQRCodeReadListener;

public class MainActivity extends Activity implements OnQRCodeReadListener {

    private QRCodeReaderView mydecoderview;
    private ImageView line_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydecoderview = (QRCodeReaderView) findViewById(R.id.qrdecoderview);
        mydecoderview.setOnQRCodeReadListener(this);


        line_image = (ImageView) findViewById(R.id.red_line_image);

    }

    @Override
    public void onQRCodeRead(String text, PointF[] points) {
        Intent intent = new Intent(getApplication(),DataActivity.class);
        intent.putExtra("txt",text.toString());
        startActivity(intent);
    }

    @Override
    public void cameraNotFound() {

    }
    @Override
    public void QRCodeNotFoundOnCamImage() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mydecoderview.getCameraManager().startPreview();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mydecoderview.getCameraManager().stopPreview();
    }
}
