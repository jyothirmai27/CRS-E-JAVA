/**
 * 
 */
package com.signify.bean;

/**
 * @author BHAVISH
 *
 */
public class PaymentNotification {
	private int notificationId;
	private String notificationMessage;
	private int referenceId;

	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getReferenceId() {
		return referenceId;
	}
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	public String getNotificationMessage() {
		return notificationMessage;
	}
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
}
