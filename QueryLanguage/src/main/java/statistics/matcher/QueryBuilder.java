/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

/**
 *
 * @author jonnej
 */
public class QueryBuilder {
    
    private Matcher matcher;
    private int index;
    
    
    public QueryBuilder() {
        matcher = new And();
        index = 0;
    }
    
    public Matcher build() {
        Matcher returnMatcher = new And(matcher, new All());
        matcher = new And();
        return returnMatcher;
    }
    
    public QueryBuilder and(Matcher... matchers) {
        addToMatcher(new And(matchers));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        addToMatcher(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        addToMatcher(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder not(Matcher... matchers) {
        addToMatcher(new Not(matchers));
        return this;
    }
    
    public QueryBuilder or(Matcher... matchers) {
        addToMatcher(new Or(matchers));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        addToMatcher(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matcher = new Or(m1,m2);
        return this;
    }
    
    private void addToMatcher(Matcher m) {
        matcher = new And(matcher, m);
    }
    
    private void addtoOrMatcher(Matcher m) {
        
    }
    
    
}
