package com.ste.symphony.domain;

public class MyMessage {
    private String topic;
    private String content;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MyMessage{" +
                "topic='" + topic + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

