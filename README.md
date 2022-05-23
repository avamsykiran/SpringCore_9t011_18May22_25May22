Spring Framewok
-----------------------------------------------------------------------------------

    is a dev., platform catering solutions to varity of JavaEE specifications (statements).

    + Light weight and highly modularized
    + Pluggable

    Spring Core                 Dependency Injection, Bean Life Cycle Management
    Spring Context              Autowiring, ApplicationContext
    Spring AOP                  Aspect Oriented Programming
    Spring Boot                 Rapid Application Development and Auto-Configuaration
    Spring Data                 Dynamic JPA / NoSQL ORM implementations
    Spring Jdbc                 Jdbc Templates
    Spring Web                  Web MVC and Rest API
    Spring ORM                  Dynamic JPA / NoSQL ORM implementations
    Spring Test                 Testing Framework
    Spring Security             Authorization and Authentication
    Spring WebFlux              Asynchronous web end points
    Spring Batch ....etc.,      Batch processing

    Pre-requisite Skills
    --------------------
        Java 8

    Lab Setup
    ---------------------
        JDK 8
        STS 4 or above as IDE
        MySQL Community Server 5 or above

    Objectives
    ---------------------
        Spring Core
        Spring Context
        Spring Expression Language
        Dependency Injection
        Various ways of Bean Configuarations
        Working with property files facilatating external configuaration
        
        Spring Boot

        Spring Data
        
        Aspect Oriented Prgramming
    

    Dependency Injection
    -----------------------------

        Dependency or Functional Dependency ?

            if a component depends on the functional operations of another component to
            accomplish a task , then they are functionally dependent.

            controller ------------>> Service ------------->> DAO

        interface EmpDao {
            //emp related crud operations
        }

        class EmpDaoJdbcImpl implements EmpDao {
            //implemented the methods from EmpDao interface
        }

        class EmpDaoJpaImpl implements EmpDao {
            //implemented the methods from EmpDao interface
        }

        interface EmpService {
            //emp related crud operations
        }

        /*class EmpServiceImpl implements EmpService {

            private EmpDao empDao;

            public EmpServiceImpl(){
                //this.empDao = new EmpDaoJdbcImpl();
                this.empDao = new EmpDaoJpaImpl();
            }

            //.........
        }*/

        class EmpServiceImpl implements EmpService {

            private EmpDao empDao;

            public EmpServiceImpl(EmpDao empDao){
                this.empDao = empDao;
            }

            public void setEmpDao(EmpDao empDao){
                this.empDao = empDao;
            }

            //.........
        }

        passing the dependency component to the needed component through a point of reception is called dependency injection.

        Constructor Injection
        Setter Injection
        Method Injection
        Field Injection

    Inversion of Control 
    -------------------------------

        There will be some software that keeps track of the list of component in the applciation
        and the components are wired (linked) as per the needed dependencies when ever and where ever requested.

        Component       is any class that plays the a specific functional role in the application
                        Service
                        Dao
                        Controller
                        ....etc.,

        Bean            is an object of a Component whoes lifecycle is maanged by a context. Context will
                            - create the bean
                            - supply the bean when requested
                            - wire the dependencies
                            - dispose the bean once not needed anymore.

        Context         is a software component that manages the lifecycle of a bean.

    Spring Core and Spring Context
    --------------------------------
        are IoC frameworks.

        Spring Core offers a context called BeanFactory
        Spring Context offers a context called ApplicationContext.

        Both BeanFactory and ApplicationContext are capable of managing the lifecycle of a Bean.

        But ApplicationContext is a little advanced or enchanced than BeanFactory. ApplicationContext has an additional feature
        called Auto-wiring.

        Bean Configuaration ?
            informing the BeanFactory / ApplicationContext that
                1. Different components we have
                2. Beans needed 
                3. Dependency between those beans.

            XML Based Bean Configuaration
            Annotation Based Bean Configuaration
            Java Based Bean Configuaration

            XML Based Bean Configuaration

                <bean 
                    id="beanId"
                    class="ComponentClass"
                    scope="singleton/prototype/request/session/global-session"
                    init-method=""
                    destroy-method=""
                    factory-method=""
                >
                    
                    <property
                        name="fieldName"
                        ref="beanIdOfTheDependencyBean"
                        value="primitveValueOrStrings"
                     />

                    <constructor-arg
                        index="argIndex"
                        ref="beanIdOfTheDependencyBean"
                        value="primitveValueOrStrings"
                     />


                </bean>

                beans.xml

                    <beans>

                        <bean id="ed" class="com.cts.hrapp.dao.EmpDaoJdbcImpl" />

                        <bean id="dd" class="com.cts.hrapp.dao.DeptDaoJdbcImpl" />

                        <bean id="es" class="com.cts.hrapp.service.EmpServiceImpl" >
                            <property name="empDao" ref="ed" />
                        </bean>

                        <bean id="ds" class="com.cts.hrapp.service.DeptServiceImpl" >
                            <constructor-arg index="0" ref="dd" />
                        </bean>

                    </beans>

                Context Api

                    ApplicationContext context = new XmlConfigApplicationContext("./beans.xml");

                    EmpService empService = context.getBean("es");

                    
            Annotation Based Configuaration

                @Configuaration
                @ComponentScan("com.cts.hrapp")
                public class MyConfig {

                }

                @Component("id")
                    @Repository
                    @Service
                    @Controller
                    @RestController
                    @ControllerAdvice
                    @Aspect
                    ....etc.,
                
                @Scope

                @PostConstruct
                @PreDestroy

                @Autowired
                @Qualifier
                @Primary
                @Value

                @PropertySource

                Context Api

                    ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

                    EmpService empService = context.getBean("es");
            
            Java Based Bean Configuaration

                is not an alternate to Annontation Based Config but it is
                a compliment to it.

                we create objects all by our own java code and we will supply those
                objects tot eh 'context' to mange them as benas.

                @Configuaration
                public class MyConfig {

                    @Bean
                    public Scanner scanner(){
                        return new Scanner(System.in);
                    }
                }

    Spring Boot
    ---------------------------------

        is a spring framework module that offers 
            1. AutoConfiguaration
            2. Rapid Application Development

        AutoConfiguaration

            Spring JDBC     we need to config a javax.sql.DataSource

            Spring Web (MVC)    we need to config a View Engine, InternalResourceViewResolver,
                                    DispatcherServlet, request mapping ...etc.,

            Spring Security     we need to config RoleProviders, UserDetailsProviders....etc.,

            and son for each spring module we need to do some module related configs.


            If these modules are used along with SpringBoot, the spring boot will do the
            minimum default configs for all those modules automatically.

            Spring Boot project offers special module called 'starter packages'

            spring.starter.web      =   spring.web + default configs
            spring.starter.security =   spring.security + default configs
            and so on.,....


        As auto configs ensure a lot of boiler plate coding done, the applciation
        developemnt gains pace and hence RAD is possible.

        @SpringBootApplication  =   @Configuaration + @AutoConfig + @ComponentScan + @PropertySource


        1. Use spring starter project wizard from STS.
        2. Use http://start.spring.io - is a spring initializer
        3. Use Spring Boot CLI

    Spring Data JPA
    ---------------------------------
        
        CrudRepository
            |
            |- JpaRepository


        spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
        spring.datasource.username=root
        spring.datasource.password=root
        spring.datasource.url=jdbc:mysql://localhost:3306/booksDB?createDatabaseIfNotExist=true
        spring.jpa.hibernate.ddl-auto=update
         
