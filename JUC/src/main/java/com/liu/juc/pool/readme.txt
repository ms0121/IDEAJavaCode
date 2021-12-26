线程池（重点）
 线程池：三大方法，七大参数，4种拒接策略

池化技术：
    程序的运行：本质，占用系统的资源，优化资源的使用 ===》 池化技术

线程池，连接池，内存池，对象池。。。。创建，销毁，十分浪费资源
池化技术，事先准备好一些资源，有人需要使用，就直接来我这里拿，用完之后需要进行归回


池化的好处：
    降低资源的消耗
    提高相应的速度，
    方便管理
    线程复用，可以控制最大并发数，管理线程



 public ThreadPoolExecutor
      (int corePoolSize,  // 核心线程池大小
      int maximumPoolSize, // 最大核心线程池大小
      long keepAliveTime, //  指定超时时间（超时了没有人调用就会直接释放）
      TimeUnit unit, // 超时的单位
      BlockingQueue<Runnable> workQueue, // 阻塞队列
      ThreadFactory threadFactory, // 线程工厂，创建线程的，一般不会进行修改
      RejectedExecutionHandler handler) //(四种)拒绝策略，分别为其实现类
