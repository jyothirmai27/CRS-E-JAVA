/**
 * 
 */
package com.signify.dao;

import com.signify.bean.Payment;

/**
 * @author BHAVISH
 *
 */
public interface PaymentDAOInterface {
	public void add(String userId, Payment payment);
}
