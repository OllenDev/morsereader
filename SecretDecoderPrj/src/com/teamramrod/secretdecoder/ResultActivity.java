package com.teamramrod.secretdecoder;

import com.teamramrod.secertdecoder.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	public static final String MESSAGE_KEY = "MESSAGE_KEY";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		Bundle bundle = getIntent().getExtras();
		String message = new String();
		if (bundle != null) {
			message = bundle.getString("MESSAGE_KEY");
		}
		
		setContentView(R.layout.result);
		
		TextView description = (TextView) findViewById(R.id.description);
		description.setText(message);
	}
}
