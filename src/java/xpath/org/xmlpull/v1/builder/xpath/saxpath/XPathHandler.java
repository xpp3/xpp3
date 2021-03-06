/*
 * $Header: /l/extreme/cvspub/XPP3/java/src/java/xpath/org/xmlpull/v1/builder/xpath/saxpath/XPathHandler.java,v 1.1 2004/06/16 15:55:43 aslom Exp $
 * $Revision: 1.1 $
 * $Date: 2004/06/16 15:55:43 $
 *
 * ====================================================================
 *
 * Copyright (C) 2000-2002 werken digital.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions, and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions, and the disclaimer that follows 
 *    these conditions in the documentation and/or other materials 
 *    provided with the distribution.
 *
 * 3. The name "SAXPath" must not be used to endorse or promote products
 *    derived from this software without prior written permission.  For
 *    written permission, please contact license@saxpath.org.
 * 
 * 4. Products derived from this software may not be called "SAXPath", nor
 *    may "SAXPath" appear in their name, without prior written permission
 *    from the SAXPath Project Management (pm@saxpath.org).
 * 
 * In addition, we request (but do not require) that you include in the 
 * end-user documentation provided with the redistribution and/or in the 
 * software itself an acknowledgement equivalent to the following:
 *     "This product includes software developed by the
 *      SAXPath Project (http://www.saxpath.org/)."
 * Alternatively, the acknowledgment may be graphical using the logos 
 * available at http://www.saxpath.org/
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE SAXPath AUTHORS OR THE PROJECT
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * ====================================================================
 * This software consists of voluntary contributions made by many 
 * individuals on behalf of the SAXPath Project and was originally 
 * created by bob mcwhirter <bob@werken.com> and 
 * James Strachan <jstrachan@apache.org>.  For more information on the 
 * SAXPath Project, please see <http://www.saxpath.org/>.
 * 
 * $Id: XPathHandler.java,v 1.1 2004/06/16 15:55:43 aslom Exp $
 */



package org.xmlpull.v1.builder.xpath.saxpath;

/** Interface for event-based XPath parsing.
 *
 *  <p>
 *  A {@link XPathReader} generates callbacks into
 *  an <code>XPathHandler</code> to allow for custom
 *  handling of the parse.
 *  </p>
 *
 *  <p>
 *  The callbacks very closely match the productions
 *  listed in the W3C XPath specification.  Gratuitous
 *  productions (ie, Expr/startExpr()/endExpr())are not
 *  included in this API.
 *  </p>
 *
 *  @author bob mcwhirter (bob@werken.com)
 */
public interface XPathHandler
{
    /** Receive notification of the start of an XPath expression parse.
     */
    void startXPath() throws SAXPathException;

    /** Receive notification of the end of an XPath expression parse.
     */
    void endXPath() throws SAXPathException;

    /** Receive notification of the start of a path expression.
     */
    void startPathExpr() throws SAXPathException;

    /** Receive notification of the end of a path expression.
     */
    void endPathExpr() throws SAXPathException;

    /** Receive notification of the start of an absolute location path expression.
     */
    void startAbsoluteLocationPath() throws SAXPathException;

    /** Receive notification of the end of an absolute location path expression.
     */
    void endAbsoluteLocationPath() throws SAXPathException;

    /** Receive notification of the start of a relative location path expression.
     */
    void startRelativeLocationPath() throws SAXPathException;

    /** Receive notification of the end of a relative location path expression.
     */
    void endRelativeLocationPath() throws SAXPathException;

    /** Receive notification of the start of a name step.
     *
     *  @param axis The axis of this step.
     *  @param prefix The namespace prefix for the name to test,
     *         or the empty-string if no prefix is specified.
     *  @param localName The local part of the name to test.
     */
    void startNameStep(int axis,
                       String prefix,
                       String localName) throws SAXPathException;

    /** Receive notification of the end of a NameStep
     */
    void endNameStep() throws SAXPathException;

    /** Receive notification of the start of a text() step.
     *
     *  @param axis The axis of this step. 
     */
    void startTextNodeStep(int axis) throws SAXPathException;

    /** Receive notification of the end of a text() step.
     */
    void endTextNodeStep() throws SAXPathException;

    /** Receive notification of the start of a comment() step.
     *
     *  @param axis The axis of this step.
     */
    void startCommentNodeStep(int axis) throws SAXPathException;

    /** Receive notification of the end of a comment() step.
     */
    void endCommentNodeStep() throws SAXPathException;

    /** Receive notification of the start of a node() step.
     *
     *  @param axis The axis of this step.
     */
    void startAllNodeStep(int axis) throws SAXPathException;

    /** Receive notification of the end of a node() step.
     */
    void endAllNodeStep() throws SAXPathException;

    /** Receive notification of the start of a processing-instruction(...) step.
     *
     *  @param axis The axis of this step.
     *  @param name The name of the processing-instruction, of
     *         the empty-string if none is specified.
     */
    void startProcessingInstructionNodeStep(int axis,
                                            String name) throws SAXPathException;

    /** Receive notification of the end of a processing-instruction(...) step.
     */
    void endProcessingInstructionNodeStep() throws SAXPathException;

    /** Receive notification of the start of a predicate.
     */
    void startPredicate() throws SAXPathException;

    /** Receive notification of the end of a predicate.
     */
    void endPredicate() throws SAXPathException;

    /** Receive notification of the start of a filter expression.
     */
    void startFilterExpr() throws SAXPathException;

    /** Receive notification of the end of a filter expression.
     */
    void endFilterExpr() throws SAXPathException;

    /** Receive notification of the start of an 'or' expression.
     */
    void startOrExpr() throws SAXPathException;

    /** Receive notification of the end of an 'or' expression.
     *
     *  @param create Flag that indicates if this expression
     *         should truly be instantiated, or if it was just
     *         a pass-through, based upon the grammar productions.
     */
    void endOrExpr(boolean create) throws SAXPathException;

    /** Receive notification of the start of an 'and' expression.
     */
    void startAndExpr() throws SAXPathException;

    /** Receive notification of the end of an 'and' expression.
     *
     *  @param create Flag that indicates if this expression
     *         should truly be instantiated, or if it was just
     *         a pass-through, based upon the grammar productions.
     */
    void endAndExpr(boolean create) throws SAXPathException;

    /** Receive notification of the start of an equality ('=' or '!=') expression.
     */
    void startEqualityExpr() throws SAXPathException;

    /** Receive notification of the end of an equality ('=' or '!=') expression.
     *
     *  @param operator The operator specific to this particular
     *         equality expression.  If null, this expression
     *         is only a pass-through, and should not actually
     *         be instantiated.
     */
    void endEqualityExpr(int equalityOperator) throws SAXPathException;

    /** Receive notification of the start of a relational ('<', '>', '<=', or '>=') expression.
     */
    void startRelationalExpr() throws SAXPathException;

    /** Receive notification of the start of a relational ('<', '>', '<=', or '>=') expression.
     *
     *  @param operator The operator specific to this particular
     *         relational expression.  If null, this expression
     *         is only a pass-through, and should not actually
     *         be instantiated.
     */
    void endRelationalExpr(int relationalOperator) throws SAXPathException;

    /** Receive notification of the start of an additive ('+' or '-') expression.
     */
    void startAdditiveExpr() throws SAXPathException;

    /** Receive notification of the end of an additive ('+' or '-') expression.
     *
     *  @param operator The operator specific to this particular
     *         additive expression.  If null, this expression
     *         is only a pass-through, and should not actually
     *         be instantiated.
     */
    void endAdditiveExpr(int additiveOperator) throws SAXPathException;

    /** Receive notification of the start of a multiplicative ('*', 'div' or 'mod') expression.
     */
    void startMultiplicativeExpr() throws SAXPathException;

    /** Receive notification of the start of a multiplicative ('*', 'div' or 'mod') expression.
     *
     *  @param operator The operator specific to this particular
     *         multiplicative expression.  If null, this expression
     *         is only a pass-through, and should not actually
     *         be instantiated.
     */
    void endMultiplicativeExpr(int multiplicativeOperator) throws SAXPathException;

    /** Receive notification of the start of a unary ('+' or '-') expression.
     */
    void startUnaryExpr() throws SAXPathException;

    /** Receive notification of the end of a unary ('+' or '-') expression.
     *
     *  @param operator The operator specific to this particular
     *         unary expression. If null, this expression is only
     *         a pass-through, and should not actually be instantiated.
     *         If not {@link Operator#NO_OP}, it'll always be {@link Operator#NEGATIVE}.
     */
    void endUnaryExpr(int unaryOperator) throws SAXPathException;

    /** Receive notification of the start of a union ('|') expression.
     */
    void startUnionExpr() throws SAXPathException;

    /** Receive notification of the end of a union ('|') expression.
     *
     *  @param create Flag that indicates if this expression
     *         should truly be instantiated, or if it was just
     *         a pass-through, based upon the grammar productions.
     */
    void endUnionExpr(boolean create) throws SAXPathException;

    /** Receive notification of a number expression.
     *
     *  @param number The number value.
     */
    void number(int number) throws SAXPathException;

    /** Receive notification of a number expression.
     *
     *  @param number The number value.
     */
    void number(double number) throws SAXPathException;

    /** Receive notification of a literal expression.
     *
     *  @param literal The string literal value.
     */
    void literal(String literal) throws SAXPathException;

    /** Receive notification of a variable-reference expression.
     *
     *  @param prefix The ns-uri prefix of the variable.
     *  @param variableName The name of the variable.
     */
    void variableReference(String prefix,
                           String variableName) throws SAXPathException;

    /** Receive notification of a function call.
     *
     *  @param prefix The ns-uri prefix of the function.
     *  @param functionName The name of the function.
     */
    void startFunction(String prefix,
                       String functionName) throws SAXPathException;

    /** Receive notification of the end of a function call.
     */
    void endFunction() throws SAXPathException;
}
