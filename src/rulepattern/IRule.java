package rulepattern;

public interface IRule<I, O> {

    public boolean isRuleApplicable(I input);

    public O applyRule(I input);
}
