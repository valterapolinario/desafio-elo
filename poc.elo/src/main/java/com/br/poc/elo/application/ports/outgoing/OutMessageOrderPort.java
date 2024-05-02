package com.br.poc.elo.application.ports.outgoing;

public interface OutMessageOrderPort {
    void sendMessage(Object message,String topic);
}
