package com.liu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author lms
 * @date 2021-03-30 - 11:53
 */
public class Test {
    public static void main(String[] args) throws DocumentException {
        // 需要分四步操作:
        // 第一步，通过创建 SAXReader 对象。来读取 xml 文件，获取 Document 对象
        // 束标签之间的文本内容

        SAXReader reader = new SAXReader();
        Document document = reader.read("D:\\E_DISK\\IDEAJavaCode\\JavaWeb\\06_xml\\src\\books.xml");
        // 第二步，通过 Document 对象。拿到 XML 的根元素对象
        Element root = document.getRootElement();
        // System.out.println(root.asXML());
        // 第三步，通过根元素对象。获取所有的 book 标签对象
        List<Element> books = root.elements();
        //        第四小，遍历每个 book 标签对象。然后获取到 book 标签对象内的每一个元素，再通过 getText() 方法拿到起始标签和结
        for (Element book : books) {
            // 测试
            // System.out.println(book.asXML());
            // 拿到 book 下面的 name 元素对象
            Element nameElement = book.element("name");
            // 拿到 book 下面的 price 元素对象
            Element priceElement = book.element("price");
            // 拿到 book 下面的 author 元素对象
            Element authorElement = book.element("author");
            // 再通过 getText() 方法拿到起始标签和结束标签之间的文本内容
            System.out.println("书名" + nameElement.getText() + " , 价格:"
                    + priceElement.getText() + ", 作者：" + authorElement.getText());
        }
    }

    @org.junit.Test
    public void name() throws DocumentException {
        // 要创建一个 Document 对象，需要我们先创建一个 SAXReader 对象
        SAXReader reader = new SAXReader();
        // 这个对象用于读取 xml 文件，然后返回一个 Document。
        Document document = reader.read("D:\\E_DISK\\IDEAJavaCode\\JavaWeb\\06_xml\\src\\books.xml");
        // 打印到控制台，看看是否创建成功
        System.out.println(document);
    }
}
