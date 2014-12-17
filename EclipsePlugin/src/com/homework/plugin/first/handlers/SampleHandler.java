package com.homework.plugin.first.handlers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;

import com.homework.showfunctionclassinfo.Delegation;

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
			process = Runtime.getRuntime().exec("chmod 777 " + path + "gui.py");
			process = Runtime.getRuntime().exec("python " + path + "gui.py");
			Thread.sleep(20000);
			BufferedReader br = new BufferedReader(new FileReader(new File(path
					+ "type.txt")));
			int type = Integer.parseInt(br.readLine());
			Delegation.run(type);
			br.close();
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
