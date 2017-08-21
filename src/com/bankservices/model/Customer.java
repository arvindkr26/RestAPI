package com.bankservices.model;

public class Customer {
	
	private int customerId;
	private int accountId;
	private int positionId;
	private int shares;
	private int pricePerShare;
	private String name;
	private String symbol;
	
    public Customer(int customerId, int accountId, int positionId, int shares, int pricePerShare) {
    		this.customerId = customerId;
    		this.accountId = accountId;
    		this.positionId = positionId;
    		this.pricePerShare=pricePerShare;
    		this.shares=shares;
    };
    
    public Customer(int customerId, int accountId, String name, String symbol, int shares, int pricePerShare) {
		this.customerId = customerId;
		this.accountId = accountId;
		this.name = name;
		this.symbol = symbol;
		this.pricePerShare=pricePerShare;
		this.shares=shares;
};


    public void setcustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setaccountId(int accountId) {
        this.accountId = accountId;
    }
 
    public void setpositionId(int positionId) {
        this.positionId = positionId;
    }

    public void setpricePerShare(int pricePerShare) {
        this.pricePerShare = pricePerShare;
    }
 
    public void setshares(int shares) {
        this.shares = shares;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


}
