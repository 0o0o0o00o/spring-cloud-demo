## AOP
### 一些方法注解的用处
1. @Before 进入方法之前，处理日志
2. @Around 环绕方法，可以修改入参和返回数据
3. @After  在返回数据之前，处理日志，不影响返回数据
4. @AfterReturning 可以拿到返回数据，但不能替换返回数据即修改返回数据地址，只能改变返回数据的内部结构数据。
### 执行顺序
- 同一个切面内的方法 @Around->@Before->@Around->@After->@AfterReturning
- 不同的切面，通过类上的@Order注解设置优先级，数值越大，优先级越低。默认值为Integer.MAX_VALUE。
### 切面注解
不再通过类名方法名指定切面，但是需要在具体方法上使用注解指定切面。

## jasypt对配置文件进行加解密
https://blog.csdn.net/more_try/article/details/82389532
