package com.homework.unit.test;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;

public class Test {

	public static void open() {
		String filePath = "/Users/berryjam/git/EclipsePlugin/EclipsePlugin/src/com/homework/unit/test/Test.java";
		final IFile inputFile = ResourcesPlugin.getWorkspace().getRoot()
				.getFileForLocation(Path.fromOSString(filePath));
		if (inputFile != null) {
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			try {
				IEditorPart openEditor = IDE.openEditor(page, inputFile);

				int line = 46;
				if (openEditor instanceof ITextEditor) {
					ITextEditor textEditor = (ITextEditor) openEditor;
					IDocument document = textEditor.getDocumentProvider()
							.getDocument(textEditor.getEditorInput());
					textEditor.selectAndReveal(
							document.getLineOffset(line - 1),
							document.getLineLength(line - 1));
				}
			} catch (PartInitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
