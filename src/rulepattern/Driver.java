package rulepattern;

import rulepattern.engineImpl.DefaultCouponRuleEngine;
import rulepattern.model.CouponData;
import rulepattern.model.User;
import rulepattern.ruleImpl.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        // Initialize user data object
        User user = new User();
        user.setCreatedAt(LocalDateTime.now());
        user.setUserName("user1");
        user.setDateOfBirth(LocalDate.now());
        user.setTotalOrders(20);
        CouponData couponData = new CouponData();
        couponData.setUser(user);

        /// Old way
        System.out.println("With Old way");
        OldWay oldWay = new OldWay();
        oldWay.addCoupons(couponData);

        System.out.println("------------------------------");

        /// New way
        System.out.println("With New way");
        ICouponRuleEngine couponRuleEngine = new DefaultCouponRuleEngine();

        // Adding rules
        couponRuleEngine.addRule(new BirthDaySpecialCouponRule());
        couponRuleEngine.addRule(new FestivalOfferCouponRule());
        couponRuleEngine.addRule(new FirstOrderCouponRule());
        couponRuleEngine.addRule(new HundredOrdersCouponRule());
        couponRuleEngine.addRule(new NewUserCouponRule());
        couponData.setCoupons(new ArrayList<>());

        // Evaluate rules
        couponRuleEngine.evaluateRules(couponData);

        // Result
        System.out.println(String.format("Coupons available for user: %s are %s", user.getUserName(), couponData.getCoupons().toString()));
    }

}
