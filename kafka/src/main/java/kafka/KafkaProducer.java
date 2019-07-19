/*
 * Copyright (C) 2019 Baidu, Inc. All Rights Reserved.
 */
package kafka;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

public class KafkaProducer {

    public static Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put("metadata.broker.list", "127.0.0.1:9092");
//        props.put("zookeeper.connect", "127.0.0.1:2181");
        //配置value的序列化类
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //配置key的序列化类
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "-1");
        return new Producer<String, String>(new ProducerConfig(props));
    }

    public static void main(String[] args) {

//        //zookeeper地址：端口号
//        String ZkStr = "127.0.0.1:2181";
//        String topicName = "demo";
//
//        //topic对象
//        KafkaTopicBean topic = new KafkaTopicBean();
//        topic.setTopicName(topicName);  //topic名称
//        topic.setPartition(2);            //分区数量设置为1
//        topic.setReplication(1);          //副本数量设置为1
//
//        //创建topic
//        KafkaUtil.createKafaTopic(ZkStr, topic);
//        //删除topic
//        //KafkaUtil.deleteKafaTopic(ZkStr, topic);

        Producer<String, String> producer = KafkaProducer.createProducer();
        int messageNo = 1;
        int count = 10;
        while (messageNo < count) {
            String key = String.valueOf(messageNo);
            String data = "hello kafka message " + key;
            producer.send(new KeyedMessage<String, String>("test", key, data));
            System.out.println(data);
            messageNo++;
        }
    }
}