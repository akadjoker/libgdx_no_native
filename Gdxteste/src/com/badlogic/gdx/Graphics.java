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

import java.io.InputStream;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Font;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.ShaderProgram;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;

/**
 * This interface encapsulates the communication with the graphics pipeline.
 * It allows to retrieve {@link GL10}, {@link GL11} and {@link GL20} instances
 * depending on the available hardware and configuration of the {@link Application}.
 * Additionally it features methods to generate {@link Pixmap}s, {@link Font}s,
 * {@link Texture}s, and {@link ShaderProgram}s. 
 * Note that ShaderPrograms only work with OpenGL ES 2.0
 * 
 * @author mzechner
 *
 */
public interface Graphics 
{
	/**
	 * Returns whether OpenGL ES 1.1 is available. If it is
	 * you can get an instance of {@link GL11} via {@link getGL11()}
	 * to access OpenGL ES 1.1 functionality.
	 * 
	 * @return whether OpenGL ES 1.1 is available
	 */
	public boolean isGL11Available( );
	
	/**
	 * Returns whether OpenGL ES 2.0 is available. If it is
	 * you can get an instance of {@link GL20} via {@link getGL20()}
	 * to access OpenGL ES 2.0 functionality. Note that this
	 * functionality will only be available if you instructed
	 * the Application instance to use OpenGL ES 2.0!
	 * 
	 * @return whether OpenGL ES 2.0 is available
	 * 
	 * @see DesktopApplication
	 * @see AndroidApplication
	 */
	public boolean isGL20Available( );
	
	/**
	 * @return the {@link GL10} instance or null if OpenGL ES 2.0 is used.
	 */
	public GL10 getGL10( );
	
	/**
	 * @return the {@link GL11} instance or null if OpenGL ES 1.1 is not supported or OpenGL ES 2.0 is used
	 */
	public GL11 getGL11( );
	
	/**
	 * @return the {@link GL20} instance or null if OpenGL ES 2.0 is not supported or OpenGL ES 1.x is used
	 */
	public GL20 getGL20( );
	
	/**
	 * @return the viewport width in pixels
	 */
	public int getWidth( );	
	
	/**
	 * @return the viewport height in pixels
	 */
	public int getHeight( );
	
	/**
	 * @return the time span between the current frame and the last frame in seconds.
	 */
	public float getDeltaTime( );
	
	/**
	 * Sets the {@link RenderListener}. The RenderListener will be called
	 * once the OpenGL surface has been setup to give it an opportunity to
	 * create all its graphic resources like textures and meshes. After the
	 * setup is complete the RenderListener will be called continuously to
	 * render new frames. When the {@link Application} is closing the RenderListener
	 * will be called one last time to clean up.
	 * 
	 * @param listener the RenderListener
	 */
	public void setRenderListener( RenderListener listener );
	
	/**
	 * Creates a new {@link Pixmap} with the specified dimensions and
	 * format.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @param format the {@link Pixmap.Format}
	 * @return a new Pixmap
	 */
	public Pixmap newPixmap( int width, int height, Pixmap.Format format );
	
	/**
	 * Creates a new {@link Pixmap} from the given InputStream which is assumed
	 * to point to a bitmap in a readable form, e.g. PNG, JPEG. The InputStream is not closed.
	 * 
	 * @param in the InputStream
	 * @return a new Pixmap or null in case the Pixmap could not be loaded
	 */
	public Pixmap newPixmap( InputStream in);
	
	/**
	 * Creates a new {@link Pixmap} from the given file which is assumed
	 * to point to a bitmap in a readable form, e.g. PNG, JPEG.
	 * 
	 * @param file the file to load the pixmap from
	 * @return a new Pixmap or null in case the Pixmap could not be loaded
	 */
	public Pixmap newPixmap( FileHandle file );
	
	/**
	 * Creates a new {@link Pixmap} from the given native pixmap. The native
	 * pixmap is an instance of BufferedImage on the desktop or Bitmap on
	 * Android. 
	 * 
	 * @param nativePixmap the native pixmap
	 * @return a new Pixmap
	 */
	public Pixmap newPixmap( Object nativePixmap );



	/**
	 * Creates a new {@link Font} from the given font name, the size and the style.
	 * The font is looked up by name in the system fonts. In case no font with that
	 * name could be found a default font is returned. The Font has to be disposed
	 * once it's no longer used via the {@link Font.dispose()} method.
	 * 
	 * @param fontName the font name
	 * @param size the size
	 * @param style the {@link Font.FontStyle}
	 * @return a new Font
	 */
	public Font newFont( String fontName, int size, Font.FontStyle style, boolean managed );
	
	/**
	 * Creates a new {@link Font} from the given file. The file must point to a true type font file.
	 * The Font has to be disposed once it's no longer used via the {@link Font.dispose()} method.
	 * 
	 * @param file the file to load the font from
	 * @param size the size
	 * @param style the {@link Font.FontStyle}
	 * @param wheter the font is managed or not.
	 * @return a new Font or null in case the Font could not be loaded
	 */
	public Font newFont( FileHandle file, int size, Font.FontStyle style, boolean managed );
	
	/**
	 * Creates a new {@link Texture} with the specified dimensions, minification
	 * and magnification filters and texture wraps in u and v. The Texture has
	 * to be disposed via the {@link Texture.dispose()} methods once it is no
	 * longer used.
	 * 
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @param format the format of the texture
	 * @param minFilter the minification {@link Texture.TextureFilter}
	 * @param magFilter the magnification {@link Texture.TextureFilter}
	 * @param uWrap the {@link Texture.TextureWrap} in u
	 * @param vWrap the {@link Texture.TextureWrap} in v
	 * @return a new Texture
	 */

	public Texture newTexture( int width, int height, Format format, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, Texture.TextureWrap uWrap, Texture.TextureWrap vWrap, boolean managed );

	public Texture newTexture(FileHandle file,  Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, Texture.TextureWrap uWrap, Texture.TextureWrap vWrap, boolean managed );
	
	public Pixmap newPixmap( String file );
	public Texture newTexture(String file, boolean managed);
	public Texture newTexture(FileHandle file, boolean managed);
	public Texture newTexture(Pixmap pixmap, boolean managed);
	
	/**
	 * Creates a new {@link Texture} from the given {@link Pixmap} using
	 * the specified minification and magnification filter and texture wraps in
	 * u and v. If the minification filter is specified as {@link Texture.TextureFilter.MipMap}
	 * mip maps will be created automatically. The Texture has
	 * to be disposed via the {@link Texture.dispose()} methods once it is no
	 * longer used. 
	 * 
	 * @param pixmap the pixmap
	 * @param minFilter the minification {@link Texture.TextureFilter}
	 * @param magFilter the magnification {@link Texture.TextureFilter}
	 * @param uWrap the {@link Texture.TextureWrap} in u
	 * @param vWrap the {@link Texture.TextureWrap} in v
	 * @return a new Texture
	 */
	public Texture newTexture( Pixmap pixmap, Texture.TextureFilter minFilter, Texture.TextureFilter magFilter, Texture.TextureWrap uWrap, Texture.TextureWrap vWrap, boolean managed );		
}
