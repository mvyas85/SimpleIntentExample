package com.example.activitytoactivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int SECOND_ACTIVITY = 1;
	private static final int THIRD_ACTIVITY = 2;
	
	Button btnsec, btnthird,bt1;
	TextView txtmain;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    	btnsec = (Button) findViewById(R.id.second);
    	//bt1 = (Button) findViewById(R.id.button1);
    	btnthird = (Button) findViewById (R.id.third);
    	txtmain = (TextView) findViewById(R.id.txtmain);
        
        btnsec.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,SecondaryActivity.class);
		        startActivityForResult(intent, SECOND_ACTIVITY);	
			}
		});
        btnthird.setOnClickListener(new View.OnClickListener() {		
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
				intent.putExtra("PassToThird", txtmain.getText().toString());
				startActivityForResult(intent, THIRD_ACTIVITY);  				
			}
		});
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	switch (requestCode)
        {
	        case SECOND_ACTIVITY:
	        {
	        	if(resultCode == Activity.RESULT_OK)
	        	{
	        		String txt = data.getStringExtra("Text");
	        		txtmain.setText(txt);
	        	}
	        	break;
	        }
	        case THIRD_ACTIVITY : 
	        {
	          if (resultCode == Activity.RESULT_OK) 
	          {
	        	  String txt = data.getStringExtra("Text");
	        	  txtmain.setText(txt);
	          }
	          break;
	        }
        }
    	
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
