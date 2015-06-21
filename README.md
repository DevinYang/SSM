Spring 4.0.2+Spring MVC 4.0.2+MyBatis 3.2.6 

1、新建maven工程SSM
2、添加jar包
3、添加spring配置文件application-root.xml（根文件）、spring-mybatis.xml
4、添加数据源
		<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
		destroy-method="close" p:driverClass="${database.driver}" 
		p:jdbcUrl="${database.url}"
		p:user="${database.username}" 
		p:password="${database.password}"
		p:initialPoolSize="${database.initialPoolSize}" 
		p:minPoolSize="${database.minPoolSize}"
		p:maxPoolSize="${database.maxPoolSize}" 
		p:acquireIncrement="${database.acquireIncrement}"
		p:idleConnectionTestPeriod="${database.idleConnectionTestPeriod}"
		p:acquireRetryAttempts="${database.acquireRetryAttempts}"
		p:breakAfterAcquireFailure="${database.breakAfterAcquireFailure}"
		p:maxStatements="${database.maxStatements}" 
		p:testConnectionOnCheckin="${database.testConnectionOnCheckin}" />
		
5、配置mybatis sqlSessionFactory
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource" />
		<!-- 自动扫描mapping.xml文件 -->
		<property name="mapperLocations" value="classpath:com/ssm/mapping/*.xml"></property>
	</bean>
6、将mybatis自动生成的接口交给spring管理
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
		<property name="basePackage" value="com.ssm.dao" />
		<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"></property>
	</bean>
