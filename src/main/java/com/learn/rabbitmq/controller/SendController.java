package com.learn.rabbitmq.controller;

import com.learn.rabbitmq.dto.SendMessageDto;
import com.learn.rabbitmq.exception.BizDataException;
import com.learn.rabbitmq.ret.BaseRet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/send")
@Api(value = "/send", tags = {"Send Message API"}, description = "RabbitMQ相关API")//swagger2使用此注解
public class SendController {

	private static final Logger logger = LoggerFactory.getLogger(SendController.class);

	@Autowired
	private AmqpTemplate amqpTemplate;

	@ResponseBody
	@RequestMapping(value = "/sendMsg", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "发送消息", httpMethod = "POST", response = BaseRet.class, notes = "send message")
	public BaseRet send(@RequestBody SendMessageDto dto) {

		BaseRet ret = new BaseRet();
		try {
			if (StringUtils.isBlank(dto.getRoutingKey())) {
				throw new BizDataException("路由键不能为空");
			}
			if (null == dto.getMsg()) {
				throw new BizDataException("消息内容不能为空");
			}
			/* 1.routing key 
			 * 2.meeage
			 * convertAndSend方法，看方法名就可知道需要转换，其实在spring-rabbitmq的配置文件中配置message-converter指定
			 * */
			amqpTemplate.convertAndSend(dto.getRoutingKey(), dto.getMsg());
			ret.setSuccess("0");
			ret.setMsg("成功");
		} catch (BizDataException e) {
			ret.setSuccess("1");
			ret.setMsg(e.getMessage());
			logger.error(e.getMessage());
		} catch (Exception e) {
			ret.setSuccess("2");
			ret.setMsg("失败");
			logger.error(e.getMessage());
		}
		return ret;
	}

}
