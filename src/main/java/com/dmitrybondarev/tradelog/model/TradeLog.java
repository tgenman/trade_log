package com.dmitrybondarev.tradelog.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Data Base of trades to different exchanges
 */
public class TradeLog {

    /**
     * Container.
     * String - name of exchange
     * List Trade - log of completed trades on the current exchange
     */
    private Map<String, List<Trade>> tradeLog;

    public TradeLog() {
        this.tradeLog = new HashMap<>();
    }

    /**
     * Add Trade to Log.
     * @param trade - Trade.
     */
    public void addTrade(Trade trade) {
        if (tradeLog.containsKey(trade.getExchange())) {
            tradeLog.get(trade.getExchange()).add(trade);
        } else {
            ArrayList<Trade> exchangeLog = new ArrayList<>();
            exchangeLog.add(trade);
            tradeLog.put(trade.getExchange(), exchangeLog);
        }
    }

    /**
     * Get Set of Strings of all exchanges.
     * @return Set
     */
    public Set<String> getExchangesSet() {
        return tradeLog.keySet();
    }

    /**
     * Get log of specific exchange
     * @param exchange name of exchange
     * @return List of Trade log
     */
    public List<Trade> getExchangeTradeLog(String exchange) {
        return tradeLog.get(exchange);
    }
}
