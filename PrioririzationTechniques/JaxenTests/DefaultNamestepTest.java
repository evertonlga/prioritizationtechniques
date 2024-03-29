/*
 * $Header$
 * $Revision: 1287 $
 * $Date: 2007-04-16 08:56:54 -0700 (Mon, 16 Apr 2007) $
 *
 * ====================================================================
 *
 * Copyright 2007 Elliotte Rusty Harold
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
 * $Id: DefaultNamestepTest.java 1287 2007-04-16 15:56:54Z elharo $
 */

package org.jaxen.test;

import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import junit.framework.TestCase;

import org.jaxen.JaxenException;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;

/**
 * @author Elliotte Rusty Harold
 *
 */
public class DefaultNamestepTest extends TestCase {

    private Document doc_DefaultNamestepTest;
    
    public void setUp() throws ParserConfigurationException
    {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc_DefaultNamestepTest = builder.newDocument();
    }


    public DefaultNamestepTest(String name) {
        super(name);
    }


    public void testIdentitySetUsageInDefaultNameStep() 
      throws JaxenException {
        
        XPath xpath = new DOMXPath("/a/x/preceding-sibling::x[last()]");
        org.w3c.dom.Element a = doc_DefaultNamestepTest.createElementNS("", "a");
        doc_DefaultNamestepTest.appendChild(a);
        org.w3c.dom.Element x1 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x2 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x3 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x4 = doc_DefaultNamestepTest.createElementNS("", "x");
        org.w3c.dom.Element x5 = doc_DefaultNamestepTest.createElementNS("", "x");
        a.appendChild(x1);
        a.appendChild(x2);
        a.appendChild(x3);
        a.appendChild(x4);
        a.appendChild(x5);
        x1.appendChild(doc_DefaultNamestepTest.createTextNode("1"));
        x2.appendChild(doc_DefaultNamestepTest.createTextNode("2"));
        x3.appendChild(doc_DefaultNamestepTest.createTextNode("3"));
        x4.appendChild(doc_DefaultNamestepTest.createTextNode("4"));
        x5.appendChild(doc_DefaultNamestepTest.createTextNode("5"));
        
        List result = xpath.selectNodes(doc_DefaultNamestepTest);
        assertEquals(1, result.size());
        assertEquals(x1, result.get(0));
        
    }
    
}
