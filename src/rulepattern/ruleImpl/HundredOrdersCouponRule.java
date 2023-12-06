package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;

import java.util.ArrayList;

public class HundredOrdersCouponRule implements IRule<CouponData, Void> {

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final long totalOrders = input.getUser().getTotalOrders() + 1;

        return totalOrders == 100;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }
        input.getCoupons().add(Coupon.ORDER_100);

        return null;
    }
}
