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
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See thelass
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with libgdx.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.badlogic.gdx.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * A file handle represents a system dependant representation of an
 * internal or external file. FileHandles can only be created via
 * a {@link Files} instance.
 * 
 * @author mzechner
 *
 */
public class FileHandle 
{
	protected File file;
	protected FileType type;
	
	protected FileHandle () {
	}

	/** Creates a new absolute FileHandle for the file name. Use this for tools on the desktop that don't need any of the backends.
	 * Do not use this constructor in case you write something cross-platform. Use the {@link Files} interface instead.
	 * @param fileName the filename. */
	public FileHandle (String fileName) {
		this.file = new File(fileName);
		this.type = FileType.Absolut;
	}

	/** Creates a new absolute FileHandle for the {@link File}. Use this for tools on the desktop that don't need any of the
	 * backends. Do not use this constructor in case you write something cross-platform. Use the {@link Files} interface instead.
	 * @param file the file. */
	public FileHandle (File file) {
		this.file = file;
		this.type = FileType.Absolut;
	}

	protected FileHandle (String fileName, FileType type) {
		this.type = type;
		file = new File(fileName);
	}

	protected FileHandle (File file, FileType type) {
		this.file = file;
		this.type = type;
	}

	/** @return the path of the file as specified on construction, e.g. Gdx.files.internal("dir/file.png") -> dir/file.png. backward
	 *         slashes will be replaced by forward slashes. */
	public String path () {
		return file.getPath().replace('\\', '/');
	}

	/** @return the name of the file, without any parent paths. */
	public String name () {
		return file.getName();
	}
	
	public File file () {

		return file;
	}
	
	public InputStream read () {
		if ( (type == FileType.Internal && !file.exists())
			|| (type == FileType.External && !file.exists())) {
			InputStream input = FileHandle.class.getResourceAsStream("/" + file.getPath().replace('\\', '/'));
			if (input == null) throw new GdxRuntimeException("File not found: " + file + " (" + type + ")");
			return input;
		}
		try {
			return new FileInputStream(file);
		} catch (Exception ex) {
			if (file.isDirectory())
				throw new GdxRuntimeException("Cannot open a stream to a directory: " + file + " (" + type + ")", ex);
			throw new GdxRuntimeException("Error reading file: " + file + " (" + type + ")", ex);
		}
	}
	
	public FileHandle child (String name) 
	{
		if (file.getPath().length() == 0) return new FileHandle(new File(name), type);
		return new FileHandle(new File(file, name), type);
		
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
		return new FileHandle(parent, type);
	}
}