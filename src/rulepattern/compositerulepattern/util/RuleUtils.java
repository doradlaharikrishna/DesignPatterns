package rulepattern.compositerulepattern.util;

import rulepattern.compositerulepattern.compositerules.AndRule;
import rulepattern.compositerulepattern.compositerules.OrRule;
import rulepattern.compositerulepattern.rules.IEvaluateRule;

import java.util.List;

public class RuleUtils {

    public static IEvaluateRule and(IEvaluateRule... rules) {
        return new AndRule(List.of(rules));
    }

    public static IEvaluateRule or(IEvaluateRule... rules) {
        return new OrRule(List.of(rules));
    }
}
