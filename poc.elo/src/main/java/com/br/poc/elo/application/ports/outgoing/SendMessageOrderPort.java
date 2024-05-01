package com.br.poc.elo.application.ports.outgoing;

public interface SendMessageOrderPort {
    void sendMessageOrder(Object message,String topic);
}
