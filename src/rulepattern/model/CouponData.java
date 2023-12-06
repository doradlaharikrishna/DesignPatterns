package rulepattern.model;

import java.util.List;

public class CouponData {

    private User user;

    private List<Coupon> coupons;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "CouponData{" +
                "user=" + user +
                ", coupons=" + coupons +
                '}';
    }
}
