package com.example.activitytoactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class SecondaryActivity extends Activity {
	
	Button btn_sec;
	EditText txtsec;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        
    	btn_sec = (Button) findViewById(R.id.btn_sec);
    	txtsec = (EditText) findViewById(R.id.txtsec);  	
     
        btn_sec.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent result = new Intent();
				result.putExtra("Text",txtsec.getText().toString());
				setResult(RESULT_OK, result);
				
				finish();
			}
		});
    }
}
