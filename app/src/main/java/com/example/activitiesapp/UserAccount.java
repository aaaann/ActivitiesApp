package com.example.activitiesapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserAccount extends AppCompatActivity {

    private static final String SAVED_PARCEL = "PARCEL";
    private TestModel mTestModel;

    @BindView(R.id.url_et)
    EditText urlEditText;

    @BindView(R.id.rndm_text_1)
    TextView rndmTextView1;

    @BindView(R.id.rndm_text_2)
    TextView rndmTextView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);
        mTestModel = new TestModel(UUID.randomUUID().toString(), UUID.randomUUID().toString(),
                new ArrayList<String>() {{
                    add(UUID.randomUUID().toString());
                    add(UUID.randomUUID().toString());
                }},
                new ArrayList<String>() {{
                    add(UUID.randomUUID().toString());
                    add(UUID.randomUUID().toString());
                }}
        );

        rndmTextView1.setText(mTestModel.getText1());
        rndmTextView2.setText(mTestModel.getText2());
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
                Intent intent = new Intent(this, Catalog.class);
                startActivity(intent);
                break;
            }

            default:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(SAVED_PARCEL, mTestModel);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        mTestModel = savedInstanceState.getParcelable(SAVED_PARCEL);
        rndmTextView1.setText(mTestModel != null ? mTestModel.getText1() : null);
        rndmTextView2.setText(mTestModel != null ? mTestModel.getText2() : null);
        super.onRestoreInstanceState(savedInstanceState);
    }

}
