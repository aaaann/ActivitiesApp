package com.example.activitiesapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Catalog extends AppCompatActivity {

    @BindView(R.id.url_et)
    EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.go_to_btn, R.id.goto_next_activity_btn})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.go_to_btn: {
                String url = urlEditText.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                break;
            }

            case R.id.goto_next_activity_btn: {
                Intent intent = new Intent(this, Map.class);
                startActivity(intent);
                break;
            }

            default:
                break;
        }

    }
}
