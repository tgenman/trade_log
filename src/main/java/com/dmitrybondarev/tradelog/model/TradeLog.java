package com.dmitrybondarev.tradelog.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TradeLog {

    private Map<String, List<Trade>> tradeLog;

    public TradeLog() {
        this.tradeLog = new HashMap<>();
    }

    public void addTrade(Trade trade) {
        if (tradeLog.containsKey(trade.getExchange())) {
            tradeLog.get(trade.getExchange()).add(trade);
        } else {
            ArrayList<Trade> exchangeLog = new ArrayList<>();
            exchangeLog.add(trade);
            tradeLog.put(trade.getExchange(), exchangeLog);
        }
    }

    public Set<String> getExchangesSet() {
        return tradeLog.keySet();
    }

    public List<Trade> getExchangeTradeLog(String exchange) {
        return tradeLog.get(exchange);
    }
}
