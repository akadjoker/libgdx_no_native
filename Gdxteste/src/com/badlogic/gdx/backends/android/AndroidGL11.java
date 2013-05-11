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

import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

import javax.microedition.khronos.opengles.GL10;

import com.badlogic.gdx.graphics.GL11;

/**
 * An implementation of the {@link GL11} interface for Android
 * 
 * @author mzechner
 *
 */
final class AndroidGL11 extends AndroidGL10 implements GL11
{
	private final javax.microedition.khronos.opengles.GL11 gl;
			
	public AndroidGL11(GL10 gl) 
	{
		super(gl);	
		this.gl = (javax.microedition.khronos.opengles.GL11)gl;		
	}

	@Override
	public void glBindBuffer(int target, int buffer) 
	{	
		gl.glBindBuffer( target, buffer );
	}

	@Override
	public void glBufferData(int target, int size, Buffer data, int usage) 
	{	
		gl.glBufferData( target, size, data, usage );
	}

	@Override
	public void glBufferSubData(int target, int offset, int size, Buffer data) 
	{	
		gl.glBufferSubData( target, offset, size, data );
	}

	@Override
	public void glClipPlanef(int plane, FloatBuffer equation) 
	{	
		gl.glClipPlanef( plane, equation );
	}

	@Override
	public void glClipPlanex(int plane, IntBuffer equation) 
	{	
		gl.glClipPlanex( plane, equation );
	}

	@Override
	public void glColor4ub(byte red, byte green, byte blue, byte alpha) 
	{	
		gl.glColor4ub( red, green, blue, alpha );
	}

	@Override
	public void glDeleteBuffers(int n, IntBuffer buffers) 
	{	
		gl.glDeleteBuffers( n, buffers );
	}

	@Override
	public void glGenBuffers(int n, IntBuffer buffers) 
	{	
		gl.glGenBuffers( n, buffers );
	}

	@Override
	public void glGetBooleanv(int pname, IntBuffer params) 
	{	
		gl.glGetBooleanv( pname, params );
	}

	@Override
	public void glGetBufferParameteriv(int target, int pname, IntBuffer params) 
	{	
		gl.glGetBufferParameteriv( target, pname, params );
	}

	@Override
	public void glGetClipPlanef(int pname, FloatBuffer eqn) 
	{	
		gl.glGetClipPlanef( pname, eqn );
	}

	@Override
	public void glGetClipPlanex(int pname, IntBuffer eqn) 
	{
		gl.glGetClipPlanex( pname, eqn );
	}

	@Override
	public void glGetFixedv(int pname, IntBuffer params) 
	{	
		gl.glGetFixedv( pname, params );
	}

	@Override
	public void glGetFloatv(int pname, FloatBuffer params) 
	{	
		gl.glGetFloatv( pname, params );
	}

	@Override
	public void glGetLightfv(int light, int pname, FloatBuffer params) 
	{	
		gl.glGetLightfv( light, pname, params );
	}

	@Override
	public void glGetLightxv(int light, int pname, IntBuffer params) 
	{	
		gl.glGetLightxv( light, pname, params );
	}

	@Override
	public void glGetMaterialfv(int face, int pname, FloatBuffer params) 
	{	
		gl.glGetMaterialfv( face, pname, params );
	}

	@Override
	public void glGetMaterialxv(int face, int pname, IntBuffer params) 
	{	
		gl.glGetMaterialxv( face, pname, params );
	}

	@Override
	public void glGetPointerv(int pname, Buffer[] params) 
	{	
		gl.glGetPointerv( pname, params );
	}

	@Override
	public void glGetTexEnviv(int env, int pname, IntBuffer params) 
	{	
		gl.glGetTexEnviv( env, pname, params );
	}

	@Override
	public void glGetTexEnvxv(int env, int pname, IntBuffer params) 
	{	
		gl.glGetTexEnvxv( env, pname, params );
	}

	@Override
	public void glGetTexParameterfv(int target, int pname, FloatBuffer params) 
	{	
		gl.glGetTexParameterfv( target, pname, params );
	}

	@Override
	public void glGetTexParameteriv(int target, int pname, IntBuffer params) 
	{	
		gl.glGetTexParameteriv( target, pname, params );
	}

	@Override
	public void glGetTexParameterxv(int target, int pname, IntBuffer params) 
	{	
		gl.glGetTexParameterxv( target, pname, params );
	}

	@Override
	public boolean glIsBuffer(int buffer) 
	{	
		return gl.glIsBuffer( buffer );
	}

	@Override
	public boolean glIsEnabled(int cap) 
	{
		return gl.glIsEnabled( cap );
	}

	@Override
	public boolean glIsTexture(int texture) 
	{	
		return gl.glIsTexture( texture );
	}

	@Override
	public void glPointParameterf(int pname, float param) 
	{	
		gl.glPointParameterf( pname, param );
	}

	@Override
	public void glPointParameterfv(int pname, FloatBuffer params) 
	{	
		gl.glPointParameterfv( pname, params );
	}

	@Override
	public void glPointParameterx(int pname, int param) 
	{	
		gl.glPointParameterx( pname, param );
	}

	@Override
	public void glPointParameterxv(int pname, IntBuffer params) 
	{	
		gl.glPointParameterxv( pname, params );
	}

	@Override
	public void glPointSizePointerOES(int type, int stride, Buffer pointer) 
	{	
		gl.glPointSizePointerOES( type, stride, pointer );
	}

	@Override
	public void glTexEnvi(int target, int pname, int param) 
	{	
		gl.glTexEnvi( target, pname, param );
	}

	@Override
	public void glTexEnviv(int target, int pname, IntBuffer params) 
	{	
		gl.glTexEnviv( target, pname, params );
	}

	@Override
	public void glTexParameterfv(int target, int pname, FloatBuffer params) 
	{	
		gl.glTexParameterfv( target, pname, params );
	}

	@Override
	public void glTexParameteri(int target, int pname, int param) 
	{	
		gl.glTexParameteri( target, pname, param );
	}

	@Override
	public void glTexParameteriv(int target, int pname, IntBuffer params) 
	{	
		gl.glTexParameteriv( target, pname, params );
	}

	@Override
	public void glTexParameterxv(int target, int pname, IntBuffer params) 
	{	
		gl.glTexParameterxv( target, pname, params );
	}

	@Override
	public void glClipPlanef(int plane, float[] equation, int offset) 
	{	
		gl.glClipPlanef( plane, equation, offset );
	}

	@Override
	public void glClipPlanex(int plane, int[] equation, int offset) 
	{
		gl.glClipPlanex( plane, equation, offset );
	}

	@Override
	public void glDeleteBuffers(int n, int[] buffers, int offset) 
	{	
		gl.glDeleteBuffers( n, buffers, offset );
	}

	@Override
	public void glGenBuffers(int n, int[] buffers, int offset) 
	{	
		gl.glGenBuffers( n, buffers, offset );
	}

	@Override
	public void glGetBooleanv(int pname, boolean[] params, int offset) 
	{		
		gl.glGetBooleanv( pname, params, offset );
	}

	@Override
	public void glGetBufferParameteriv(int target, int pname, int[] params,
			int offset) 
	{
		gl.glGetBufferParameteriv( target, pname, params, offset );		
	}

	@Override
	public void glGetClipPlanef(int pname, float[] eqn, int offset) 
	{	
		gl.glGetClipPlanef( pname, eqn, offset );
	}

	@Override
	public void glGetClipPlanex(int pname, int[] eqn, int offset) 
	{	
		gl.glGetClipPlanex( pname, eqn, offset );
	}

	@Override
	public void glGetFixedv(int pname, int[] params, int offset) 
	{
		gl.glGetFixedv( pname, params, offset );
	}

	@Override
	public void glGetFloatv(int pname, float[] params, int offset) 
	{	
		gl.glGetFloatv( pname, params, offset );
	}

	@Override
	public void glGetLightfv(int light, int pname, float[] params, int offset) 
	{	
		gl.glGetLightfv( light, pname, params, offset );
	}

	@Override
	public void glGetLightxv(int light, int pname, int[] params, int offset) 
	{	
		gl.glGetLightxv( light, pname, params, offset );
	}

	@Override
	public void glGetMaterialfv(int face, int pname, float[] params, int offset) 
	{	
		gl.glGetMaterialfv( face, pname, params, offset );
	}

	@Override
	public void glGetMaterialxv(int face, int pname, int[] params, int offset) 
	{	
		gl.glGetMaterialxv( face, pname, params, offset );
	}

	@Override
	public void glGetTexEnviv(int env, int pname, int[] params, int offset) 
	{	
		gl.glGetTexEnviv( env, pname, params, offset );
	}

	@Override
	public void glGetTexEnvxv(int env, int pname, int[] params, int offset) 
	{	
		gl.glGetTexEnvxv( env, pname, params, offset );
	}

	@Override
	public void glGetTexParameterfv(int target, int pname, float[] params,
			int offset) 
	{	
		gl.glGetTexParameterfv( target, pname, params, offset );
	}

	@Override
	public void glGetTexParameteriv(int target, int pname, int[] params,
			int offset) 
	{	
		gl.glGetTexParameteriv( target, pname, params, offset );
	}

	@Override
	public void glGetTexParameterxv(int target, int pname, int[] params,
			int offset) 
	{	
		gl.glGetTexParameterxv( target, pname, params, offset );
	}

	@Override
	public void glPointParameterfv(int pname, float[] params, int offset) 
	{	
		gl.glPointParameterfv( pname, params, offset );
	}

	@Override
	public void glPointParameterxv(int pname, int[] params, int offset) 
	{	
		gl.glPointParameterxv( pname, params, offset );
	}

	@Override
	public void glTexEnviv(int target, int pname, int[] params, int offset) 
	{	
		gl.glTexEnviv( target, pname, params, offset );
	}

	@Override
	public void glTexParameterfv(int target, int pname, float[] params,
			int offset) 
	{	
		gl.glTexParameterfv( target, pname, params, offset );
	}

	@Override
	public void glTexParameteriv(int target, int pname, int[] params, int offset) 
	{	
		gl.glTexParameteriv( target, pname, params, offset );
	}

	@Override
	public void glTexParameterxv(int target, int pname, int[] params, int offset) 
	{	
		gl.glTexParameterxv( target, pname, params, offset );
	}

	@Override
	public void glColorPointer(int size, int type, int stride, int pointer) 
	{	
		gl.glColorPointer( size, type, stride, pointer );
	}

	@Override
	public void glNormalPointer( int type, int stride, int pointer) 
	{
		gl.glNormalPointer( type, stride, pointer );
	}

	@Override
	public void glTexCoordPointer(int size, int type, int stride, int pointer) 
	{	
		gl.glTexCoordPointer( size, type, stride, pointer );
	}

	@Override
	public void glVertexPointer(int size, int type, int stride, int pointer) 
	{	
		gl.glVertexPointer( size, type, stride, pointer );
	}
	
	@Override
	public void glDrawElements( int mode, int count, int type, int indices )
	{
		gl.glDrawElements( mode, count, type, indices );
	}
}
