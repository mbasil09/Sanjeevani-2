package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundConnector extends AsyncTask<String,Void,String> {
     Context context;
     BackgroundConnector(Context ctx){
         context = ctx;
     }
    @Override
    protected String doInBackground(String... strs) {
        Log.d("here", "opened");
         String type = strs[0];
         if(type.equals("register")){
             Log.d("here", "register");
             String name = strs[1];
             String address = strs[2];
             String contact = strs[3];
             String email = strs[4];
             String password = strs[5];
             String age = strs[6];
             String sex = strs[7];
             String donor = strs[8];
             String donor_status = "0";
             if(donor=="true"){
                 donor_status = "1";
             }
             try{
                 URL url = new URL("http://nikhilsexiboi.000webhostapp.com/register.php");
                 HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                 Log.d("here", "conn");
                 conn.setRequestMethod("POST");
                 conn.setDoInput(true);
                 conn.setDoInput(true);
                 OutputStream outputStream = conn.getOutputStream();
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                 String data =
                         URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                         URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8") +"&"+
                         URLEncoder.encode("contact","UTF-8")+"="+URLEncoder.encode(contact,"UTF-8") +"&"+
                         URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8") +"&"+
                         URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8") +"&"+
                         URLEncoder.encode("age","UTF-8")+"="+URLEncoder.encode(age,"UTF-8") +"&"+
                         URLEncoder.encode("sex","UTF-8")+"="+URLEncoder.encode(sex,"UTF-8") +"&"+
                         URLEncoder.encode("donor","UTF-8")+"="+URLEncoder.encode(donor_status,"UTF-8");
                 bufferedWriter.write(data);
                 bufferedWriter.flush();
                 bufferedWriter.close();
                 outputStream.close();
                 InputStream inputStream = conn.getInputStream();
                 BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                 String inputLine;
                 String result="";
                 while((inputLine=in.readLine())!=null){
                     result+=inputLine;
                     Log.d("lul",inputLine+"\n");
                 };
                 in.close();
                 inputStream.close();
                 conn.disconnect();
                 Log.d("result",result);
                 return result;
             }
             catch(Exception e){
                 Log.d("error","error",e);
             }
         }
         else if(type.equals("login")){
             String username = strs[1];
             String password  = strs[2];
             try{
                 URL url = new URL("http://nikhilsexiboi.000webhostapp.com/connect.php");
                 HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                 conn.setRequestMethod("POST");
                 conn.setDoInput(true);
                 conn.setDoInput(true);
                 OutputStream outputStream = conn.getOutputStream();
                 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                 String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"+ URLEncoder.encode("pswd","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                 bufferedWriter.write(data);
                 bufferedWriter.flush();
                 bufferedWriter.close();
                 outputStream.close();
                 Log.d("here", "done op");
                 InputStream inputStream = conn.getInputStream();
                 BufferedReader in = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                 String inputLine;
                 String result="";
                 while((inputLine=in.readLine())!=null){
                     result+=inputLine;
                     Log.d("lul",inputLine+"\n");
                 };
                 Log.d("here", "done ip");
                 in.close();
                 inputStream.close();
                 conn.disconnect();
//                 Log.d("result",result);
//                 Toast.makeText(create_user.this,"success",Toast.LENGTH_LONG).show();
                 return result;
             }

             catch(Exception e){
                 Log.d("error","error",e);
             }

         }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


}
