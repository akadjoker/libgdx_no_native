package org.djoker;


import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.RenderListener;
import com.badlogic.gdx.graphics.BitmapFont;
import com.badlogic.gdx.graphics.Font;
import com.badlogic.gdx.graphics.Font.FontStyle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Sprite;
import com.badlogic.gdx.graphics.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureAtlas;
import com.badlogic.gdx.graphics.TextureAtlas.AtlasRegion;



public class MyFirstTriangle implements ApplicationListener,RenderListener {
	
	public SpriteBatch spriteBatch;
	public Texture texture;
	float angle = 0;
	float scale = 1;
	float vScale = 1;
	Font fonte;
	BitmapFont bmfont;
	TextureAtlas atlas;
	Sprite badlogic, badlogicSmall, star;
	
	
	@Override
	public void pause(Application app) {
		// TODO Auto-generated method stub
		  System.out.print("pause listner\n");
		
	}

	@Override
	public void resume(Application app) {
		// TODO Auto-generated method stub
		System.out.print("resume listner \n");
		
	}

	@Override
	public void destroy(Application app) {
		// TODO Auto-generated method stub
		System.out.print("destroy listner\n");
		
	}

	@Override
	public void surfaceCreated(Application app) 
	{
		
	    GL10 gl=app.getGraphics().getGL10();
		gl.glClear( gl.GL_COLOR_BUFFER_BIT);
		gl.glClearColor(0, 0, 1, 0);
		
		spriteBatch=new SpriteBatch();
		
		 fonte=Gdx.graphics.newFont("Arial", 22,FontStyle.Bold,false);

		  bmfont= new BitmapFont("assets/data/arial-15.fnt","assets/data/arial-15_00.png",false,false);
		 
		  atlas = new TextureAtlas("assets/data/pack");
			badlogic = atlas.createSprite("badlogicslice");
			badlogic.setPosition(50, 50);

			badlogicSmall = atlas.createSprite("badlogicsmall");
			badlogicSmall.setPosition(10, 10);

			AtlasRegion region = atlas.findRegion("badlogicsmall");
			System.out.println("badlogicSmall original size: " + region.originalWidth + ", " + region.originalHeight);
			System.out.println("badlogicSmall packed size: " + region.packedWidth + ", " + region.packedHeight);

			star = atlas.createSprite("particle-star");
			star.setPosition(10, 70);
		 
	//Pixmap map =	Gdx.graphics.newPixmap( app.getFiles().getFileHandle( "assets/data/badlogicsmall.jpg", FileType.Internal )); 
	 texture=Gdx.graphics.newTexture("assets/data/badlogicsmall.jpg",false);
	
	 //texture=Gdx.graphics.newTexture(map,false);
	 
		 
	
		  
		 
		System.out.print("surfacecreate render listner\n");
		
	}

	@Override
	public void surfaceChanged(Application app, int width, int height) {

		
	}

	@Override
	public void render(Application app) {
	
	
		
		GL10 gl=app.getGraphics().getGL10();
		
		gl.glClear( gl.GL_COLOR_BUFFER_BIT);
		gl.glClearColor(0, 0, 1, 0);
		
		

		

		spriteBatch.begin();
		
		star.draw(spriteBatch);
		
		
		//spriteBatch.draw(texture, 80, 200, 0, 0, 32, 32);
	
		star.draw(spriteBatch);
		bmfont.draw(spriteBatch, " luis santos aka djoker", 100, 100);
		
	
		spriteBatch.draw(texture, 64, 100, 32, 32, 0, 0, texture.getWidth(), texture.getHeight(), false, false);
		spriteBatch.draw(texture, 112, 10, 0, 0, texture.getWidth(), texture.getHeight());

		spriteBatch.draw(texture, 16, 58, 16, 16, 32, 32, 1, 1, angle, 0, 0, texture.getWidth(), texture.getHeight(), false, false);
		spriteBatch.draw(texture, 64, 58, 16, 16, 32, 32, scale, scale, 0, 0, 0, texture.getWidth(), texture.getHeight(), false,
			false);
		spriteBatch.draw(texture, 112, 58, 16, 16, 32, 32, scale, scale, angle, 0, 0, texture.getWidth(), texture.getHeight(),
			false, false);
		spriteBatch.draw(texture, 160, 58, 0, 0, 32, 32, scale, scale, angle, 0, 0, texture.getWidth(), texture.getHeight(), false,
			false);
			
		

		
		
		spriteBatch.draw(texture, 180, 200, 0, 0, 32, 32);
		spriteBatch.draw(texture, 180, 300, 0, 0, 32, 32);
		
		star.draw(spriteBatch);
		
		spriteBatch.end();
		
		gl.glFlush();

		
		angle += 20 * app.getGraphics().getDeltaTime();
		scale += vScale * app.getGraphics().getDeltaTime();
		if (scale > 2) {
			vScale = -vScale;
			scale = 2;
		}
		if (scale < 0) {
			vScale = -vScale;
			scale = 0;
		}
		
		
	}

	@Override
	public void dispose(Application app) {
		// TODO Auto-generated method stub
		
	}


}