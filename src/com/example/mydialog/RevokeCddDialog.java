package com.example.mydialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
/**
 * @author horrywu
 *
 */
@SuppressLint("SimpleDateFormat")
public class RevokeCddDialog extends Dialog implements
		android.view.View.OnClickListener {
	Context context;
	public Button cdd_modify_no;
	public Button cdd_modify_yes;
	public Spinner cdd_type;
	public EditText cdd_revoke;
	
	private onInterviewClickListener mOncClickListener;
	
	/**
	 * 
	 * @param context
	 * @param theme 主题
	 * @param token 用户token
	 * @param interviewId 面试id
	 * @param t 1：修改面�? 2确认面试
	 * @param interviewtype 面试类型
	 */
	public RevokeCddDialog(Context context, int theme) {
		super(context, theme);
		this.context = context;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.interview_revoke);
		
		cdd_modify_no = (Button) findViewById(R.id.cdd_revoke_no);
		cdd_modify_yes = (Button) findViewById(R.id.cdd_revoke_yes);

		cdd_revoke=(EditText) findViewById(R.id.cdd_revoke_reson);
		
		cdd_modify_no.setOnClickListener(this);
		cdd_modify_yes.setOnClickListener(this);
	}


	public void setOnInterviewClickListener(onInterviewClickListener onClickListener){
		mOncClickListener=onClickListener;
	}
	public interface onInterviewClickListener{
		public void revokeCdd(String result);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.cdd_revoke_yes:
			this.dismiss();
			break;
		case R.id.cdd_revoke_no:
			mOncClickListener.revokeCdd(cdd_revoke.getText().toString());
			break;
		default:
			break;
		}
	}

	
	private void showShortToast(String str){
		Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
	}
	
	private void hidedia(){
		this.dismiss();
	}
}
