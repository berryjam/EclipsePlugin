package com.homework.plugin.first.handlers;

import java.io.IOException;

import javax.swing.JFrame;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.homework.ui.GUI;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) {
		String path = "/Users/berryjam/Tsinghua/软件体系结构/大作业相关/doxygen+ubigraph+GUI/";

		Process process = null;
		try {
			// process = Runtime.getRuntime().exec("chmod 777 " + path +
			// "gui.py");
			// process.waitFor();
			process = Runtime.getRuntime().exec("python " + path + "gui.py");
			Thread.sleep(20000);
			// GUI.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
