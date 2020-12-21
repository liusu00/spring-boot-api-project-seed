package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "account_info")
public class Account {
    /**
     * 账户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 账户余额 账户余额=可用余额+冻结余额
     */
    private Integer balance;

    /**
     * 可用余额
     */
    @Column(name = "usable_balance")
    private Integer usableBalance;

    /**
     * 冻结余额
     */
    @Column(name = "freeze_balance")
    private Integer freezeBalance;

    /**
     * 赠送金额
     */
    @Column(name = "give_amount")
    private Integer giveAmount;

    /**
     * 累计充值金额
     */
    @Column(name = "up_amount")
    private Integer upAmount;

    /**
     * 累计消费金额
     */
    @Column(name = "down_amount")
    private Integer downAmount;

    /**
     * 账户状态 0激活 1冻结 2注销
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 账户类型 1余额账户，2 积分账户，3 红包账户
     */
    @Column(name = "account_type")
    private String accountType;

    /**
     * 账户名称
     */
    @Column(name = "account_name")
    private String accountName;
    @Transient
    private String cardNum;
    @Transient
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    /**
     * 获取账户ID
     *
     * @return id - 账户ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置账户ID
     *
     * @param id 账户ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取账户余额 账户余额=可用余额+冻结余额
     *
     * @return balance - 账户余额 账户余额=可用余额+冻结余额
     */
    public Integer getBalance() {
        return balance;
    }

    /**
     * 设置账户余额 账户余额=可用余额+冻结余额
     *
     * @param balance 账户余额 账户余额=可用余额+冻结余额
     */
    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    /**
     * 获取可用余额
     *
     * @return usable_balance - 可用余额
     */
    public Integer getUsableBalance() {
        return usableBalance;
    }

    /**
     * 设置可用余额
     *
     * @param usableBalance 可用余额
     */
    public void setUsableBalance(Integer usableBalance) {
        this.usableBalance = usableBalance;
    }

    /**
     * 获取冻结余额
     *
     * @return freeze_balance - 冻结余额
     */
    public Integer getFreezeBalance() {
        return freezeBalance;
    }

    /**
     * 设置冻结余额
     *
     * @param freezeBalance 冻结余额
     */
    public void setFreezeBalance(Integer freezeBalance) {
        this.freezeBalance = freezeBalance;
    }

    /**
     * 获取赠送金额
     *
     * @return give_amount - 赠送金额
     */
    public Integer getGiveAmount() {
        return giveAmount;
    }

    /**
     * 设置赠送金额
     *
     * @param giveAmount 赠送金额
     */
    public void setGiveAmount(Integer giveAmount) {
        this.giveAmount = giveAmount;
    }

    /**
     * 获取累计充值金额
     *
     * @return up_amount - 累计充值金额
     */
    public Integer getUpAmount() {
        return upAmount;
    }

    /**
     * 设置累计充值金额
     *
     * @param upAmount 累计充值金额
     */
    public void setUpAmount(Integer upAmount) {
        this.upAmount = upAmount;
    }

    /**
     * 获取累计消费金额
     *
     * @return down_amount - 累计消费金额
     */
    public Integer getDownAmount() {
        return downAmount;
    }

    /**
     * 设置累计消费金额
     *
     * @param downAmount 累计消费金额
     */
    public void setDownAmount(Integer downAmount) {
        this.downAmount = downAmount;
    }

    /**
     * 获取账户状态 0激活 1冻结 2注销
     *
     * @return status - 账户状态 0激活 1冻结 2注销
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置账户状态 0激活 1冻结 2注销
     *
     * @param status 账户状态 0激活 1冻结 2注销
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取更新时间
     *
     * @return update_date - 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新时间
     *
     * @param updateDate 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取账户类型 1余额账户，2 积分账户，3 红包账户
     *
     * @return account_type - 账户类型 1余额账户，2 积分账户，3 红包账户
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * 设置账户类型 1余额账户，2 积分账户，3 红包账户
     *
     * @param accountType 账户类型 1余额账户，2 积分账户，3 红包账户
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * 获取账户名称
     *
     * @return account_name - 账户名称
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * 设置账户名称
     *
     * @param accountName 账户名称
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}