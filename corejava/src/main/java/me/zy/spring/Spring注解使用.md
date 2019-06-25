# Spring基础配置

## 依赖注入

### 声明bean的注解

* @Component：组件，没有明确角色
* @Service：在业务逻辑层（service层）使用
* @Repository：在数据访问层（dao层）使用

* @Controller：在展现层（MVC->SpringMVC）使用

> 以上四个注解是等效的，根据需要使用。

### 注入bean的注解

* @Autowired：Spring提供的注解
* @Inject：JSR-330提供的注解
* @Resource：JSR-250提供的注解

> 注入bean的三个注解可以注解在set方法或者属性上，个人更倾向于属性。

## Java配置类

> * Java配置是Spring4.x推荐的配置方式，可以完全替代xml配置，也是Spring Boot推荐的配置方式。
>
> * Java配置主要是通过@Configuration和@Bean来实现的。
>
> * 何时使用Java配置或者注解配置呢？主要原则是：全局配置使用Java配置（数据库、MVC等），业务Bean的配置使用注解配置。

* @Configuration：声明当前类是一个配置类。
* @Bean：注解在方法上，表明当前方法返回值为一个Bean。
* @ComponentScan：自动扫描包名下所有使用@Component、@Service、@Repository、@Controller的类，并注册为bean。

## AOP

### Spring支持AspectJ的注解式切面编程

* @Aspect：声明类是一个切面。
* @Before、@After、@Around定义建言（Advice），直接将拦截规则（切点）作为参数。
* @PointCut（切点）：为了使切点可以复用，可以使用@PointCut专门定义拦截规则，在@After、@Before、@Around的参数中调用。因此，切点其实是一系列规则的定义。
* JoinPoint（连接点）：符合条件的每一个拦截处被称为连接点。

# Spring常用配置

## Bean的Scope

> Scope用来描述Spring容器如何新建实例Bean的。Spring的Scope有以下几种：

* Singleton：一个Spring容器只要一个Bean实例，Spring默认配置，全容器共享一个实例。
* Prototype：每次调用都新建一个Bean的实例。
* Request：Web项目中，给每一个http request新建一个Bean实例。
* Session：Web项目中，给每一个http session新建一个Bean实例。
* Global Session：这个只在portal应用中有用，给每一个global http session新建一个Bean实例。

* @StepScope：在Spring Batch中使用。

## Spring-EL和资源调用

> * Spring表达式语言，支持在xml和注解中使用表达式，类似于JSP的EL表达式。
> * Spring开发中经常调用各种资源，包含普通文件、网址、配置文件、系统环境变量等等。我们可以使用Spring表达式语言实现资源的注入。

### @Value注解

> Spring主要在@Value注解的参数中使用表达式。

* 注入普通字符串
* 注入操作系统属性
* 注入表达式运算结果
* 注入其他Bean的属性
* 注入文件内容
* 注入网址内容
* 注入属性文件

## Bean的初始化和销毁

### Java配置方式

#### @Bean的initMethod和destoryMethod

> 相当于xml配置文件中的init-method和destory-method。

### 注解方式

#### 利用JSR-250的@PostConstruct和@PreDestory。

## Profile

* Profile为不同环境下使用不同的配置提供了支持。
* 通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。在开发中使用@Profile注解类或者方法，达到在不同的环境下选择实例化不同的Bean。
* 通过设定jvm的spring.profiles.active参数来设定环境。
* Web项目设置在Servlet的context parameter中。
* Servlet2.5及以下：

``` xml
<servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
    	<param-name>spring.profiles.active</param-name>
        <param-value>production</param-value>
    </init-param>
</servlet>
```

* Servlet3.0及以上：

```java
public class WebInit implements WebApplicationInitializer{
    @Override
    public void onStartup(ServletContext container) throws ServletException{
        container.setInitParameter("spring.profiles.default","dev");
    }
}
```

## 事件（Application Event）

* Spring事件为Bean与Bean之间的消息通信提供了支持。当一个Bean处理完一个任务之后，希望另外一个Bean知道并做相应的处理，这时就需要让另外一个Bean监听当前Bean所发送的事件。
* Spring的事件需要遵循以下事件：
  * 自定义事件，继承Application。
  * 定义事件监听器，实现ApplicationListener。
  * 使用容器发布事件。

# Spring高级话题

## Spring Aware

* Spring依赖注入最大亮点就是所有的Bean对Spring容器的存在是没有意识的。即可以将你的容器换成别的容器，如Google Guice，这时Bean之间的耦合度很低。
* 实际项目中，不可避免的要用到Spring容器本身的功能资源，这时Bean必须要意识到Spring容器的存在，才能调用容器本身的功能资源，这就是所谓的Spring Aware。
* 其实Spring Aware本来就是Spring设计用来框架内部使用的，若使用了Spring Aware，你的Bean将会和Spring框架耦合。
* Spring所提供的Aware接口如下：

| BeanNameAware                  | 获取容器中Bean的名称                                  |
| ------------------------------ | ----------------------------------------------------- |
| BeanFactoryAware               | 获取当前的bean factory，这样可以调用容器的服务        |
| ApplicationConetextAware       | 获取当前的application context，这样可以调用容器的服务 |
| MessageSourceAware             | 获得message source，这样可以获得文本信息              |
| ApplicationEventPublisherAware | 应用事件发布器，可以发布事件                          |
| ResourceLoaderAware            | 获得资源加载器，可以获得外部资源文件                  |

* Spring Aware的目的是为了让Bean获得Spring容器的服务。因为ApplicationContext接口继承了MessageSource接口、ApplicationEventPublisher接口和ResourceLoader接口，所以Bean继承ApplicationContext可以获得spring容器的所有服务，但是原则上我们还是使用什么接口，就实现什么接口。

## Spring多线程

### 任务执行器TaskExecutor、@EnableAsync、@Async

* Spring通过任务执行器来实现多线程和并发编程。使用ThreadPoolTaskExecutor可实现一个基于线程池的TaskExecutor。而实际开发中的任务一般是非阻塞的，即异步的，所以我们要在配置类中通过```@EnableAsync```开启对异步任务的支持，并通过在实际执行的Bean方法中使用```@Async```注解来声明其是一个异步任务。	

## 计划任务

### @EnableScheduling 、@Scheduled

* 计划任务在Spring中的实现变得异常简单：在配置类中使用```@EnableScheduling```来开启对计划任务的支持，在执行计划任务的方法上注解使用```@Scheduled，```声明这是一个计划任务。
* Spring通过```@Scheduled```支持多种类型的计划任务，包含cron、fixedDelay、fixedRate等。
* xml中使用```<task:annotation-driven />```开启计划任务，类似于```@EnableScheduling```。

## 条件注解@Conditional

* 通过`@Profile`可以获取不同的Bean。Spring4提供了`@Conditional`注解这种更通用的基于条件的Bean创建的方式。
* `@Conditional`根据满足某一特定条件创建一个特定的Bean。比如，只有某个bean被创建，才会创建另外一个bean。利用这个特性，可以进行一些自动的配置。SpringBoot大量运用了条件注解。

## 组合注解与元注解

* 注解到其他注解上的注解被称为元注解。

## @Enable*注解的工作原理

* `@EnableAspectJAutoProxy `开启对AspectJ自动代理的支持
* `@EnableAsync`开启异步方法的支持
* `@EnableScheduling`开启对计划任务的支持
* `@EnableWebMvc`开启对Web MVC的支持
* `@EnableConfigurationProperties`开启`@ConfigurationProperties`注解配置Bean的支持
* `@EnableJpaRepositories`开启Spring Data JPA Repository的支持
* `@EnableTransactionManagement`开启注解式事务的支持
* `@EnableCaching`开启注解式的缓存支持

> 通过观察这下@Enable*注解的源码，我们发现所有的注解都有一个`@Import`注解，该注解是用来导入配置类的，这意味着这些自动开启的实现其实是导入了一些自动配置的Bean。这些导入的配置方式主要分为以下三种类型：
### 1.直接导入配置类
> ```java
> @Target(ElementType.TYPE)
> @Retention(RetentionPolicy.RUNTIME)
> @Import(SchedulingConfiguration.class)
> @Documented
> public @interface EnableScheduling {
> 
> }
> //直接导入了SchedulingConfiguration配置类，这个类注解了`@Configuration`，且注册了一个scheduledAnnotationProcessor的Bean，源码如下：
> @Configuration
> @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
> public class SchedulingConfiguration {
> 	@Bean(name = TaskManagementConfigUtils.SCHEDULED_ANNOTATION_PROCESSOR_BEAN_NAME)
> 	@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
> 	public ScheduledAnnotationBeanPostProcessor scheduledAnnotationProcessor() {
> 		return new ScheduledAnnotationBeanPostProcessor();
> 	}
> 
> }
> 
> ```
>
### 2.依据条件选择配置类：
>
> ```java
> @Target(ElementType.TYPE)
> @Retention(RetentionPolicy.RUNTIME)
> @Documented
> @Import(AsyncConfigurationSelector.class)
> public @interface EnableAsync {	
> 	Class<? extends Annotation> annotation() default Annotation.class;
> 	boolean proxyTargetClass() default false;	
> 	AdviceMode mode() default AdviceMode.PROXY;	
> 	int order() default Ordered.LOWEST_PRECEDENCE;
> }
> //AsyncConfigurationSelector通过条件类来选择需要导入的配置类：若adviceMode为PROXY，则返回ProxyAsyncConfiguration；若adviceMode为ASPECTJ，则返回AspectJAsyncConfiguration
> public class AsyncConfigurationSelector extends AdviceModeImportSelector<EnableAsync> {
> 	private static final String ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME =
> 			"org.springframework.scheduling.aspectj.AspectJAsyncConfiguration";
> 	
> 	@Override
> 	@Nullable
> 	public String[] selectImports(AdviceMode adviceMode) {
> 		switch (adviceMode) {
> 			case PROXY:
> 				return new String[] { ProxyAsyncConfiguration.class.getName() };
> 			case ASPECTJ:
> 				return new String[] { ASYNC_EXECUTION_ASPECT_CONFIGURATION_CLASS_NAME };
> 			default:
> 				return null;
> 		}
> 	}
> }
> ```
>
### 3.动态注册Bean：
```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(AspectJAutoProxyRegistrar.class)
public @interface EnableAspectJAutoProxy {
	boolean proxyTargetClass() default false;
	boolean exposeProxy() default false;
}
//AspectJAutoProxyRegistrar通过重写registerBeanDefinitions方法，在运行时自动添加Bean到已有的配置类中
class AspectJAutoProxyRegistrar implements ImportBeanDefinitionRegistrar {
	@Override
	public void registerBeanDefinitions(
			AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AopConfigUtils.registerAspectJAnnotationAutoProxyCreatorIfNecessary(registry);
		AnnotationAttributes enableAspectJAutoProxy =
            AnnotationConfigUtils.attributesFor(importingClassMetadata, 				                   		EnableAspectJAutoProxy.class);
		if (enableAspectJAutoProxy != null) {
			if (enableAspectJAutoProxy.getBoolean("proxyTargetClass")) {
				AopConfigUtils.forceAutoProxyCreatorToUseClassProxying(registry);
			}
			if (enableAspectJAutoProxy.getBoolean("exposeProxy")) {
				AopConfigUtils.forceAutoProxyCreatorToExposeProxy(registry);
			}
		}
	}

}
```

## 测试

### 单元测试

> 单元测试只针对当前开发的类和方法进行测试。可以简单通过依赖模拟来实现，对环境没有依赖。

### 集成测试

> * 仅仅进行单元测试是不够的，他只能验证当前类或方法是否能正常工作，而我们想要知道系统各个部分组合在一起能否正常工作，这就是集成测试的意义。
> * 集成测试一般需要不同对象的交互，如数据库、网络连接、IoC容器等等。其实我们也经常通过运行程序，然后自己操作来完成类似于集成测试的流程。
### Spring对集成测试的支持
> * Spring通过Spring TestContext Framework对集成测试提供顶级支持。它不依赖于特定的测试框架，既可使用Junit，也可以使用TestNG。
> * Spring提供了一个`SpringJUnit4ClassRunner`类，它提供了Spring TestContext Framework的功能。通过`@ContextConfiguration`来配置Application Context，通过`@ActiveProfile`确定活动的profile。