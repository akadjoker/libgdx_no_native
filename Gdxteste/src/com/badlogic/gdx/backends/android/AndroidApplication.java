/*
 *  This file is part of Libgdx by Mario Zechner (badlogicgames@gmail.com)
 *
 *  Libgdx is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Libgdx is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with libgdx.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.badlogic.gdx.backends.android;


import android.app.Activity;
import android.util.Log;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;

/**
 * An implementation of the {@link Application} interface for Android. Create an {@link Activity}
 * that derives from this class. In the {@link Activity.onCreate()} method call the {@link initialize()}
 * method specifying the configuration for the GLSurfaceView.
 * 
 * @author mzechner
 *
 */
public class AndroidApplication extends Activity implements Application
{
	
	
	/** the android graphics instance **/
	private AndroidGraphics graphics;	
	
	/** the input instance **/
	private AndroidInput input;
	
	/** the audio instance **/
	private AndroidAudio audio;
	
	/** the resources instance **/
	private AndroidFiles resources;
	
	/** the DestroyListener **/
	private ApplicationListener listener;
	
	/**
	 * This method has to be called in the {@link Activity.onCreate()}
	 * method. It sets up all the things necessary to get input, render
	 * via OpenGL and so on. If useGL20IfAvailable is set the
	 * AndroidApplication will try to create an OpenGL ES 2.0 context
	 * which can then be used via {@link AndroidApplication.getGraphics().getGL20()}. The
	 * {@link GL10} and {@link GL11} interfaces should not be used when
	 * OpenGL ES 2.0 is enabled. To query whether enabling OpenGL ES 2.0 was
	 * successful use the {@link AndroidApplication.getGraphics().isGL20Available()}
	 * method. 
	 * 
	 * @param useGL2IfAvailable whether to use OpenGL ES 2.0 if its available.
	 */
	public void initialize( boolean useGL2IfAvailable )
	{
		graphics = new AndroidGraphics( this, useGL2IfAvailable );
		input = new AndroidInput( this, graphics.view );
		graphics.setInput( input );
		audio = new AndroidAudio( this );
		resources = new AndroidFiles( this.getAssets() );
		
		Gdx.app=this;
		Gdx.input=input;
		Gdx.audio=audio;
		Gdx.graphics=graphics;
		Gdx.files=resources;
	}
	
	@Override
	protected void onPause( )
	{
		super.onPause( );
		
		if( isFinishing() )		
			graphics.disposeRenderListener();		
		
		if( graphics.view != null )
			graphics.view.onPause();
		
		audio.pause();
		
		if( listener != null )
			listener.pause( this );
	}
	
	@Override
	protected void onResume( )
	{
		super.onResume();
		
		if( listener != null )
			listener.resume( this );			
		
		if( graphics.view != null )
			graphics.view.onResume();
		
		audio.resume();
	}

	@Override
	protected void onDestroy( )
	{
		super.onDestroy();
		
		if( listener != null )
			listener.destroy(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Audio getAudio() 
	{	
		return audio;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Files getFiles() 
	{	
		return resources;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Graphics getGraphics() 
	{		
		return graphics;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Input getInput() 
	{	
		return input;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setApplicationListener(ApplicationListener listener) 
	{	
		this.listener = listener;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void log(String tag, String message) 
	{	
		Log.d( tag, message );
	}
}
