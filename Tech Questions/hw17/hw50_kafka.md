# Explain following concepts, and how they coordinate with each other:
Kafka is a data-stream platform which is composed by multiple brokers (managed by Zookeepers which is used to manage metadata, leader election, and ensuring cluster synchronization).
The broker is a single service node and used to store and manage Data in topics (which are logic channels to store information in different categories) and handle Producer & consumer Requests.
Producers (clients applications) publish message to topics and Consumers consume data from topics.
Inside of topics, partition is used to ensure parallel processing and offset is used to track the position of messages in the parition. 
## Topic:
    A Kafka Topic is a logical channel in Apache Kafka used to organize and store records (messages) for a particular category of information. 
    Producers publish messages to a topic, and consumers subscribe to topics to receive those messages.
## Partition:
    A Kafka partition is a unit of parallelism and scalability within a Kafka topic. 
    Each topic in Kafka is divided into multiple partitions, and each partition is an ordered, immutable sequence of records that Kafka appends to.
    Key Characteristics of Kafka Partitions
        1. Parallelism & Scalability
            Partitions allow multiple consumers to read data in parallel, improving throughput.
            More partitions mean higher parallel processing, as different consumers can read from different partitions simultaneously.
        2. Data Ordering
            Kafka guarantees order within a partition but not across partitions.
            If messages have the same partition key, they will always be written to the same partition, ensuring strict order.
        3. Replication & Fault Tolerance
            Each partition has a leader replica and multiple follower replicas.
            If a broker fails, a follower replica takes over as the new leader to maintain availability.
        4. Partitioning Strategy
            Key-based partitioning: Messages with the same key always go to the same partition (ensures ordering for a specific key).
            Round-robin (default): If no key is provided, Kafka distributes messages evenly across partitions.
## Broker:
    A Kafka Broker is a server in an Apache Kafka cluster that stores and manages data (messages) and handles requests from producers and consumers. 
    It acts as an intermediary between clients (producers and consumers) and the Kafka storage system.
    Key Responsibilities of a Kafka Broker
        1. Stores & Manages Data
            Brokers store messages in topics, which are divided into partitions.
            Each broker manages multiple partitions.
        2. Handles Producer Requests
            Producers send data to Kafka topics, and brokers write this data to the appropriate partitions.
            If a partition has multiple brokers (replicas), one broker acts as the leader, and others as followers.
        3. Handles Consumer Requests
            Consumers request messages from brokers.
            The broker ensures each consumer gets data from the correct partition.  
        4. Ensures Fault Tolerance & High Availability
            Kafka uses replication to ensure data durability.
            If a broker fails, Kafka automatically elects a new leader for affected partitions.
## Consumer group:
    A Kafka Consumer Group is a collection of consumers that work together to read data from a Kafka topic in parallel. 
    Consumer groups help scale consumption and ensure fault tolerance while maintaining efficient data processing.
    How Consumer Groups Work
        Parallel Processing with Partitions
            Each consumer in a group reads from one or more partitions of a topic.
            A partition can be read by only one consumer per group, ensuring that messages are not duplicated within the group.
            Different consumer groups can read the same data independently.
        Automatic Load Balancing
            If a new consumer joins, Kafka redistributes partitions.
            If a consumer fails, its partitions are reassigned to the remaining consumers.
        Consumer Offsets Tracking
            Kafka tracks the last read message (offset) for each partition in a consumer group.
            Consumers can resume from where they left off in case of failure.
## Producer:
    A Kafka Producer is a client application that sends (publishes) messages to Kafka topics.
    Key Responsibilities of a Kafka Producer
        Sends Messages to Kafka Topics
            A producer sends messages (events) to a specific topic in Kafka.
            Kafka then distributes these messages across partitions for parallel processing.
        Partitioning Strategy
            Key-based Partitioning: Messages with the same key go to the same partition (ensures ordering).
            Round-robin Partitioning (default): If no key is provided, Kafka distributes messages evenly across partitions.
        Message Reliability & Acknowledgments
            Producers can choose acknowledgment levels (acks) to balance reliability and performance:
                acks=0: Fire-and-forget (fastest, but data loss possible).
                acks=1: Confirms only when the leader broker receives the message.
                acks=all: Waits for all replicas to acknowledge (safest).
        Batching & Compression for Performance
            Producers can batch messages before sending to reduce network overhead.
            Kafka supports compression (e.g., Gzip, Snappy) to optimize storage and speed.
## Offset:
    Offsets represent the position of a message within a Kafka Partition
## Zookeeper:
    Apache ZooKeeper is a distributed coordination service used by Kafka for managing metadata, leader election, and ensuring cluster synchronization.
    Key Responsibilities of ZooKeeper in Kafka
        1. Manages Broker Metadata
            Keeps track of active Kafka brokers in the cluster.
            Stores configuration data such as topic details and partition assignments.
        2. Leader Election for Partitions
            Each Kafka partition has a leader replica and multiple followers.
            If a broker (leader) fails, ZooKeeper helps elect a new leader from the available replicas.
        3. Manages Consumer Group Offsets (Before Kafka 2.8)
            Stores consumer offsets, tracking which messages have been processed.
            Kafka moved offset storage to brokers after version 2.8, reducing dependency on ZooKeeper.
        4. Handles Configuration and Access Control
            Manages Kafka ACLs (Access Control Lists) for security.
            Stores topic metadata, replication settings, and cluster configurations.
# Answer following questions:
## 1. Given N (number of partitions) and M (number of consumers) what will happen when N>=M and N<M respectively?
    Case: N (partitions) >= M (consumers):
        There are more or equal partitions than consumers.
            Each consumer will be assigned at least on partition.
            Some consumers may handle multiple partitions, but each partition is read by only one consumer in a group.
        Cons: Consumers may have an unequal workload if partitions store different amounts of data
    Case: N (paritions) < M (consumers):
        There are more consumers than partitions.
            Some consumers will remain idle, as a parition can only be assigned to one consumer at a time within a group.
            Not all consumers will receive message.
        Cons: wasted resources, as some consumers do nothing.
## 2. Explain how brokers work with topics?
    A kafka broker is a server in a kafka cluster that stores and manages topics and their partitions. Brokers handle producer writes, 
    consumer reads, parition replication, and coordination to ensure fault tolerance and scalability, 
    2.1 Topic Storage Across Brokers
        A Kafka topic is split into multiple partitions, which are distributed across multiple brokers for parallelism and fault tolerance.
        Each partition is assigned to a single broker as the leader, and replicated to other brokers (followers).
        Brokers store partition data on disk and manage replication.
    2.2 Producer Interaction with Brokers
        Producers send messages to a topic.
        Kafka distributes messages across partitions based on:
            Key-based partitioning (same key → same partition).
            Round-robin (default) (randomly assigns partitions).
        Producers communicate with the broker that holds the leader partition.
    2.3 Consumer Interaction with Brokers
        Consumers read data from Kafka topics.
        Kafka ensures each partition is read by only one consumer per consumer group.
        Consumers connect to the leader broker for their assigned partitions.
## 3. Are messages pushed to consumers or consumers pull messages from topics?
    Kafka follows a pull-based model, meaning consumers pull messages from topics rather than Kafka pushing messages to them.
    How Kafka’s Consumer Pull Model Works
        Producers write messages to Kafka topics, which are stored in partitions across brokers.
        Consumers periodically poll (pull) messages from their assigned partitions.
        Kafka retains messages based on time (log retention) or size (disk limit), regardless of whether they are consumed.
        Consumers track their offsets (i.e., last read message) to ensure they resume from where they left off.
## 4. How to avoid duplicate consumption of messages?
    1. Idempotent Producers:
        Kafka producers can ensure idempotent message delivery to Kafka brokers by enabling idempotence on the producer. This guarantees that even if the producer retries sending a message due to network issues, duplicate messages are not written to Kafka.
        Enable idempotence by setting acks=all and enable.idempotence=true in the producer config.
    2. Consumer Offset Management:
        Kafka consumers track the offsets of messages they have consumed. If a consumer crashes or restarts, it can resume consumption from the last committed offset. To avoid duplicates:
            Manually commit offsets: By controlling when offsets are committed, you can ensure that a message is only marked as consumed once it has been fully processed.
            Auto-commit (not recommended for critical systems): By default, Kafka automatically commits the offset of the last message consumed. However, this may result in duplicate consumption if the consumer crashes before committing the offset.
    3. Exactly-Once Semantics (EOS):
        Kafka supports Exactly-Once Semantics (EOS), ensuring that messages are processed exactly once throughout the entire pipeline (producer → Kafka → consumer → downstream processing).
        Steps for EOS:
            Enable idempotent producers (enable.idempotence=true).
            Enable transactional consumers and producers by using transactions in both producer and consumer to ensure atomicity.
    4. Deduplication at Consumer Side: 
        Message Deduplication Logic:
            If your use case involves consuming messages that might be processed more than once (due to retries, crashes, etc.), you can implement deduplication logic at the consumer side:
            Maintain a cache of processed message IDs (e.g., using Redis or a database).
            Before processing, check if the message ID already exists in the cache.
## 5. What will happen if some consumers are down in a consumer group? Will data loss occur? Why?
    When a consumer in a group is down, Kafka does not immediately reassign partitions unless the consumer does not return in a certain time (controlled by the session.timeout.ms setting). 
    If the consumer fails and cannot recover, the partitions it was assigned to will be reassigned to other active consumers in the same group.
    Kafka ensures no data loss by maintaining messages in topic partitions for a certain retention period (based on log retention settings: time or size). If some consumers are down, Kafka does not delete data; it keeps the messages available for later consumption.
## 6. What will happen if an entire consumer group is down? Will data loss occur? Why?
    Messages Will Not Be Lost
        No data loss will occur, as Kafka stores messages in partitions for the configured retention period (either time or size). Even if a consumer group is entirely down, the messages remain on disk until the retention time expires.
        While the consumer group is down, producers can still send messages to the Kafka topic. These messages are stored in the corresponding partitions and will remain available for the consumer group when it comes back online.
    Rebalancing and Consumer Group Recovery
        Once the consumer group comes back online, the consumer group will rebalance, and each partition will be reassigned to one of the available consumers.
        Kafka uses offset tracking for consumers. When the consumer group recovers, consumers will continue reading from the last committed offset for each partition.
## 7. Explain consumer lag and how to resolve it?
    Consumer lag in Kafka refers to the difference between the latest produced message (the offset of the latest message in the partition) and the offset of the last message that the consumer has successfully processed.
    Why happen?
        1. Slow Consumers, 2. insufficient number of consumers, 3. high message production rate, 4. network or IO issues, 5. unbalanced consumer group.
    Solution:
        1. Scale the Number of Consumers: increase the number of consumer instances in the group. Kafka will automatically rebalance and assign new partitions to the new consumers.
        2. Optimize Consumer Performance: Profile your consumer application to find performance bottlenecks, and improve processing time.
        3. Ensure Efficient Partitioning: Repartition the data by adjusting the number of partitions and consumers to balance the load. Consider custom partitioning logic to distribute messages more evenly across partitions.
        4. Monitor and Optimize Kafka Broker Performance
        5. Use Kafka Consumer Lag Monitoring
        6. Tune Consumer Configurations
## 8. Explain how Kafka tracks message delivery?
    Kafka tracks message delivery primarily through the concept of offsets, which help consumers track which messages have been consumed and where they left off. 
    Kafka guarantees at least once delivery semantics (by default), meaning messages are delivered to consumers at least once, but there can be cases where a message is delivered more than once due to failures, crashes, or retries.
    1. Kafka Offsets:
        An offset is a unique identifier for a message within a partition, representing its position in the partition's log. Kafka assigns an incrementing integer to each message, starting at zero for the first message. This offset allows consumers to track their progress and resume consumption from where they left off.
            Producer writes messages to a partition, and each message is assigned a unique offset in that partition.
            Consumer reads messages from a partition, keeping track of which messages (offsets) it has successfully processed.
            The consumer offset is stored in Kafka’s internal consumer offset topic (named __consumer_offsets), which tracks which messages a consumer has consumed
    2. Consumer Groups and Offset Tracking:
        Each consumer group in Kafka has a logical offset for each partition it consumes. Kafka doesn't automatically store consumer offsets for each consumer but does so at the consumer group level.
            When a consumer within a group consumes a message, it can commit the offset (i.e., mark the message as processed).
            The consumer group offset is stored in Kafka's __consumer_offsets topic, where it tracks the latest successfully processed message for each partition per consumer group.
            Offsets can be committed either automatically (using enable.auto.commit) or manually (using commitSync() or commitAsync()).
    3. Message Delivery Semantics in Kafka:
        At least once delivery:
            Kafka guarantees that messages will be delivered to a consumer at least once. If a consumer crashes after consuming a message but before committing the offset, the message will be re-delivered. This is the default delivery guarantee in Kafka.
        At most once delivery:
           In this mode, Kafka will ensure that messages are delivered no more than once. Consumers commit offsets before processing messages. If a consumer crashes before processing, the message is lost.
           Less common, used in cases where duplicate delivery is unacceptable, but data loss is acceptable.
        Exactly once delivery:
            This guarantee ensures that each message is delivered once and only once. It requires idempotent producers and transactional consumers.
            This is a more advanced setting and may require careful configuration of both producers and consumers.
## 9. Compare Kafka vs RabbitMQ, compare messaging frameworks vs Kafka (Why Kafka)?
    Kafka is a distributed streaming platform designed for handling real-time event streaming and high-throughput message delivery with horizontal scalability.
    RabbitMQ is a message broker designed primarily for message queuing and supporting a variety of messaging protocols (AMQP, MQTT, STOMP, etc.). It focuses on reliable messaging and can support complex routing scenarios.
| Feature           | 	Kafka                                                                                                                               | 	RabbitMQ                                                                                                                   |
|-------------------|--------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| Architecture      | 	Distributed, partitioned, and fault-tolerant log-based storage.	                                                                    | Centralized broker, supports various routing mechanisms.                                                                    |
| Use Case          | 	Ideal for event streaming, logs, real-time analytics, and big data pipelines.	                                                      | Best for message queuing, RPC, and point-to-point messaging.                                                                |
| Message Storage   | 	Messages are stored in partitions for a configurable retention period (e.g., hours, days). Messages can be consumed multiple times. | Messages are deleted once consumed, unless explicitly configured to be persistent.                                          |
| Message Ordering  | 	Provides strong ordering guarantees within a partition, but no global ordering across partitions.                                   | 	Ordering is guaranteed within a queue, but no guarantees across multiple queues.                                           |
| Throughput        | 	High throughput, designed for massive amounts of data, supporting millions of messages per second.                                  | 	Moderate throughput, designed for high availability and complex routing, but not optimized for high-volume streaming.      |
| Scalability       | 	Horizontal scalability by adding more brokers and partitions. Scales well for large data streams.	                                  | Can scale vertically (more CPU/memory), but horizontal scaling is more complex and may require clustering.                  |
| Consumer Model    | 	Consumer groups: Consumers share partitions and can work in parallel to increase throughput. Kafka tracks offsets internally.	      | Queue-based: Each message is delivered to a single consumer, though you can implement consumer groups with multiple queues. |
| Fault Tolerance   | 	High fault tolerance with replication of partitions across brokers. If a broker fails, replicas are available.                      | 	Supports high availability via clustering, but does not have the same level of fault tolerance as Kafka.                   |
| Message Retention | 	Messages are retained for a configured period (even after consumption) until the retention period or storage limit is reached.	     | Messages are removed from the queue after they are consumed (unless configured to be persistent).                           |
| Latency           | 	Low latency for streaming use cases but may vary depending on partitioning.                                                         | 	Generally lower latency in message delivery, suitable for quick messaging.                                                 |
| Consumer          | Acknowledgement	Consumers commit offsets to keep track of progress. Automatic and manual offset commits.	                            | Consumers acknowledge messages manually or automatically to ensure messages are not lost or redelivered.                    |
| Persistence       | 	Highly persistent; messages are stored on disk and can be replayed.                                                                 | 	Messages can be persistent (saved to disk), but typically rely more on the broker's memory for performance.                |
    Kafka is ideal for:
        High-throughput, real-time event streaming.
        Scenarios where message replay is important (e.g., data pipelines, event sourcing, or logs).
        Large-scale systems with high availability and fault tolerance requirements.
        Use cases where the consumer group model and parallel consumption of partitions is essential.
    RabbitMQ is ideal for:
        Message queuing with guaranteed delivery and routing.
        Workloads requiring complex routing, such as pub/sub, fanout, direct, or topic-based messaging.
        Systems where message order and low latency are more critical.
        Applications requiring request-response patterns and RPC.
        Smaller-scale messaging workloads with reliable delivery and acknowledgments.
## 10. On top of https://github.com/CTYue/Spring-Producer-Consumer
    see /Coding/hw17/springcloud-redbook
        - analysis-service -- kafka consumer
        - order-service -- kafka producer (enable exactly once)
    1. Write your consumer application with Spring Kafka dependency, set up 3 consumers in a single consumer group. Prove message consumption with screenshots.
        see Tech\ Questions/hw17/hw17-10-1-1-start.png -- start application
        see Tech\ Questions/hw17/hw17-10-1-2-messsage.png -- three consumers start to consume messages.
    2. Increase number of consumers in a single consumer group, observe what happens, explain your observation.
        see Tech\ Questions/hw17/hw17-10-2.png
        Setup:
            kafka with three broker
            1 topic (order-event) -- three paritions
            1 consumer group -- 5 consumers.
        From pictures, you can see only consumer 3, consumer 4, and consumer 5 are assigned to listen to topic. However, the consumer 1 and consumer 2 never get messages from topic. 
        This is because a topic parition can only be assigned to one consumer at a time within a consumer group.
    3. Create multiple consumer groups using Spring Kafka, set up different numbers of consumers within each group, observe consumer offset,
        Consumer group independence: Each consumer group consumes messages independently and maintains its own offset        
        Setup:
            consumer-group-A -- 5 consumer - no sleep method
            consumer-group-B -- 2 consumer - 10s sleep
            consumer-group-C -- 1 consumer - 20s sleep
    4. Prove that each consumer group is consuming messages on topics as expected, take screenshots of offset records.
        see Tech\ Question/hw17/hw17-10-3.png
        You can see different consumer group with the same LOG-END-OFFSET (producer position) and different CURRENT-OFFSET (consumer position)
    5. Demo different message delivery guarantees in Kafka, with necessary code or configuration changes.
        see \ Question/hw17/hw17-10-5.png
        At Most Once：message may be lost
        At Least Once：message may be duplicated
        Exactly Once：message will not be lost and not be duplicated
    Note: There's already a docker compose file in above git repo, you can start the 3 brokers (with zookeep) using docker-compose up command.