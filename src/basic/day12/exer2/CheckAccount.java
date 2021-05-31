package basic.day12.exer2;

/*
    创建Account类的子类CheckAccount，代表可以透支的账户（信用卡账户）
    该账户中定义一个属性overdraft代表可透支限额
    在CheckAccount类中重写withdraw方法，其算法如下：
        如果取款金额 >= 账户余额，则可直接取款
        如果取款金额 < 账户余额，则计算需要透支的额度，判断可透支额度是否足够支付本次透支需要
            如果可以，则将账户余额改为0，冲减可透支金额
            如果不可以，则提示用户超过可透支的限额
 */

import java.math.BigDecimal;

public class CheckAccount extends Account{

    private double overdraft;

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    @Override
    public void withdraw(double amount) {
        BigDecimal balanceValue = new BigDecimal(getBalance());
        BigDecimal amountValue = new BigDecimal(amount);
        if (balanceValue.compareTo(amountValue) >= 0) {
            //  取款金额 >= 账户余额，则直接取款
            //  方式1：
//            setBalance(balanceValue.subtract(amountValue).doubleValue());
            //  方式2：调用父类的withdraw方法，直接取款
            super.withdraw(amount);
        } else {
            //  如果取款金额 < 账户余额，则计算需要透支的额度
            BigDecimal overdraftValue = new BigDecimal(overdraft);
            if (overdraftValue.compareTo(amountValue.subtract(balanceValue)) >= 0) {    //  透支额度 + 余额 > 消费金额
                //  如果可以，则将账户余额改为0，冲减可透支金额
                super.withdraw(getBalance());
                //  透支额度 = 透支额度 + 余额 - 消费金额
                overdraft = overdraftValue.add(balanceValue).subtract(amountValue).doubleValue();
            } else {
                //  如果不可以，则提示用户超过可透支的限额
                System.out.println("超过可透支的限额");
            }
        }

    }

    @Override
    public void showBalance() {
        System.out.println("您的账户余额为：" + getBalance() + ", 可透支额度为：" + overdraft);
    }
}
