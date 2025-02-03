Explain following concepts, and how they coordinate with each other:
>Topic:  newspaper section (e.g., "Sports", "Politics", "Finance").
Partition:A partition is like pages within a newspaper section. Partitions allow parallel processing—different consumers in a consumer group can process different partitions simultaneously.
Broker:A broker is like a news agency that stores and delivers newspapers to subscribers.
Consumer group:A consumer group is like a team of people subscribing to a newspaper—each person (consumer) reads different pages (partitions) so they don’t all read the same thing.
Producer:A producer is like a journalist writing news articles
Offset:An offset is like a page number in a book—it tells you where you left off reading. Each message in a partition gets a unique offset.
Zookeeper:Zookeeper is like the newsroom editor—it manages Kafka’s metadata, leader election, and configurations.


Example: Zookeeper keeps track of which broker is the leader for each partition.
Answer following questions:
1. Given N (number of partitions) and M (number of consumers), what will happen when N>=M and N<M
   respectively?
> Kafka distribute partitions evenly among consumers. N >= M : some consumers receive more partitions.Each consumer is assigned at least one partition. ideal scenario for maximizing parallelism.
> N < M: some consumers may be idle, no message received.
2. Explain how brokers work with topics?
> A broker in Kafka is like a post office. The broker receives messages (like letters) from producers and stores them in topics (like mailboxes). Each topic can be thought of as a different category (e.g., “sports”, “news”). The broker manages and stores the messages in partitions, and each partition is like a sub-mailbox.
>When consumers want to retrieve messages, the broker ensures they are able to access the topics (or mailboxes) based on their subscriptions.
3. Are messages pushed to consumers or consumers pull messages from topics?
>Kafka works on a pull model. This is like a bookstore where customers (consumers) come and pick the books (messages) they want to read, rather than having the bookstore push books to them.
>In Kafka, consumers poll the broker (server) for messages. The consumers are responsible for fetching messages, and they can control the pace of consumption based on how fast they can process the messages.
4. How to avoid duplicate consumption of messages?
> To avoid duplicate consumption of messages, Kafka uses offsets. Think of this like a bookmark in a book. Each time a consumer reads a message, it keeps track of the position (offset) in the topic (like marking the page number).

To ensure a message is not consumed twice, consumers should commit their offsets after processing the message. If the consumer fails or restarts, it can pick up from where it left off, not re-reading the same messages.
5. What will happen if some consumers are down in a consumer group? Will data loss occur? Why?
> Kafka will reassign the partitions to the remaining consumers in the group. No data loss will occur because kafka retains messages in the topic for a configurable retention period.
6. What will happen if an entire consumer group is down? Will data loss occur? Why?
>If an entire consumer group is down, Kafka will reassign the partitions to other consumer groups, if they are available. If there are no other consumer groups to take over, messages will remain unprocessed until the consumer group comes back online.
> Again, no data loss occurs because Kafka stores messages in topics for a configured retention period. The messages will remain in the topic until they are consumed or the retention period expires.
> However, consumers will have to catch up on all the missed messages once they are back up.
7. Explain consumer lag and how to resolve it?
> Consumer lag occurs when a consumer is not able to keep up with the rate of incoming messages.
>To resolve lag:
Scale your consumers (i.e., add more consumers or partitions).
Increase consumer capacity (e.g., better hardware or more efficient processing).
Tune consumer configurations (e.g., increase the poll interval or batch size).
8. Explain how Kafka tracks message delivery?
> Kafka tracks message delivery using offsets. Think of it like keeping a journal where each message is numbered (offset), and each consumer has a bookmark (stored offset) indicating the last message it processed.
> Kafka also has features like at-most-once, at-least-once, and exactly-once delivery semantics to ensure the desired message delivery behavior.
9. Compare Kafka vs RabbitMQ, compare messaging frameworks vs MySql (Why Kafka)?
>   Feature 	            Kafka	                                RabbitMQ
>    Type	                Distributed Event Streaming Platform	Traditional Message Broker
>    Message Model	        Pub-Sub (Topic-Based) & Queue-Based	    Queue-Based
>   Storage & Durability	Stores messages in logs (persisted)	Stores messages temporarily 
>  consumption              consumers pull msgs                     messages pushed to consumers
>  order                    maintain message order within a partition no strict order guarantee
>  performance              for large-scale event streaming         transactional messaging

> Traditional databases like MySQL are great for storing structured data but are not designed for real-time messaging and event-driven architectures. k:High throughput, handles millions of events per second, Horizontally scalable with partitions
10. On top of https://github.com/CTYue/Spring-Producer-Consumer
    Write your consumer application with Spring Kafka dependency, set up 3 consumers in a single
    consumer group.
    Prove message consumption with screenshots.
    Increase number of consumers in a single consumer group, observe what happens, explain your
    observation.
    Create multiple consumer groups using Spring Kafka, set up different numbers of consumers within
    each group, observe consumer offset,
    Prove that each consumer group is consuming messages on topics as expected, take screenshots of
    offset records,
    Demo different message delivery guarantees in Kafka, with necessary code or configuration changes.
    Note: There's already a docker compose file in above git repo, you can start the 3 brokers (with
    zookeep) using docker-compose up command.