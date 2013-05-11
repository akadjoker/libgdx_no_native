package org.djoker;

import com.badlogic.gdx.backends.desktop.JoglApplication;

public class MyFirstTriangleDesktop {
        public static void main (String[] argv)
        {
        	System.out.print("main\n");
        	JoglApplication app = new JoglApplication( "My First Triangle", 480, 320, false);
        	System.out.print("app created\n");
        	MyFirstTriangle apploop= new MyFirstTriangle();
        	app.setApplicationListener(apploop);
        	app.getGraphics().setRenderListener(apploop);
        	System.out.print("listner ok\n");
        }
}