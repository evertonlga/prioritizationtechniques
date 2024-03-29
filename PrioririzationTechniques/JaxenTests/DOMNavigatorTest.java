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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.jaxen.Navigator;
import org.jaxen.dom.DocumentNavigator;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DOMNavigatorTest extends XPathTestBase
{    
    
    private DocumentBuilder builder_DOMNavigatorTest;
    
    
    public DOMNavigatorTest(String name)
    {
        super( name );
    }
    
    public Navigator getNavigator()
    {
        return new DocumentNavigator();
    }
    
    protected void setUp() throws Exception {
        super.setUp();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        builder_DOMNavigatorTest = factory.newDocumentBuilder();
    }

    public Object getDocument(String url) throws Exception
    {
        return builder_DOMNavigatorTest.parse( url );
    }
    
    public void testGetAttributeQNameOnElement() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Element a = doc.createElement("a");
        String qname = nav.getAttributeQName(a);
        assertNull(qname);
    }
    
    public void testGetElementQNameOnAttr() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttribute("a");
        String qname = nav.getElementQName(a);
        assertNull(qname);
    }
    
    public void testGetAttributeLocalNameOnElement() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Element a = doc.createElementNS("http://www.ex.com", "pre:a");
        String name = nav.getAttributeName(a);
        assertNull(name);
    }
    
    public void testGetElementLocalNameOnAttr() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.ex.com", "a");
        String name = nav.getElementName(a);
        assertNull(name);
    }
    
    public void testGetAttributeNamespaceURIOnElement() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Element a = doc.createElementNS("http://www.example.org/", "a");
        String qname = nav.getAttributeNamespaceUri(a);
        assertNull(qname);
    }
    
    public void testGetElementNamespaceURIOnAttr() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        String qname = nav.getElementNamespaceUri(a);
        assertNull(qname);
    }
    
    public void testGetTargetOfNonPI() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        try {
            nav.getProcessingInstructionTarget(a);
            fail("got target of non processing instruction");
        }
        catch (ClassCastException ex) {
            assertNotNull(ex.getMessage());
        }
    }
    
    public void testGetDataOfNonPI() {
        Navigator nav = getNavigator();
        Document doc = builder_DOMNavigatorTest.newDocument();
        Attr a = doc.createAttributeNS("http://www.element.org/", "a");
        try {
            nav.getProcessingInstructionData(a);
            fail("got data of non processing instruction");
        }
        catch (ClassCastException ex) {
            assertNotNull(ex.getMessage());
        }
    }
    
    
}
