/******************************************************************************* 
 * Copyright (c) 2019 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/
package org.jboss.tools.quarkus.lsp4e.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IOpenable;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.lsp4j.Range;
import com.redhat.quarkus.jdt.core.IJDTUtils;

public class JDTUtilsImpl implements IJDTUtils {
	private static final IJDTUtils INSTANCE = new JDTUtilsImpl();

	public static IJDTUtils getInstance() {
		return INSTANCE;
	}

	private JDTUtilsImpl() {
	}
	
	@Override
	public ICompilationUnit resolveCompilationUnit(String uriString) {
		return JDTUtils.resolveCompilationUnit(uriString);
	}
	public IClassFile resolveClassFile(String uriString) {
		return JDTUtils.resolveClassFile(uriString);
	}

	@Override
	public boolean isHiddenGeneratedElement(IJavaElement element) {
		return JDTUtils.isHiddenGeneratedElement(element);
	}

	@Override
	public Range toRange(IOpenable openable, int offset, int length) throws JavaModelException {
		return JDTUtils.toRange(openable, offset, length);
	}

	@Override
	public String toClientUri(String uri) {
		return ResourceUtils.toClientUri(uri);
	}

	@Override
	public String toUri(ITypeRoot typeRoot) {
		return JDTUtils.toUri(typeRoot);
	}

	@Override
	public void waitForLifecycleJobs(IProgressMonitor monitor) {
		/*try {
			Job.getJobManager().join(DocumentLifeCycleHandler.DOCUMENT_LIFE_CYCLE_JOBS, monitor);
		} catch (OperationCanceledException ignorable) {
			// No need to pollute logs when query is cancelled
		} catch (Exception e) {
			QuarkusLSPPlugin.logException(e.getMessage(), e);
		}*/
		//TODO: verify we need to synchronise on jobs
	}



}
