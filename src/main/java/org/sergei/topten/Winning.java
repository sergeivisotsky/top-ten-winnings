package org.sergei.topten;

import java.math.BigDecimal;

/**
 * @author Sergei Visotsky
 */
public class Winning {

    private Long userId;
    private BigDecimal amount;

    public Winning() {
    }

    public Winning(Long userId, BigDecimal amount) {
        this.userId = userId;
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "org.sergei.topten.Winning{" +
                "userId=" + userId +
                ", amount=" + amount +
                '}';
    }
}
