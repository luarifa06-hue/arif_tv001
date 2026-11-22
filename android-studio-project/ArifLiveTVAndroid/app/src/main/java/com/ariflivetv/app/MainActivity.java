package com.ariflivetv.app;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.webkit.ValueCallback;
import android.content.Intent;
import android.net.Uri;
public class MainActivity extends Activity {
    private WebView webView;
    private ValueCallback<Uri[]> fileCallback;
    private static final int PICK_FILE=1042;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(android.graphics.Color.rgb(8,9,16));
        getWindow().setNavigationBarColor(android.graphics.Color.rgb(8,9,16));
        webView=new WebView(this); webView.setBackgroundColor(android.graphics.Color.rgb(8,9,16));
        WebSettings s=webView.getSettings(); s.setJavaScriptEnabled(true); s.setDomStorageEnabled(true); s.setAllowFileAccess(true); s.setMediaPlaybackRequiresUserGesture(false);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient(){@Override public boolean onShowFileChooser(WebView v,ValueCallback<Uri[]> cb,FileChooserParams p){
            if(fileCallback!=null)fileCallback.onReceiveValue(null); fileCallback=cb; Intent i=new Intent(Intent.ACTION_GET_CONTENT); i.addCategory(Intent.CATEGORY_OPENABLE); i.setType("*/*");
            try{startActivityForResult(Intent.createChooser(i,"Choose playlist"),PICK_FILE);}catch(Exception e){fileCallback=null;cb.onReceiveValue(null);} return true;}});
        setContentView(webView); webView.loadUrl("file:///android_asset/index.html");
    }
    @Override protected void onActivityResult(int rq,int rc,Intent data){super.onActivityResult(rq,rc,data);if(rq==PICK_FILE&&fileCallback!=null){Uri[] r=(rc==RESULT_OK&&data!=null&&data.getData()!=null)?new Uri[]{data.getData()}:null;fileCallback.onReceiveValue(r);fileCallback=null;}}
    @Override public void onBackPressed(){if(webView!=null&&webView.canGoBack())webView.goBack();else super.onBackPressed();}
}
