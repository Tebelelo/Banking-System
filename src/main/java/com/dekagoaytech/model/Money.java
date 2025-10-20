package com.dekagoaytech.model;

public class Money implements Comparable<Money> {

    public static final Money ZERO = new Money(0); // 0 cents

    // stored in cents (or other smallest currency unit), R22,34 stored as 2234
    // Reason for using long is accuracy in computation
    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public void setAmount(long newAmount) {
        this.amount = newAmount;
    }

    public long getAmount() {
        return amount;
    }


    public Money add(Money other) {
        setAmount(this.amount + other.getAmount());
        return this;
    }


    public Money subtract(Money other) {
        setAmount(this.amount - other.getAmount());
        return this;
    }


    @Override
    public int compareTo(Money new_money){
        long diff = this.amount - new_money.getAmount();
        return (int) diff;
    };

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return this.amount == money.getAmount();
    }

    @Override
    public String toString() {
        return "Money{" + "amount=" + amount + '}';
    }

    //Optional: Display as rands (or main currency unit)
    public String toDisplayInRands() {
        return String.format("$%.2f", amount / 100.0);
    }
}
