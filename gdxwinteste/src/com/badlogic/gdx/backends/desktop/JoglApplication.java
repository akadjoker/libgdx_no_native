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
package com.badlogic.gdx.backends.desktop;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputListener;
import com.badlogic.gdx.RenderListener;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;

/**
 * An implemenation of the {@link Application} interface based on Jogl for Windows, Linux and Mac. Instantiate
 * this class with apropriate parameters and then register {@link ApplicationListener}, {@link RenderListener} or {@link InputListener}
 * instances.
 * 
 * @author mzechner
 *
 */
public final class JoglApplication implements Application
{
	/** the graphics instance **/
	private final JoglGraphics graphics;
	
	/** the input instance **/
	private final JoglInput input;
	
	/** the audio instance **/
	private final JoglAudio audio;
	
	/** the DestroyListener **/
	ApplicationListener listener;
	
	/**
	 * Creates a new {@link JoglApplication} with the given
	 * title and dimensions. If useGL20IfAvailable is set the
	 * JoglApplication will try to create an OpenGL 2.0 context
	 * which can then be used via {@link JoglApplication.getGraphics().getGL20()}. The
	 * {@link GL10} and {@link GL11} interfaces should not be used when
	 * OpenGL 2.0 is enabled. To query whether enabling OpenGL 2.0 was
	 * successful use the {@link JoglApplication.getGraphics().isGL20Available()}
	 * method. 
	 * 
	 * @param title the title of the application
	 * @param width the width of the surface in pixels
	 * @param height the height of the surface in pixels
	 * @param useGL20IfAvailable wheter to use OpenGL 2.0 if it is available or not
	 */
	public JoglApplication( String title, int width, int height, boolean useGL20IfAvailable )
	{
		graphics = new JoglGraphics( this, title, width, height, useGL20IfAvailable );
		input = new JoglInput( graphics.graphicPanel );
		audio = new JoglAudio( );
		Gdx.app=this;
		Gdx.input=input;
		Gdx.audio=audio;
		Gdx.graphics=graphics;
		Gdx.files=getFiles();
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
		return new JoglFiles( );
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

	@Override
	public void log(String tag, String message) 
	{	
		System.out.println( tag + ": " + message );
	}

}
