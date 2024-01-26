package com.example.demo.xsd;

import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.w3c.dom.Element;

public class SanYouNameSpaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        //注册解析 mybean 标签的解析器
        registerBeanDefinitionParser("mybean", new SanYouBeanDefinitionParser());
    }

    private static class SanYouBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
        @Override
        protected boolean shouldGenerateId() {
            return true;
        }

        @Override
        protected String getBeanClassName(Element element) {
            return element.getAttribute("class");
        }

    }
}
