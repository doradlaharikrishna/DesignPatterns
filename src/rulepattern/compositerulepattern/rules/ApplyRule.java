package rulepattern.compositerulepattern.rules;

public abstract class ApplyRule<I, O> implements IEvaluateRule<I> {

    public abstract O applyRule(I input);
}
