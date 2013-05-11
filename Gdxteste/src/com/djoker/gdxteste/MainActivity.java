package com.djoker.gdxteste;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.InputListener;
import com.badlogic.gdx.RenderListener;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.graphics.GL10;

public class MainActivity extends AndroidApplication {


	  @Override
      public void onCreate (Bundle savedInstanceState) {
              super.onCreate(savedInstanceState);
              initialize( false);    
              MyFirstTriangle app= new MyFirstTriangle();
              
              this.getGraphics().setRenderListener(app);
              setApplicationListener(app);
      }

	
	
	
	
}

/*
implements RenderListener, InputListener, ApplicationListener
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
*/