package test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jaxen.saxpath.XPathHandler;

class ConformanceXPathHandler implements XPathHandler {

    ConformanceXPathHandler() {
        this.events = new LinkedList();
    }

    private List events;

    public void startCommentNodeStep(int axis) {
        addEvent("startCommentNodeStep(" + axis + ")");
    }

    public void startUnionExpr() {
        addEvent("startUnionExpr()");
    }

    public void endRelativeLocationPath() {
        addEvent("endRelativeLocationPath()");
    }

    public void startRelativeLocationPath() {
        addEvent("startRelativeLocationPath()");
    }

    public void startUnaryExpr() {
        addEvent("startUnaryExpr()");
    }

    public void startEqualityExpr() {
        addEvent("startEqualityExpr()");
    }

    public String toString() {
        Iterator eventIter = this.events.iterator();
        int i = 0;
        StringBuffer buf = new StringBuffer();
        while (eventIter.hasNext()) {
            buf.append("(").append(i).append(") ").append(eventIter.next().toString()).append("\n");
            ++i;
        }
        return buf.toString();
    }

    public void number(double number) {
        addEvent("number(" + number + ")");
    }

    public void startFunction(String prefix, String functionName) {
        addEvent("startFunction(\"" + prefix + ":" + functionName + "\")");
    }

    public void literal(String literal) {
        addEvent("literal(\"" + literal + "\")");
    }

    public void endXPath() {
        addEvent("endXPath()");
    }

    public void endTextNodeStep() {
        addEvent("endTextNodeStep()");
    }

    public void startNameStep(int axis, String prefix, String localName) {
        addEvent("startNameStep(" + axis + ", \"" + prefix + "\", \"" + localName + "\")");
    }

    public void startPredicate() {
        addEvent("startPredicate()");
    }

    public boolean equals(Object thatObj) {
        if (thatObj instanceof ConformanceXPathHandler) {
            ConformanceXPathHandler that = (ConformanceXPathHandler) thatObj;
            return (this.events.equals(that.events));
        }
        return false;
    }

    public void endNameStep() {
        addEvent("endNameStep()");
    }

    public void startTextNodeStep(int axis) {
        addEvent("startTextNodeStep(" + axis + ")");
    }

    public void endCommentNodeStep() {
        addEvent("endCommentNodeStep()");
    }

    public void endFilterExpr() {
        addEvent("endFilterExpr()");
    }

    public void startOrExpr() {
        addEvent("startOrExpr()");
    }

    public void startXPath() {
        addEvent("startXPath()");
    }

    public void endEqualityExpr(int operator) {
        addEvent("endEqualityExpr(" + operator + ")");
    }

    public void endFunction() {
        addEvent("endFunction()");
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public void startRelationalExpr() {
        addEvent("startRelationalExpr()");
    }

    public void endUnaryExpr(int operator) {
        addEvent("endUnaryExpr(" + operator + ")");
    }

    public void endUnionExpr(boolean create) {
        addEvent("endUnionExpr(" + create + ")");
    }

    public void endAllNodeStep() {
        addEvent("endAllNodeStep()");
    }

    public void startAdditiveExpr() {
        addEvent("startAdditiveExpr()");
    }

    public void endMultiplicativeExpr(int operator) {
        addEvent("endMultiplicativeExpr(" + operator + ")");
    }

    public void number(int number) {
        addEvent("number(" + number + ")");
    }

    public void endRelationalExpr(int operator) {
        addEvent("endRelationalExpr(" + operator + ")");
    }

    public void variableReference(String prefix, String variableName) {
        addEvent("variableReference(\"" + prefix + ":" + variableName + "\")");
    }

    public void endAdditiveExpr(int operator) {
        addEvent("endAdditiveExpr(" + operator + ")");
    }

    public void startAndExpr() {
        addEvent("startAndExpr()");
    }

    public void endProcessingInstructionNodeStep() {
        addEvent("endProcessingInstructionNodeStep()");
    }

    public void endOrExpr(boolean create) {
        addEvent("endOrExpr(" + create + ")");
    }

    public void startAllNodeStep(int axis) {
        addEvent("startAllNodeStep(" + axis + ")");
    }

    public void startMultiplicativeExpr() {
        addEvent("startMultiplicativeExpr()");
    }

    public void startAbsoluteLocationPath() {
        addEvent("startAbsoluteLocationPath()");
    }

    public void endAbsoluteLocationPath() {
        addEvent("endAbsoluteLocationPath()");
    }

    public void endAndExpr(boolean create) {
        addEvent("endAndExpr(" + create + ")");
    }

    public void startProcessingInstructionNodeStep(int axis, String name) {
        addEvent("startProcessingInstructionNodeStep(" + axis + ", \"" + name + "\")");
    }

    public void endPredicate() {
        addEvent("endPredicate()");
    }

    public void endPathExpr() {
        addEvent("endPathExpr()");
    }

    public void startPathExpr() {
        addEvent("startPathExpr()");
    }

    private void addEvent(String eventStr) {
        this.events.add(eventStr);
    }

    public void startFilterExpr() {
        addEvent("startFilterExpr()");
    }
}
