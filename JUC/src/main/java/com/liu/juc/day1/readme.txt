Synchronized与Lock的区别?
    1.Synchronized 是内置的java关键字， Lock可以判断是否获得了锁
    2.Synchronized 无法判断锁的状态，Lock 可以判断是否获得了锁
    3.Synchronized 会自动释放锁，Lock必须手动进行释放锁！如果不释放锁，就会出现死锁的状态
    4.Synchronized 线程1(获得锁，阻塞) 线程2(等待，傻傻的等)，Lock锁不一定会继续等到下去
    5.Synchronized 可重入锁，不可以中断，非公平的锁，Lock可重入锁，可以判断锁，非公平，可以设置
    6.Synchronized 适合少量的同步代码问题，Lock适合锁大量的代码问题
