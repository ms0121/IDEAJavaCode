package com.liu;

import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author lms
 * @date 2021-05-15 - 18:17
 */
public class ZookeeperTest {

    // zookeeper的连接地址
    private String conn = "zk:2181";
    // 设置超时连接时间上限
    private Integer sessionTime = 2000;
    private ZooKeeper zkClient;

    @Before
    public void tets1() throws IOException {
        new ZooKeeper(conn, sessionTime, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {

            }
        });
    }

    //   1.创建一个子节点
    @Test
    public void test2() throws KeeperException, InterruptedException {
        String path = zkClient.create("/lms", "shamji".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println("path = " + path);
    }

}










