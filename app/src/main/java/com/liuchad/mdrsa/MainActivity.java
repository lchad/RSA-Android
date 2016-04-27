package com.liuchad.mdrsa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mInputMessage;
    private TextView mResult;
    private TextView mGenerate;
    private TextView mDecryptedMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputMessage = (EditText) findViewById(R.id.input);
        mResult = (TextView) findViewById(R.id.result);
        mGenerate = (TextView) findViewById(R.id.generate);
        mDecryptedMessage = (TextView) findViewById(R.id.encypt);
        mGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mInputMessage.getText().toString().trim();
                if (TextUtils.isEmpty(message)) {
                    Toast.makeText(MainActivity.this, "输入内容为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String encryptedMessage = RSA.encryptWithStoredKey(MainActivity.this, message);
                String decryptedMessage = RSA.decryptWithStoredKey(MainActivity.this, encryptedMessage);
                mResult.setText(new StringBuilder().append(encryptedMessage).toString());
                mDecryptedMessage.setText(new StringBuilder().append(decryptedMessage).toString());
            }
        });
    }
}