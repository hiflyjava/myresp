package cc.mrbird.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.sms.domain.Sms;
import cc.mrbird.sms.service.SmsService;

@RestController
@RequestMapping("/yxt/sms")
public class SmsController {

	@Autowired
	SmsService smsService;
	
	@RequestMapping("/getSmsByKey")
	public ResponseBo getSmsController(){
				
		Sms sms2 = smsService.selectByKey(1L);
		return 	ResponseBo.ok(sms2);
				
	}
	
}
