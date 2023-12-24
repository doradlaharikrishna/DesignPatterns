package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FestivalOfferCouponRule implements IRule<CouponData, Void> {

    private static final List<String> festivalDates = List.of("2023-01-01", "2023-10-02");

    public FestivalOfferCouponRule() {
        System.out.println("Adding FestivalOfferCouponRule");
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        String todayDate = LocalDate.now().toString();

        final boolean result = festivalDates.contains(todayDate);

        System.out.println(String.format("Result of FestivalOfferCouponRule evaluation is: %s", result));

        return result;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }
        input.getCoupons().add(Coupon.FESTIVAL_OFFER);
        System.out.println("Added FESTIVAL_OFFER coupon");
        return null;
    }
}
