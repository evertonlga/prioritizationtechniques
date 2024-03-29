/*
 * $Header$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 *
 * Copyright 2005 Elliotte Rusty Harold.
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

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.jaxen.BaseXPath;
import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

/**
 * @author Elliotte Rusty Harold
 *
 */
public class BooleanTest extends TestCase {

    private Document doc_BooleanTest;
    
    public void setUp() throws ParserConfigurationException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_BooleanTest = builder.newDocument();
    }


    public BooleanTest(String name) {
        super(name);
    }

    // test case for JAXEN-55
    public void testNonEmptyNodeSetsAreTrue() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean(//x)");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BooleanTest.createElementNS("", "b");
        doc_BooleanTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BooleanTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BooleanTest.createTextNode("false"));
        x3.appendChild(doc_BooleanTest.createTextNode("false"));
        x4.appendChild(doc_BooleanTest.createTextNode("false"));
        
        List result = xpath.selectNodes(doc_BooleanTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
        
    }    

    public void testEmptyNodeSetsAreFalse() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean(//y)");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        org.w3c.dom.Element b = doc_BooleanTest.createElementNS("", "b");
        doc_BooleanTest.appendChild(a);
        a.appendChild(b);
        org.w3c.dom.Element x2 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_BooleanTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_BooleanTest.createElementNS("", "x");
        a.appendChild(x4);
        b.appendChild(x2);
        b.appendChild(x3);
        x2.appendChild(doc_BooleanTest.createTextNode("false"));
        x3.appendChild(doc_BooleanTest.createTextNode("false"));
        x4.appendChild(doc_BooleanTest.createTextNode("false"));
        
        List result = xpath.selectNodes(doc_BooleanTest);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
        
    }    

    public void testZeroIsFalse() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean(0)");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
        
    }    

    public void testEmptyStringIsFalse() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean('')");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.FALSE, result.get(0));
        
    }    

    public void testNaNIsFalse() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean(0 div 0)");
        Object result = xpath.evaluate(null);
        assertEquals(Boolean.FALSE, result);
        
    }    

    public void testNonEmptyStringIsTrue() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean('false')");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        
        List result = xpath.selectNodes(a);
        assertEquals(1, result.size());
        assertEquals(Boolean.TRUE, result.get(0));
        
    }    

    public void testBooleanFunctionRequiresOneArgument() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean()");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        
        try {
            xpath.selectNodes(a);
            fail("Allowed boolean function with no arguments");
        }
        catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
        
    }    

    public void testBooleanFunctionRequiresExactlyOneArgument() 
      throws JaxenException {
        
        BaseXPath xpath = new DOMXPath("boolean('', '')");
        org.w3c.dom.Element a = doc_BooleanTest.createElementNS("", "a");
        
        try {
            xpath.selectNodes(a);
            fail("Allowed boolean function with two arguments");
        }
        catch (FunctionCallException ex) {
            assertNotNull(ex.getMessage());
        }
        
    }    

}
