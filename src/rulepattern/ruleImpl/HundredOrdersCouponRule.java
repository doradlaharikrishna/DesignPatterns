package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;

import java.util.ArrayList;

public class HundredOrdersCouponRule implements IRule<CouponData, Void> {

    public HundredOrdersCouponRule() {
        System.out.println("Adding HundredOrdersCouponRule");
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final long totalOrders = input.getUser().getTotalOrders() + 1;

        final boolean result = (totalOrders == 100);

        System.out.println(String.format("Result of HundredOrdersCouponRule evaluation is: %s", result));

        return result;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }
        input.getCoupons().add(Coupon.ORDER_100);
        System.out.println("Added ORDER_100 coupon");
        return null;
    }
}
