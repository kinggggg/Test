#Test

#����ͨ���������ַ�ʽ������generator
##��һ�֣��������µ�����
'''
java -jar ·��ָ��mybatis-generator-core-1.3.5.jar -configfile ·��ָ��generatorConfig.xml -overwrite
'''

##�ڶ��֣�ʹ��maven�ķ�ʽ�����������ַ�ʽ��ò��generator�������ļ����Ʊ���ΪgeneratorConfig.xml
'''
mvn mybatis-generator:generate
'''

���꾡���ĵ����Բο�http://mbg.cndocs.tk/quickstart.html

��ʵ�����������У�Ӧ�ý�mybatis���ɵ�spring���У���spring������mybatis��session��
����spring������ָ�����ɵ�mapper�����ļ����������µ�����
'''
<bean id="xxxSqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="xxxDataSource"/>
        <property name="configLocation" value="classpath:dao/mybatis-config.xml"/>
        <property name="mapperLocations" value="classpath:dao/xxx/mappers/*.xml"/>
    </bean>
'''
����xxxΪ���ƻ�����Ŀ��Ϣ