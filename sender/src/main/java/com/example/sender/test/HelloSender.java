package com.example.sender.test;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class HelloSender implements RabbitTemplate.ReturnCallback{



    @Autowired
    //private AmqpTemplate rabbitTemplate;
    private RabbitTemplate rabbitTemplate;
    public void send() {
        String context = "你好现在是 " + new Date() +"";
        System.out.println("HelloSender发送内容 : " + context);
        // this.rabbitTemplate.setConfirmCallback(this);
        this.rabbitTemplate.setReturnCallback(this);
        this.rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
            if (!ack) {
                System.out.println("HelloSender消息发送失败" + cause + correlationData.toString());
            } else {
                System.out.println("HelloSender 消息发送成功111 ");
            }
        });
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendObj() {
        MessageObj obj = new MessageObj();
        obj.setACK(false);
        obj.setId(123);
        obj.setName("zhangsan");
        obj.setValue("data");
        System.out.println("发送 : " + obj);
        this.rabbitTemplate.convertAndSend("helloObj", obj);
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("sender return success" + message.toString()+"==="+i+"==="+s1+"==="+s2);

    }
}
