package com.example.Annotation;

import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.model.Customer;

public class CustomerListValidator implements ConstraintValidator<ValidCustomerList, List<Customer>> {

	@Override
	public boolean isValid(List<Customer> customersList, ConstraintValidatorContext context) {

		for (Customer customer : customersList) {
			if (!(customer instanceof Customer)) {
				return false;
			}
// if you need any other validations you can use like this.
			/*if (!isValidCustomer(customer)) {
				return false;
			}*/
		}
		return true;
	}

	/*private boolean isValidCustomer(Customer customer) {

		if (!(customer.getDuetime() instanceof String)) {
			return false;
		}
		return true;
	}*/

}
