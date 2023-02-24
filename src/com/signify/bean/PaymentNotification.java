/**
 * 
 */
package com.signify.bean;

/**
 * @author CRS_SIGNIFY_GROUP_E
 *
 */
public class PaymentNotification {
	private int notificationId;
	private String notificationMessage;
	private int referenceId;
	
	//method to get NotificationId

	public int getNotificationId() {
		return notificationId;
	}
	//method to set NotificationId
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	//method to get ReferenceId
	public int getReferenceId() {
		return referenceId;
	}
	
	//method to set ReferenceId
	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
	}
	
	//method to get NotificationMessage
	public String getNotificationMessage() {
		return notificationMessage;
	}
	//method to set NotificationMessage
	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}
}
