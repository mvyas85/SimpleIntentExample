package com.example.activitytoactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends Activity {
	Button btn_third;
	EditText txtthird;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_act);
        
    	btn_third = (Button) findViewById(R.id.btn_third);
    	txtthird = (EditText) findViewById(R.id.txtthird);  	
     
    	String mainval = this.getIntent().getStringExtra("PassToThird");
    	txtthird.setText(mainval);
        btn_third.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent result = new Intent();
				result.putExtra("Text",txtthird.getText().toString());
				setResult(RESULT_OK, result);
				
				finish();
			}
		});
    }
}
