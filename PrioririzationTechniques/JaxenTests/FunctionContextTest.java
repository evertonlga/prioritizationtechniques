/*
 * $Header$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 *
 * Copyright 2000-2002 bob mcwhirter & James Strachan.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 * 
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 * 
 *   * Neither the name of the Jaxen Project nor the names of its
 *     contributors may be used to endorse or promote products derived 
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 * OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * ====================================================================
 * This software consists of voluntary contributions made by many 
 * individuals on behalf of the Jaxen Project and was originally 
 * created by bob mcwhirter <bob@werken.com> and 
 * James Strachan <jstrachan@apache.org>.  For more information on the 
 * Jaxen Project, please see <http://www.jaxen.org/>.
 * 
 * $Id$
 */



package org.jaxen.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jaxen.FunctionContext;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.UnresolvableException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import junit.framework.TestCase;

/**
 * <p>
 *  Test for function context.
 * </p>
 * 
 * @author Elliotte Rusty Harold
 * @version 1.1b9
 *
 */
public class FunctionContextTest extends TestCase
{

    private Document doc_FunctionContextTest;
    
    public void setUp() throws ParserConfigurationException {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        doc_FunctionContextTest = factory.newDocumentBuilder().newDocument();
        Element root = doc_FunctionContextTest.createElementNS("http://www.example.org/", "root");
        doc_FunctionContextTest.appendChild(root);
        root.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", "http://www.example.org/");
              
    }
    
    public void testJAXEN50() throws JaxenException {
        
        DOMXPath xpath = new DOMXPath("true()");
        
        SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
        // Add all namespace declarations from the node
        nsContext.addElementNamespaces(xpath.getNavigator(), doc_FunctionContextTest);
        xpath.setNamespaceContext(nsContext);
        
        boolean result = xpath.booleanValueOf(doc_FunctionContextTest);
        assertTrue(result);
        
    }
 
    public void testUnresolvableFunction() throws JaxenException {
        
        DOMXPath xpath = new DOMXPath("nonesuch()");
        
        try {
            xpath.evaluate(doc_FunctionContextTest);
            fail("Evaluated nonexistent function");
        }
        catch (UnresolvableException ex) {
            assertNotNull(ex.getMessage());
        }
        
    }
 
    public void testUnresolvableFunctionExceptionMessage() throws JaxenException {
        
        DOMXPath xpath = new DOMXPath("nonesuch()");
        
        try {
            xpath.evaluate(doc_FunctionContextTest);
            fail("Evaluated nonexistent function");
        }
        catch (UnresolvableException ex) {
            assertEquals(-1, ex.getMessage().indexOf(':'));
        }
        
    }
 
    public void testGetFunctionContext() throws JaxenException {      
        DOMXPath xpath = new DOMXPath("/root/child");
        assertNotNull(xpath.getFunctionContext());
    }
 
    public void testSerializeFunctionContext() throws JaxenException, IOException { 
        
        DOMXPath xpath = new DOMXPath("/root/child");
        FunctionContext context = xpath.getFunctionContext();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(out);
        try {
            oout.writeObject(context);
            fail("serialized function context");
        }
        catch (NotSerializableException ex) {
            assertNotNull(ex.getMessage());
        }
        
    }
 
}
