package com.vayavyalabs.prometheus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends ActionBarActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@JavascriptInterface
	public void onStart() {
		super.onStart();

		WebView webView = (WebView) findViewById(R.id.webview);
		// enable JavaScript
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/index.html");
		webView.addJavascriptInterface(new WebAppInterface(this), "Android");
		
		WebViewClientImpl webViewClient = new WebViewClientImpl(this);
        webView.setWebViewClient(webViewClient);
	}
	
	public class WebViewClientImpl extends WebViewClient {

	    public WebViewClientImpl(MainActivity mainActivity) {
			// TODO Auto-generated constructor stub
		}

		@Override
	    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
	        return false;
	    }

	}
}
