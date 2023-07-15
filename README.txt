
<MyBatis 프로젝트 작업>

1. 스프링과 MyBatis 연동
2. MyBatis 연동을 위한 DataSource 객체 설정 및 프로젝트 구성
3. MyBatis의 구조 이해 및 SqlSessionFactory 객체 설정
4. XML mapper를 이용한 DB 연동
5. Mybatis를 이용한 오라클 접속
6. Mybatis를 이용한 회원관리



[ORACLE + MyBaits Generator 사용하기]

 - 설치
   . 이클립스  Help > Install New Software
   
   update url : http://mybatis.googlecode.com/svn/sub-projects/generator/trunk/eclipse/UpdateSite/
 
 - generator config 파일 생성
   . file > new > other
     myBatis generator configuration file을 선택한다.
     
     ex> location : 
         file name : generatorConfig.xml   
 
 
1. 스프링과 MyBatis를 연동하기 위한 라이브러리 설정(pom.xml)
    - MyBatis 프레임워크 추가
    - MyBatis-Spring 모듈 추가
    - Spring-jdbc 라이브러리 추가
    - Spring-test 라이브러리 추가


2. 마이바티스 설정 작업

    - 데이터베이스와 연결을 담당하는 DataSource 객체 설정(servlet-context.xml 설정)
    - MyBatis의 핵심인 SqlSessionFactory 객체 설정(테스트)

    
3. 스프링+MyBatis

    - MyBatis를 이용하는데 있어서 SQL문을 사용하는 방식
    
        1)  XML문을 이용해서 SQL문을 설정하고 DAO에서 XML을 찾아서 실행하는 코드를 작성하는 방식
           - 장점 : SQL문은 별도의 XML로 작성되기 때문에 SQL문의 수정이나 유지보수가 많은 경우 관리하기가 편하다. 	
           - 단점 : 개발시 코드양이 많아진다. 복잡성이 증가	

        2)  어노테이션과 인터페이스만을 이용해서 SQL문을 설정하는 방식
           - 장점 : DAO없이도 개발이 가능하기 때문에 생산성이 향사
           - 단점 : SQL문을 어노테이션으로 작성하기 때문에 매번 수정이 일어나는 경우 재컴파일을 해야한다.	
    
        3)  인터페이스와  XML로 작성된 SQL문을 활용하는 방식
           - 장점 : 유연성 있음. 간단한 SQL문은 어노테이션으로, 복잡한 SQL문은 XML로 처리하므로 상황에 따라 처리
           - 단점 : 유지보수가 많은 프로젝트에서는 부적합한 방식	


<XML기반의 MyBaits 사용 순서>
    - 테이블 생성 및 개발준비
    - 도메인 객체의 설계 및 클래스 작성
    - DAO 인터페이스 작성
    - XML Mapper 생성과 SQL문 작성
    - MyBatis에서 XML Mapper를 인식하도록 설정
    - DAO 구현(SqlSessionTemplate 설정 및 구현클래스 작성)   




<MyBaits 기본 설정>

// pom.xml

		<!-- MyBatis 설정 -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.1.4.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.2.8</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.2.2</version>
		</dependency>
		

		<!-- JPA(Java Persistence API) Validation  -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-entitymanager</artifactId>
			<version>3.6.0.Final</version>
		</dependency>
		<dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
			<version>1.0.0.GA</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>4.1.0.Final</version>
		</dependency>		        

	
	
	
// servlet-context.xml	

	<beans:bean name="dataSource" 
	class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<beans:property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<beans:property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl"/>
		<beans:property name="username" value="계정" />
		<beans:property name="password" value="비번" />
	</beans:bean>
	
	
	<beans:bean name="dataSource" 
		class="org.springframework.jdbc.datasource.DriverManagerDataSource">
		<beans:property name="driverClassName" value="oracle.jdbc.driver.OracleDriver" />
		<beans:property name="url" value="jdbc:oracle:thin:@localhost:1521:orcl"/>
		<beans:property name="username" value="EDU01" />
		<beans:property name="password" value="1111" />
	</beans:bean>
	
	<beans:bean name="template" class="org.springframework.jdbc.core.JdbcTemplate">
		<beans:property name="dataSource" ref="dataSource" />
	</beans:bean>
	
	<beans:bean name="bbsdao" class="com.spring.ormDAO.BbsDAO">
		<beans:property name="template" ref="template"></beans:property>
	</beans:bean>
	
	
	<beans:bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<beans:property name="dataSource" ref="dataSource"></beans:property>
		<beans:property name="mapperLocations" value="classpath:META-INF/mapper/*.xml"></beans:property>                     <!-- resources 위치  -->
		<!-- <beans:property name="mapperLocations" value="classpath:com/spring/ormDAO/mapper/*.xml"></beans:property>  -->  <!-- java 위치           -->
	</beans:bean>
	
	<beans:bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<beans:constructor-arg index="0" ref="sqlSessionFactory"></beans:constructor-arg>
	</beans:bean>	