package com.ghw.org.test;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import freemarker.template.Configuration;
import freemarker.template.Template;


public final class WordUtil {
	
	private static Configuration configuration = null;

	  private WordUtil() {
	    throw new AssertionError();
	  }

	  /**
	   * 根据模板生成相应的文件
	   * @param root 保存数据的map
	   * @param template 模板文件的地址
	   * @param path 生成的word文档输出地址
	   * @return
	   */
	  public static synchronized File process(Map<?, ?> root, String template, String path) {

	    if (null == root ) {
	      throw new RuntimeException("数据不能为空");
	    }

	    if (null == template) {
	      throw new RuntimeException("模板文件不能为空");
	    }

	    if (null == path) {
	      throw new RuntimeException("输出路径不能为空");
	    }

	    File file = new File(path);
	    String templatePath = template.substring(0, template.lastIndexOf("/"));
	    String templateName = template.substring(template.lastIndexOf("/") + 1, template.length());

	    if (null == configuration) {
	      configuration = new Configuration( );  // 这里Configurantion对象不能有两个，否则多线程访问会报错
	      configuration.setDefaultEncoding("utf-8");
	      configuration.setClassicCompatible(true);
	    }
	    configuration.setClassForTemplateLoading(WordUtil.class, templatePath);

	    Template t = null;
	    try {
	      t = configuration.getTemplate(templateName);
	      Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
	      t.process(root, w);  // 这里w是一个输出地址，可以输出到任何位置，如控制台，网页等
	      w.close();
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	    return file;
	  }

	}	

