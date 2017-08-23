# myLearning
All my learning

https://github.com/apache/camel/tree/master/examples/camel-example-spring-boot

Camel

    Consumers
     "from" component in camel 
      wrap the payload and creates exchange
      2 types 
           Event driven /asynchronous consumer
             JMS,Kafka
           Polling consumers /synchronous consumer
             file,ftp
    
    Producers
        to component /destinations
          entity which can create and send a message to an endPoint
          converts the exchange according to the endpoint behind the scenes

