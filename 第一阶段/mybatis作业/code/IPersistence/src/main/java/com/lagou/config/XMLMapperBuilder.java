package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;
import com.lagou.pojo.SqlCommandType;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Locale;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");

        List<Element> list = rootElement.selectNodes("//select");
        elementFor(namespace,list);
        //添加insert标签
        List<Element> listInsert = rootElement.selectNodes("//insert");
        elementFor(namespace,listInsert);
        //添加update标签
        List<Element> listUpdate = rootElement.selectNodes("//update");
        elementFor(namespace,listUpdate);
        //添加delete标签
        List<Element> listDelete = rootElement.selectNodes("//delete");
        elementFor(namespace,listDelete);
    }

    private void elementFor(String namespace,List<Element> list){
        if (list == null || list.isEmpty()) {
            return;
        }
        for (Element e : list) {
            String id = e.attributeValue("id");
            String resultType = e.attributeValue("resultType");
            String paramterType = e.attributeValue("paramterType");
            String sql = e.getTextTrim();
            SqlCommandType sqlCommandType = SqlCommandType.valueOf(e.getName().toUpperCase(Locale.ENGLISH));
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sql);
            mappedStatement.setSqlCommandType(sqlCommandType);
            String key = namespace+"."+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);
        }
    }
}
