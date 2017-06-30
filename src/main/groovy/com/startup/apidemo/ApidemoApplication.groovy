package com.startup.apidemo

import com.startup.apidemo.services.ForeignExchangeService
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.regex.Matcher
import java.util.regex.Pattern

@RestController
@SpringBootApplication
class ApidemoApplication {

	@RequestMapping('/hello')
	protected String home() {
		return 'Hello World!';
	}

	/*
	ex- http://localhost:8080/welcome?name=is(deepss)
	 */
	@RequestMapping('/welcome')
	protected String welcomeWithName(
			@RequestParam('name') String name
	) {
		Matcher m = Pattern.compile("\\((.*?)\\)").matcher(name)
		while(m.find()) {
			return ('Hello '+m.group(1))
		}
		return 'Hi without name'
	}

	@RequestMapping('/findValue')
	def whatIsTheValue(
			@RequestParam('currency') def currency
	) {
		try {
			return ForeignExchangeService.getConversion(currency)
		}catch (Exception e) {
			System.out.print(e)
			return 'Unavailable '
		}
	}

	static void main(String[] args) {
		SpringApplication.run ApidemoApplication, args
	}
}
