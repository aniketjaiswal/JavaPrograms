package com.example.new_vegis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends ActionBarActivity {
	 
    private EditText editTextUserName;
    private EditText editTextPassword;
 
    public static final String USER_NAME = "USERNAME";
 
    String username;
    String password;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
 
        editTextUserName = (EditText) findViewById(R.id.editText1);
        editTextPassword = (EditText) findViewById(R.id.editText2);
    }
 
    public void invokeLogin(View view){
        username = editTextUserName.getText().toString();
        password = editTextPassword.getText().toString();
 
        login(username,password);
 
    }
 
    private void login(final String username, String password) {
 
        @SuppressLint("NewApi")
		class LoginAsync extends AsyncTask<String, Void, String>{
 
            private Dialog loadingDialog;
 
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loadingDialog = ProgressDialog.show(login.this, "Please wait", "Loading...");
            }
 
            @Override
            protected String doInBackground(String... params) {
                String uname = params[0];
                String pass = params[1];
 
                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));
                nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;
 
                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://10.0.2.2/Aniket/login/login.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
 
                    HttpResponse response = httpClient.execute(httpPost);
 
                    HttpEntity entity = response.getEntity();
 
                    is = entity.getContent();
 
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();
 
                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }
 
            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                loadingDialog.dismiss();
                if(s.equalsIgnoreCase("success")){
                    Intent intent = new Intent(login.this, mainpage.class);
                    intent.putExtra(USER_NAME, username);
                    finish();
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid User Name or Password", Toast.LENGTH_LONG).show();
                }
            }
        }
 
        LoginAsync la = new LoginAsync();
        la.execute(username, password);
 
    }
 
 
   
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
 
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
 
        return super.onOptionsItemSelected(item);
    }


}
