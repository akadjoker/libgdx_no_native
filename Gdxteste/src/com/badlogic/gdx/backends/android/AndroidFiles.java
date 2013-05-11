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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.res.AssetManager;
import android.os.Environment;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.files.FileHandle;

/**
 * An implementation of the {@link Files} interface for Android. External files are stored and accessed
 * relative to Environment.getExternalStorageDirectory().getAbsolutePath(). Internal files are accessed
 * relative to the assets directory.
 * 
 * @author mzechner
 *
 */
final class AndroidFiles implements Files
{
	/** external storage path **/
	private final String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
	private  File lastFile;
	/** asset manager **/
	private final AssetManager assets;

	AndroidFiles( AssetManager assets )
	{
		this.assets = assets;
	}

	/**
	 * @return the asset manager.
	 */
	protected AssetManager getAssetManager( )
	{
		return assets;
	}

	@Override
	public File getlastFile()
	{
		return lastFile;
	}
	
	
	private InputStream readExternalFile(String fileName) 
	{	
		FileInputStream in = null;

		try
		{
			in = new FileInputStream( sdcard + fileName );
		}
		catch( FileNotFoundException ex )
		{
			// fall through
		}

		return in;
	}

	
	private InputStream readInternalFile(String fileName) 
	{	
		InputStream in = null;
		try
		{
			in = assets.open( fileName );
		}
		catch( Exception ex )
		{
			// fall through
		}

		return in;
	}

	private OutputStream writeExternalFile(String filename) 
	{	
		FileOutputStream out = null;

		try
		{
			out = new FileOutputStream( sdcard + filename );
		}
		catch( FileNotFoundException ex )
		{
			// fall through
		}

		return out;
	}
	
	
	private InputStream readAbsolutFile(String filename) 
	{	
		FileInputStream in = null;

		try
		{
			in = new FileInputStream( filename );
		}
		catch( FileNotFoundException ex )
		{
			// fall through
		}

		return in;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public FileHandle getFileHandle(String filename, FileType type) 
	{	
		if( type == FileType.Internal )
		{
			boolean exists = true;
	
			try
			{
				InputStream in = assets.open( filename );
				in.close();
			}
			catch( Exception ex )
			{
				exists = false;
			}
	
			if( !exists )
				return null;
			
				return new AndroidFileHandle( assets, filename,type);			
		}
		
		if( type == FileType.External )
		{
			if( new File( sdcard + filename ).exists() == false )
				return null;
			else
				return new AndroidFileHandle( null, sdcard + filename,type );
		}
		else
		{
			if( new File( filename ).exists() == false )
				return null;
			else
				return new AndroidFileHandle( null, filename,type );
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String[] listDirectory(String directory, FileType type) 
	{
		if( type == FileType.Internal )
		{
			try
			{
				return assets.list( directory );
			}
			catch( Exception ex )
			{
				return null;
			}
		}
		
		if( type == FileType.External )		
			return new File( sdcard + directory ).list();		
		else
			return new File( directory ).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean makeDirectory(String directory, FileType type) 
	{
		if( type == FileType.Internal )
			return false;
		
		if( type == FileType.External )		
			return new File( sdcard + directory ).mkdirs();
		else
			return new File( directory ).mkdirs();		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public InputStream readFile(String fileName, FileType type) 
	{
		if( type == FileType.Internal )
			return readInternalFile( fileName );
		if( type == FileType.External )
			return readExternalFile( fileName );
		else
			return readAbsolutFile( fileName );		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OutputStream writeFile(String filename, FileType type) 
	{
		if( type == FileType.Internal )
			return null;
		if( type == FileType.External )
			return writeExternalFile( filename );
		else
		{
			FileOutputStream out = null;

			try
			{
				out = new FileOutputStream( filename );
			}
			catch( FileNotFoundException ex )
			{
				// fall through
			}

			return out;
		}
	}
}
