package rulepattern.compositerulepattern.rules.impl;

import rulepattern.compositerulepattern.rules.ApplyRule;
import rulepattern.compositerulepattern.rules.IEvaluateRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;

import java.util.ArrayList;

import static rulepattern.compositerulepattern.util.RuleUtils.and;

public class BirthdayFestiveComboCouponRule extends ApplyRule<CouponData, Void> {

    public BirthdayFestiveComboCouponRule() {
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        IEvaluateRule birthDayRule = new BirthDaySpecialCouponRule();
        IEvaluateRule festiveRule = new FestivalOfferCouponRule();

        return and(birthDayRule, festiveRule).isRuleApplicable(input);
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.BIRTHDAY_FESTIVE_OFFER);
        System.out.println("Added BIRTHDAY_FESTIVE_OFFER coupon");
        return null;
    }
}
