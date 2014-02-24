(require '[zeromq-clj.core :as zmq] :reload-all)

(def ctx (zmq/create-context))

(def sub (zmq/create-sub-socket ctx "tcp://127.0.0.1:5858" "myTopic"))

(def pub (zmq/create-pub-socket ctx "tcp://127.0.0.1:5858"))

(def ex (java.util.concurrent.Executors/newFixedThreadPool 5))

(def received-messages (atom []))

(def disruptor (zmq/on-msg sub
                           (fn [m]
                             (swap! received-messages conj m))
                           ex))

(try
  (dotimes [n 1000]
    (zmq/publish pub {:event n :message "Hello there!"} "myTopic"))
  (finally
    (.shutdown disruptor)
    (.shutdownNow ex)
    (doseq [i [ctx pub sub]]
      (.close i))))
