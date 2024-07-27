package com.iiht.restjpa.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorResponse {
	
	private String message;
	private String errorCode;
	private Date time;
	

}
