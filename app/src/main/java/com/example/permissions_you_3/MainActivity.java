package com.example.permissions_you_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int Req_Code;
    private Button mBtnCamaraPermission;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnCamaraPermission = findViewById(R.id.btnCamaraPermission);

        mBtnCamaraPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permissions = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this,permissions,Req_Code);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            showToast("Camara Permission Granted");
        if(grantResults[0] == PackageManager.PERMISSION_DENIED)
            if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,permissions[0])){
                showToast("Camara Permission Denied");
            }else
                showToast("Camara Permission Denied by selecting Do not Show Again");

    }
    private void showToast(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
    }
}