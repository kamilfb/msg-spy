/***********************************************************************************
 * 
 * Copyright (c) 2015 Kamil Baczkowicz
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v1.0 which accompany this distribution.
 *
 * The Eclipse Public License is available at
 *    http://www.eclipse.org/legal/epl-v10.html
 *    
 * The Eclipse Distribution License is available at
 *   http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 * 
 *    Kamil Baczkowicz - initial API and implementation and/or initial documentation
 *    
 */
package pl.baczkowicz.mqspy.daemon.remote.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pl.baczkowicz.mqspy.daemon.remote.RemoteController;

public class RunScriptFunctionRequestHandler extends BaseRequestHandler
{
	/** Diagnostic logger. */
	private final static Logger logger = LoggerFactory.getLogger(RunScriptFunctionRequestHandler.class);
	
	private static final long serialVersionUID = -9204115887954866526L;
	
	public RunScriptFunctionRequestHandler(final RemoteController controller)
	{
		super(controller);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		try
		{
			resp.setStatus(HttpStatus.OK_200);
			resp.getWriter().println("Received: " + req.getParameterMap());
			
			final String scriptName = req.getParameter("name");
			final String functionName = req.getParameter("function");
			
			if (scriptName != null && functionName != null)
			{
				final String scriptLocation = controller.getScriptLocation(scriptName);
				
				if (scriptLocation == null)
				{
					resp.getWriter().println("Invalid request: file " + scriptName + " does not exist");
					return;
				}
				
				resp.getWriter().println("Attemping to run script function: " + scriptLocation + "/" + functionName);						
				final Object result = controller.getDaemon().runScriptFunction(scriptLocation, functionName, getParameterMap(req));
				
				resp.getWriter().println("Result = " + result);
			}
			else
			{		
				resp.getWriter().println("Invalid request: missing parameter 'name' and 'function'");
			}
		}
		catch (Exception e)
		{
			logger.error("Error handling the request", e);
			resp.setStatus(HttpStatus.OK_200);
			resp.getWriter().println("Invalid request: internal error");
			resp.getWriter().println(e);
		}
	}
}
