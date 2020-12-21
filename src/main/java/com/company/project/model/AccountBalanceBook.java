package com.company.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "account_balance_book")
public class AccountBalanceBook {
    /**
     * 账本流水
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 账户ID
     */
    @Column(name = "account_id")
    private String accountId;

    /**
     * 变动前总余额
     */
    @Column(name = "before_balance")
    private Integer beforeBalance;

    /**
     * 变动后总余额
     */
    @Column(name = "after_balance")
    private Integer afterBalance;

    /**
     * 余额发生额
     */
    @Column(name = "balance_incurred")
    private Integer balanceIncurred;

    /**
     * 账本类型 1充值 2提现 3转帐 4退款 5付费 6冻结 7解冻  8 调整
     */
    @Column(name = "book_type")
    private String bookType;

    /**
     * 赠送金发生额
     */
    @Column(name = "give_amount_incurred")
    private Integer giveAmountIncurred;

    /**
     * 赠送金后金额
     */
    @Column(name = "after_give_amount")
    private Integer afterGiveAmount;

    /**
     * 赠送金前金额
     */
    @Column(name = "before_give_amount")
    private Integer beforeGiveAmount;

    /**
     * 医生ID
     */
    @Column(name = "doctor_id")
    private String doctorId;

    /**
     * 操作ID
     */
    @Column(name = "operate_id")
    private String operateId;

    /**
     * 咨询师ID
     */
    @Column(name = "therapist_id")
    private String therapistId;

    /**
     * 门诊ID
     */
    @Column(name = "cahier_id")
    private String cahierId;

    /**
     * 使用人ID
     */
    @Column(name = "user_id")
    private String userId;

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
     * 备注
     */
    private String remarks;

    /**
     * 门诊名称
     */
    @Column(name = "cahier_name")
    private String cahierName;

    /**
     * 被转账户ID
     */
    @Column(name = "transferred_account_id")
    private String transferredAccountId;

    /**
     * 支付方式
     */
    @Column(name = "pay_method")
    private String payMethod;

    /**
     * 类型,积分类型：对应积分类型表，红包类型：1：分享红包，2：返现红包，3：红包支付，4：红包提现
     */
    private String type;

    /**
     * 交易凭证
     */
    @Column(name = "transaction_id")
    private String transactionId;

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
     * 获取账本流水
     *
     * @return id - 账本流水
     */
    public String getId() {
        return id;
    }

    /**
     * 设置账本流水
     *
     * @param id 账本流水
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取账户ID
     *
     * @return account_id - 账户ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 设置账户ID
     *
     * @param accountId 账户ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取变动前总余额
     *
     * @return before_balance - 变动前总余额
     */
    public Integer getBeforeBalance() {
        return beforeBalance;
    }

    /**
     * 设置变动前总余额
     *
     * @param beforeBalance 变动前总余额
     */
    public void setBeforeBalance(Integer beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    /**
     * 获取变动后总余额
     *
     * @return after_balance - 变动后总余额
     */
    public Integer getAfterBalance() {
        return afterBalance;
    }

    /**
     * 设置变动后总余额
     *
     * @param afterBalance 变动后总余额
     */
    public void setAfterBalance(Integer afterBalance) {
        this.afterBalance = afterBalance;
    }

    /**
     * 获取余额发生额
     *
     * @return balance_incurred - 余额发生额
     */
    public Integer getBalanceIncurred() {
        return balanceIncurred;
    }

    /**
     * 设置余额发生额
     *
     * @param balanceIncurred 余额发生额
     */
    public void setBalanceIncurred(Integer balanceIncurred) {
        this.balanceIncurred = balanceIncurred;
    }

    /**
     * 获取账本类型 1充值 2提现 3转帐 4退款 5付费 6冻结 7解冻  8 调整
     *
     * @return book_type - 账本类型 1充值 2提现 3转帐 4退款 5付费 6冻结 7解冻  8 调整
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * 设置账本类型 1充值 2提现 3转帐 4退款 5付费 6冻结 7解冻  8 调整
     *
     * @param bookType 账本类型 1充值 2提现 3转帐 4退款 5付费 6冻结 7解冻  8 调整
     */
    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    /**
     * 获取赠送金发生额
     *
     * @return give_amount_incurred - 赠送金发生额
     */
    public Integer getGiveAmountIncurred() {
        return giveAmountIncurred;
    }

    /**
     * 设置赠送金发生额
     *
     * @param giveAmountIncurred 赠送金发生额
     */
    public void setGiveAmountIncurred(Integer giveAmountIncurred) {
        this.giveAmountIncurred = giveAmountIncurred;
    }

    /**
     * 获取赠送金后金额
     *
     * @return after_give_amount - 赠送金后金额
     */
    public Integer getAfterGiveAmount() {
        return afterGiveAmount;
    }

    /**
     * 设置赠送金后金额
     *
     * @param afterGiveAmount 赠送金后金额
     */
    public void setAfterGiveAmount(Integer afterGiveAmount) {
        this.afterGiveAmount = afterGiveAmount;
    }

    /**
     * 获取赠送金前金额
     *
     * @return before_give_amount - 赠送金前金额
     */
    public Integer getBeforeGiveAmount() {
        return beforeGiveAmount;
    }

    /**
     * 设置赠送金前金额
     *
     * @param beforeGiveAmount 赠送金前金额
     */
    public void setBeforeGiveAmount(Integer beforeGiveAmount) {
        this.beforeGiveAmount = beforeGiveAmount;
    }

    /**
     * 获取医生ID
     *
     * @return doctor_id - 医生ID
     */
    public String getDoctorId() {
        return doctorId;
    }

    /**
     * 设置医生ID
     *
     * @param doctorId 医生ID
     */
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * 获取操作ID
     *
     * @return operate_id - 操作ID
     */
    public String getOperateId() {
        return operateId;
    }

    /**
     * 设置操作ID
     *
     * @param operateId 操作ID
     */
    public void setOperateId(String operateId) {
        this.operateId = operateId;
    }

    /**
     * 获取咨询师ID
     *
     * @return therapist_id - 咨询师ID
     */
    public String getTherapistId() {
        return therapistId;
    }

    /**
     * 设置咨询师ID
     *
     * @param therapistId 咨询师ID
     */
    public void setTherapistId(String therapistId) {
        this.therapistId = therapistId;
    }

    /**
     * 获取门诊ID
     *
     * @return cahier_id - 门诊ID
     */
    public String getCahierId() {
        return cahierId;
    }

    /**
     * 设置门诊ID
     *
     * @param cahierId 门诊ID
     */
    public void setCahierId(String cahierId) {
        this.cahierId = cahierId;
    }

    /**
     * 获取使用人ID
     *
     * @return user_id - 使用人ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置使用人ID
     *
     * @param userId 使用人ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * 获取备注
     *
     * @return remarks - 备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     *
     * @param remarks 备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取门诊名称
     *
     * @return cahier_name - 门诊名称
     */
    public String getCahierName() {
        return cahierName;
    }

    /**
     * 设置门诊名称
     *
     * @param cahierName 门诊名称
     */
    public void setCahierName(String cahierName) {
        this.cahierName = cahierName;
    }

    /**
     * 获取被转账户ID
     *
     * @return transferred_account_id - 被转账户ID
     */
    public String getTransferredAccountId() {
        return transferredAccountId;
    }

    /**
     * 设置被转账户ID
     *
     * @param transferredAccountId 被转账户ID
     */
    public void setTransferredAccountId(String transferredAccountId) {
        this.transferredAccountId = transferredAccountId;
    }

    /**
     * 获取支付方式
     *
     * @return pay_method - 支付方式
     */
    public String getPayMethod() {
        return payMethod;
    }

    /**
     * 设置支付方式
     *
     * @param payMethod 支付方式
     */
    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    /**
     * 获取类型,积分类型：对应积分类型表，红包类型：1：分享红包，2：返现红包，3：红包支付，4：红包提现
     *
     * @return type - 类型,积分类型：对应积分类型表，红包类型：1：分享红包，2：返现红包，3：红包支付，4：红包提现
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型,积分类型：对应积分类型表，红包类型：1：分享红包，2：返现红包，3：红包支付，4：红包提现
     *
     * @param type 类型,积分类型：对应积分类型表，红包类型：1：分享红包，2：返现红包，3：红包支付，4：红包提现
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取交易凭证
     *
     * @return transaction_id - 交易凭证
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 设置交易凭证
     *
     * @param transactionId 交易凭证
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}