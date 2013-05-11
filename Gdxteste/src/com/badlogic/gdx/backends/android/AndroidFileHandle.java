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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

import android.content.res.AssetManager;

/**
 * A {@link FileHandle} implementation for Android. Encapsulates
 * assets and files on the external storage device.
 * 
 * @author mzechner
 *
 */
public class AndroidFileHandle extends FileHandle
{
	
//	protected FileType type;
	
	/** the asset manager or null if this is an external file **/
	private final AssetManager manager;
	
	/** the filename **/
	//private final String filename;
	
	//private  File file;
	//public InputStream in;
	
	

	

	
	
	AndroidFileHandle (AssetManager assets, String fileName, FileType type)
	{
		super(fileName.replace('\\', '/'),type);
		this.manager = assets;
		
	
	}

	AndroidFileHandle (AssetManager assets, File file, FileType type) {
		
		super(file, type);
		this.manager = assets;
		
	}
	

	
	public FileHandle parent ()
	{
	
		File parent = file.getParentFile();
		if (parent == null) {
			if (type == FileType.Absolut)
				parent = new File("/");
			else
				parent = new File("");
		}
		return new AndroidFileHandle(manager, parent, type);
	}
	
	public FileHandle child (String name) 
	{
		name = name.replace('\\', '/');

		if (file.getPath().length() == 0) return new AndroidFileHandle(manager, new File(name), type);
		return new AndroidFileHandle(manager, new File(file, name), type);

	}
	public InputStream read () 
	{
		if (type == FileType.Internal) 
		{
			try {
				return manager.open(file.getPath());
			} catch (IOException ex) {
				throw new GdxRuntimeException("Error reading file: " + file + " (" + type + ")", ex);
			}
		}
		
		return super.read();
		
			
	}
	
	/**
	 * @return whether this is an asset file or an external file
	 */
	public boolean isAsset( )
	{
		return manager != null;
	}
	
	/**
	 * @return the {@link AssetManager} or null
	 */
	public AssetManager getAssetManager( )
	{
		return manager;
	}
	
	/**
	 * @return the filename
	 */
	public String getFileName( )
	{
		return file.getPath();
	}
}
