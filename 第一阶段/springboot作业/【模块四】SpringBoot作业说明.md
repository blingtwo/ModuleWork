编程题：个人博客系统首页展示（文章分页展示）

   前台需要显示： 首页 上一页 下一页 尾页



**作业具体要求参考以下链接文档：**

https://gitee.com/lagouedu/test/raw/master/%E7%AC%AC%E4%B8%80%E9%98%B6%E6%AE%B5/springboot/%E6%A8%A1%E5%9D%97%E5%9B%9B%E4%BD%9C%E4%B8%9A%E8%B5%84%E6%96%99.zip



【答】：详细见代码文件夹【code】所示

（1）新建数据库blog_system，新建表t_article，并给表中写入相关数据

（2）使用Spring Initializr方式创建Spring Boot项目，引入Spring Web、Spring Data JPA、MySQL Driver、Thymeleaf依赖。

（3）application.properties文件中配置数据库连接配置、thymeleaf.prefix配置等。

（4）将SpringbootBlogApplication启动类移到com.lagou包下。

（5）新建pojo包，并新建Article实体类，字段和数据表t_article对应，并加上相关注解。

（6）新建repository包，并新建ArticleRepository接口，继承JpaRepository接口。

（7）新建service包，并新建ArticleService类，新建findAllArticle方法，其中使用articleRepository.findAll(pageOf)方法查询数据。

（8）新建controller包，并新建ArticleController类，新建toIndexPage方法，并打上相关注解。

（9）将文件夹static/templates中文件拷入其中，并在index.html中${}填入数据，并新增分页显示的内容。

（10）测试：浏览器中输入http://localhost:8080/index进行测试。