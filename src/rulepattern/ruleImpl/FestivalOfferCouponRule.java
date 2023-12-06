package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FestivalOfferCouponRule implements IRule<CouponData, Void> {

    private static final List<String> festivalDates = List.of("2023-01-01", "2023-10-02");

    @Override
    public boolean isRuleApplicable(CouponData input) {
        String todayDate = LocalDate.now().toString();

        return festivalDates.contains(todayDate);
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }
        input.getCoupons().add(Coupon.FESTIVAL_OFFER);

        return null;
    }
}
