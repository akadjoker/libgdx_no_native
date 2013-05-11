package com.badlogic.gdx.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.NumberUtils;
/**
 * A color class, holding the r, g, b and alpha component
 * as floats in the range [0,1].
 * 
 * @author mzechner
 *
 */
public class Color 
{
	public static final Color CLEAR = new Color(0, 0, 0, 0);
	public static final Color WHITE = new Color(1, 1, 1, 1);
	public static final Color white = new Color(1, 1, 1, 1);
	public static final Color BLACK = new Color(0, 0, 0, 1);
	public static final Color RED = new Color(1, 0, 0, 1);
	public static final Color GREEN = new Color(0, 1, 0, 1);
	public static final Color BLUE = new Color(0, 0, 1, 1);
	public static final Color LIGHT_GRAY = new Color(0.75f, 0.75f, 0.75f, 1);
	public static final Color GRAY = new Color(0.5f, 0.5f, 0.5f, 1);
	public static final Color DARK_GRAY = new Color(0.25f, 0.25f, 0.25f, 1);
	public static final Color PINK = new Color(1, 0.68f, 0.68f, 1);
	public static final Color ORANGE = new Color(1, 0.78f, 0, 1);
	public static final Color YELLOW = new Color(1, 1, 0, 1);
	public static final Color MAGENTA = new Color(1, 0, 1, 1);
	public static final Color CYAN = new Color(0, 1, 1, 1);
	
	/** the red, green, blue and alpha components **/
	public float r, g, b, a;
	
	public Color()
	{
		
		this(1,1,1,1);
	}
	/**
	 * Constructor, sets the components of the color
	 * @param r the red component
	 * @param g the green component
	 * @param b the blue component
	 * @param a the alpha component
	 */
	
	public Color( float r, float g, float b, float a )
	{
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public void bind() 
	{
	Gdx.gl10.glColor4f(r,g,b,a);
	}
	/**
	 * Constructs a new color using the given color
	 * @param color the color
	 */
	public Color( Color color )
	{
		set( color );
	}
	
	/**
	 * Sets this color to the given color.
	 * @param color the Color
	 */
	public Color set( Color color )
	{
		this.r = color.r;
		this.g = color.g;
		this.b = color.b;
		this.a = color.a;
		return this;
	}
	
	/**
	 * Multiplies the this color and the given color
	 * @param color the color
	 * @return this color.
	 */
	public Color mul( Color color )
	{
		this.r *= color.r;
		this.g *= color.g;
		this.b *= color.b;
		this.a *= color.a;
		return this;
	}
	
	/** Packs the four color components which should be in the range 0-255 into a 32-bit. Note that no range checking is performed
	 * for higher performance.
	 * 
	 * @param r the red component, 0 - 255
	 * @param g the green component, 0 - 255
	 * @param b the blue component, 0 - 255
	 * @param a the alpha component, 0 - 255
	 * @return the packed color as a 32-bit int */
	public static int toIntBits (int r, int g, int b, int a) {
		return (a << 24) | (b << 16) | (g << 8) | r;
	}

	/** Packs the 4 components of this color into a 32-bit int and returns it as a float.
	 * 
	 * @return the packed color as a 32-bit float */
	public float toFloatBits () {
		int color = ((int)(255 * a) << 24) | ((int)(255 * b) << 16) | ((int)(255 * g) << 8) | ((int)(255 * r));
		return NumberUtils.intToFloatColor(color);
	}

	/** Packs the 4 components of this color into a 32-bit int.
	 * 
	 * @return the packed color as a 32-bit int. */
	public int toIntBits () {
		int color = ((int)(255 * a) << 24) | ((int)(255 * b) << 16) | ((int)(255 * g) << 8) | ((int)(255 * r));
		return color;
	}

	/** Packs the 4 components of this color into a 32-bit int and returns it as a float.
	 * 
	 * @return the packed color as a 32-bit float */
	public static float toFloatBits (float r, float g, float b, float a) {
		int color = ((int)(255 * a) << 24) | ((int)(255 * b) << 16) | ((int)(255 * g) << 8) | ((int)(255 * r));
		return NumberUtils.intToFloatColor(color);
	}

}
