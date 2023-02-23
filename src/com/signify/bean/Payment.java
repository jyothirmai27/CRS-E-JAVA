/**
 * 
 */
package com.signify.bean;

/**
 * @author BHAVISH
 *
 */
public class Payment {

	private String studentId;
	private float amount;
	private String referenceId;	
	private boolean scholarship;
	private boolean offline;
	private boolean cash;
	private int bankNumber;
	private boolean status;
	private String upiId;
	private int cardNumber;
	private String cardType;
	private String bankName;
	private String chequeNumber;
	private int cvv;
	
	//method to get student ID

	public String getStudentId() {
		return studentId;
	}
	//method to set studentid
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	//method to get amount
	public float getAmount() {
		return amount;
	}
	//method to set amount
	public void setAmount(float amount) {
		this.amount = amount;
	}
	

	public boolean isScholarship() {
		return scholarship;
	}
	
	//method to set scholarship
	public void setScholarship(boolean scholarship) {
		this.scholarship = scholarship;
	}
	public boolean isOffline() {
		return offline;
	}
	//method to set Offlinepayment
	public void setOffline(boolean offline) {
		this.offline = offline;
	}
	public boolean isCash() {
		return cash;
	}
	//method to set cash
	public void setCash(boolean cash) {
		this.cash = cash;
	}
	//method to get BankNumber
	public int getBankNumber() {
		return bankNumber;
	}
	
	//method to set BankNumber
	public void setBankNumber(int bankNumber) {
		this.bankNumber = bankNumber;
	}
	
	public boolean isStatus() {
		return status;
	}
	//method to set status
	public void setStatus(boolean status) {
		this.status = status;
	}
	//method to get UpiID
	public String getUpiId() {
		return upiId;
	}
	//method to set UpiID
	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}
	
	//method to get CardNumber
	public int getCardNumber() {
		return cardNumber;
	}
	//method to get CardNumber
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	//method to get Card Type
	public String getCardType() {
		return cardType;
	}
	//method to set Card Type
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	//method to get BankName
	public String getBankName() {
		return bankName;
	}
	
	//method to set BankName
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	//method to get ChequeNumber
	public String getChequeNumber() {
		return chequeNumber;
	}
	
	//method to set ChequeNumber
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	//method to get Cvv
	public int getCvv() {
		return cvv;
	}
	
	//method to set Cvv
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	//method to get ReferenceId
	public String getReferenceId() {
		return referenceId;
	}
	
	//method to set ReferenceId
	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}
	

}
