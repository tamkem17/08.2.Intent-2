package com.example.tam.a082intent_2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText mEdt_x, mEdt_y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_goSumActivity = (Button)findViewById(R.id.btn_goSumActivity);
        Button btn_goSumActivityData = (Button)findViewById(R.id.btn_goSumActivityData);
        Button btn_goSumActivityEdit = (Button)findViewById(R.id.btn_goSumActivityEdit);
        mEdt_x = (EditText)findViewById(R.id.edt_x);
        mEdt_y = (EditText)findViewById(R.id.edt_y);
        btn_goSumActivity.setOnClickListener(new goSumActivity());
        btn_goSumActivityData.setOnClickListener(new goSumActivityData());
        btn_goSumActivityEdit.setOnClickListener(new goSumActivityEdit());
    }

    private class goSumActivity implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("sum://example.com/add");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    private class goSumActivityData implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Uri uri = Uri.parse("sum://example.com/add");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtras(IntegerBundle.randomInteger());
            startActivity(intent);
        }
    }

    private class goSumActivityEdit implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            float x, y;
            x = Float.parseFloat(mEdt_x.getText().toString());
            y = Float.parseFloat(mEdt_y.getText().toString());
            Uri uri = Uri.parse("sum://example.com/add");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            Bundle bundle = new Bundle();
            bundle.putFloat("x", x);
            bundle.putFloat("y", y);
            intent.putExtras(bundle);
            startActivity(intent);


        }
    }

    public static class IntegerBundle{
        public static Bundle makeIntegerInfoBundle(float x, float y) {
            Bundle IntegerInfo = new Bundle();
            IntegerInfo.putFloat("x",x);
            IntegerInfo.putFloat("y",y);
            return (IntegerInfo);
        }

        public static Bundle randomInteger(){
            float x,y;
            Random random = new Random();
            x = random.nextFloat();
            y = random.nextFloat();
            return IntegerBundle.makeIntegerInfoBundle(x,y);
        }
    }

}
