# Apache Kafka

KRaft `controller.quorum.voters` config defines the KRaft quorum members.

## Start Kafka broker

```bash
# Start Kafka with KRaft
bin/kafka-server-start.sh config/kraft/server.properties

- kraft/server.properties is already configured to use internal metadata quorum instead of Zookeeper.


# Start kafka broker
bin/kafka-server-start.sh config/server.properties
```

## Quick test

```bash
# create topic
bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092

# produce to topic
bin/kafka-console-producer.sh --topic my-topic --bootstrap-server localhost:9092

# consume from topic
bin/kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server localhost:9092
```