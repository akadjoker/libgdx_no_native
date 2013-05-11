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

import java.io.File;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.GdxRuntimeException;

/**
 * A {@link FileHandle} implementation for the desktop. 
 * 
 * @author mzechner
 *
 */
public class JoglFileHandle extends FileHandle
{
	public JoglFileHandle (String fileName, FileType type) {
		super(fileName, type);
	}

	public JoglFileHandle (File file, FileType type) {
		super(file, type);
	}

	public FileHandle child (String name) {
		if (file.getPath().length() == 0) return new JoglFileHandle(new File(name), type);
		return new JoglFileHandle(new File(file, name), type);
	}

	public FileHandle sibling (String name) {
		if (file.getPath().length() == 0) throw new GdxRuntimeException("Cannot get the sibling of the root.");
		return new JoglFileHandle(new File(file.getParent(), name), type);
	}

	public FileHandle parent () {
		File parent = file.getParentFile();
		if (parent == null) {
			if (type == FileType.Absolut)
				parent = new File("/");
			else
				parent = new File("");
		}
		return new JoglFileHandle(parent, type);
	}

	public File file ()
	{
		
		return file;
	}

}
