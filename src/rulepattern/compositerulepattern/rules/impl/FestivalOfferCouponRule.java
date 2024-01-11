package rulepattern.compositerulepattern.rules.impl;

import rulepattern.compositerulepattern.rules.IEvaluateRule;
import rulepattern.model.CouponData;

import java.time.LocalDate;
import java.util.List;

public class FestivalOfferCouponRule implements IEvaluateRule<CouponData> {
    private static final List<String> festivalDates = List.of("2023-01-01", "2023-10-02");

    public FestivalOfferCouponRule() {
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        String todayDate = LocalDate.now().toString();
        return festivalDates.contains(todayDate);
    }
}
