package rulepattern.ruleImpl;

import rulepattern.IRule;
import rulepattern.model.Coupon;
import rulepattern.model.CouponData;
import rulepattern.model.User;

import java.util.ArrayList;

public class FirstOrderCouponRule implements IRule<CouponData, Void> {

    @Override
    public boolean isRuleApplicable(CouponData input) {
        final User user = input.getUser();

        return user.getTotalOrders() == 0;
    }

    @Override
    public Void applyRule(CouponData input) {
        if (input.getCoupons() == null) {
            input.setCoupons(new ArrayList<>());
        }

        input.getCoupons().add(Coupon.FIRST_ORDER);
        return null;
    }
}
