package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.util.ArrayList;

public class FirstOrderCouponRule implements IRule<CouponData, Void> {

    public FirstOrderCouponRule() {
        System.out.println("Adding FirstOrderCouponRule");
    }

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        final boolean result = user.getTotalOrders() == 0;

        System.out.println(String.format("Result of FirstOrderCouponRule evaluation is: %s", result));

        return result;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.FIRST_ORDER);
        System.out.println("Added FIRST_ORDER coupon");
        return null;
    }
}
