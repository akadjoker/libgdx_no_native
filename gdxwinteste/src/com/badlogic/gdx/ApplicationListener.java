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
package com.badlogic.gdx;

/**
 * An ApplicationListener is called when the {@link Application}
 * is resumed, paused and destroyed. This allows you to save any states you want
 * to save. The methods are not called from within
 * the rendering thread so care has to be taken. This follows
 * the standard Android Activity life-cycle and is emulated on
 * the desktop accordingly. The pause method will be called after the rendering
 * thread has been paused. The resume method will be called before the rendering
 * thread has been started.
 * 
 * @author mzechner
 *
 */
public interface ApplicationListener 
{
	/**
	 * Called when the {@link Application} is paused. An
	 * Application is paused before it is destroyed or
	 * when a user pressed the Home button on Android.
	 * This will not be called in the rendering thread. Instead
	 * the rendering thread will be paused before this method is called.
	 * @param app the Application
	 */
	public void pause( Application app );
	
	/**
	 * Called when the {@link Application} is resumed
	 * from a paused state or the Application was just
	 * created. This will not be called in the rendering thread.
	 * Instead this callback will be first called, then the
	 * rendering thread will be resumed.
	 * @param app the Application
	 */
	public void resume( Application app );
	
	/**
	 * Called when the {@link Application} is destroyed. This
	 * will not be called in the rendering thread.
	 * @param app the Application
	 */
	public void destroy( Application app );
}
