package com.example.new_vegis;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class mainpage extends Activity {
	Button b1,b2,b3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainpage);
		
		b1=(Button) findViewById(R.id.button1);
		b2=(Button) findViewById(R.id.button2);
		b3=(Button) findViewById(R.id.button3);
}
}
