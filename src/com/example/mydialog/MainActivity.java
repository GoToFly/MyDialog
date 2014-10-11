package com.example.mydialog;

import com.example.mydialog.RevokeCddDialog.onInterviewClickListener;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	Button button1;
	TextView textView1;
	RevokeCddDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button) findViewById(R.id.button1);
        textView1=(TextView) findViewById(R.id.textView1);
        
        dialog =new RevokeCddDialog(this, R.style.AppTheme);
        dialog.setOnInterviewClickListener(new onInterviewClickListener() {
			
			@Override
			public void revokeCdd(String result) {
				textView1.setText(result);
			}
		});
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.show();
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
