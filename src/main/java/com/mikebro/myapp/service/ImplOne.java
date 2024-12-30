package com.mikebro.myapp.service;

import com.mikebro.myapp.service.AppService;
import org.springframework.stereotype.Service;


/**
 *
 * @author mikebro
 */
@Service
public class ImplOne implements AppService {

	@Override
	public String serviceMethodA() {
		return "MethodA says hi from javafx.ImplOne";
	}

	@Override
	public String serviceMethodB() {
		return "MethodB says hi from javafx.ImplOne";
	}

	@Override
	public String serviceMethodC() {
		return "MethodC says hi from javafx.ImplOne";
	}

}
