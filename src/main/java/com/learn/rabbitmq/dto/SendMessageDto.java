package com.learn.rabbitmq.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SendMessageDto {

	@ApiModelProperty(value = "路由键")
	private String routingKey;
	@ApiModelProperty(value = "消息内容")
	private Object msg;

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

}
