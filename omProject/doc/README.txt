项目构成
1.omProject，总项目，包含所有的子项目
2.omProtal，供游客和会员使用，打成war包
3.omCms，供网站管理员使用，打成war包
4.omWechat，公众号M站，打成war包
5.omCollect，自己编写的采集jar包，相应的站需要自己调试才可正常使用

前端页面：通过仿站工具下载的目标站的静态页面，修改调试即可
1.index.html	主页面
2.search.html	搜索页面
3.user.html		个人页面




问题：
1.maven项目新建后，jsp/html文件出现The superclass "javax.servlet.http.HttpServlet" was not found on the Java Build Path
解决：在pom.xml文件中添加
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
		</dependency>
		