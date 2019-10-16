# StockExchange

Classes:

StockExchange:

    -HashMap of listed stocks - keyed by Ticker Symbols
  
Brokerage:

    -TreeMap of registered traders
  
    -TreeSet of logged in traders
  
    -Recieves quotes requests and trade orders from Traders and relays them to StockExchange
  
Stock:

    -Holds Stock Symbol, Company Name, Low and High price, Volume of Sale
  
    -Priority queue for buy orders
  
PriceComparator:

    -Compares TradeOrder objects based on prices and puts them into a priority queue based on 
    ascending or decending  parameter
  
Trader:

    -Trader Object
  
    -Request Quotes and place orders with brokerage
  
    -Stores messages in a mailbox and displays them in Trader Window
  
TradeOrder:

    -Data Carrier
  
    -fields and accessor methods that correspond with data entry in Trader Window
  
  
Assigned tasks: 

Nate - Quality Assurance

Noah - Quality Assurance

Jared - Stock

Tomas - Trader

Colby - StockExchange, Brokerage

Nazarii - TradeOrder, PriceComparator
