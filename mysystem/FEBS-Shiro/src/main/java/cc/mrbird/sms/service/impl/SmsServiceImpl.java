package cc.mrbird.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cc.mrbird.common.service.impl.BaseService;
import cc.mrbird.sms.domain.Sms;
import cc.mrbird.sms.service.SmsService;

@Service("smsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SmsServiceImpl extends BaseService<Sms> implements SmsService {

	
	public Sms getById(Integer id){
		Sms byKey = this.selectByKey(1);
	     return byKey;
	}
	
}
