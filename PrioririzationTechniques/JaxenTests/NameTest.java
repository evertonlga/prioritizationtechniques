/*
 * $Header$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 *
 * Copyright 2005 Elliotte Rusty Harold
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

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.jaxen.FunctionCallException;
import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Attr;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * @author Elliotte Rusty Harold
 *
 */
public class NameTest extends TestCase {

    private Document doc_NameTest;
    
    public void setUp() throws ParserConfigurationException, SAXException, IOException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_NameTest = builder.parse( "xml/basic.xml" );
    }


    public NameTest(String name) {
        super(name);
    }

    public void testNameOfNumber() throws JaxenException
    {
        try
        {
            XPath xpath = new DOMXPath( "name(3)" );
            xpath.selectNodes( doc_NameTest );
            fail("name of non-node-set");
        }
        catch (FunctionCallException e) 
        {
           assertEquals("The argument to the name function must be a node-set", e.getMessage());
        }
    }    

    public void testNameWithTwoArguments() throws JaxenException
    {
        try
        {
            XPath xpath = new DOMXPath( "name(/*, //*)" );
            xpath.selectNodes( doc_NameTest );
            fail("name with two arguments");
        }
        catch (FunctionCallException e) 
        {
           assertEquals("name() requires zero or one argument.", e.getMessage());
        }
    }    

    public void testNameAllowsNoArguments() throws JaxenException
    {
        XPath xpath = new DOMXPath( "name()" );
        String result = (String) xpath.evaluate( doc_NameTest.getDocumentElement() );
        assertEquals("foo", result);
    }    

    public void testNameOfCommentIsEmptyString() throws JaxenException
    {
        XPath xpath = new DOMXPath( "name(/comment())" );
        Comment c = doc_NameTest.createComment("test");
        doc_NameTest.appendChild(c);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("", result);
    }    

    public void testNameOfProcessingInstructionIsTarget() throws JaxenException
    {
        XPath xpath = new DOMXPath( "name(/processing-instruction())" );
        ProcessingInstruction pi = doc_NameTest.createProcessingInstruction("target", "value");
        doc_NameTest.appendChild(pi);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("target", result);
    }    

    public void testNameOfAttribute() throws JaxenException
    {
        XPath xpath = new DOMXPath( "name(/*/@*)" );
        Attr a = doc_NameTest.createAttribute("name");
        doc_NameTest.getDocumentElement().setAttributeNode(a);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("name", result);
    }    

    public void testNameOfTextIsEmptyString() throws JaxenException
    {
        XPath xpath = new DOMXPath( "name(/*/text())" );
        Text c = doc_NameTest.createTextNode("test");
        doc_NameTest.getDocumentElement().appendChild(c);
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("", result);
    }    

    public void testNameOfNamespaceIsPrefix() throws JaxenException
    {
        XPath xpath = new DOMXPath( "name(/*/namespace::node())" );
        String result = (String) xpath.evaluate(doc_NameTest);
        assertEquals("xml", result);
    }    

    public void testNameNoArguments()
    {
        try
        {
            XPath xpath = new DOMXPath( "name()" );
            List results = xpath.selectNodes( doc_NameTest );
            assertEquals("", results.get(0));
       }
       catch (Exception e)
        {
            e.printStackTrace();
            fail( e.getMessage() );
        }
    }    

}
